package co.smart.procesador.campañas.resultadotelefonoatelefono.adaptador.repopsitorio;

import co.smart.procesador.campañas.resultadomaquinafinal.entidad.EntidadCampañaResultadoMaquinaFinal;
import co.smart.procesador.campañas.resultadotelefonoatelefono.entidad.EntidadCampañaResultadoTelefonoATelefono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioCampañaResultadoTelefonoATelefonoJpa extends JpaRepository<EntidadCampañaResultadoTelefonoATelefono, Long> {

    @Query(nativeQuery = true,
            value = "Select *  from wolkvox.campaña_resultado_telefono_a_telefono WHERE :fechabuscada BETWEEN fecha_inicio_carga AND fecha_fin_carga")
    List<EntidadCampañaResultadoTelefonoATelefono> consultarSiExisteRegistroHoy(@Param("fechabuscada")String fecha);

}
