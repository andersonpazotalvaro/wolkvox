package co.smart.procesador.diagram.encuestainteligenteporagente.adaptador;

import co.smart.procesador.diagram.encuestainteligenteporagente.entidad.EntidadDiagramEncuestaInteligenteAgente;
import co.smart.procesador.diagram.encuestainteligenteporagente.modelo.dominio.DiagramEncuestaInteligenteAgente;
import co.smart.procesador.diagram.esperainteligente.entidad.EntidadDiagramEsperaInteligente;
import co.smart.procesador.diagram.esperainteligente.modelo.dominio.DiagramEsperaInteligente;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperDiagramEncuestaInteligenteAgente {



    public EntidadDiagramEncuestaInteligenteAgente crearEntity(DiagramEncuestaInteligenteAgente diagramEncuestaInteligenteAgente){
        return new EntidadDiagramEncuestaInteligenteAgente(
                diagramEncuestaInteligenteAgente.getAgent_id(),
                diagramEncuestaInteligenteAgente.getAgent_name(),
                diagramEncuestaInteligenteAgente.getSurveys(),
                diagramEncuestaInteligenteAgente.getQ01(),
                diagramEncuestaInteligenteAgente.getQ02(),
                diagramEncuestaInteligenteAgente.getQ03(),
                diagramEncuestaInteligenteAgente.getQ04(),
                diagramEncuestaInteligenteAgente.getQ05(),
                diagramEncuestaInteligenteAgente.getQ06(),
                diagramEncuestaInteligenteAgente.getQ07(),
                diagramEncuestaInteligenteAgente.getQ08(),
                diagramEncuestaInteligenteAgente.getQ09(),
                diagramEncuestaInteligenteAgente.getQ10(),
                diagramEncuestaInteligenteAgente.getAverage(),
                diagramEncuestaInteligenteAgente.getFECHA(),
                diagramEncuestaInteligenteAgente.getFecha_inicio_carga(),
                diagramEncuestaInteligenteAgente.getFecha_fin_carga()
        );
    }

    public List<EntidadDiagramEncuestaInteligenteAgente> convertirDominioAEntidad(List<DiagramEncuestaInteligenteAgente> diagramEncuestaInteligenteAgentes){
        var listaEntidadDiagram = new ArrayList<EntidadDiagramEncuestaInteligenteAgente>();

        diagramEncuestaInteligenteAgentes.forEach(diagramEncuestaInteligenteAgente -> {
            listaEntidadDiagram.add(this.crearEntity(diagramEncuestaInteligenteAgente));

        });
        return listaEntidadDiagram;
    }
}
