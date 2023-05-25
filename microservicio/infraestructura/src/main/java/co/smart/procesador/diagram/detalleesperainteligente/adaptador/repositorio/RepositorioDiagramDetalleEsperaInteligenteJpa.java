package co.smart.procesador.diagram.detalleesperainteligente.adaptador.repositorio;

import co.smart.procesador.diagram.detalleesperainteligente.entidad.EntidadDiagramDetalleEsperaInteligente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioDiagramDetalleEsperaInteligenteJpa extends JpaRepository<EntidadDiagramDetalleEsperaInteligente, Long> {

    @Query(nativeQuery = true,
            value = "Select *  from wolkvox.diagram_detalle_espera_inteligente WHERE :fechabuscada BETWEEN fecha_inicio_carga AND fecha_fin_carga")
    List<EntidadDiagramDetalleEsperaInteligente> consultarSiExisteRegistroHoy(@Param("fechabuscada")String fecha);

}
