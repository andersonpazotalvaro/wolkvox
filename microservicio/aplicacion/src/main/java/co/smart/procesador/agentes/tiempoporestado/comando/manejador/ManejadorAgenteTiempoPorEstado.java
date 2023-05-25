package co.smart.procesador.agentes.tiempoporestado.comando.manejador;

import co.smart.procesador.agentes.tiempoporestado.comando.ResponseAgenteTiempoPorEstado;
import co.smart.procesador.agentes.tiempoporestado.comando.fabrica.FabricaAgenteTiempoPorEstado;

import co.smart.procesador.agentes.tiempoporestado.consumir.ConsumirDiarioTiempoPorEstado;
import co.smart.procesador.agentes.tiempoporestado.servicio.ServicioGuardarAgenteTiempoPorEstado;
import co.smart.procesador.datos.servicio.ServicioGenerarFechasDiarias;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


@RequiredArgsConstructor
@Component
public class ManejadorAgenteTiempoPorEstado {

    private final RestTemplate restTemplate;

    private final FabricaAgenteTiempoPorEstado fabricaAgenteTiempoPorEstado;

    private final ServicioGuardarAgenteTiempoPorEstado servicioGuardarAgenteTiempoPorEstado;

    private final ConsumirDiarioTiempoPorEstado consumirDiario;

    private final ServicioGenerarFechasDiarias servicioGenerarFechasDiarias;



    public Boolean ejecutar(ResponseAgenteTiempoPorEstado responseAgenteTiempoPorEstado, String ini, String fin){
        var datos = this.fabricaAgenteTiempoPorEstado.obtenerDatos(responseAgenteTiempoPorEstado);
        var listaAgenteTiempoPorEstado = this.fabricaAgenteTiempoPorEstado.convertirRespuestaADominio(datos, ini, fin);
        return this.servicioGuardarAgenteTiempoPorEstado.ejecutar(listaAgenteTiempoPorEstado);
    }

    //@Scheduled(cron= "@"+"${cron.midnight}")


    //@Scheduled(fixedDelay = 60000)
    public boolean ejecutarCiclo() throws IOException {

        String fechaString= this.servicioGenerarFechasDiarias.generarFechaIni();

        var response= this.consumirDiario.consumir();
        var json = response.body().string();

        Gson gson= new Gson();
        ResponseAgenteTiempoPorEstado responseAgenteEstadosPorHora = gson.fromJson(json, ResponseAgenteTiempoPorEstado.class);
        boolean guardo= false;

        try {
            if(this.ejecutar(responseAgenteEstadosPorHora, fechaString, fechaString)){;
                guardo = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("guardo agente tiempo por estado");

        return guardo;
    }

}
