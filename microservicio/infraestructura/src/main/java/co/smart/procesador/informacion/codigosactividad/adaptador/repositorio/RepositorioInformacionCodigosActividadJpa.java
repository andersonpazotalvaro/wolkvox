package co.smart.procesador.informacion.codigosactividad.adaptador.repositorio;

import co.smart.procesador.informacion.codigosactividad.entidad.EntidadInformacionCodigosActividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioInformacionCodigosActividadJpa extends JpaRepository<EntidadInformacionCodigosActividad, Long> {

    @Query(nativeQuery = true,
            value = "Select *  from wolkvox.informacion_codigos_actividad where fecha_carga=:fechabuscada group by fecha_carga")
    List<EntidadInformacionCodigosActividad> consultarSiExisteRegistroHoy(@Param("fechabuscada")String fecha);

}
