package co.smart.procesador.diagram.encuestainteligenteporskill.adaptador.repositorio;

import co.smart.procesador.diagram.encuestainteligenteporskill.entidad.EntidadDiagramEncuestaInteligenteSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioDiagramEencuestaInteligenteSkill extends JpaRepository<EntidadDiagramEncuestaInteligenteSkill, Long> {

    @Query(nativeQuery = true,
            value = "Select *  from wolkvox.diagram_encuesta_inteligente_skill WHERE :fechabuscada BETWEEN fecha_inicio_carga AND fecha_fin_carga")
    List<EntidadDiagramEncuestaInteligenteSkill> consultarSiExisteRegistroHoy(@Param("fechabuscada")String fecha);

}
