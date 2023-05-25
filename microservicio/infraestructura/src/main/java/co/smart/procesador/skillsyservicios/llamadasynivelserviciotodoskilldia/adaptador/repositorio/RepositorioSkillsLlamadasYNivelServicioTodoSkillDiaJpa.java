package co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.adaptador.repositorio;

import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.entidad.EntidadSkillsLlamadasYNivelServicioHora;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.entidad.EntidadSkillsLlamadasYNivelServicioTodoSkillDia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioSkillsLlamadasYNivelServicioTodoSkillDiaJpa extends JpaRepository<EntidadSkillsLlamadasYNivelServicioTodoSkillDia, Long> {

    @Query(nativeQuery = true,
            value = "Select *  from wolkvox.llamadas_y_nivel_servicio_todo_skill_dia WHERE :fechabuscada BETWEEN fecha_inicio_carga AND fecha_fin_carga")
    List<EntidadSkillsLlamadasYNivelServicioTodoSkillDia> consultarSiExisteRegistroHoy(@Param("fechabuscada")String fecha);

}
