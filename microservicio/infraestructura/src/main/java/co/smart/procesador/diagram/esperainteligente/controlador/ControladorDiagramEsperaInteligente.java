package co.smart.procesador.diagram.esperainteligente.controlador;


import co.smart.procesador.diagram.email.servicio.NotificacionDiagramEsperaInteligente;
import co.smart.procesador.diagram.esperainteligente.comando.ResponseDiagramEsperaInteligente;
import co.smart.procesador.diagram.esperainteligente.comando.manejador.ManejadorDiagramEsperaInteligente;
import co.smart.procesador.diagram.esperainteligente.consumir.ConsumirEsperaInteligente;
import com.google.gson.Gson;
import okhttp3.Response;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("DiagramEsperaInteligente")
public class ControladorDiagramEsperaInteligente {

        private final static String NO_SE_ENCONTRO_DATOS = "no se encontraron datos para estas fechas";

        private final NotificacionDiagramEsperaInteligente notificacionDiagramEsperaInteligente;

        private final ManejadorDiagramEsperaInteligente manejadorDiagramEsperaInteligente;

        private final ConsumirEsperaInteligente consumirEsperaInteligente;

    public ControladorDiagramEsperaInteligente(NotificacionDiagramEsperaInteligente notificacionDiagramEsperaInteligente, ManejadorDiagramEsperaInteligente manejadorDiagramEsperaInteligente, ConsumirEsperaInteligente consumirEsperaInteligente) {
        this.notificacionDiagramEsperaInteligente = notificacionDiagramEsperaInteligente;
        this.manejadorDiagramEsperaInteligente = manejadorDiagramEsperaInteligente;
        this.consumirEsperaInteligente = consumirEsperaInteligente;
    }

    @RequestMapping(value= "/{ini}/{fin}", method = RequestMethod.POST)
    public String enviar(@PathVariable("ini") String ini, @PathVariable("fin") String fin) throws IOException {

        Response response= this.consumirEsperaInteligente.consumirr(ini,fin);
        boolean guardo= false;
        Gson gson= new Gson();
        String json;
        if(response.code()!=404) {
             json = response.body().string();
            ResponseDiagramEsperaInteligente responseDiagramEsperaInteligente = gson.fromJson(json, ResponseDiagramEsperaInteligente.class);
            try {
                this.manejadorDiagramEsperaInteligente.ejecutar(responseDiagramEsperaInteligente,ini, fin);
                guardo = true;
            } catch (Exception e) {
                return e.getMessage()+"\n"+ response.code()+ "\n"+ responseDiagramEsperaInteligente.getMsg();

            }
            System.out.println("guardo");


            this.notificacionDiagramEsperaInteligente.ejecutar(guardo);
            return json;
        }
        else {
            json= NO_SE_ENCONTRO_DATOS;
            return json;
        }

    }


   }
