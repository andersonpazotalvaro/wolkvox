package co.smart.procesador.skillsyservicios.detallellamadascontestadas.adaptador.repositorio;

import co.smart.procesador.skillsyservicios.detallellamadascontestadas.entidad.EntidadSkillsDetalleLlamadasContestadas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioSkillsDetalleLlamadasContestadasJpa extends JpaRepository<EntidadSkillsDetalleLlamadasContestadas, Long> {

    @Query(nativeQuery = true,
            value = "Select *  from wolkvox.detalle_llamadas_contestadas WHERE :fechabuscada BETWEEN fecha_inicio_carga AND fecha_fin_carga")
    List<EntidadSkillsDetalleLlamadasContestadas> consultarSiExisteRegistroHoy(@Param("fechabuscada")String fecha);

}
