package co.smart.procesador.agente.tiempoporestado.adaptador.repositorio;

import co.smart.procesador.agente.tiempoporestado.adaptador.MapperAgenteTiempoPorEstado;
import co.smart.procesador.agente.tiempoporestado.entidad.EntidadAgenteTiempoPorEstado;
import co.smart.procesador.agentes.tiempoporestado.modelo.dominio.AgenteTiempoPorEstado;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioAgenteTiempoPorEstadoSql implements co.smart.procesador.agentes.tiempoporestado.puerto.repositorio.RepositorioAgenteTiempoPorEstado {

    private final MapperAgenteTiempoPorEstado mapperAgenteTiempoPorEstado;




    private final RepositorioAgenteTiempoPorEstadoJpa repositorioAgenteTiempoPorEstadoJpa;
    public RepositorioAgenteTiempoPorEstadoSql(MapperAgenteTiempoPorEstado mapperAgenteTiempoPorEstado,  RepositorioAgenteTiempoPorEstadoJpa repositorioAgenteTiempoPorEstadoJpa) {
        this.mapperAgenteTiempoPorEstado = mapperAgenteTiempoPorEstado;
        this.repositorioAgenteTiempoPorEstadoJpa = repositorioAgenteTiempoPorEstadoJpa;
    }

    @Override
    public boolean guardar(AgenteTiempoPorEstado agenteTiempoPorEstado) {
        var entidadAgenteTiempoPorEstado= this.mapperAgenteTiempoPorEstado.crearEntity(agenteTiempoPorEstado);
        this.repositorioAgenteTiempoPorEstadoJpa.save(entidadAgenteTiempoPorEstado);
        return false;
    }



    @Override
    public boolean guardarArray(List<AgenteTiempoPorEstado> agenteTiempoPorEstados) {
        var listaEntidadagenteTiempoPorEstado= this.mapperAgenteTiempoPorEstado.convertirDominioAEntidad(agenteTiempoPorEstados);
        this.repositorioAgenteTiempoPorEstadoJpa.saveAll(listaEntidadagenteTiempoPorEstado);
        return true;
    }

    @Override
    public boolean existe(LocalDate fecha) {
        var entidadAgenteTiempoPorEstados = this.repositorioAgenteTiempoPorEstadoJpa.consultarSiExisteRegistroHoy(fecha.toString());
        if (entidadAgenteTiempoPorEstados == null || entidadAgenteTiempoPorEstados.size() == 0) {
            return false;
        }
        return true;
    }

    @Override
    public List<AgenteTiempoPorEstado> listarIpAgent() {
        var entidad= this.repositorioAgenteTiempoPorEstadoJpa.consultarDistinctIpAgent();
        var lista= this.mapperAgenteTiempoPorEstado.convertirEntidadADominio(entidad);
        return lista;
    }


}
