package co.smart.procesador.interaccionesychats.transferenciachats.adaptador.repositorio;

import co.smart.procesador.interaccionesychats.chats.puerto.repositorio.RepositorioInteraccionesChats;
import co.smart.procesador.interaccionesychats.transferenciachats.adaptador.MapperInteraccionesTransferenciaChats;
import co.smart.procesador.interaccionesychats.transferenciachats.modelo.dominio.InteraccionesTransferenciaChats;
import co.smart.procesador.interaccionesychats.transferenciachats.puerto.repositorio.RepositorioInteraccionesTransferenciaChats;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RepositorioInteraccionesTransferenciaChatsJpaSql implements RepositorioInteraccionesTransferenciaChats {

    private final MapperInteraccionesTransferenciaChats mapperInteraccionesTransferenciaChats;
    private final RepositorioInteraccionesTransferenciaChatsJpa repositorioInteraccionesTransferenciaChatsJpa;

    public RepositorioInteraccionesTransferenciaChatsJpaSql(MapperInteraccionesTransferenciaChats mapperInteraccionesTransferenciaChats, RepositorioInteraccionesTransferenciaChatsJpa repositorioInteraccionesTransferenciaChatsJpa) {
        this.mapperInteraccionesTransferenciaChats = mapperInteraccionesTransferenciaChats;
        this.repositorioInteraccionesTransferenciaChatsJpa = repositorioInteraccionesTransferenciaChatsJpa;
    }

    @Override
    public boolean guardar(InteraccionesTransferenciaChats interaccionesTransferenciaChats) {
        var entidadSkill= this.mapperInteraccionesTransferenciaChats.crearEntity(interaccionesTransferenciaChats);
        this.repositorioInteraccionesTransferenciaChatsJpa.save(entidadSkill);
        return false;
    }



    @Override
    public boolean guardarArray(List<InteraccionesTransferenciaChats> interaccionesTransferenciaChats) {
        var listaEntidadInteracciones= this.mapperInteraccionesTransferenciaChats.convertirDominioAEntidad(interaccionesTransferenciaChats);
        this.repositorioInteraccionesTransferenciaChatsJpa.saveAll(listaEntidadInteracciones);
        return true;
    }

    @Override
    public boolean existe(LocalDate fecha) {
        var entidadInteraccionesTransferenciaChats = this.repositorioInteraccionesTransferenciaChatsJpa.consultarSiExisteRegistroHoy(fecha.toString());
        if (entidadInteraccionesTransferenciaChats == null || entidadInteraccionesTransferenciaChats.size() == 0) {
            return false;
        }
        return true;
    }


}
