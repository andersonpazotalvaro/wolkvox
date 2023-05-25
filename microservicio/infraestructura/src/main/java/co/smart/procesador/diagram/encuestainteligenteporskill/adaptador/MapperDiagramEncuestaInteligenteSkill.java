package co.smart.procesador.diagram.encuestainteligenteporskill.adaptador;

import co.smart.procesador.diagram.encuestainteligenteporagente.entidad.EntidadDiagramEncuestaInteligenteAgente;
import co.smart.procesador.diagram.encuestainteligenteporagente.modelo.dominio.DiagramEncuestaInteligenteAgente;
import co.smart.procesador.diagram.encuestainteligenteporskill.entidad.EntidadDiagramEncuestaInteligenteSkill;
import co.smart.procesador.diagram.encuestainteligenteporskill.modelo.dominio.DiagramEncuestaInteligenteSkill;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperDiagramEncuestaInteligenteSkill {



    public EntidadDiagramEncuestaInteligenteSkill crearEntity(DiagramEncuestaInteligenteSkill diagramEncuestaInteligenteSkill){
        return new EntidadDiagramEncuestaInteligenteSkill(
                diagramEncuestaInteligenteSkill.getAgent_id(),
                diagramEncuestaInteligenteSkill.getAgent_name(),
                diagramEncuestaInteligenteSkill.getSurveys(),
                diagramEncuestaInteligenteSkill.getQ01(),
                diagramEncuestaInteligenteSkill.getQ02(),
                diagramEncuestaInteligenteSkill.getQ03(),
                diagramEncuestaInteligenteSkill.getQ04(),
                diagramEncuestaInteligenteSkill.getQ05(),
                diagramEncuestaInteligenteSkill.getQ06(),
                diagramEncuestaInteligenteSkill.getQ07(),
                diagramEncuestaInteligenteSkill.getQ08(),
                diagramEncuestaInteligenteSkill.getQ09(),
                diagramEncuestaInteligenteSkill.getQ10(),
                diagramEncuestaInteligenteSkill.getAverage(),
                diagramEncuestaInteligenteSkill.getFECHA(),
                diagramEncuestaInteligenteSkill.getFecha_inicio_carga(),
                diagramEncuestaInteligenteSkill.getFecha_fin_carga()
        );
    }

    public List<EntidadDiagramEncuestaInteligenteSkill> convertirDominioAEntidad(List<DiagramEncuestaInteligenteSkill> diagramEncuestaInteligenteSkill){
        var listaEntidadDiagram = new ArrayList<EntidadDiagramEncuestaInteligenteSkill>();

        diagramEncuestaInteligenteSkill.forEach(diagramEncuestaInteligenteSkills -> {
            listaEntidadDiagram.add(this.crearEntity(diagramEncuestaInteligenteSkills));

        });
        return listaEntidadDiagram;
    }
}
