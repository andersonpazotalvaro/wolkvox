package co.smart.procesador.agente.porevento.adaptador.repositorio;

import co.smart.procesador.agente.porevento.entidad.EntidadAgentePorEvento;
import co.smart.procesador.agente.tiempoporestado.entidad.EntidadAgenteTiempoPorEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioAgentePorEventoJpa extends JpaRepository<EntidadAgentePorEvento, Long> {

    @Query(nativeQuery = true,
            value = "Select *  from wolkvox.agente_por_evento where fecha= :fechabuscada and agent_id= :agent group by fecha")
    List<EntidadAgentePorEvento> consultarSiExisteRegistroHoy(@Param("fechabuscada")String fecha,@Param("agent") String agent);

}
