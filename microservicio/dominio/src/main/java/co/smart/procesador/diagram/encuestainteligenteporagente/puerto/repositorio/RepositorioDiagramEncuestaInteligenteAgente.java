package co.smart.procesador.diagram.encuestainteligenteporagente.puerto.repositorio;

import co.smart.procesador.diagram.encuestainteligenteporagente.modelo.dominio.DiagramEncuestaInteligenteAgente;
import co.smart.procesador.diagram.esperainteligente.modelo.dominio.DiagramEsperaInteligente;

import java.time.LocalDate;
import java.util.List;

public interface RepositorioDiagramEncuestaInteligenteAgente {

    boolean guardar(DiagramEncuestaInteligenteAgente diagramEncuestaInteligenteAgente);


    boolean guardarArray(List<DiagramEncuestaInteligenteAgente> diagramEncuestaInteligenteAgentes);

    boolean existe(LocalDate fecha);


}
