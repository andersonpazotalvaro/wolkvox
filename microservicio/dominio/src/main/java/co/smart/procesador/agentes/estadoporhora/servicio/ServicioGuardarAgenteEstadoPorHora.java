package co.smart.procesador.agentes.estadoporhora.servicio;

import co.smart.procesador.agentes.email.servicio.NotificacionAgenteEstadoPorHora;
import co.smart.procesador.agentes.estadoporhora.modelo.dominio.AgenteEstadoPorHora;
import co.smart.procesador.agentes.estadoporhora.puerto.repositorio.RepositorioAgenteEstadoPorHora;
import co.smart.procesador.agentes.porevento.modelo.dominio.AgentePorEvento;
import co.smart.procesador.excepcion.ExcepcionDuplicidad;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioGuardarAgenteEstadoPorHora {

    private static final String EL_INFORME_YA_EXISTE = "El informe con esta fecha ya existe";

    private final RepositorioAgenteEstadoPorHora repositorioAgenteEstadoPorHora;

    private final NotificacionAgenteEstadoPorHora notificacionAgenteEstadoPorHora;

    public ServicioGuardarAgenteEstadoPorHora(RepositorioAgenteEstadoPorHora repositorioAgenteEstadoPorHora, NotificacionAgenteEstadoPorHora notificacionAgenteEstadoPorHora) {
        this.repositorioAgenteEstadoPorHora = repositorioAgenteEstadoPorHora;
        this.notificacionAgenteEstadoPorHora = notificacionAgenteEstadoPorHora;
    }


    public boolean ejecutar(List<AgenteEstadoPorHora> agenteEstadoPorHora){
            validarExistencia(agenteEstadoPorHora);
            return this.repositorioAgenteEstadoPorHora.guardarArray(agenteEstadoPorHora);
    }

    private void validarExistencia(List<AgenteEstadoPorHora> agenteEstadoPorHoras) {
        var ini = agenteEstadoPorHoras.get(0).getFecha_inicio_carga();
        var fin = agenteEstadoPorHoras.get(0).getFecha_fin_carga();
        if(this.repositorioAgenteEstadoPorHora.existe(ini) || this.repositorioAgenteEstadoPorHora.existe(fin)) {
            throw new ExcepcionDuplicidad(String.format(EL_INFORME_YA_EXISTE));
        }
    }
}
