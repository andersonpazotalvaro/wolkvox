package co.smart.procesador.interaccionesychats.transferenciachats.servicio;


import co.smart.procesador.excepcion.ExcepcionDuplicidad;
import co.smart.procesador.interaccionesychats.email.servicio.NotificacionInteraccionesTransferenciaChats;
import co.smart.procesador.interaccionesychats.transferenciachats.modelo.dominio.InteraccionesTransferenciaChats;
import co.smart.procesador.interaccionesychats.transferenciachats.puerto.repositorio.RepositorioInteraccionesTransferenciaChats;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioGuardarInteraccionesTransferenciaChats {

    private static final String EL_INFORME_YA_EXISTE = "El informe con esta fecha ya existe";

    private final RepositorioInteraccionesTransferenciaChats repositorioInteraccionesTransferenciaChats;

    private final NotificacionInteraccionesTransferenciaChats notificacionInteraccionesTransferenciaChats;

    public ServicioGuardarInteraccionesTransferenciaChats(RepositorioInteraccionesTransferenciaChats repositorioInteraccionesTransferenciaChats, NotificacionInteraccionesTransferenciaChats notificacionInteraccionesTransferenciaChats) {
        this.repositorioInteraccionesTransferenciaChats = repositorioInteraccionesTransferenciaChats;
        this.notificacionInteraccionesTransferenciaChats = notificacionInteraccionesTransferenciaChats;
    }

    public boolean ejecutar(List<InteraccionesTransferenciaChats> interaccionesTransferenciaChats){

            validarExistencia(interaccionesTransferenciaChats);
            return this.repositorioInteraccionesTransferenciaChats.guardarArray(interaccionesTransferenciaChats);
    }

    private void validarExistencia(List<InteraccionesTransferenciaChats> interaccionesTransferenciaChats) {
        var ini = interaccionesTransferenciaChats.get(0).getFecha_inicio_carga();
        var fin = interaccionesTransferenciaChats.get(0).getFecha_fin_carga();
        if(this.repositorioInteraccionesTransferenciaChats.existe(ini) || this.repositorioInteraccionesTransferenciaChats.existe(fin)) {
            throw new ExcepcionDuplicidad(String.format(EL_INFORME_YA_EXISTE));
        }
    }
}
