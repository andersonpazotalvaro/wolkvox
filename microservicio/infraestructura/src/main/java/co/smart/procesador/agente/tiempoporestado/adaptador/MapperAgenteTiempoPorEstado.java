package co.smart.procesador.agente.tiempoporestado.adaptador;

import co.smart.procesador.agentes.tiempoporestado.modelo.dominio.AgenteTiempoPorEstado;
import co.smart.procesador.agente.tiempoporestado.entidad.EntidadAgenteTiempoPorEstado;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperAgenteTiempoPorEstado {



    public EntidadAgenteTiempoPorEstado crearEntity(AgenteTiempoPorEstado agenteTiempoPorEstado){
        return new EntidadAgenteTiempoPorEstado(
                agenteTiempoPorEstado.getAgent_id(),
                agenteTiempoPorEstado.getAgent_dni(),
                agenteTiempoPorEstado.getAgent_name(),
                agenteTiempoPorEstado.getCalls(),
                agenteTiempoPorEstado.getInbound(),
                agenteTiempoPorEstado.getOutbound(),
                agenteTiempoPorEstado.getInternal(),
                agenteTiempoPorEstado.getReady_time(),
                agenteTiempoPorEstado.getInbound_time(),
                agenteTiempoPorEstado.getOutbound_time(),
                agenteTiempoPorEstado.getAcw_time(),
                agenteTiempoPorEstado.getRing_time(),
                agenteTiempoPorEstado.getLogin_time(),
                agenteTiempoPorEstado.getAht(),
                agenteTiempoPorEstado.getOccupancy(),
                agenteTiempoPorEstado.getAux_time(),
                agenteTiempoPorEstado.getHits(),
                agenteTiempoPorEstado.getRpc(),
                agenteTiempoPorEstado.getAht_outbound(),
                agenteTiempoPorEstado.getAht_inbound(),
                agenteTiempoPorEstado.getLogin(),
                agenteTiempoPorEstado.getLogout(),
                agenteTiempoPorEstado.getFECHA(),
                agenteTiempoPorEstado.getFecha_inicio_carga(),
                agenteTiempoPorEstado.getFecha_fin_carga()

        );
    }

    public List<EntidadAgenteTiempoPorEstado> convertirDominioAEntidad(List<AgenteTiempoPorEstado> agenteTiempoPorEstados){
        var listaEntidadAgenteTiempoPorEstado = new ArrayList<EntidadAgenteTiempoPorEstado>();

        agenteTiempoPorEstados.forEach(agenteTiempoPorEstado -> {
            listaEntidadAgenteTiempoPorEstado.add(this.crearEntity(agenteTiempoPorEstado));

        });
        return listaEntidadAgenteTiempoPorEstado;
    }

    public AgenteTiempoPorEstado crearDominio(EntidadAgenteTiempoPorEstado entidadAgenteTiempoPorEstado){
        return new AgenteTiempoPorEstado(
                entidadAgenteTiempoPorEstado.getAgent_id(),
                entidadAgenteTiempoPorEstado.getAgent_dni(),
                entidadAgenteTiempoPorEstado.getAgent_name(),
                entidadAgenteTiempoPorEstado.getCalls(),
                entidadAgenteTiempoPorEstado.getInbound(),
                entidadAgenteTiempoPorEstado.getOutbound(),
                entidadAgenteTiempoPorEstado.getInternal(),
                entidadAgenteTiempoPorEstado.getReady_time(),
                entidadAgenteTiempoPorEstado.getInbound_time(),
                entidadAgenteTiempoPorEstado.getOutbound_time(),
                entidadAgenteTiempoPorEstado.getAcw_time(),
                entidadAgenteTiempoPorEstado.getRing_time(),
                entidadAgenteTiempoPorEstado.getLogin_time(),
                entidadAgenteTiempoPorEstado.getAht(),
                entidadAgenteTiempoPorEstado.getOccupancy(),
                entidadAgenteTiempoPorEstado.getAux_time(),
                entidadAgenteTiempoPorEstado.getHits(),
                entidadAgenteTiempoPorEstado.getRpc(),
                entidadAgenteTiempoPorEstado.getAht_outbound(),
                entidadAgenteTiempoPorEstado.getAht_inbound(),
                entidadAgenteTiempoPorEstado.getLogin(),
                entidadAgenteTiempoPorEstado.getLogout(),
                entidadAgenteTiempoPorEstado.getFecha_inicio_carga(),
                entidadAgenteTiempoPorEstado.getFecha_inicio_carga()
        );
    }

    public List<AgenteTiempoPorEstado> convertirEntidadADominio(List<EntidadAgenteTiempoPorEstado> entidadAgenteTiempoPorEstados){
        var listaAgenteTiempoPorEstado = new ArrayList<AgenteTiempoPorEstado>();

        entidadAgenteTiempoPorEstados.forEach(entidadAgenteTiempoPorEstado -> {
            listaAgenteTiempoPorEstado.add(this.crearDominio(entidadAgenteTiempoPorEstado));

        });
        return listaAgenteTiempoPorEstado;
    }
}
