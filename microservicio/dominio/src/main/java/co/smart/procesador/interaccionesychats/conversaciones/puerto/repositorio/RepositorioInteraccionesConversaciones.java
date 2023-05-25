package co.smart.procesador.interaccionesychats.conversaciones.puerto.repositorio;

import co.smart.procesador.interaccionesychats.chats.modelo.dominio.InteraccionesChats;
import co.smart.procesador.interaccionesychats.conversaciones.modelo.dominio.InteraccionesConversaciones;

import java.time.LocalDate;
import java.util.List;

public interface RepositorioInteraccionesConversaciones {

    boolean guardar(InteraccionesConversaciones interaccionesConversaciones);


    boolean guardarArray(List<InteraccionesConversaciones> interaccionesConversaciones);

    boolean existe(LocalDate fecha);


}
