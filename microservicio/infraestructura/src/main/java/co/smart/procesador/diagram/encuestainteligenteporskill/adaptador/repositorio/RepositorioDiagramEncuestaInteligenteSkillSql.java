package co.smart.procesador.diagram.encuestainteligenteporskill.adaptador.repositorio;

import co.smart.procesador.diagram.encuestainteligenteporskill.adaptador.MapperDiagramEncuestaInteligenteSkill;
import co.smart.procesador.diagram.encuestainteligenteporskill.modelo.dominio.DiagramEncuestaInteligenteSkill;
import co.smart.procesador.diagram.encuestainteligenteporskill.puerto.repositorio.RepositorioDiagramEncuestaInteligenteSkill;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RepositorioDiagramEncuestaInteligenteSkillSql implements RepositorioDiagramEncuestaInteligenteSkill {

    private final MapperDiagramEncuestaInteligenteSkill mapperDiagramEncuestaInteligenteSkill;
    private final RepositorioDiagramEencuestaInteligenteSkill repositorioDiagramEencuestaInteligenteSkill;

    public RepositorioDiagramEncuestaInteligenteSkillSql(MapperDiagramEncuestaInteligenteSkill mapperDiagramEncuestaInteligenteSkill, RepositorioDiagramEencuestaInteligenteSkill repositorioDiagramEencuestaInteligenteSkill) {
        this.mapperDiagramEncuestaInteligenteSkill = mapperDiagramEncuestaInteligenteSkill;
        this.repositorioDiagramEencuestaInteligenteSkill = repositorioDiagramEencuestaInteligenteSkill;
    }


    @Override
    public boolean guardar(DiagramEncuestaInteligenteSkill diagramEncuestaInteligenteSkill) {
        var entidadDiagram= this.mapperDiagramEncuestaInteligenteSkill.crearEntity(diagramEncuestaInteligenteSkill);
        this.repositorioDiagramEencuestaInteligenteSkill.save(entidadDiagram);
        return false;
    }



    @Override
    public boolean guardarArray(List<DiagramEncuestaInteligenteSkill> diagramEncuestaInteligenteSkill) {
        var listaEntidadDiagram= this.mapperDiagramEncuestaInteligenteSkill.convertirDominioAEntidad(diagramEncuestaInteligenteSkill);
        this.repositorioDiagramEencuestaInteligenteSkill.saveAll(listaEntidadDiagram);
        return true;
    }

    @Override
    public boolean existe(LocalDate fecha) {
        var entidadDiagramEncuestaInteligenteSkill = this.repositorioDiagramEencuestaInteligenteSkill.consultarSiExisteRegistroHoy(fecha.toString());
        if (entidadDiagramEncuestaInteligenteSkill == null || entidadDiagramEncuestaInteligenteSkill.size() == 0) {
            return false;
        }
        return true;
    }


}
