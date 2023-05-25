package co.smart.procesador.informacion.codigosactividad.servicio;


import co.smart.procesador.excepcion.ExcepcionDuplicidad;
import co.smart.procesador.informacion.codigosactividad.modelo.dominio.InformacionCodigosActividad;
import co.smart.procesador.informacion.codigosactividad.puerto.repositorio.RepositorioInformacionsCodigosActividad;
import co.smart.procesador.informacion.email.servicio.NotificacionInformacionCodigosActividad;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioGuardarInformacionCodigosActividad {

    private static final String EL_INFORME_YA_EXISTE = "El informe con esta fecha ya existe";

    private final RepositorioInformacionsCodigosActividad repositorioInformacionsCodigosActividad;

    private final NotificacionInformacionCodigosActividad notificacionInformacionCodigosActividad;

    public ServicioGuardarInformacionCodigosActividad(RepositorioInformacionsCodigosActividad repositorioInformacionsCodigosActividad, NotificacionInformacionCodigosActividad notificacionInformacionCodigosActividad) {
        this.repositorioInformacionsCodigosActividad = repositorioInformacionsCodigosActividad;
        this.notificacionInformacionCodigosActividad = notificacionInformacionCodigosActividad;
    }

    public boolean ejecutar(List<InformacionCodigosActividad> informacionCodigosActividads){
            //validarExistencia(informacionSkillsList);
            return this.repositorioInformacionsCodigosActividad.guardarArray(informacionCodigosActividads);
    }

    private void validarExistencia(List<InformacionCodigosActividad> informacionSkills) {
        LocalDate fecha= informacionSkills.get(0).getFECHA();
        if(this.repositorioInformacionsCodigosActividad.existe(fecha)) {
            throw new ExcepcionDuplicidad(String.format(EL_INFORME_YA_EXISTE));
        }
    }
}
