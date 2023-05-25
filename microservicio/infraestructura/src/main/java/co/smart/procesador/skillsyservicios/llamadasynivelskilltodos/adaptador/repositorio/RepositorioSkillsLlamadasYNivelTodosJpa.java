package co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.adaptador.repositorio;

import co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.entidad.EntidadSkillsLlamadasYNivelTodos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioSkillsLlamadasYNivelTodosJpa extends JpaRepository<EntidadSkillsLlamadasYNivelTodos, Long> {

    @Query(nativeQuery = true,
            value = "Select *  from wolkvox.llamadas_y_nivel_servicio_todos WHERE :fechabuscada BETWEEN fecha_inicio_carga AND fecha_fin_carga")
    List<EntidadSkillsLlamadasYNivelTodos> consultarSiExisteRegistroHoy(@Param("fechabuscada")String fecha);

}
