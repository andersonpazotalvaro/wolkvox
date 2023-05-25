package co.smart.procesador.diagram.esperainteligente.puerto.repositorio;

import co.smart.procesador.diagram.esperainteligente.modelo.dominio.DiagramEsperaInteligente;

import java.time.LocalDate;
import java.util.List;

public interface RepositorioDiagramEsperaInteligente {

    boolean guardar(DiagramEsperaInteligente diagramEsperaInteligente);


    boolean guardarArray(List<DiagramEsperaInteligente> diagramEsperaInteligentes);

    boolean existe(LocalDate fecha);


}
