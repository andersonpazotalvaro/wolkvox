package co.smart.procesador.informacion.codigosactividad.puerto.repositorio;

import co.smart.procesador.informacion.codigosactividad.modelo.dominio.InformacionCodigosActividad;

import java.time.LocalDate;
import java.util.List;

public interface RepositorioInformacionsCodigosActividad {

    boolean guardar(InformacionCodigosActividad informacionCodigosActividad);


    boolean guardarArray(List<InformacionCodigosActividad> informacionCodigosActividads);

    boolean existe(LocalDate fecha);


}
