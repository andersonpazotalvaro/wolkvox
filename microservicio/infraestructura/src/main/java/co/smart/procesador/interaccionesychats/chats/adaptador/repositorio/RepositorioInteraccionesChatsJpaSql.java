package co.smart.procesador.interaccionesychats.chats.adaptador.repositorio;

import co.smart.procesador.interaccionesychats.chats.adaptador.MapperInteraccionesChats;
import co.smart.procesador.interaccionesychats.chats.modelo.dominio.InteraccionesChats;
import co.smart.procesador.interaccionesychats.chats.puerto.repositorio.RepositorioInteraccionesChats;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RepositorioInteraccionesChatsJpaSql implements RepositorioInteraccionesChats {

    private final MapperInteraccionesChats mapperInteraccionesChats;
    private final RepositorioInteraccionesChatsJpa repositorioInteraccionesChatsJpa;

    public RepositorioInteraccionesChatsJpaSql(MapperInteraccionesChats mapperInteraccionesChats, RepositorioInteraccionesChatsJpa repositorioInteraccionesChatsJpa) {
        this.mapperInteraccionesChats = mapperInteraccionesChats;
        this.repositorioInteraccionesChatsJpa = repositorioInteraccionesChatsJpa;
    }

    @Override
    public boolean guardar(InteraccionesChats interaccionesChats) {
        var entidadSkill= this.mapperInteraccionesChats.crearEntity(interaccionesChats);
        this.repositorioInteraccionesChatsJpa.save(entidadSkill);
        return false;
    }



    @Override
    public boolean guardarArray(List<InteraccionesChats> interaccionesChats) {
        var listaEntidadInteracciones= this.mapperInteraccionesChats.convertirDominioAEntidad(interaccionesChats);
        this.repositorioInteraccionesChatsJpa.saveAll(listaEntidadInteracciones);
        return true;
    }

    @Override
    public boolean existe(LocalDate fecha) {
        var entidadInteraccionesChats = this.repositorioInteraccionesChatsJpa.consultarSiExisteRegistroHoy(fecha.toString());
        if (entidadInteraccionesChats == null || entidadInteraccionesChats.size() == 0) {
            return false;
        }
        return true;
    }


}
