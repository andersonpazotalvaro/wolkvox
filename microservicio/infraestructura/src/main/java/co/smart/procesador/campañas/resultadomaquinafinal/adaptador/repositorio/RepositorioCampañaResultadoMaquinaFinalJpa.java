package co.smart.procesador.campañas.resultadomaquinafinal.adaptador.repositorio;

import co.smart.procesador.agente.estadoporhora.entidad.EntidadAgenteEstadoPorHora;
import co.smart.procesador.campañas.resultadomaquinafinal.entidad.EntidadCampañaResultadoMaquinaFinal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioCampañaResultadoMaquinaFinalJpa extends JpaRepository<EntidadCampañaResultadoMaquinaFinal, Long> {

    @Query(nativeQuery = true,
            value = "Select *  from wolkvox.campaña_resultado_maquina_final WHERE :fechabuscada BETWEEN fecha_inicio_carga AND fecha_fin_carga")
    List<EntidadCampañaResultadoMaquinaFinal> consultarSiExisteRegistroHoy(@Param("fechabuscada")String fecha);

}
