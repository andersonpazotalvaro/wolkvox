package co.smart.procesador.informacion.codigosactividad.controlador;


import co.smart.procesador.informacion.codigosactividad.comando.ResponseInformacionCodigosActividad;
import co.smart.procesador.informacion.codigosactividad.comando.manejador.ManejadorInformacionCodigosActividad;
import co.smart.procesador.informacion.codigosactividad.consumir.ConsumirInformacionsCodigosActividad;
import co.smart.procesador.informacion.email.servicio.NotificacionInformacionCodigosActividad;
import com.google.gson.Gson;
import okhttp3.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("Informacioncodigos")
public class ControladorInformacionCodigosActividad {

        private final static String NO_SE_ENCONTRO_DATOS = "no se encontraron datos para estas fechas";

        private final NotificacionInformacionCodigosActividad notificacionInformacionCodigosActividad;

        private final ManejadorInformacionCodigosActividad manejadorInformacionCodigosActividad;

        private final ConsumirInformacionsCodigosActividad consumirInformacionsCodigosActividad;


    public ControladorInformacionCodigosActividad(NotificacionInformacionCodigosActividad notificacionInformacionCodigosActividad, ManejadorInformacionCodigosActividad manejadorInformacionCodigosActividad, ConsumirInformacionsCodigosActividad consumirInformacionsCodigosActividad) {
        this.notificacionInformacionCodigosActividad = notificacionInformacionCodigosActividad;
        this.manejadorInformacionCodigosActividad = manejadorInformacionCodigosActividad;
        this.consumirInformacionsCodigosActividad = consumirInformacionsCodigosActividad;
    }

    @RequestMapping(value= "/guardar", method = RequestMethod.POST)
    public String enviar() throws IOException {

        Response response= this.consumirInformacionsCodigosActividad.consumirr();
        boolean guardo= false;
        Gson gson= new Gson();
        String json;
        if(response.code()!=404) {
             json = response.body().string();
            ResponseInformacionCodigosActividad responseInformacionCodigosActividad= gson.fromJson(json, ResponseInformacionCodigosActividad.class);
            try {
                this.manejadorInformacionCodigosActividad.ejecutar(responseInformacionCodigosActividad);
                guardo = true;
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("guardo");


            this.notificacionInformacionCodigosActividad.ejecutar(guardo);
            return json;
        }
        else {
            json= NO_SE_ENCONTRO_DATOS;
            return json;
        }

    }



   }
