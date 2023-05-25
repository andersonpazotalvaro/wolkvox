package co.smart.procesador.diagram.esperainteligente.adaptador;

import co.smart.procesador.diagram.esperainteligente.entidad.EntidadDiagramEsperaInteligente;
import co.smart.procesador.diagram.esperainteligente.modelo.dominio.DiagramEsperaInteligente;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperDiagramEsperaInteligente {



    public EntidadDiagramEsperaInteligente crearEntity(DiagramEsperaInteligente diagramEsperaInteligente){
        return new EntidadDiagramEsperaInteligente(
                diagramEsperaInteligente.getSkill_id(),
                diagramEsperaInteligente.getTreatment(),
                diagramEsperaInteligente.getCustomer_say_no(),
                diagramEsperaInteligente.getCustomer_say_yes(),
                diagramEsperaInteligente.getRecall_fail(),
                diagramEsperaInteligente.getRecall_ok(),
                diagramEsperaInteligente.getService_level_up(),
                diagramEsperaInteligente.getFECHA(),
                diagramEsperaInteligente.getFecha_inicio_carga(),
                diagramEsperaInteligente.getFecha_inicio_carga()
        );
    }

    public List<EntidadDiagramEsperaInteligente> convertirDominioAEntidad(List<DiagramEsperaInteligente> diagramEsperaInteligentes){
        var listaEntidadDiagram = new ArrayList<EntidadDiagramEsperaInteligente>();

        diagramEsperaInteligentes.forEach(diagramEsperaInteligente -> {
            listaEntidadDiagram.add(this.crearEntity(diagramEsperaInteligente));

        });
        return listaEntidadDiagram;
    }
}
