package co.smart.procesador.diagram.detalleesperainteligente.adaptador.repositorio;

import co.smart.procesador.diagram.detalleesperainteligente.adaptador.MapperDiagramDetalleEsperaInteligente;
import co.smart.procesador.diagram.detalleesperainteligente.entidad.CompositeEntityDiagram;
import co.smart.procesador.diagram.detalleesperainteligente.entidad.Id_detalle_espera_inteligente;
import co.smart.procesador.diagram.detalleesperainteligente.modelo.dominio.DiagramDetalleEsperaInteligente;
import co.smart.procesador.diagram.detalleesperainteligente.puerto.repositorio.RepositorioDiagramDetalleEsperaInteligente;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioDiagramDetalleEsperaInteligenteSql implements RepositorioDiagramDetalleEsperaInteligente {

    private final MapperDiagramDetalleEsperaInteligente mapperDiagramDetalleEsperaInteligente;
    private final RepositorioDiagramDetalleEsperaInteligenteJpa repositorioDiagramDetalleEsperaInteligenteJpa;
    private final RepositorioCompositeEntityDiagramJpa repositorioCompositeEntityDiagramJpa;

    public RepositorioDiagramDetalleEsperaInteligenteSql(MapperDiagramDetalleEsperaInteligente mapperDiagramDetalleEsperaInteligente, RepositorioDiagramDetalleEsperaInteligenteJpa repositorioDiagramDetalleEsperaInteligenteJpa, RepositorioCompositeEntityDiagramJpa repositorioCompositeEntityDiagramJpa) {
        this.mapperDiagramDetalleEsperaInteligente = mapperDiagramDetalleEsperaInteligente;
        this.repositorioDiagramDetalleEsperaInteligenteJpa = repositorioDiagramDetalleEsperaInteligenteJpa;
        this.repositorioCompositeEntityDiagramJpa = repositorioCompositeEntityDiagramJpa;
    }

    @Override
    public boolean guardar(DiagramDetalleEsperaInteligente diagramDetalleEsperaInteligente) {
        var entidadDiagram= this.mapperDiagramDetalleEsperaInteligente.crearEntity(diagramDetalleEsperaInteligente);
        this.repositorioDiagramDetalleEsperaInteligenteJpa.save(entidadDiagram);
        return false;
    }



    @Override
    public boolean guardarArray(List<DiagramDetalleEsperaInteligente> diagramDetalleEsperaInteligentes) {
        var listaEntidadDiagram= this.mapperDiagramDetalleEsperaInteligente.convertirDominioAEntidad(diagramDetalleEsperaInteligentes);
        this.repositorioDiagramDetalleEsperaInteligenteJpa.saveAll(listaEntidadDiagram);
        return true;
    }

    @Override
    public boolean existe(LocalDate fecha) {
        var entidadDiagramDetalleEsperaInteligente = this.repositorioDiagramDetalleEsperaInteligenteJpa.consultarSiExisteRegistroHoy(fecha.toString());
        if (entidadDiagramDetalleEsperaInteligente == null || entidadDiagramDetalleEsperaInteligente.size() == 0) {
            return false;
        }
        return true;
    }


}
