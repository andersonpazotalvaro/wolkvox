package co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.puerto.repositorio;

import co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.modelo.dominio.SkillsLlamadasYNivelTodos;

import java.time.LocalDate;
import java.util.List;

public interface RepositorioSkillsLlamadasYNivelTodos {

    boolean guardar(SkillsLlamadasYNivelTodos skillsLlamadasYNivelTodos);


    boolean guardarArray(List<SkillsLlamadasYNivelTodos> skillsLlamadasYNivelTodos);

    boolean existe(LocalDate fecha);


}
