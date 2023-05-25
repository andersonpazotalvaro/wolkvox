package co.smart.procesador.interaccionesychats.conversaciones.adaptador.repositorio;

import co.smart.procesador.interaccionesychats.conversaciones.entidad.EntidadInteraccionesConversaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioInteraccionesConversacionesJpa extends JpaRepository<EntidadInteraccionesConversaciones, Long> {

    @Query(nativeQuery = true,
            value = "Select *  from wolkvox.interacciones_conversaciones WHERE :fechabuscada BETWEEN fecha_inicio_carga AND fecha_fin_carga")
    List<EntidadInteraccionesConversaciones> consultarSiExisteRegistroHoy(@Param("fechabuscada")String fecha);

}
