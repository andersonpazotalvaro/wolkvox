package co.smart.procesador.informacion.skill.controlador;


import co.smart.procesador.informacion.email.servicio.NotificacionInformacionSkills;
import co.smart.procesador.informacion.skill.comando.ResponseInformacionSkills;
import co.smart.procesador.informacion.skill.comando.manejador.ManejadorInformacionSkills;
import co.smart.procesador.informacion.skill.consumir.ConsumirInformacionsSkills;
import co.smart.procesador.interaccionesychats.chats.comando.ResponseInteraccionesChats;
import co.smart.procesador.interaccionesychats.chats.comando.manejador.ManejadorInteraccionesChats;
import co.smart.procesador.interaccionesychats.chats.consumir.ConsumirInteraccionesChats;
import co.smart.procesador.interaccionesychats.email.servicio.NotificacionInteraccionesChats;
import com.google.gson.Gson;
import okhttp3.Response;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("Informacionskills")
public class ControladorInformacionSkills {

        private final static String NO_SE_ENCONTRO_DATOS = "no se encontraron datos para estas fechas";

        private final NotificacionInformacionSkills notificacionInformacionSkills;

        private final ManejadorInformacionSkills manejadorInformacionSkills;

        private final ConsumirInformacionsSkills consumirInformacionsSkills;


    public ControladorInformacionSkills(NotificacionInformacionSkills notificacionInformacionSkills, ManejadorInformacionSkills manejadorInformacionSkills, ConsumirInformacionsSkills consumirInformacionsSkills) {
        this.notificacionInformacionSkills = notificacionInformacionSkills;
        this.manejadorInformacionSkills = manejadorInformacionSkills;
        this.consumirInformacionsSkills = consumirInformacionsSkills;
    }

    @RequestMapping(value= "/guardar", method = RequestMethod.POST)
    public String enviar() throws IOException {

        Response response= this.consumirInformacionsSkills.consumirr();
        boolean guardo= false;
        Gson gson= new Gson();
        String json;
        if(response.code()!=404) {
             json = response.body().string();
            ResponseInformacionSkills responseInformacionSkills= gson.fromJson(json, ResponseInformacionSkills.class);
            try {
                this.manejadorInformacionSkills.ejecutar(responseInformacionSkills);
                guardo = true;
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("guardo");


            this.notificacionInformacionSkills.ejecutar(guardo);
            return json;
        }
        else {
            json= NO_SE_ENCONTRO_DATOS;
            return json;
        }

    }



   }
