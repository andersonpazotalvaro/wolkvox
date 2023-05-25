package co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.adaptador.repositorio;

import co.smart.procesador.diagram.encuestainteligenteporskill.modelo.dominio.DiagramEncuestaInteligenteSkill;
import co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.adaptador.MapperSkillsLlamadasYNivelTodos;
import co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.modelo.dominio.SkillsLlamadasYNivelTodos;
import co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.puerto.repositorio.RepositorioSkillsLlamadasYNivelTodos;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RepositorioSkillsLlamadasYNivelTodosJpaSql implements RepositorioSkillsLlamadasYNivelTodos {

    private final MapperSkillsLlamadasYNivelTodos mapperSkillsLlamadasYNivelTodos;
    private final RepositorioSkillsLlamadasYNivelTodosJpa repositorioSkillsLlamadasYNivelTodosjpa;

    public RepositorioSkillsLlamadasYNivelTodosJpaSql(MapperSkillsLlamadasYNivelTodos mapperSkillsLlamadasYNivelTodos, RepositorioSkillsLlamadasYNivelTodosJpa repositorioSkillsLlamadasYNivelTodosjpa) {
        this.mapperSkillsLlamadasYNivelTodos = mapperSkillsLlamadasYNivelTodos;
        this.repositorioSkillsLlamadasYNivelTodosjpa = repositorioSkillsLlamadasYNivelTodosjpa;
    }

    @Override
    public boolean guardar(SkillsLlamadasYNivelTodos skillsLlamadasYNivelTodos) {
        var entidadSkill= this.mapperSkillsLlamadasYNivelTodos.crearEntity(skillsLlamadasYNivelTodos);
        this.repositorioSkillsLlamadasYNivelTodosjpa.save(entidadSkill);
        return false;
    }



    @Override
    public boolean guardarArray(List<SkillsLlamadasYNivelTodos> skillsLlamadasYNivelTodos) {
        var listaEntidadSkill= this.mapperSkillsLlamadasYNivelTodos.convertirDominioAEntidad(skillsLlamadasYNivelTodos);
        this.repositorioSkillsLlamadasYNivelTodosjpa.saveAll(listaEntidadSkill);
        return true;
    }

    @Override
    public boolean existe(LocalDate fecha) {
        var entidadSkillsLlamadasYNivelTodos = this.repositorioSkillsLlamadasYNivelTodosjpa.consultarSiExisteRegistroHoy(fecha.toString());
        if (entidadSkillsLlamadasYNivelTodos == null || entidadSkillsLlamadasYNivelTodos.size() == 0) {
            return false;
        }
        return true;
    }


}
