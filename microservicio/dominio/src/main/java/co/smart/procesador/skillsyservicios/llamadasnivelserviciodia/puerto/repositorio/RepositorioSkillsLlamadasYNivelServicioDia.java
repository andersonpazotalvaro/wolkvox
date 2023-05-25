package co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.puerto.repositorio;

import co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.modelo.dominio.SkillsLlamadasYNivelServicioDia;
import co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.modelo.dominio.SkillsLlamadasYNivelTodos;

import java.time.LocalDate;
import java.util.List;

public interface RepositorioSkillsLlamadasYNivelServicioDia {

    boolean guardar(SkillsLlamadasYNivelServicioDia skillsLlamadasYNivelServicioDia);


    boolean guardarArray(List<SkillsLlamadasYNivelServicioDia> skillsLlamadasYNivelServicioDias);

    boolean existe(LocalDate fecha);


}
