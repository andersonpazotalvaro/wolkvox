package co.smart.procesador.diagram.detalleencuestainteligente.adaptador.repositorio;

import co.smart.procesador.diagram.detalleencuestainteligente.adaptador.MapperDiagramDetalleEncuestaInteligente;
import co.smart.procesador.diagram.detalleencuestainteligente.modelo.dominio.DiagramDetalleEncuestaInteligente;
import co.smart.procesador.diagram.detalleencuestainteligente.puerto.repositorio.RepositorioDiagramDetalleEncuestaInteligente;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RepositorioDiagramDetalleEncuestaInteligenteSql implements RepositorioDiagramDetalleEncuestaInteligente {

    private final MapperDiagramDetalleEncuestaInteligente mapperDiagramDetalleEncuestaInteligente;
    private final RepositorioDiagramDetalleEncuestaInteligenteJpa repositorioDiagramDetalleEncuestaInteligenteJpa;

    public RepositorioDiagramDetalleEncuestaInteligenteSql(MapperDiagramDetalleEncuestaInteligente mapperDiagramDetalleEncuestaInteligente, RepositorioDiagramDetalleEncuestaInteligenteJpa repositorioDiagramDetalleEncuestaInteligenteJpa) {
        this.mapperDiagramDetalleEncuestaInteligente = mapperDiagramDetalleEncuestaInteligente;
        this.repositorioDiagramDetalleEncuestaInteligenteJpa = repositorioDiagramDetalleEncuestaInteligenteJpa;
    }

    @Override
    public boolean guardar(DiagramDetalleEncuestaInteligente diagramDetalleEncuestaInteligente) {
        var entidadDiagram= this.mapperDiagramDetalleEncuestaInteligente.crearEntity(diagramDetalleEncuestaInteligente);
        this.repositorioDiagramDetalleEncuestaInteligenteJpa.save(entidadDiagram);
        return false;
    }



    @Override
    public boolean guardarArray(List<DiagramDetalleEncuestaInteligente> diagramDetalleEncuestaInteligentes) {
        var listaEntidadDiagram= this.mapperDiagramDetalleEncuestaInteligente.convertirDominioAEntidad(diagramDetalleEncuestaInteligentes);
        this.repositorioDiagramDetalleEncuestaInteligenteJpa.saveAll(listaEntidadDiagram);
        return true;
    }

    @Override
    public boolean existe(LocalDate fecha) {
        var entidadDiagramDetalleEncuestaInteligente = this.repositorioDiagramDetalleEncuestaInteligenteJpa.consultarSiExisteRegistroHoy(fecha.toString());
        if (entidadDiagramDetalleEncuestaInteligente == null || entidadDiagramDetalleEncuestaInteligente.size() == 0) {
            return false;
        }
        return true;
    }


}
