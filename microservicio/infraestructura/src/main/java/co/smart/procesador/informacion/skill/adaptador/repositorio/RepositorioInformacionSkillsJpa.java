package co.smart.procesador.informacion.skill.adaptador.repositorio;

import co.smart.procesador.informacion.skill.entidad.EntidadInformacionSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioInformacionSkillsJpa extends JpaRepository<EntidadInformacionSkills, Long> {

    @Query(nativeQuery = true,
            value = "Select *  from wolkvox.informacion_skills where fecha_carga=:fechabuscada group by fecha_carga")
    List<EntidadInformacionSkills> consultarSiExisteRegistroHoy(@Param("fechabuscada")String fecha);

}
