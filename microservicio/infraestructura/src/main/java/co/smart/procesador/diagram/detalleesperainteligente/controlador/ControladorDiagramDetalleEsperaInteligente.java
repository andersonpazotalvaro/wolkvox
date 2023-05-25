package co.smart.procesador.diagram.detalleesperainteligente.controlador;


import co.smart.procesador.diagram.detalleesperainteligente.comando.ResponseDiagramDetalleEsperaInteligente;
import co.smart.procesador.diagram.detalleesperainteligente.comando.manejador.ManejadorDiagramDetalleEsperaInteligente;
import co.smart.procesador.diagram.detalleesperainteligente.consumir.ConsumirDetalleEsperaInteligente;
import co.smart.procesador.diagram.email.servicio.NotificacionDiagramDetalleEsperaInteligente;
import co.smart.procesador.diagram.esperainteligente.comando.ResponseDiagramEsperaInteligente;
import com.google.gson.Gson;
import okhttp3.Response;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("DiagramDetalleEsperaInteligente")
public class ControladorDiagramDetalleEsperaInteligente {

        private final static String NO_SE_ENCONTRO_DATOS = "no se encontraron datos para estas fechas";

        private final NotificacionDiagramDetalleEsperaInteligente notificacionDiagramDetalleEsperaInteligente;

        private final ManejadorDiagramDetalleEsperaInteligente manejadorDiagramDetalleEsperaInteligente;

        private final ConsumirDetalleEsperaInteligente consumirDetalleEsperaInteligente;

    public ControladorDiagramDetalleEsperaInteligente(NotificacionDiagramDetalleEsperaInteligente notificacionDiagramDetalleEsperaInteligente, ManejadorDiagramDetalleEsperaInteligente manejadorDiagramDetalleEsperaInteligente, ConsumirDetalleEsperaInteligente consumirDetalleEsperaInteligente) {
        this.notificacionDiagramDetalleEsperaInteligente = notificacionDiagramDetalleEsperaInteligente;
        this.manejadorDiagramDetalleEsperaInteligente = manejadorDiagramDetalleEsperaInteligente;
        this.consumirDetalleEsperaInteligente = consumirDetalleEsperaInteligente;
    }


    @RequestMapping(value= "/{ini}/{fin}", method = RequestMethod.POST)
    public String enviar(@PathVariable("ini") String ini, @PathVariable("fin") String fin) throws IOException {

        Response response= this.consumirDetalleEsperaInteligente.consumirr(ini,fin);
        boolean guardo= false;
        Gson gson= new Gson();
        String json;
        if(response.code()!=404) {
             json = response.body().string();
            ResponseDiagramDetalleEsperaInteligente responseDiagramDetalleEsperaInteligente = gson.fromJson(json, ResponseDiagramDetalleEsperaInteligente.class);
            try {
                this.manejadorDiagramDetalleEsperaInteligente.ejecutar(responseDiagramDetalleEsperaInteligente,ini, fin);
                guardo = true;
            } catch (Exception e) {
                return e.getMessage()+"\n"+ response.code()+ "\n"+ responseDiagramDetalleEsperaInteligente.getMsg();

            }
            System.out.println("guardo");


            this.notificacionDiagramDetalleEsperaInteligente.ejecutar(guardo);
            return json;
        }
        else {
            json= NO_SE_ENCONTRO_DATOS;
            return json;
        }

    }


   }
