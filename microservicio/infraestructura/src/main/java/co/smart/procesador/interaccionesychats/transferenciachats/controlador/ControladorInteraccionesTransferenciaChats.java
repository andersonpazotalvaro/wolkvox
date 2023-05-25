package co.smart.procesador.interaccionesychats.transferenciachats.controlador;

import co.smart.procesador.interaccionesychats.email.servicio.NotificacionInteraccionesTransferenciaChats;
import co.smart.procesador.interaccionesychats.transferenciachats.comando.ResponseInteraccionesTransferenciaChats;
import co.smart.procesador.interaccionesychats.transferenciachats.comando.manejador.ManejadorInteraccionesTransferenciaChats;
import co.smart.procesador.interaccionesychats.transferenciachats.consumir.ConsumirInteraccionesTransferenciaChats;
import com.google.gson.Gson;
import okhttp3.Response;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("Interaccionestransferenciachats")
public class ControladorInteraccionesTransferenciaChats {

        private final static String NO_SE_ENCONTRO_DATOS = "no se encontraron datos para estas fechas";

        private final NotificacionInteraccionesTransferenciaChats notificacionInteraccionesTransferenciaChats;

        private final ManejadorInteraccionesTransferenciaChats manejadorInteraccionesTransferenciaChats;

        private final ConsumirInteraccionesTransferenciaChats consumirInteraccionesTransferenciaChats;


    public ControladorInteraccionesTransferenciaChats(NotificacionInteraccionesTransferenciaChats notificacionInteraccionesTransferenciaChats, ManejadorInteraccionesTransferenciaChats manejadorInteraccionesTransferenciaChats, ConsumirInteraccionesTransferenciaChats consumirInteraccionesTransferenciaChats) {
        this.notificacionInteraccionesTransferenciaChats = notificacionInteraccionesTransferenciaChats;
        this.manejadorInteraccionesTransferenciaChats = manejadorInteraccionesTransferenciaChats;
        this.consumirInteraccionesTransferenciaChats = consumirInteraccionesTransferenciaChats;
    }

    @RequestMapping(value= "/{ini}/{fin}", method = RequestMethod.POST)
    public String enviar(@PathVariable("ini") String ini, @PathVariable("fin") String fin) throws IOException {

        Response response= this.consumirInteraccionesTransferenciaChats.consumirr(ini,fin);
        boolean guardo= false;
        Gson gson= new Gson();
        String json;
        if(response.code()!=404) {
             json = response.body().string();
            ResponseInteraccionesTransferenciaChats responseInteraccionesTransferenciaChats= gson.fromJson(json, ResponseInteraccionesTransferenciaChats.class);
            try {
                this.manejadorInteraccionesTransferenciaChats.ejecutar(responseInteraccionesTransferenciaChats, ini, fin);
                guardo = true;
            } catch (Exception e) {
                return e.getMessage()+"\n"+ response.code()+ "\n"+ responseInteraccionesTransferenciaChats.getMsg();
            }
            System.out.println("guardo");


            this.notificacionInteraccionesTransferenciaChats.ejecutar(guardo);
            return json;
        }
        else {
            json= NO_SE_ENCONTRO_DATOS;
            return json;
        }

    }



   }
