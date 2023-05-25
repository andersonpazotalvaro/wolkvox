package co.smart.procesador.skillsyservicios.workforceporhora.adaptador.repositorio;

import co.smart.procesador.skillsyservicios.workforceporhora.entidad.EntidadSkillsWorkforceHora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioSkillsWorkforceHoraJpa extends JpaRepository<EntidadSkillsWorkforceHora, Long> {

    @Query(nativeQuery = true,
            value = "Select *  from wolkvox.workforce_hora WHERE :fechabuscada BETWEEN fecha_inicio_carga AND fecha_fin_carga")
    List<EntidadSkillsWorkforceHora> consultarSiExisteRegistroHoy(@Param("fechabuscada")String fecha);

}
