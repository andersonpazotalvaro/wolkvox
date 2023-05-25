package co.smart.procesador.interaccionesychats.chats.puerto.repositorio;

import co.smart.procesador.interaccionesychats.chats.modelo.dominio.InteraccionesChats;

import java.time.LocalDate;
import java.util.List;

public interface RepositorioInteraccionesChats {

    boolean guardar(InteraccionesChats interaccionesChats);


    boolean guardarArray(List<InteraccionesChats> interaccionesChats);

    boolean existe(LocalDate fecha);


}
