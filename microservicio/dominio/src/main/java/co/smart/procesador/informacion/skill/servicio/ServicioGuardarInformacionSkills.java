package co.smart.procesador.informacion.skill.servicio;


import co.smart.procesador.excepcion.ExcepcionDuplicidad;
import co.smart.procesador.informacion.email.servicio.NotificacionInformacionSkills;
import co.smart.procesador.informacion.skill.modelo.dominio.InformacionSkills;
import co.smart.procesador.informacion.skill.puerto.repositorio.RepositorioInformacionsSkills;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioGuardarInformacionSkills {

    private static final String EL_INFORME_YA_EXISTE = "El informe con esta fecha ya existe";

    private final RepositorioInformacionsSkills repositorioInformacionsSkills;

    private final NotificacionInformacionSkills notificacionInformacionSkills;

    public ServicioGuardarInformacionSkills(RepositorioInformacionsSkills repositorioInformacionsSkills, NotificacionInformacionSkills notificacionInformacionSkills) {
        this.repositorioInformacionsSkills = repositorioInformacionsSkills;
        this.notificacionInformacionSkills = notificacionInformacionSkills;
    }

    public boolean ejecutar(List<InformacionSkills> informacionSkillsList){
            //validarExistencia(informacionSkillsList);
            return this.repositorioInformacionsSkills.guardarArray(informacionSkillsList);
    }

    private void validarExistencia(List<InformacionSkills> informacionSkills) {
        LocalDate fecha= informacionSkills.get(0).getFECHA();
        if(this.repositorioInformacionsSkills.existe(fecha)) {
            throw new ExcepcionDuplicidad(String.format(EL_INFORME_YA_EXISTE));
        }
    }
}
