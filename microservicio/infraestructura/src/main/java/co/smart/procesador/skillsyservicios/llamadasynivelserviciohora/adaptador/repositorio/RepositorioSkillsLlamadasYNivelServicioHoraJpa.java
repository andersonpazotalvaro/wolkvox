package co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.adaptador.repositorio;

import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.entidad.EntidadSkillsLlamadasYNivelServicioHora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioSkillsLlamadasYNivelServicioHoraJpa extends JpaRepository<EntidadSkillsLlamadasYNivelServicioHora, Long> {

    @Query(nativeQuery = true,
            value = "Select *  from wolkvox.llamadas_y_nivel_servicio_hora WHERE :fechabuscada BETWEEN fecha_inicio_carga AND fecha_fin_carga")
    List<EntidadSkillsLlamadasYNivelServicioHora> consultarSiExisteRegistroHoy(@Param("fechabuscada")String fecha);

}
