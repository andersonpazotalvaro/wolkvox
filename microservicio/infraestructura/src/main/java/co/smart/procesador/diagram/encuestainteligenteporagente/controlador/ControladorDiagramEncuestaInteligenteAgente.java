package co.smart.procesador.diagram.encuestainteligenteporagente.controlador;


import co.smart.procesador.diagram.email.servicio.NotificacionDiagramEncuestaInteligenteAgente;
import co.smart.procesador.diagram.encuestainteligenteporagente.comando.ResponseDiagramEncuestaInteligenteAgente;
import co.smart.procesador.diagram.encuestainteligenteporagente.comando.manejador.ManejadorDiagramEncuestaInteligenteAgente;
import co.smart.procesador.diagram.encuestainteligenteporagente.consumir.ConsumirEncuestaInteligenteAgente;
import co.smart.procesador.diagram.esperainteligente.comando.ResponseDiagramEsperaInteligente;
import com.google.gson.Gson;
import okhttp3.Response;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("DiagramEncuestaInteligenteAgente")
public class ControladorDiagramEncuestaInteligenteAgente {

        private final static String NO_SE_ENCONTRO_DATOS = "no se encontraron datos para estas fechas";

        private final NotificacionDiagramEncuestaInteligenteAgente notificacionDiagramEncuestaInteligenteAgente;

        private final ManejadorDiagramEncuestaInteligenteAgente manejadorDiagramEncuestaInteligenteAgente;

        private final ConsumirEncuestaInteligenteAgente consumirEncuestaInteligenteAgente;

    public ControladorDiagramEncuestaInteligenteAgente(NotificacionDiagramEncuestaInteligenteAgente notificacionDiagramEncuestaInteligenteAgente, ManejadorDiagramEncuestaInteligenteAgente manejadorDiagramEncuestaInteligenteAgente, ConsumirEncuestaInteligenteAgente consumirEncuestaInteligenteAgente) {
        this.notificacionDiagramEncuestaInteligenteAgente = notificacionDiagramEncuestaInteligenteAgente;
        this.manejadorDiagramEncuestaInteligenteAgente = manejadorDiagramEncuestaInteligenteAgente;
        this.consumirEncuestaInteligenteAgente = consumirEncuestaInteligenteAgente;
    }


    @RequestMapping(value= "/{ini}/{fin}", method = RequestMethod.POST)
    public String enviar(@PathVariable("ini") String ini, @PathVariable("fin") String fin) throws IOException {

        Response response= this.consumirEncuestaInteligenteAgente.consumirr(ini,fin);
        boolean guardo= false;
        Gson gson= new Gson();
        String json;
        if(response.code()!=404) {
             json = response.body().string();
            ResponseDiagramEncuestaInteligenteAgente responseDiagramEncuestaInteligenteAgente = gson.fromJson(json, ResponseDiagramEncuestaInteligenteAgente.class);
            try {
                this.manejadorDiagramEncuestaInteligenteAgente.ejecutar(responseDiagramEncuestaInteligenteAgente, ini, fin);
                guardo = true;
            } catch (Exception e) {
                return e.getMessage()+"\n"+ response.code()+ "\n"+ responseDiagramEncuestaInteligenteAgente.getMsg();

            }
            System.out.println("guardo");


            this.notificacionDiagramEncuestaInteligenteAgente.ejecutar(guardo);
            return json;
        }
        else {
            json= NO_SE_ENCONTRO_DATOS;
            return json;
        }

    }


   }
