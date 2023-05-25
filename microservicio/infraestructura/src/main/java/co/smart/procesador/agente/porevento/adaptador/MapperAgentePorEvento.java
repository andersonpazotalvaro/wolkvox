package co.smart.procesador.agente.porevento.adaptador;

import co.smart.procesador.agente.porevento.entidad.EntidadAgentePorEvento;
import co.smart.procesador.agentes.porevento.modelo.dominio.AgentePorEvento;
import co.smart.procesador.agentes.tiempoporestado.modelo.dominio.AgenteTiempoPorEstado;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperAgentePorEvento {



    public EntidadAgentePorEvento crearEntity(AgentePorEvento agentePorEvento){
        return new EntidadAgentePorEvento(
                agentePorEvento.getAgent_id(),
                agentePorEvento.getAgent_status(),
                agentePorEvento.getTime(),
                agentePorEvento.getDate_ini(),
                agentePorEvento.getDate_end(),
                agentePorEvento.getConn_id(),
                agentePorEvento.getType_interaction(),
                agentePorEvento.getDestiny(),
                agentePorEvento.getTelephone(),
                agentePorEvento.getCampaign_id(),
                agentePorEvento.getFECHA()

        );
    }

    public List<EntidadAgentePorEvento> convertirDominioAEntidad(List<AgentePorEvento> agentePorEventos){
        var listaEntidadAgentePorEvento = new ArrayList<EntidadAgentePorEvento>();

        agentePorEventos.forEach(agentePorEvento -> {
            listaEntidadAgentePorEvento.add(this.crearEntity(agentePorEvento));

        });
        return listaEntidadAgentePorEvento;
    }
}
