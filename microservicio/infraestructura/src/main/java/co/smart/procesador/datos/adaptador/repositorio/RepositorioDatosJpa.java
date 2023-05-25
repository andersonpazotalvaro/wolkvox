package co.smart.procesador.datos.adaptador.repositorio;

import co.smart.procesador.datos.entidad.EntidadToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface RepositorioDatosJpa extends JpaRepository<EntidadToken, Long> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM wolkvox.datos WHERE datos.id = 1")
    EntidadToken selectFirstRow() ;

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = "UPDATE `wolkvox`.`datos` SET `correo` = :correodestino, `correo2` = :correodestino2, `correo3` = :correodestino3, `ip_server` = :ipstring, `token` = :tokenstring  WHERE (`id` = '1')")
    void updateFirstRow(@Param("tokenstring") String tokenString, @Param("ipstring") String ipString, @Param("correodestino") String correo,
                        @Param("correodestino2") String correo2,@Param("correodestino3") String correo3);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = "INSERT INTO wolkvox.datos (id, token, ip_server, correo, correo2, correo3) VALUES (1, :tokenstring , :ipstring, :correodestino, :correodestino2, :correodestino3)")
    void saveFirstRow(@Param("tokenstring") String tokenString, @Param("ipstring") String ipString,  @Param("correodestino") String correo,
                      @Param("correodestino2") String correo2, @Param("correodestino3") String correo3) ;

}
