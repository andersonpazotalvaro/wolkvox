package co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.puerto.repositorio;

import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.modelo.dominio.SkillsLlamadasYNivelServicioHora;
import java.time.LocalDate;
import java.util.List;

public interface RepositorioSkillsLlamadasYNivelServicioHora {

    boolean guardar(SkillsLlamadasYNivelServicioHora skillsLlamadasYNivelServicioHora);


    boolean guardarArray(List<SkillsLlamadasYNivelServicioHora> skillsLlamadasYNivelServicioHoras);

    boolean existe(LocalDate fecha);


}
