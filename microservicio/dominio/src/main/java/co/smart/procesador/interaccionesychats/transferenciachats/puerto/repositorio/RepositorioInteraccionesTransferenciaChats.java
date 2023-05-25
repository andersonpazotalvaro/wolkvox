package co.smart.procesador.interaccionesychats.transferenciachats.puerto.repositorio;

import co.smart.procesador.interaccionesychats.chats.modelo.dominio.InteraccionesChats;
import co.smart.procesador.interaccionesychats.transferenciachats.modelo.dominio.InteraccionesTransferenciaChats;

import java.time.LocalDate;
import java.util.List;

public interface RepositorioInteraccionesTransferenciaChats {

    boolean guardar(InteraccionesTransferenciaChats interaccionesTransferenciaChats);


    boolean guardarArray(List<InteraccionesTransferenciaChats> interaccionesTransferenciaChats);

    boolean existe(LocalDate fecha);


}
