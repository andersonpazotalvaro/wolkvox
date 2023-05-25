package co.smart.procesador.agente.tiempoporestado.controlador;

import co.smart.procesador.agentes.email.servicio.NotificacionAgenteTiempoPorEstado;
import co.smart.procesador.agentes.tiempoporestado.comando.ResponseAgenteTiempoPorEstado;
import co.smart.procesador.agentes.tiempoporestado.consumir.ConsumirTiempoPorEstado;
import co.smart.procesador.agentes.tiempoporestado.comando.manejador.ManejadorAgenteTiempoPorEstado;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
@RequestMapping("AgenteTiempoPorEstado")
public class ControladorAgenteTiempoPorEstado {


        private final NotificacionAgenteTiempoPorEstado notificacionAgenteTiempoPorEstado;

        private final ManejadorAgenteTiempoPorEstado manejadorAgenteTiempoPorEstado;

        private final ConsumirTiempoPorEstado consumir;

    public ControladorAgenteTiempoPorEstado(NotificacionAgenteTiempoPorEstado notificacionAgenteTiempoPorEstado, ManejadorAgenteTiempoPorEstado manejadorAgenteTiempoPorEstado, ConsumirTiempoPorEstado consumir) {
        this.notificacionAgenteTiempoPorEstado = notificacionAgenteTiempoPorEstado;
        this.manejadorAgenteTiempoPorEstado = manejadorAgenteTiempoPorEstado;
        this.consumir = consumir;
    }




    @RequestMapping(value= "/{ini}/{fin}", method = RequestMethod.POST)
    public String enviar(@PathVariable("ini") String ini, @PathVariable("fin") String fin) throws IOException {


        var response= this.consumir.consumirr(ini,fin);
        String json= response.body().string();


        boolean guardo= false;
        Gson gson= new Gson();
       ResponseAgenteTiempoPorEstado responseAgenteEstadosPorEstado = gson.fromJson(json, ResponseAgenteTiempoPorEstado.class);
        try {
            this.manejadorAgenteTiempoPorEstado.ejecutar(responseAgenteEstadosPorEstado, ini, fin);
            guardo= true;
        }catch (Exception e){
            return e.getMessage()+"\n"+ response.code()+ "\n"+ responseAgenteEstadosPorEstado.getMsg();
        }



        this.notificacionAgenteTiempoPorEstado.ejecutar(guardo);
        return json;

    }


   }
