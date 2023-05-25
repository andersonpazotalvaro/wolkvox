package co.smart.procesador.informacion.codigosactividad.adaptador.repositorio;

import co.smart.procesador.informacion.codigosactividad.adaptador.MapperInformacionCodigosActividad;
import co.smart.procesador.informacion.codigosactividad.modelo.dominio.InformacionCodigosActividad;
import co.smart.procesador.informacion.codigosactividad.puerto.repositorio.RepositorioInformacionsCodigosActividad;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RepositorioInformacionCodigosActividadJpaSql implements RepositorioInformacionsCodigosActividad {

    private final MapperInformacionCodigosActividad mapperInformacionCodigosActividad;
    private final RepositorioInformacionCodigosActividadJpa repositorioInformacionCodigosActividadJpa;

    public RepositorioInformacionCodigosActividadJpaSql(MapperInformacionCodigosActividad mapperInformacionCodigosActividad, RepositorioInformacionCodigosActividadJpa repositorioInformacionCodigosActividadJpa) {
        this.mapperInformacionCodigosActividad = mapperInformacionCodigosActividad;
        this.repositorioInformacionCodigosActividadJpa = repositorioInformacionCodigosActividadJpa;
    }

    @Override
    public boolean guardar(InformacionCodigosActividad informacionCodigosActividad) {
        var entidadSkill= this.mapperInformacionCodigosActividad.crearEntity(informacionCodigosActividad);
        this.repositorioInformacionCodigosActividadJpa.save(entidadSkill);
        return false;
    }


    @Override
    public boolean guardarArray(List<InformacionCodigosActividad> informacionCodigosActividads) {
        var listaEntidadInteracciones= this.mapperInformacionCodigosActividad.convertirDominioAEntidad(informacionCodigosActividads);
        this.repositorioInformacionCodigosActividadJpa.saveAll(listaEntidadInteracciones);
        return true;
    }

    @Override
    public boolean existe(LocalDate fecha) {
        var entidadInformacionCodigosActividads = this.repositorioInformacionCodigosActividadJpa.consultarSiExisteRegistroHoy(fecha.toString());
        if (entidadInformacionCodigosActividads == null || entidadInformacionCodigosActividads.size() == 0) {
            return false;
        }
        return true;
    }


}
