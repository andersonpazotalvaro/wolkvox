package co.smart.procesador.agente.estadoporhora.adaptador.repositorio;

import co.smart.procesador.agente.estadoporhora.adaptador.MapperAgenteEstadoPorHora;
import co.smart.procesador.agentes.estadoporhora.modelo.dominio.AgenteEstadoPorHora;
import co.smart.procesador.agentes.estadoporhora.puerto.repositorio.RepositorioAgenteEstadoPorHora;
import co.smart.procesador.agentes.tiempoporestado.modelo.dominio.AgenteTiempoPorEstado;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RepositorioAgenteEstadoPorHoraSql implements RepositorioAgenteEstadoPorHora {

    private final MapperAgenteEstadoPorHora mapperAgenteEstadoPorHora;




    private final RepositorioAgenteEstadoPorHoraJpa repositorioAgenteEstadoPorHoraJpa;
    public RepositorioAgenteEstadoPorHoraSql(MapperAgenteEstadoPorHora mapperAgenteEstadoPorHora, RepositorioAgenteEstadoPorHoraJpa repositorioAgenteEstadoPorHoraJpa) {
        this.mapperAgenteEstadoPorHora = mapperAgenteEstadoPorHora;
        this.repositorioAgenteEstadoPorHoraJpa = repositorioAgenteEstadoPorHoraJpa;
    }

    @Override
    public boolean guardar(AgenteEstadoPorHora agenteEstadoPorHora) {
        var entidadAgenteEstadoPorHora= this.mapperAgenteEstadoPorHora.crearEntity(agenteEstadoPorHora);
        this.repositorioAgenteEstadoPorHoraJpa.save(entidadAgenteEstadoPorHora);
        return false;
    }



    @Override
    public boolean guardarArray(List<AgenteEstadoPorHora> agenteEstadoPorHoras) {
        var listaEntidadagenteEstadoPorHora= this.mapperAgenteEstadoPorHora.convertirDominioAEntidad(agenteEstadoPorHoras);
        this.repositorioAgenteEstadoPorHoraJpa.saveAll(listaEntidadagenteEstadoPorHora);
        return true;
    }

    @Override
    public boolean existe(LocalDate fecha) {
        var entidadAgenteTiempoPorEstados = this.repositorioAgenteEstadoPorHoraJpa.consultarSiExisteRegistroHoy(fecha.toString());
        if (entidadAgenteTiempoPorEstados == null || entidadAgenteTiempoPorEstados.size() == 0) {
            return false;
        }
        return true;
    }


}
