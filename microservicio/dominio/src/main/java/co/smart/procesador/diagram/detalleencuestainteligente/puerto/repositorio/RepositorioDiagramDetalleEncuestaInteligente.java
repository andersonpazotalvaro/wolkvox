package co.smart.procesador.diagram.detalleencuestainteligente.puerto.repositorio;

import co.smart.procesador.diagram.detalleencuestainteligente.modelo.dominio.DiagramDetalleEncuestaInteligente;

import java.time.LocalDate;
import java.util.List;

public interface RepositorioDiagramDetalleEncuestaInteligente {

    boolean guardar(DiagramDetalleEncuestaInteligente diagramDetalleEncuestaInteligente);


    boolean guardarArray(List<DiagramDetalleEncuestaInteligente> diagramDetalleEncuestaInteligentes);

    boolean existe(LocalDate fecha);


}
