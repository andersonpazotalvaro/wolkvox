package co.smart.procesador.diagram.encuestainteligenteporagente.comando.manejador;

import co.smart.procesador.datos.servicio.ServicioGenerarFechasDiarias;
import co.smart.procesador.diagram.encuestainteligenteporagente.comando.ResponseDiagramEncuestaInteligenteAgente;
import co.smart.procesador.diagram.encuestainteligenteporagente.comando.fabrica.FabricaDiagramEncuestaInteligenteAgente;
import co.smart.procesador.diagram.encuestainteligenteporagente.consumir.ConsumirDiarioEncuestaInteligenteAgente;
import co.smart.procesador.diagram.encuestainteligenteporagente.servicio.ServicioGuardarDiagramEncuestaInteligenteAgente;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;


@RequiredArgsConstructor
@Component
public class ManejadorDiagramEncuestaInteligenteAgente {


    private final FabricaDiagramEncuestaInteligenteAgente fabricaDiagramEncuestaInteligenteAgente;
    private final ServicioGuardarDiagramEncuestaInteligenteAgente servicioGuardarDiagramEncuestaInteligenteAgente;
   private final ConsumirDiarioEncuestaInteligenteAgente consumirDiarioEncuestaInteligenteAgente;
    private final ServicioGenerarFechasDiarias servicioGenerarFechasDiarias;



    public Boolean ejecutar(ResponseDiagramEncuestaInteligenteAgente responseDiagramEncuestaInteligenteAgente, String ini, String fin){
        var datos = this.fabricaDiagramEncuestaInteligenteAgente.obtenerDatos(responseDiagramEncuestaInteligenteAgente);
        var listaDiagramEncuestaInteligenteAgentes = this.fabricaDiagramEncuestaInteligenteAgente.convertirRespuestaADominio(datos,ini,fin);
        return this.servicioGuardarDiagramEncuestaInteligenteAgente.ejecutar(listaDiagramEncuestaInteligenteAgentes);
    }

    //@Scheduled(cron= "@"+"${cron.midnight}")


    //@Scheduled(fixedDelay = 60000)
    public boolean ejecutarCiclo() throws IOException {
        String fechaString= this.servicioGenerarFechasDiarias.generarFechaIni();
        var response= this.consumirDiarioEncuestaInteligenteAgente.consumir();
        var json = response.body().string();

        Gson gson= new Gson();
        ResponseDiagramEncuestaInteligenteAgente responseDiagramEncuestaInteligenteAgente = gson.fromJson(json, ResponseDiagramEncuestaInteligenteAgente.class);
        boolean guardo= false;

        try {
            if(this.ejecutar(responseDiagramEncuestaInteligenteAgente,fechaString,fechaString)){;
                guardo = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("guardo Diagram Encuesta inteligente por agente");

        return guardo;
    }

}
