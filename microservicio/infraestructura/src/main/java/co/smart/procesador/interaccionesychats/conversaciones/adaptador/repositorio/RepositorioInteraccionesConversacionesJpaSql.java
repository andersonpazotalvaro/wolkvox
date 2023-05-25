package co.smart.procesador.interaccionesychats.conversaciones.adaptador.repositorio;

import co.smart.procesador.interaccionesychats.conversaciones.adaptador.MapperInteraccionesConversaciones;
import co.smart.procesador.interaccionesychats.conversaciones.modelo.dominio.InteraccionesConversaciones;
import co.smart.procesador.interaccionesychats.conversaciones.puerto.repositorio.RepositorioInteraccionesConversaciones;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RepositorioInteraccionesConversacionesJpaSql implements RepositorioInteraccionesConversaciones {

    private final MapperInteraccionesConversaciones mapperInteraccionesConversaciones;
    private final RepositorioInteraccionesConversacionesJpa repositorioInteraccionesConversacionesJpa;

    public RepositorioInteraccionesConversacionesJpaSql(MapperInteraccionesConversaciones mapperInteraccionesConversaciones, RepositorioInteraccionesConversacionesJpa repositorioInteraccionesConversacionesJpa) {
        this.mapperInteraccionesConversaciones = mapperInteraccionesConversaciones;
        this.repositorioInteraccionesConversacionesJpa = repositorioInteraccionesConversacionesJpa;
    }

    @Override
    public boolean guardar(InteraccionesConversaciones interaccionesConversaciones) {
        var entidadSkill= this.mapperInteraccionesConversaciones.crearEntity(interaccionesConversaciones);
        this.repositorioInteraccionesConversacionesJpa.save(entidadSkill);
        return false;
    }



    @Override
    public boolean guardarArray(List<InteraccionesConversaciones> interaccionesConversaciones) {
        var listaEntidadInteracciones= this.mapperInteraccionesConversaciones.convertirDominioAEntidad(interaccionesConversaciones);
        this.repositorioInteraccionesConversacionesJpa.saveAll(listaEntidadInteracciones);
        return true;
    }

    @Override
    public boolean existe(LocalDate fecha) {
        var entidadInteraccionesConversaciones = this.repositorioInteraccionesConversacionesJpa.consultarSiExisteRegistroHoy(fecha.toString());
        if (entidadInteraccionesConversaciones == null || entidadInteraccionesConversaciones.size() == 0) {
            return false;
        }
        return true;
    }


}
