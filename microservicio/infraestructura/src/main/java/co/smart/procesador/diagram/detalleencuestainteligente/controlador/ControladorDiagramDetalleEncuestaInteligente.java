package co.smart.procesador.diagram.detalleencuestainteligente.controlador;


import co.smart.procesador.diagram.detalleencuestainteligente.comando.ResponseDiagramDetalleEncuestaInteligente;
import co.smart.procesador.diagram.detalleencuestainteligente.comando.manejador.ManejadorDiagramDetalleEncuestaInteligente;
import co.smart.procesador.diagram.detalleencuestainteligente.consumir.ConsumirDetalleEncuestaInteligente;
import co.smart.procesador.diagram.detalleesperainteligente.comando.ResponseDiagramDetalleEsperaInteligente;
import co.smart.procesador.diagram.email.servicio.NotificacionDiagramDetalleEncuestaInteligente;
import com.google.gson.Gson;
import okhttp3.Response;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("DiagramDetalleEncuestaInteligente")
public class ControladorDiagramDetalleEncuestaInteligente {

        private final static String NO_SE_ENCONTRO_DATOS = "no se encontraron datos para estas fechas";

        private final NotificacionDiagramDetalleEncuestaInteligente notificacionDiagramDetalleEncuestaInteligente;

        private final ManejadorDiagramDetalleEncuestaInteligente manejadorDiagramDetalleEncuestaInteligente;

        private final ConsumirDetalleEncuestaInteligente consumirDetalleEncuestaInteligente;

    public ControladorDiagramDetalleEncuestaInteligente(NotificacionDiagramDetalleEncuestaInteligente notificacionDiagramDetalleEncuestaInteligente, ManejadorDiagramDetalleEncuestaInteligente manejadorDiagramDetalleEncuestaInteligente, ConsumirDetalleEncuestaInteligente consumirDetalleEncuestaInteligente) {
        this.notificacionDiagramDetalleEncuestaInteligente = notificacionDiagramDetalleEncuestaInteligente;
        this.manejadorDiagramDetalleEncuestaInteligente = manejadorDiagramDetalleEncuestaInteligente;
        this.consumirDetalleEncuestaInteligente = consumirDetalleEncuestaInteligente;
    }


    @RequestMapping(value= "/{ini}/{fin}", method = RequestMethod.POST)
    public String enviar(@PathVariable("ini") String ini, @PathVariable("fin") String fin) throws IOException {

        Response response= this.consumirDetalleEncuestaInteligente.consumirr(ini,fin);
        boolean guardo= false;
        Gson gson= new Gson();
        String json;
        if(response.code()!=404) {
             json = response.body().string();
            ResponseDiagramDetalleEncuestaInteligente responseDiagramDetalleEncuestaInteligente = gson.fromJson(json, ResponseDiagramDetalleEncuestaInteligente.class);
            try {
                this.manejadorDiagramDetalleEncuestaInteligente.ejecutar(responseDiagramDetalleEncuestaInteligente,ini, fin);
                guardo = true;
            } catch (Exception e) {
                return e.getMessage()+"\n"+ response.code()+ "\n"+ responseDiagramDetalleEncuestaInteligente.getMsg();

            }
            System.out.println("guardo");


            this.notificacionDiagramDetalleEncuestaInteligente.ejecutar(guardo);
            return json;
        }
        else {
            json= NO_SE_ENCONTRO_DATOS;
            return json;
        }

    }


   }
