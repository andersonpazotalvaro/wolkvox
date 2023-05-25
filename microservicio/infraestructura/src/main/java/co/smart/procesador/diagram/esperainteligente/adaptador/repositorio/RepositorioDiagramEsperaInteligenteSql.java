package co.smart.procesador.diagram.esperainteligente.adaptador.repositorio;

import co.smart.procesador.diagram.esperainteligente.adaptador.MapperDiagramEsperaInteligente;
import co.smart.procesador.diagram.esperainteligente.modelo.dominio.DiagramEsperaInteligente;
import co.smart.procesador.diagram.esperainteligente.puerto.repositorio.RepositorioDiagramEsperaInteligente;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RepositorioDiagramEsperaInteligenteSql implements RepositorioDiagramEsperaInteligente {

    private final MapperDiagramEsperaInteligente mapperDiagramEsperaInteligente;
    private final RepositorioDiagramEsperaInteligenteJpa repositorioDiagramEsperaInteligenteJpa;

    public RepositorioDiagramEsperaInteligenteSql(MapperDiagramEsperaInteligente mapperDiagramEsperaInteligente, RepositorioDiagramEsperaInteligenteJpa repositorioDiagramEsperaInteligenteJpa) {
        this.mapperDiagramEsperaInteligente = mapperDiagramEsperaInteligente;
        this.repositorioDiagramEsperaInteligenteJpa = repositorioDiagramEsperaInteligenteJpa;
    }


    @Override
    public boolean guardar(DiagramEsperaInteligente diagramEsperaInteligente) {
        var entidadDiagram= this.mapperDiagramEsperaInteligente.crearEntity(diagramEsperaInteligente);
        this.repositorioDiagramEsperaInteligenteJpa.save(entidadDiagram);
        return false;
    }



    @Override
    public boolean guardarArray(List<DiagramEsperaInteligente> diagramEsperaInteligentes) {
        var listaEntidadDiagram= this.mapperDiagramEsperaInteligente.convertirDominioAEntidad(diagramEsperaInteligentes);
        this.repositorioDiagramEsperaInteligenteJpa.saveAll(listaEntidadDiagram);
        return true;
    }

    @Override
    public boolean existe(LocalDate fecha) {
        var entidadDiagramEsperaInteligentes = this.repositorioDiagramEsperaInteligenteJpa.consultarSiExisteRegistroHoy(fecha.toString());
        if (entidadDiagramEsperaInteligentes == null || entidadDiagramEsperaInteligentes.size() == 0) {
            return false;
        }
        return true;
    }


}
