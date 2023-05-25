package co.smart.procesador.agente.porevento.adaptador.repositorio;

import co.smart.procesador.agente.porevento.adaptador.MapperAgentePorEvento;
import co.smart.procesador.agentes.porevento.modelo.dominio.AgentePorEvento;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RepositorioAgentePorEventoSql implements co.smart.procesador.agentes.porevento.puerto.repositorio.RepositorioAgentePorEvento {

    private final MapperAgentePorEvento mapperAgentePorEvento;
    private final RepositorioAgentePorEventoJpa repositorioAgentePorEventoJpa;
    public RepositorioAgentePorEventoSql(MapperAgentePorEvento mapperAgentePorEvento, RepositorioAgentePorEventoJpa repositorioAgentePorEventoJpa) {
        this.mapperAgentePorEvento = mapperAgentePorEvento;
        this.repositorioAgentePorEventoJpa = repositorioAgentePorEventoJpa;
    }

    @Override
    public boolean guardar(AgentePorEvento agentePorEvento) {
        var entidadAgentePorEvento= this.mapperAgentePorEvento.crearEntity(agentePorEvento);
        this.repositorioAgentePorEventoJpa.save(entidadAgentePorEvento);
        return false;
    }



    //@Async
    @Override
    public boolean guardarArray(List<AgentePorEvento> agentePorEventos) {
        var listaEntidadAgentePorEvento= this.mapperAgentePorEvento.convertirDominioAEntidad(agentePorEventos);
        this.repositorioAgentePorEventoJpa.saveAll(listaEntidadAgentePorEvento);
        return true;
    }

    @Override
    public boolean existe(LocalDate fecha, String agent_id) {
        var entidadAgenteTiempoPorEstados = this.repositorioAgentePorEventoJpa.consultarSiExisteRegistroHoy(fecha.toString(), agent_id);
        if (entidadAgenteTiempoPorEstados == null || entidadAgenteTiempoPorEstados.size() == 0) {
            return false;
        }
        return true;
    }


}
