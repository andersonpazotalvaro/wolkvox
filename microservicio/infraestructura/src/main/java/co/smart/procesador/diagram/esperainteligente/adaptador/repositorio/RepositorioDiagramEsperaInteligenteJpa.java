package co.smart.procesador.diagram.esperainteligente.adaptador.repositorio;

import co.smart.procesador.diagram.esperainteligente.entidad.EntidadDiagramEsperaInteligente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioDiagramEsperaInteligenteJpa extends JpaRepository<EntidadDiagramEsperaInteligente, Long> {

    @Query(nativeQuery = true,
            value = "Select *  from wolkvox.diagram_espera_inteligente WHERE :fechabuscada BETWEEN fecha_inicio_carga AND fecha_fin_carga")
    List<EntidadDiagramEsperaInteligente> consultarSiExisteRegistroHoy(@Param("fechabuscada")String fecha);

}
