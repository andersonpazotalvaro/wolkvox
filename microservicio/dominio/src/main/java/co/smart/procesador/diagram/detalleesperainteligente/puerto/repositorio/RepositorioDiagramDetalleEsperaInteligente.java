package co.smart.procesador.diagram.detalleesperainteligente.puerto.repositorio;

import co.smart.procesador.diagram.detalleesperainteligente.modelo.dominio.DiagramDetalleEsperaInteligente;

import java.time.LocalDate;
import java.util.List;

public interface RepositorioDiagramDetalleEsperaInteligente {

    boolean guardar(DiagramDetalleEsperaInteligente diagramDetalleEsperaInteligente);


    boolean guardarArray(List<DiagramDetalleEsperaInteligente> diagramDetalleEsperaInteligentes);

    boolean existe(LocalDate fecha);


}
