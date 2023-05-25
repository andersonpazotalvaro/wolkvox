package co.smart.procesador.skillsyservicios.detallellamadascontestadas.servicio;


import co.smart.procesador.excepcion.ExcepcionDuplicidad;
import co.smart.procesador.skillsyservicios.detallellamadascontestadas.modelo.dominio.SkillsDetalleLlamadasContestadas;
import co.smart.procesador.skillsyservicios.detallellamadascontestadas.puerto.repositorio.RepositorioSkillsDetalleLlamadasContestadas;
import co.smart.procesador.skillsyservicios.email.servicio.NotificacionSkillDetalleLlamadasContestadas;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioGuardarSkillsDetalleLlamadasContestadas {

    private static final String EL_INFORME_YA_EXISTE = "El informe con esta fecha ya existe";

    private final RepositorioSkillsDetalleLlamadasContestadas repositorioSkillsDetalleLlamadasContestadas;

    private final NotificacionSkillDetalleLlamadasContestadas notificacionSkillDetalleLlamadasContestadas;

    public ServicioGuardarSkillsDetalleLlamadasContestadas(RepositorioSkillsDetalleLlamadasContestadas repositorioSkillsDetalleLlamadasContestadas, NotificacionSkillDetalleLlamadasContestadas notificacionSkillDetalleLlamadasContestadas) {
        this.repositorioSkillsDetalleLlamadasContestadas = repositorioSkillsDetalleLlamadasContestadas;
        this.notificacionSkillDetalleLlamadasContestadas = notificacionSkillDetalleLlamadasContestadas;
    }

    public boolean ejecutar(List<SkillsDetalleLlamadasContestadas> skillsDetalleLlamadasContestadas){

            validarExistencia(skillsDetalleLlamadasContestadas);
            return this.repositorioSkillsDetalleLlamadasContestadas.guardarArray(skillsDetalleLlamadasContestadas);
    }

    private void validarExistencia(List<SkillsDetalleLlamadasContestadas> skillsDetalleLlamadasContestadas) {
        var ini = skillsDetalleLlamadasContestadas.get(0).getFecha_inicio_carga();
        var fin = skillsDetalleLlamadasContestadas.get(0).getFecha_fin_carga();
        if(this.repositorioSkillsDetalleLlamadasContestadas.existe(ini) || this.repositorioSkillsDetalleLlamadasContestadas.existe(fin)) {
            throw new ExcepcionDuplicidad(String.format(EL_INFORME_YA_EXISTE));
        }
    }
}
