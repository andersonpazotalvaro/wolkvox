package co.smart.procesador.diagram.detalleencuestainteligente.adaptador;

import co.smart.procesador.diagram.detalleencuestainteligente.entidad.EntidadDiagramDetalleEncuestaInteligente;
import co.smart.procesador.diagram.detalleencuestainteligente.modelo.dominio.DiagramDetalleEncuestaInteligente;
import co.smart.procesador.diagram.detalleesperainteligente.entidad.EntidadDiagramDetalleEsperaInteligente;
import co.smart.procesador.diagram.detalleesperainteligente.modelo.dominio.DiagramDetalleEsperaInteligente;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperDiagramDetalleEncuestaInteligente {



    public EntidadDiagramDetalleEncuestaInteligente crearEntity(DiagramDetalleEncuestaInteligente diagramDetalleEncuestaInteligente){
        return new EntidadDiagramDetalleEncuestaInteligente(
                diagramDetalleEncuestaInteligente.getAgent_id(),
                diagramDetalleEncuestaInteligente.getAgent_name(),
                diagramDetalleEncuestaInteligente.getAgent_dni(),
                diagramDetalleEncuestaInteligente.getSkill_id(),
                diagramDetalleEncuestaInteligente.getSkill_name(),
                diagramDetalleEncuestaInteligente.getDate(),
                diagramDetalleEncuestaInteligente.getConn_id(),
                diagramDetalleEncuestaInteligente.getAni(),
                diagramDetalleEncuestaInteligente.getCustomer_id(),
                diagramDetalleEncuestaInteligente.getQ01(),
                diagramDetalleEncuestaInteligente.getQ02(),
                diagramDetalleEncuestaInteligente.getQ03(),
                diagramDetalleEncuestaInteligente.getQ04(),
                diagramDetalleEncuestaInteligente.getQ05(),
                diagramDetalleEncuestaInteligente.getQ06(),
                diagramDetalleEncuestaInteligente.getQ07(),
                diagramDetalleEncuestaInteligente.getQ08(),
                diagramDetalleEncuestaInteligente.getQ09(),
                diagramDetalleEncuestaInteligente.getQ10(),
                diagramDetalleEncuestaInteligente.getVoice_message_duration(),
                diagramDetalleEncuestaInteligente.getType_interaction(),
                diagramDetalleEncuestaInteligente.getResult(),
                diagramDetalleEncuestaInteligente.getTime(),
                diagramDetalleEncuestaInteligente.getVoice_message(),
                diagramDetalleEncuestaInteligente.getFeeling(),
                diagramDetalleEncuestaInteligente.getFECHA(),
                diagramDetalleEncuestaInteligente.getFecha_inicio_carga(),
                diagramDetalleEncuestaInteligente.getFecha_fin_carga()
        );
    }

    public List<EntidadDiagramDetalleEncuestaInteligente> convertirDominioAEntidad(List<DiagramDetalleEncuestaInteligente> diagramDetalleEncuestaInteligentes){
        var listaEntidadDiagram = new ArrayList<EntidadDiagramDetalleEncuestaInteligente>();

        diagramDetalleEncuestaInteligentes.forEach(diagramDetalleEncuestaInteligente -> {
            listaEntidadDiagram.add(this.crearEntity(diagramDetalleEncuestaInteligente));

        });
        return listaEntidadDiagram;
    }
}
