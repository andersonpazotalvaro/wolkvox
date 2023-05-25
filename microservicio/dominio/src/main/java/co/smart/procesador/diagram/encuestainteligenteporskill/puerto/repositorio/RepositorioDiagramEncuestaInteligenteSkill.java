package co.smart.procesador.diagram.encuestainteligenteporskill.puerto.repositorio;

import co.smart.procesador.diagram.encuestainteligenteporagente.modelo.dominio.DiagramEncuestaInteligenteAgente;
import co.smart.procesador.diagram.encuestainteligenteporskill.modelo.dominio.DiagramEncuestaInteligenteSkill;

import java.time.LocalDate;
import java.util.List;

public interface RepositorioDiagramEncuestaInteligenteSkill {

    boolean guardar(DiagramEncuestaInteligenteSkill diagramEncuestaInteligenteSkill);


    boolean guardarArray(List<DiagramEncuestaInteligenteSkill> diagramEncuestaInteligenteSkill);

    boolean existe(LocalDate fecha);


}
