package co.smart.procesador.diagram.encuestainteligenteporagente.adaptador.repositorio;

import co.smart.procesador.diagram.encuestainteligenteporagente.entidad.EntidadDiagramEncuestaInteligenteAgente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioDiagramEencuestaInteligenteAgenteJpa extends JpaRepository<EntidadDiagramEncuestaInteligenteAgente, Long> {

    @Query(nativeQuery = true,
            value = "Select *  from wolkvox.diagram_encuesta_inteligente_agente WHERE :fechabuscada BETWEEN fecha_inicio_carga AND fecha_fin_carga")
    List<EntidadDiagramEncuestaInteligenteAgente> consultarSiExisteRegistroHoy(@Param("fechabuscada")String fecha);

}
