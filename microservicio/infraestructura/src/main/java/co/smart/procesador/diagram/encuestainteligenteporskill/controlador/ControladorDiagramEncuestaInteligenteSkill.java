package co.smart.procesador.diagram.encuestainteligenteporskill.controlador;


import co.smart.procesador.diagram.email.servicio.NotificacionDiagramEncuestaInteligenteSkill;
import co.smart.procesador.diagram.encuestainteligenteporagente.comando.ResponseDiagramEncuestaInteligenteAgente;
import co.smart.procesador.diagram.encuestainteligenteporskill.comando.ResponseDiagramEncuestaInteligenteSkill;
import co.smart.procesador.diagram.encuestainteligenteporskill.comando.manejador.ManejadorDiagramEncuestaInteligenteSkill;
import co.smart.procesador.diagram.encuestainteligenteporskill.consumir.ConsumirEncuestaInteligenteSkill;
import com.google.gson.Gson;
import okhttp3.Response;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("DiagramEncuestaInteligenteSkill")
public class ControladorDiagramEncuestaInteligenteSkill {

        private final static String NO_SE_ENCONTRO_DATOS = "no se encontraron datos para estas fechas";

        private final NotificacionDiagramEncuestaInteligenteSkill notificacionDiagramEncuestaInteligenteSkill;

        private final ManejadorDiagramEncuestaInteligenteSkill manejadorDiagramEncuestaInteligenteSkill;

        private final ConsumirEncuestaInteligenteSkill consumirEncuestaInteligenteSkill;

    public ControladorDiagramEncuestaInteligenteSkill(NotificacionDiagramEncuestaInteligenteSkill notificacionDiagramEncuestaInteligenteSkill, ManejadorDiagramEncuestaInteligenteSkill manejadorDiagramEncuestaInteligenteSkill, ConsumirEncuestaInteligenteSkill consumirEncuestaInteligenteSkill) {
        this.notificacionDiagramEncuestaInteligenteSkill = notificacionDiagramEncuestaInteligenteSkill;
        this.manejadorDiagramEncuestaInteligenteSkill = manejadorDiagramEncuestaInteligenteSkill;
        this.consumirEncuestaInteligenteSkill = consumirEncuestaInteligenteSkill;
    }


    @RequestMapping(value= "/{ini}/{fin}", method = RequestMethod.POST)
    public String enviar(@PathVariable("ini") String ini, @PathVariable("fin") String fin) throws IOException {

        Response response= this.consumirEncuestaInteligenteSkill.consumirr(ini,fin);
        boolean guardo= false;
        Gson gson= new Gson();
        String json;
        if(response.code()!=404) {
             json = response.body().string();
            ResponseDiagramEncuestaInteligenteSkill responseDiagramEncuestaInteligenteSkill = gson.fromJson(json, ResponseDiagramEncuestaInteligenteSkill.class);
            try {
                this.manejadorDiagramEncuestaInteligenteSkill.ejecutar(responseDiagramEncuestaInteligenteSkill,ini, fin);
                guardo = true;
            } catch (Exception e) {
                return e.getMessage()+"\n"+ response.code()+ "\n"+ responseDiagramEncuestaInteligenteSkill.getMsg();

            }
            System.out.println("guardo");


            this.notificacionDiagramEncuestaInteligenteSkill.ejecutar(guardo);
            return json;
        }
        else {
            json= NO_SE_ENCONTRO_DATOS;
            return json;
        }

    }


   }
