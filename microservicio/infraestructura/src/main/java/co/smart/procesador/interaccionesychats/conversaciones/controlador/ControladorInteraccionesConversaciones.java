package co.smart.procesador.interaccionesychats.conversaciones.controlador;

import co.smart.procesador.interaccionesychats.conversaciones.comando.ResponseInteraccionesConversaciones;
import co.smart.procesador.interaccionesychats.conversaciones.comando.manejador.ManejadorInteraccionesConversaciones;
import co.smart.procesador.interaccionesychats.conversaciones.consumir.ConsumirInteraccionesConversaciones;
import co.smart.procesador.interaccionesychats.email.servicio.NotificacionInteraccionesConversaciones;
import com.google.gson.Gson;
import okhttp3.Response;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("Interaccionesconversaciones")
public class ControladorInteraccionesConversaciones {

        private final static String NO_SE_ENCONTRO_DATOS = "no se encontraron datos para estas fechas";

        private final NotificacionInteraccionesConversaciones notificacionInteraccionesConversaciones;

        private final ManejadorInteraccionesConversaciones manejadorInteraccionesConversaciones;

        private final ConsumirInteraccionesConversaciones consumirInteraccionesConversaciones;


    public ControladorInteraccionesConversaciones(NotificacionInteraccionesConversaciones notificacionInteraccionesConversaciones, ManejadorInteraccionesConversaciones manejadorInteraccionesConversaciones, ConsumirInteraccionesConversaciones consumirInteraccionesConversaciones) {
        this.notificacionInteraccionesConversaciones = notificacionInteraccionesConversaciones;
        this.manejadorInteraccionesConversaciones = manejadorInteraccionesConversaciones;
        this.consumirInteraccionesConversaciones = consumirInteraccionesConversaciones;
    }

    @RequestMapping(value= "/{ini}/{fin}", method = RequestMethod.POST)
    public String enviar(@PathVariable("ini") String ini, @PathVariable("fin") String fin) throws IOException {

        Response response= this.consumirInteraccionesConversaciones.consumirr(ini,fin);
        boolean guardo= false;
        Gson gson= new Gson();
        String json;

        //if(response.code()!=404) {
            if(true) {
             json = response.body().string();
            ResponseInteraccionesConversaciones responseInteraccionesConversaciones= gson.fromJson(json, ResponseInteraccionesConversaciones.class);
            try {
                this.manejadorInteraccionesConversaciones.ejecutar(responseInteraccionesConversaciones, ini, fin);
                guardo = true;
            } catch (Exception e) {
                return e.getMessage()+"\n"+ response.code()+ "\n"+ responseInteraccionesConversaciones.getMsg();
            }
            System.out.println("guardo");


            this.notificacionInteraccionesConversaciones.ejecutar(guardo);
            return json;
        }
        else {
            json= NO_SE_ENCONTRO_DATOS;
            return json;
        }

    }



   }
