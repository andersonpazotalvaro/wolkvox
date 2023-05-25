package co.smart.procesador.skillsyservicios.detallellamadasabandonadas.adaptador.repositorio;

import co.smart.procesador.skillsyservicios.detallellamadasabandonadas.entidad.EntidadSkillsDetalleLlamadasAbandonadas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioSkillsDetalleLlamadasAbandonadasJpa extends JpaRepository<EntidadSkillsDetalleLlamadasAbandonadas, Long> {

    @Query(nativeQuery = true,
            value = "Select *  from wolkvox.detalle_llamadas_abandonadas WHERE :fechabuscada BETWEEN fecha_inicio_carga AND fecha_fin_carga")
    List<EntidadSkillsDetalleLlamadasAbandonadas> consultarSiExisteRegistroHoy(@Param("fechabuscada")String fecha);

}
