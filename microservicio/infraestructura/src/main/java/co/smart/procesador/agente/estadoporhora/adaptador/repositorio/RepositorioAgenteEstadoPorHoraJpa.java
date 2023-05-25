package co.smart.procesador.agente.estadoporhora.adaptador.repositorio;

import co.smart.procesador.agente.estadoporhora.entidad.EntidadAgenteEstadoPorHora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioAgenteEstadoPorHoraJpa extends JpaRepository<EntidadAgenteEstadoPorHora, Long> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM wolkvox.agente_estado_por_hora WHERE :fechabuscada BETWEEN fecha_inicio_carga AND fecha_fin_carga")
    List<EntidadAgenteEstadoPorHora> consultarSiExisteRegistroHoy(@Param("fechabuscada")String fecha);

}
