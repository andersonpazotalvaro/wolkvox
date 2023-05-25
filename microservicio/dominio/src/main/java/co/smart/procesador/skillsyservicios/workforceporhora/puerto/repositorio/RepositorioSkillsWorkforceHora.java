package co.smart.procesador.skillsyservicios.workforceporhora.puerto.repositorio;

import co.smart.procesador.skillsyservicios.workforceporhora.modelo.dominio.SkillsWorkforceHora;

import java.time.LocalDate;
import java.util.List;

public interface RepositorioSkillsWorkforceHora {

    boolean guardar(SkillsWorkforceHora skillsWorkforceHora);


    boolean guardarArray(List<SkillsWorkforceHora> skillsWorkforceHoras);

    boolean existe(LocalDate fecha);


}
