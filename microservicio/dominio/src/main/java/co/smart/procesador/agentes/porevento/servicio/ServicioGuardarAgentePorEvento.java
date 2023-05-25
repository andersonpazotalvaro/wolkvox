package co.smart.procesador.agentes.porevento.servicio;

import co.smart.procesador.agentes.email.servicio.NotificacionAgenteEstadoPorHora;
import co.smart.procesador.agentes.email.servicio.NotificacionAgentePorEvento;
import co.smart.procesador.agentes.porevento.modelo.dominio.AgentePorEvento;
import co.smart.procesador.agentes.porevento.puerto.repositorio.RepositorioAgentePorEvento;
import co.smart.procesador.agentes.tiempoporestado.modelo.dominio.AgenteTiempoPorEstado;
import co.smart.procesador.excepcion.ExcepcionDuplicidad;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioGuardarAgentePorEvento {

    private static final String EL_INFORME_YA_EXISTE = "El informe con esta fecha ya existe";

    private final RepositorioAgentePorEvento repositorioAgentePorEvento;

    private final NotificacionAgentePorEvento notificacionAgentePorEvento;

    public ServicioGuardarAgentePorEvento(RepositorioAgentePorEvento repositorioAgentePorEvento, NotificacionAgentePorEvento notificacionAgentePorEvento) {
        this.repositorioAgentePorEvento = repositorioAgentePorEvento;
        this.notificacionAgentePorEvento = notificacionAgentePorEvento;
    }

//@Async
    public boolean ejecutar(List<AgentePorEvento> agentePorEvento){
            validarExistencia(agentePorEvento);
            return this.repositorioAgentePorEvento.guardarArray(agentePorEvento);
    }

    private void validarExistencia(List<AgentePorEvento> agentePorEventos) {
        LocalDate fecha= agentePorEventos.get(0).getFECHA();
        String agente= agentePorEventos.get(0).getAgent_id();
        if(this.repositorioAgentePorEvento.existe(fecha,agente)) {
            throw new ExcepcionDuplicidad(String.format(EL_INFORME_YA_EXISTE));
        }
    }
}
