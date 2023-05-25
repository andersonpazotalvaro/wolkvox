package co.smart.procesador.interaccionesychats.chats.servicio;


import co.smart.procesador.excepcion.ExcepcionDuplicidad;
import co.smart.procesador.interaccionesychats.chats.modelo.dominio.InteraccionesChats;
import co.smart.procesador.interaccionesychats.chats.puerto.repositorio.RepositorioInteraccionesChats;
import co.smart.procesador.interaccionesychats.email.servicio.NotificacionInteraccionesChats;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioGuardarInteraccionesChats {

    private static final String EL_INFORME_YA_EXISTE = "El informe con esta fecha ya existe";

    private final RepositorioInteraccionesChats repositorioInteraccionesChats;

    private final NotificacionInteraccionesChats notificacionInteraccionesChats;

    public ServicioGuardarInteraccionesChats(RepositorioInteraccionesChats repositorioInteraccionesChats, NotificacionInteraccionesChats notificacionInteraccionesChats) {
        this.repositorioInteraccionesChats = repositorioInteraccionesChats;
        this.notificacionInteraccionesChats = notificacionInteraccionesChats;
    }


    public boolean ejecutar(List<InteraccionesChats> interaccionesChats){

            validarExistencia(interaccionesChats);
            return this.repositorioInteraccionesChats.guardarArray(interaccionesChats);
    }

    private void validarExistencia(List<InteraccionesChats> interaccionesChats) {
        var ini = interaccionesChats.get(0).getFecha_inicio_carga();
        var fin = interaccionesChats.get(0).getFecha_fin_carga();
        if(this.repositorioInteraccionesChats.existe(ini) || this.repositorioInteraccionesChats.existe(fin)) {
            throw new ExcepcionDuplicidad(String.format(EL_INFORME_YA_EXISTE));
        }
    }
}
