package co.smart.procesador.skillsyservicios.detallesllamadasabandonadas.servicio;


import co.smart.procesador.excepcion.ExcepcionDuplicidad;
import co.smart.procesador.skillsyservicios.detallesllamadasabandonadas.modelo.dominio.SkillsDetalleLlamadasAbandonadas;
import co.smart.procesador.skillsyservicios.detallesllamadasabandonadas.puerto.repositorio.RepositorioSkillsDetalleLlamadasAbandonadas;
import co.smart.procesador.skillsyservicios.email.servicio.NotificacionSkillDetalleLlamadasAbandonadas;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioGuardarSkillsDetalleLlamadasAbandonadas {

    private static final String EL_INFORME_YA_EXISTE = "El informe con esta fecha ya existe";

    private final RepositorioSkillsDetalleLlamadasAbandonadas repositorioSkillsDetalleLlamadasAbandonadas;

    private final NotificacionSkillDetalleLlamadasAbandonadas notificacionSkillDetalleLlamadasAbandonadas;

    public ServicioGuardarSkillsDetalleLlamadasAbandonadas(RepositorioSkillsDetalleLlamadasAbandonadas repositorioSkillsDetalleLlamadasAbandonadas, NotificacionSkillDetalleLlamadasAbandonadas notificacionSkillDetalleLlamadasAbandonadas) {
        this.repositorioSkillsDetalleLlamadasAbandonadas = repositorioSkillsDetalleLlamadasAbandonadas;
        this.notificacionSkillDetalleLlamadasAbandonadas = notificacionSkillDetalleLlamadasAbandonadas;
    }


    public boolean ejecutar(List<SkillsDetalleLlamadasAbandonadas> skillsDetalleLlamadasAbandonadas){

            validarExistencia(skillsDetalleLlamadasAbandonadas);
            return this.repositorioSkillsDetalleLlamadasAbandonadas.guardarArray(skillsDetalleLlamadasAbandonadas);
    }

    private void validarExistencia(List<SkillsDetalleLlamadasAbandonadas> skillsDetalleLlamadasAbandonadas) {
        var ini = skillsDetalleLlamadasAbandonadas.get(0).getFecha_inicio_carga();
        var fin = skillsDetalleLlamadasAbandonadas.get(0).getFecha_fin_carga();
        if(this.repositorioSkillsDetalleLlamadasAbandonadas.existe(ini) || this.repositorioSkillsDetalleLlamadasAbandonadas.existe(fin)) {
            throw new ExcepcionDuplicidad(String.format(EL_INFORME_YA_EXISTE));
        }
    }
}
