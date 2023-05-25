package co.smart.procesador.agentes.porevento.puerto.repositorio;

import co.smart.procesador.agentes.porevento.modelo.dominio.AgentePorEvento;

import java.time.LocalDate;
import java.util.List;

public interface RepositorioAgentePorEvento {

    boolean guardar(AgentePorEvento agentePorEvento);


    boolean guardarArray(List<AgentePorEvento> agentePorEventos);

    boolean existe(LocalDate fecha, String agent_id);

}
