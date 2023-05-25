package co.smart.procesador.campañas.resultadotelefonoatelefono.controlador;

import co.smart.procesador.campañas.email.servicio.NotificacionCampañaResultadoTelefonoATelefono;
import co.smart.procesador.campañas.resultadotelefonoatelefono.comando.ResponseCampañaResultadoTelefonoATelefono;
import co.smart.procesador.campañas.resultadotelefonoatelefono.comando.manejador.ManejadorCampañaResultadoTelefonoATelefono;
import co.smart.procesador.campañas.resultadotelefonoatelefono.consumir.ConsumirResultadoTelefonoATelefono;
import com.google.gson.Gson;
import okhttp3.Response;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("CampañaResultadoTelefonoATelefono")
public class ControladorCampañaResultadoTelefonoATeleofno {

        private final static String NO_SE_ENCONTRO_CAMPAÑA = "no se encontro campaña para esta fecha";

        private final NotificacionCampañaResultadoTelefonoATelefono notificacionCampañaResultadoTelefonoATelefono;

        private final ManejadorCampañaResultadoTelefonoATelefono manejadorCampañaResultadoTelefonoATelefono;

        private final ConsumirResultadoTelefonoATelefono consumirResultadoTelefonoATelefono;

    public ControladorCampañaResultadoTelefonoATeleofno(NotificacionCampañaResultadoTelefonoATelefono notificacionCampañaResultadoTelefonoATelefono, ManejadorCampañaResultadoTelefonoATelefono manejadorCampañaResultadoTelefonoATelefono, ConsumirResultadoTelefonoATelefono consumirResultadoTelefonoATelefono) {
        this.notificacionCampañaResultadoTelefonoATelefono = notificacionCampañaResultadoTelefonoATelefono;
        this.manejadorCampañaResultadoTelefonoATelefono = manejadorCampañaResultadoTelefonoATelefono;
        this.consumirResultadoTelefonoATelefono = consumirResultadoTelefonoATelefono;
    }


    @RequestMapping(value= "/{ini}/{fin}/{campana}", method = RequestMethod.POST)
    public String enviar(@PathVariable("ini") String ini, @PathVariable("fin") String fin, @PathVariable("campana") String campaña) throws IOException {

        Response response= this.consumirResultadoTelefonoATelefono.consumirr(ini,fin,campaña);
        boolean guardo= false;
        Gson gson= new Gson();
        String json;
        if(response.code()!=404) {
             json = response.body().string();
            ResponseCampañaResultadoTelefonoATelefono responseCampañaResultadoTelefonoATelefono = gson.fromJson(json, ResponseCampañaResultadoTelefonoATelefono.class);
            try {
                this.manejadorCampañaResultadoTelefonoATelefono.ejecutar(responseCampañaResultadoTelefonoATelefono, ini, fin);
                guardo = true;
            } catch (Exception e) {
                return e.getMessage()+"\n"+ response.code()+ "\n"+ responseCampañaResultadoTelefonoATelefono.getMsg();

            }
            System.out.println("guardo");


            this.notificacionCampañaResultadoTelefonoATelefono.ejecutar(guardo);
            return json;
        }
        else {
            json= NO_SE_ENCONTRO_CAMPAÑA;
            return json;
        }

    }


   }
