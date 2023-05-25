package co.smart.procesador.skillsyservicios.detallesllamadasabandonadas.puerto.repositorio;

import co.smart.procesador.skillsyservicios.detallesllamadasabandonadas.modelo.dominio.SkillsDetalleLlamadasAbandonadas;

import java.time.LocalDate;
import java.util.List;

public interface RepositorioSkillsDetalleLlamadasAbandonadas {

    boolean guardar(SkillsDetalleLlamadasAbandonadas skillsDetalleLlamadasAbandonadas);


    boolean guardarArray(List<SkillsDetalleLlamadasAbandonadas> skillsDetalleLlamadasAbandonadas);

    boolean existe(LocalDate fecha);


}
