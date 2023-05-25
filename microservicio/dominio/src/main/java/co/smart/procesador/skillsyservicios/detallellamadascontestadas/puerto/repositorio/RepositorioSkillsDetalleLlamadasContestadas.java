package co.smart.procesador.skillsyservicios.detallellamadascontestadas.puerto.repositorio;

import co.smart.procesador.skillsyservicios.detallellamadascontestadas.modelo.dominio.SkillsDetalleLlamadasContestadas;

import java.time.LocalDate;
import java.util.List;

public interface RepositorioSkillsDetalleLlamadasContestadas {

    boolean guardar(SkillsDetalleLlamadasContestadas skillsDetalleLlamadasContestadas);


    boolean guardarArray(List<SkillsDetalleLlamadasContestadas> skillsDetalleLlamadasContestadas);

    boolean existe(LocalDate fecha);


}
