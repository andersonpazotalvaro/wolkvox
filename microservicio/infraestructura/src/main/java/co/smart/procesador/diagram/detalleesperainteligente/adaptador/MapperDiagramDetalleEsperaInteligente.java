package co.smart.procesador.diagram.detalleesperainteligente.adaptador;

import co.smart.procesador.diagram.detalleesperainteligente.entidad.EntidadDiagramDetalleEsperaInteligente;
import co.smart.procesador.diagram.detalleesperainteligente.modelo.dominio.DiagramDetalleEsperaInteligente;
import co.smart.procesador.diagram.esperainteligente.entidad.EntidadDiagramEsperaInteligente;
import co.smart.procesador.diagram.esperainteligente.modelo.dominio.DiagramEsperaInteligente;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperDiagramDetalleEsperaInteligente {



    public EntidadDiagramDetalleEsperaInteligente crearEntity(DiagramDetalleEsperaInteligente diagramDetalleEsperaInteligente){
        return new EntidadDiagramDetalleEsperaInteligente(
                diagramDetalleEsperaInteligente.getSkill_id(),
                diagramDetalleEsperaInteligente.getDate_inbound_call(),
                diagramDetalleEsperaInteligente.getDate_last_outbound_call(),
                diagramDetalleEsperaInteligente.getStatus(),
                diagramDetalleEsperaInteligente.getAttempts(),
                diagramDetalleEsperaInteligente.getAni(),
                diagramDetalleEsperaInteligente.getDial_phone(),
                diagramDetalleEsperaInteligente.getTime_between_calls(),
                diagramDetalleEsperaInteligente.getTime(),
                diagramDetalleEsperaInteligente.getBilled_minutes(),
                diagramDetalleEsperaInteligente.getCustomer_id(),
                diagramDetalleEsperaInteligente.getFECHA(),
                diagramDetalleEsperaInteligente.getFecha_inicio_carga(),
                diagramDetalleEsperaInteligente.getFecha_fin_carga()
        );
    }

    public List<EntidadDiagramDetalleEsperaInteligente> convertirDominioAEntidad(List<DiagramDetalleEsperaInteligente> diagramDetalleEsperaInteligentes){
        var listaEntidadDiagram = new ArrayList<EntidadDiagramDetalleEsperaInteligente>();

        diagramDetalleEsperaInteligentes.forEach(diagramDetalleEsperaInteligente -> {
            listaEntidadDiagram.add(this.crearEntity(diagramDetalleEsperaInteligente));

        });
        return listaEntidadDiagram;
    }
}
