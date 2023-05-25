package co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.adaptador.repositorio;

import co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.entidad.EntidadSkillsLlamadasYNivelServicioDia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioSkillsLlamadasYNivelServicioDiaJpa extends JpaRepository<EntidadSkillsLlamadasYNivelServicioDia, Long> {

    @Query(nativeQuery = true,
            value = "Select *  from wolkvox.llamadas_y_nivel_servicio_dia WHERE :fechabuscada BETWEEN fecha_inicio_carga AND fecha_fin_carga")
    List<EntidadSkillsLlamadasYNivelServicioDia> consultarSiExisteRegistroHoy(@Param("fechabuscada")String fecha);

}
