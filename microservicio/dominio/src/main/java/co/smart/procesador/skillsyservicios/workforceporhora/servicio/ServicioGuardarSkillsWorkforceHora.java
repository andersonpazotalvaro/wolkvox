package co.smart.procesador.skillsyservicios.workforceporhora.servicio;


import co.smart.procesador.excepcion.ExcepcionDuplicidad;
import co.smart.procesador.skillsyservicios.detallellamadascontestadas.modelo.dominio.SkillsDetalleLlamadasContestadas;
import co.smart.procesador.skillsyservicios.detallellamadascontestadas.puerto.repositorio.RepositorioSkillsDetalleLlamadasContestadas;
import co.smart.procesador.skillsyservicios.email.servicio.NotificacionSkillDetalleLlamadasContestadas;
import co.smart.procesador.skillsyservicios.email.servicio.NotificacionSkillWorkforceHora;
import co.smart.procesador.skillsyservicios.workforceporhora.modelo.dominio.SkillsWorkforceHora;
import co.smart.procesador.skillsyservicios.workforceporhora.puerto.repositorio.RepositorioSkillsWorkforceHora;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioGuardarSkillsWorkforceHora {

    private static final String EL_INFORME_YA_EXISTE = "El informe con esta fecha ya existe";

    private final RepositorioSkillsWorkforceHora repositorioSkillsWorkforceHora;

    private final NotificacionSkillWorkforceHora notificacionSkillWorkforceHora;

    public ServicioGuardarSkillsWorkforceHora(RepositorioSkillsWorkforceHora repositorioSkillsWorkforceHora, NotificacionSkillWorkforceHora notificacionSkillWorkforceHora) {
        this.repositorioSkillsWorkforceHora = repositorioSkillsWorkforceHora;
        this.notificacionSkillWorkforceHora = notificacionSkillWorkforceHora;
    }

    public boolean ejecutar(List<SkillsWorkforceHora> skillsWorkforceHoras){

            validarExistencia(skillsWorkforceHoras);
            return this.repositorioSkillsWorkforceHora.guardarArray(skillsWorkforceHoras);
    }

    private void validarExistencia(List<SkillsWorkforceHora> skillsWorkforceHoras) {
        var ini = skillsWorkforceHoras.get(0).getFecha_inicio_carga();
        var fin = skillsWorkforceHoras.get(0).getFecha_fin_carga();
        if(this.repositorioSkillsWorkforceHora.existe(ini) || this.repositorioSkillsWorkforceHora.existe(fin)) {
            throw new ExcepcionDuplicidad(String.format(EL_INFORME_YA_EXISTE));
        }
    }
}
