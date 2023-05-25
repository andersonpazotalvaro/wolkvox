package co.smart.procesador.campañas.resultadomaquinafinal.comando.manejador;

import co.smart.procesador.agentes.estadopohora.comando.ResponseAgenteEstadoPorHora;
import co.smart.procesador.agentes.estadopohora.comando.fabrica.FabricaAgenteEstadoPorHora;
import co.smart.procesador.agentes.estadoporhora.consumir.ConsumirDiarioEstadoPorHora;
import co.smart.procesador.agentes.estadoporhora.servicio.ServicioGuardarAgenteEstadoPorHora;
import co.smart.procesador.campañas.resultadomaquinafinal.comando.ResponseCampañaResultadoMaquinaFinal;
import co.smart.procesador.campañas.resultadomaquinafinal.comando.fabrica.FabricaCampañaResultadoMaquinaFinal;
import co.smart.procesador.campañas.resultadomaquinafinal.consumir.ConsumirDiarioResultadoMaquinaFinal;
import co.smart.procesador.campañas.resultadomaquinafinal.servicio.ServicioGuardarCampañaResultadoMaquinaFinal;
import co.smart.procesador.datos.servicio.ServicioGenerarFechasDiarias;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;


@RequiredArgsConstructor
@Component
public class ManejadorCampañaResultadoMaquinaFinal {


    private final FabricaCampañaResultadoMaquinaFinal fabricaCampañaResultadoMaquinaFinal;
    private final ServicioGuardarCampañaResultadoMaquinaFinal servicioGuardarCampañaResultadoMaquinaFinal;
    private final ConsumirDiarioResultadoMaquinaFinal consumirDiarioResultadoMaquinaFinal;
    private final ServicioGenerarFechasDiarias servicioGenerarFechasDiarias;



    public Boolean ejecutar(ResponseCampañaResultadoMaquinaFinal responseCampañaResultadoMaquinaFinal, String ini, String fin){
        var datos = this.fabricaCampañaResultadoMaquinaFinal.obtenerDatos(responseCampañaResultadoMaquinaFinal);
        var listaCampañaResultadoMaquinaFinals = this.fabricaCampañaResultadoMaquinaFinal.convertirRespuestaADominio(datos, ini, fin);
        return this.servicioGuardarCampañaResultadoMaquinaFinal.ejecutar(listaCampañaResultadoMaquinaFinals);
    }


    //@Scheduled(cron= "@"+"${cron.midnight}")


    //@Scheduled(fixedDelay = 60000)
    public boolean ejecutarCiclo() throws IOException {

        String fechaString= this.servicioGenerarFechasDiarias.generarFechaIni();
        var response= this.consumirDiarioResultadoMaquinaFinal.consumir();
        var json = response.body().string();

        Gson gson= new Gson();
        ResponseCampañaResultadoMaquinaFinal responseCampañaResultadoMaquinaFinal = gson.fromJson(json, ResponseCampañaResultadoMaquinaFinal.class);
        boolean guardo= false;

        try {
            if(this.ejecutar(responseCampañaResultadoMaquinaFinal,fechaString,fechaString)){;
                guardo = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("guardo Campaña Resultado Maquina Final");

        return guardo;
    }

}
