package co.smart.procesador.agente.porevento.controlador;

import co.smart.procesador.agentes.email.servicio.NotificacionAgentePorEvento;
import co.smart.procesador.agentes.porevento.comando.ResponseAgentePorEvento;
import co.smart.procesador.agentes.porevento.comando.fabrica.FabricaAgentePorEvento;
import co.smart.procesador.agentes.porevento.comando.manejador.ManejadorAgentePorEvento;
import co.smart.procesador.agentes.porevento.consumir.ConsumirPorEvento;
import co.smart.procesador.agentes.porevento.modelo.respuesta.ResponseDataAgentePorEvento;
import co.smart.procesador.agentes.tiempoporestado.servicio.ServicioConsultarIpAgent;
import com.google.gson.Gson;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("AgentePorEvento")
public class ControladorAgentePorEvento {

        private final RestTemplate restTemplate;
        private final NotificacionAgentePorEvento notificacionAgentePorEvento;

        private final ManejadorAgentePorEvento manejadorAgentePorEvento;

        private final ConsumirPorEvento consumir;

        private final ServicioConsultarIpAgent servicioConsultarIpAgent;

        private final FabricaAgentePorEvento fabricaAgentePorEvento;

    public ControladorAgentePorEvento(RestTemplate restTemplate, NotificacionAgentePorEvento notificacionAgentePorEvento, ManejadorAgentePorEvento manejadorAgentePorEvento, ConsumirPorEvento consumir, ServicioConsultarIpAgent servicioConsultarIpAgent, FabricaAgentePorEvento fabricaAgentePorEvento) {
        this.restTemplate = restTemplate;
        this.notificacionAgentePorEvento = notificacionAgentePorEvento;
        this.manejadorAgentePorEvento = manejadorAgentePorEvento;
        this.consumir = consumir;
        this.servicioConsultarIpAgent = servicioConsultarIpAgent;
        this.fabricaAgentePorEvento = fabricaAgentePorEvento;
    }

    //@Async
    @RequestMapping(value= "/{ini}/{fin}", method = RequestMethod.POST)
    public boolean enviar(@PathVariable("ini") String ini, @PathVariable("fin") String fin) throws IOException {

            List<ResponseDataAgentePorEvento> responseDataAgentePorEventos = new ArrayList<ResponseDataAgentePorEvento>();
            var listaAgentesTiempoPorEstado = this.servicioConsultarIpAgent.ejecutar();
            boolean guardo = false;
            Gson gson = new Gson();


        try {


            listaAgentesTiempoPorEstado.forEach(agenteTiempoPorEstado -> {
                String json;
                try {
                    json = this.consumir.consumirr(ini, fin, agenteTiempoPorEstado.getAgent_id()).body().string();
                    ResponseAgentePorEvento responseAgentePorEvento = gson.fromJson(json, ResponseAgentePorEvento.class);
                    this.manejadorAgentePorEvento.ejecutar(responseAgentePorEvento);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            /*String json;
            for (int i=0; i<= listaAgentesTiempoPorEstado.size();i++){
                String agentid= listaAgentesTiempoPorEstado.get(i).getAgent_id();
                json = this.consumir.consumirr(ini, fin, agentid).body().string();
                ResponseAgentePorEvento responseAgentePorEvento = gson.fromJson(json, ResponseAgentePorEvento.class);
                this.manejadorAgentePorEvento.ejecutar(responseAgentePorEvento);
            }*/

            guardo = true;
        }catch (Exception e){

        }
            System.out.println("guardo");
            this.notificacionAgentePorEvento.ejecutar(guardo);
            return guardo;

    }


   }
