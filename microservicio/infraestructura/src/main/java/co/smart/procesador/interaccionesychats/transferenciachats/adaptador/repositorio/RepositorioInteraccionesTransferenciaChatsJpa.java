package co.smart.procesador.interaccionesychats.transferenciachats.adaptador.repositorio;

import co.smart.procesador.interaccionesychats.transferenciachats.entidad.EntidadInteraccionesTransferenciaChats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioInteraccionesTransferenciaChatsJpa extends JpaRepository<EntidadInteraccionesTransferenciaChats, Long> {

    @Query(nativeQuery = true,
            value = "Select *  from wolkvox.interacciones_transferencia_chats WHERE :fechabuscada BETWEEN fecha_inicio_carga AND fecha_fin_carga")
    List<EntidadInteraccionesTransferenciaChats> consultarSiExisteRegistroHoy(@Param("fechabuscada")String fecha);

}
