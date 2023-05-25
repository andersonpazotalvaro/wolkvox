package co.smart.procesador.diagram.encuestainteligenteporagente.adaptador.repositorio;

import co.smart.procesador.diagram.encuestainteligenteporagente.adaptador.MapperDiagramEncuestaInteligenteAgente;
import co.smart.procesador.diagram.encuestainteligenteporagente.modelo.dominio.DiagramEncuestaInteligenteAgente;
import co.smart.procesador.diagram.encuestainteligenteporagente.puerto.repositorio.RepositorioDiagramEncuestaInteligenteAgente;
import co.smart.procesador.diagram.esperainteligente.modelo.dominio.DiagramEsperaInteligente;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RepositorioDiagramEncuestaInteligenteAgenteSql implements RepositorioDiagramEncuestaInteligenteAgente {

    private final MapperDiagramEncuestaInteligenteAgente mapperDiagramEncuestaInteligenteAgente;
    private final RepositorioDiagramEencuestaInteligenteAgenteJpa repositorioDiagramEencuestaInteligenteAgenteJpa;

    public RepositorioDiagramEncuestaInteligenteAgenteSql(MapperDiagramEncuestaInteligenteAgente mapperDiagramEncuestaInteligenteAgente, RepositorioDiagramEencuestaInteligenteAgenteJpa repositorioDiagramEencuestaInteligenteAgenteJpa) {
        this.mapperDiagramEncuestaInteligenteAgente = mapperDiagramEncuestaInteligenteAgente;
        this.repositorioDiagramEencuestaInteligenteAgenteJpa = repositorioDiagramEencuestaInteligenteAgenteJpa;
    }


    @Override
    public boolean guardar(DiagramEncuestaInteligenteAgente diagramEncuestaInteligenteAgente) {
        var entidadDiagram= this.mapperDiagramEncuestaInteligenteAgente.crearEntity(diagramEncuestaInteligenteAgente);
        this.repositorioDiagramEencuestaInteligenteAgenteJpa.save(entidadDiagram);
        return false;
    }



    @Override
    public boolean guardarArray(List<DiagramEncuestaInteligenteAgente> diagramEncuestaInteligenteAgentes) {
        var listaEntidadDiagram= this.mapperDiagramEncuestaInteligenteAgente.convertirDominioAEntidad(diagramEncuestaInteligenteAgentes);
        this.repositorioDiagramEencuestaInteligenteAgenteJpa.saveAll(listaEntidadDiagram);
        return true;
    }

    @Override
    public boolean existe(LocalDate fecha) {
        var entidadDiagramEncuestaInteligenteAgentes = this.repositorioDiagramEencuestaInteligenteAgenteJpa.consultarSiExisteRegistroHoy(fecha.toString());
        if (entidadDiagramEncuestaInteligenteAgentes == null || entidadDiagramEncuestaInteligenteAgentes.size() == 0) {
            return false;
        }
        return true;
    }


}
