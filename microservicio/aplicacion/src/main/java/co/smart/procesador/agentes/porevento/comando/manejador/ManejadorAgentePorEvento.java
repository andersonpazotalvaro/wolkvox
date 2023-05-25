package co.smart.procesador.agentes.porevento.comando.manejador;

import co.smart.procesador.agentes.porevento.comando.ResponseAgentePorEvento;
import co.smart.procesador.agentes.porevento.comando.fabrica.FabricaAgentePorEvento;
import co.smart.procesador.agentes.porevento.consumir.ConsumirDiarioPorEvento;
import co.smart.procesador.agentes.porevento.servicio.ServicioGuardarAgentePorEvento;

import co.smart.procesador.agentes.tiempoporestado.servicio.ServicioConsultarIpAgent;
import co.smart.procesador.datos.servicio.ServicioConsultarDatos;
import co.smart.procesador.datos.servicio.ServicioGenerarFechasDiarias;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


@RequiredArgsConstructor
@Component
public class ManejadorAgentePorEvento {


    private final FabricaAgentePorEvento fabricaAgentePorEvento;
    private final ServicioGuardarAgentePorEvento servicioGuardarAgentePorEvento;
    private final ConsumirDiarioPorEvento consumirDiario;
    private final ServicioConsultarIpAgent servicioConsultarIpAgent;
    private final ServicioGenerarFechasDiarias servicioGenerarFechasDiarias;


@Async
    public Boolean ejecutar(ResponseAgentePorEvento responseAgentePorEvento){
    try {
        var datos = this.fabricaAgentePorEvento.obtenerDatos(responseAgentePorEvento);
        var listaAgentePorEvento = this.fabricaAgentePorEvento.convertirRespuestaADominio(datos);
        return this.servicioGuardarAgentePorEvento.ejecutar(listaAgentePorEvento);
    }catch (Exception e){
    }
       return false;
    }

    //@Scheduled(cron= "@"+"${cron.midnight}")


    //@Scheduled(fixedDelay = 60000)
    //@Async
    public boolean ejecutarCiclo() throws IOException {
        String ini= this.servicioGenerarFechasDiarias.generarFechaIni();
        String fin= this.servicioGenerarFechasDiarias.generarFechaFin();


        Gson gson= new Gson();
        boolean guardo=false;
        OkHttpClient client = new OkHttpClient().newBuilder().writeTimeout(180, TimeUnit.SECONDS).build();
        client.sslSocketFactory().createSocket();
        var listaAgentesTiempoPorEstado = this.servicioConsultarIpAgent.ejecutar();

        listaAgentesTiempoPorEstado.forEach(agenteTiempoPorEstado -> {

            try {
                var response= this.consumirDiario.consumir(ini,fin,agenteTiempoPorEstado.getAgent_id());
                var json = response.body().string();

                ResponseAgentePorEvento responseAgentePorEvento = gson.fromJson(json, ResponseAgentePorEvento.class);
                try {
                    this.ejecutar(responseAgentePorEvento);
                }catch (Exception e){
                    System.out.println(e);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
        guardo = true;
        System.out.println("guardo agente Por Evento");

        return guardo;
    }

}
