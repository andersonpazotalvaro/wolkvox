package co.smart.procesador.interaccionesychats.conversaciones.servicio;


import co.smart.procesador.excepcion.ExcepcionDuplicidad;
import co.smart.procesador.interaccionesychats.conversaciones.modelo.dominio.InteraccionesConversaciones;
import co.smart.procesador.interaccionesychats.conversaciones.puerto.repositorio.RepositorioInteraccionesConversaciones;
import co.smart.procesador.interaccionesychats.email.servicio.NotificacionInteraccionesConversaciones;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioGuardarInteraccionesConversaciones {

    private static final String EL_INFORME_YA_EXISTE = "El informe con esta fecha ya existe";

    private final RepositorioInteraccionesConversaciones repositorioInteraccionesConversaciones;

    private final NotificacionInteraccionesConversaciones notificacionInteraccionesConversaciones;

    public ServicioGuardarInteraccionesConversaciones(RepositorioInteraccionesConversaciones repositorioInteraccionesConversaciones, NotificacionInteraccionesConversaciones notificacionInteraccionesConversaciones) {
        this.repositorioInteraccionesConversaciones = repositorioInteraccionesConversaciones;
        this.notificacionInteraccionesConversaciones = notificacionInteraccionesConversaciones;
    }

    public boolean ejecutar(List<InteraccionesConversaciones> interaccionesConversaciones){

            validarExistencia(interaccionesConversaciones);
            return this.repositorioInteraccionesConversaciones.guardarArray(interaccionesConversaciones);
    }

    private void validarExistencia(List<InteraccionesConversaciones> interaccionesConversaciones) {
        var ini = interaccionesConversaciones.get(0).getFecha_inicio_carga();
        var fin = interaccionesConversaciones.get(0).getFecha_fin_carga();
        if(this.repositorioInteraccionesConversaciones.existe(ini) || this.repositorioInteraccionesConversaciones.existe(fin)) {
            throw new ExcepcionDuplicidad(String.format(EL_INFORME_YA_EXISTE));
        }
    }
}
