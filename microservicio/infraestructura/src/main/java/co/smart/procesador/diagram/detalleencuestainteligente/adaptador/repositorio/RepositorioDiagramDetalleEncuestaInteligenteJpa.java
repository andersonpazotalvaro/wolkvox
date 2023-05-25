package co.smart.procesador.diagram.detalleencuestainteligente.adaptador.repositorio;

import co.smart.procesador.diagram.detalleencuestainteligente.entidad.EntidadDiagramDetalleEncuestaInteligente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioDiagramDetalleEncuestaInteligenteJpa extends JpaRepository<EntidadDiagramDetalleEncuestaInteligente, Long> {

    @Query(nativeQuery = true,
            value = "Select *  from wolkvox.diagram_detalle_encuesta_inteligente WHERE :fechabuscada BETWEEN fecha_inicio_carga AND fecha_fin_carga")
    List<EntidadDiagramDetalleEncuestaInteligente> consultarSiExisteRegistroHoy(@Param("fechabuscada")String fecha);

}
