package co.smart.procesador.diagram.detalleesperainteligente.adaptador.repositorio;

import co.smart.procesador.diagram.detalleesperainteligente.entidad.CompositeEntityDiagram;
import co.smart.procesador.diagram.detalleesperainteligente.entidad.EntidadDiagramDetalleEsperaInteligente;
import co.smart.procesador.diagram.detalleesperainteligente.entidad.Id_detalle_espera_inteligente;
import co.smart.procesador.diagram.esperainteligente.entidad.EntidadDiagramEsperaInteligente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioCompositeEntityDiagramSql {
/*
    private final RepositorioCompositeEntityDiagramJpa repositorioCompositeEntityDiagramJpa;


    public RepositorioCompositeEntityDiagramSql(RepositorioCompositeEntityDiagramJpa repositorioCompositeEntityDiagramJpa) {
        this.repositorioCompositeEntityDiagramJpa = repositorioCompositeEntityDiagramJpa;
    }


    public void guardar(List<EntidadDiagramDetalleEsperaInteligente> diagramDetalleEsperaInteligentes, List<EntidadDiagramEsperaInteligente> diagramEsperaInteligentes){

        var listaComposite = new ArrayList<CompositeEntityDiagram>();
        var compositeEntityDiagram = new CompositeEntityDiagram();
        var id = new ArrayList<Id_detalle_espera_inteligente>();
        diagramDetalleEsperaInteligentes.forEach(entidadDiagramDetalleEsperaInteligente -> {
            listaComposite.add(
                   id.add(
                           new Id_detalle_espera_inteligente(entidadDiagramDetalleEsperaInteligente)
                   )

            );
        });
        this.repositorioCompositeEntityDiagramJpa.saveAll(listaComposite);

    }*/
}
