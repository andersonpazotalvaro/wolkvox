package co.smart.procesador.diagram.encuestainteligenteporskill.comando.manejador;


import co.smart.procesador.datos.servicio.ServicioGenerarFechasDiarias;
import co.smart.procesador.diagram.encuestainteligenteporskill.comando.ResponseDiagramEncuestaInteligenteSkill;
import co.smart.procesador.diagram.encuestainteligenteporskill.comando.fabrica.FabricaDiagramEncuestaInteligenteSkill;
import co.smart.procesador.diagram.encuestainteligenteporskill.consumir.ConsumirDiarioEncuestaInteligenteSkill;
import co.smart.procesador.diagram.encuestainteligenteporskill.servicio.ServicioGuardarDiagramEncuestaInteligenteSkill;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;


@RequiredArgsConstructor
@Component
public class ManejadorDiagramEncuestaInteligenteSkill {


    private final FabricaDiagramEncuestaInteligenteSkill fabricaDiagramEncuestaInteligenteSkill;
    private final ServicioGuardarDiagramEncuestaInteligenteSkill servicioGuardarDiagramEncuestaInteligenteSkill;
   private final ConsumirDiarioEncuestaInteligenteSkill consumirDiarioEncuestaInteligenteSkill;
    private final ServicioGenerarFechasDiarias servicioGenerarFechasDiarias;



    public Boolean ejecutar(ResponseDiagramEncuestaInteligenteSkill responseDiagramEncuestaInteligenteSkill, String ini, String fin){
        var datos = this.fabricaDiagramEncuestaInteligenteSkill.obtenerDatos(responseDiagramEncuestaInteligenteSkill);
        var listaDiagramEncuestaInteligenteSkills = this.fabricaDiagramEncuestaInteligenteSkill.convertirRespuestaADominio(datos,ini,fin);
        return this.servicioGuardarDiagramEncuestaInteligenteSkill.ejecutar(listaDiagramEncuestaInteligenteSkills);
    }

    //@Scheduled(cron= "@"+"${cron.midnight}")


    //@Scheduled(fixedDelay = 60000)
    public boolean ejecutarCiclo() throws IOException {
        String fechaString= this.servicioGenerarFechasDiarias.generarFechaIni();
        var response= this.consumirDiarioEncuestaInteligenteSkill.consumir();
        var json = response.body().string();

        Gson gson= new Gson();
        ResponseDiagramEncuestaInteligenteSkill responseDiagramEncuestaInteligenteSkill = gson.fromJson(json, ResponseDiagramEncuestaInteligenteSkill.class);
        boolean guardo= false;

        try {
            if(this.ejecutar(responseDiagramEncuestaInteligenteSkill,fechaString,fechaString)){;
                guardo = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("guardo Diagram Encuesta inteligente por skill");

        return guardo;
    }

}
