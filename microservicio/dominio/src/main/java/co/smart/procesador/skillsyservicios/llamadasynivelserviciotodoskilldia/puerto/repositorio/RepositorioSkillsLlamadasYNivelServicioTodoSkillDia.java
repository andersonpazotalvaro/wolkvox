package co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.puerto.repositorio;

import co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.modelo.dominio.SkillsLlamadasYNivelServicioTodoSkillDia;

import java.time.LocalDate;
import java.util.List;

public interface RepositorioSkillsLlamadasYNivelServicioTodoSkillDia {

    boolean guardar(SkillsLlamadasYNivelServicioTodoSkillDia skillsLlamadasYNivelServicioTodoSkillDia);


    boolean guardarArray(List<SkillsLlamadasYNivelServicioTodoSkillDia> skillsLlamadasYNivelServicioTodoSkillDias);

    boolean existe(LocalDate fecha);


}
