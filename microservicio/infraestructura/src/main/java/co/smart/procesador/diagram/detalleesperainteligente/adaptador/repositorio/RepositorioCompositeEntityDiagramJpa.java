package co.smart.procesador.diagram.detalleesperainteligente.adaptador.repositorio;

import co.smart.procesador.diagram.detalleesperainteligente.entidad.CompositeEntityDiagram;
import co.smart.procesador.diagram.detalleesperainteligente.entidad.Id_detalle_espera_inteligente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioCompositeEntityDiagramJpa extends JpaRepository<CompositeEntityDiagram, Id_detalle_espera_inteligente> {


}
