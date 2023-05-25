package co.smart.procesador.agente.tiempoporestado.adaptador.repositorio;

import co.smart.procesador.agente.tiempoporestado.entidad.EntidadAgenteTiempoPorEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioAgenteTiempoPorEstadoJpa extends JpaRepository<EntidadAgenteTiempoPorEstado, Long> {

    @Query(nativeQuery = true,
            value = "Select *  from wolkvox.agente_tiempo_por_estado group by agent_id")
    List<EntidadAgenteTiempoPorEstado> consultarDistinctIpAgent();

    @Query(nativeQuery = true,
            value = "SELECT * FROM wolkvox.agente_tiempo_por_estado WHERE :fechabuscada BETWEEN fecha_inicio_carga AND fecha_fin_carga")
    List<EntidadAgenteTiempoPorEstado> consultarSiExisteRegistroHoy(@Param("fechabuscada")String fecha);

}
