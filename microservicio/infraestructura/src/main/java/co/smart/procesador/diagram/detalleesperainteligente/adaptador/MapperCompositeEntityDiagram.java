package co.smart.procesador.diagram.detalleesperainteligente.adaptador;

import co.smart.procesador.diagram.detalleesperainteligente.entidad.CompositeEntityDiagram;
import co.smart.procesador.diagram.detalleesperainteligente.entidad.EntidadDiagramDetalleEsperaInteligente;
import co.smart.procesador.diagram.detalleesperainteligente.modelo.dominio.DiagramDetalleEsperaInteligente;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperCompositeEntityDiagram {



    public CompositeEntityDiagram crearEntity(DiagramDetalleEsperaInteligente diagramDetalleEsperaInteligente){
            return new CompositeEntityDiagram(
                    diagramDetalleEsperaInteligente.getFECHA()
            );
    }

    /*public List<EntidadDiagramDetalleEsperaInteligente> convertirDominioAEntidad(List<DiagramDetalleEsperaInteligente> diagramDetalleEsperaInteligentes){
        var listaEntidadDiagram = new ArrayList<EntidadDiagramDetalleEsperaInteligente>();

        diagramDetalleEsperaInteligentes.forEach(diagramDetalleEsperaInteligente -> {
            listaEntidadDiagram.add(this.crearEntity(diagramDetalleEsperaInteligente));

        });
        return listaEntidadDiagram;
    }*/
}
