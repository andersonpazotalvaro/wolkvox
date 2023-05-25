package co.smart.procesador.agente.estadoporhora.controlador;

import co.smart.procesador.agentes.email.servicio.NotificacionAgenteEstadoPorHora;
import co.smart.procesador.agentes.estadopohora.comando.ResponseAgenteEstadoPorHora;
import co.smart.procesador.agentes.estadopohora.comando.manejador.ManejadorAgenteEstadoPorHora;
import co.smart.procesador.agentes.estadoporhora.consumir.ConsumirEstadoPorHora;
import co.smart.procesador.datos.servicio.ServicioGenerarFechasDiarias;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDate;

@RestController
@RequestMapping("AgenteEstadoPorHora")
public class ControladorAgenteEstadoPorHora {


        private final NotificacionAgenteEstadoPorHora notificacionAgenteEstadoPorHora;

        private final ManejadorAgenteEstadoPorHora manejadorAgenteEstadoPorHora;
        private final ConsumirEstadoPorHora consumir;

    public ControladorAgenteEstadoPorHora(NotificacionAgenteEstadoPorHora notificacionAgenteEstadoPorHora, ManejadorAgenteEstadoPorHora manejadorAgenteEstadoPorHora, ConsumirEstadoPorHora consumir) {
        this.notificacionAgenteEstadoPorHora = notificacionAgenteEstadoPorHora;
        this.manejadorAgenteEstadoPorHora = manejadorAgenteEstadoPorHora;
        this.consumir = consumir;
    }

    @RequestMapping(value= "/{ini}/{fin}", method = RequestMethod.POST)
    public String enviar(@PathVariable("ini") String ini, @PathVariable("fin") String fin) throws IOException {

        var response= this.consumir.consumirr(ini,fin);
        String json= response.body().string();


        boolean guardo= false;
        Gson gson= new Gson();
       ResponseAgenteEstadoPorHora responseAgenteEstadosPorHora = gson.fromJson(json, ResponseAgenteEstadoPorHora.class);
        try {
            this.manejadorAgenteEstadoPorHora.ejecutar(responseAgenteEstadosPorHora,ini, fin);
            guardo= true;
        }catch (Exception e){

                return e.getMessage()+"\n"+ response.code()+ "\n"+ responseAgenteEstadosPorHora.getMsg();
        }



        this.notificacionAgenteEstadoPorHora.ejecutar(guardo);
        return json;

    }


   }
