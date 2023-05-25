package co.smart.procesador.interaccionesychats.chats.adaptador.repositorio;

import co.smart.procesador.interaccionesychats.chats.entidad.EntidadInteraccionesChats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioInteraccionesChatsJpa extends JpaRepository<EntidadInteraccionesChats, Long> {

    @Query(nativeQuery = true,
            value = "Select *  from wolkvox.interacciones_chats WHERE :fechabuscada BETWEEN fecha_inicio_carga AND fecha_fin_carga")
    List<EntidadInteraccionesChats> consultarSiExisteRegistroHoy(@Param("fechabuscada")String fecha);

}
