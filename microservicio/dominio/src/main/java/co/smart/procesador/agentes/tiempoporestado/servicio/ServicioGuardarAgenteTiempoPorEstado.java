package co.smart.procesador.agentes.tiempoporestado.servicio;

import co.smart.procesador.agentes.email.servicio.NotificacionAgenteTiempoPorEstado;
import co.smart.procesador.agentes.tiempoporestado.modelo.dominio.AgenteTiempoPorEstado;
import co.smart.procesador.agentes.tiempoporestado.puerto.repositorio.RepositorioAgenteTiempoPorEstado;
import co.smart.procesador.excepcion.ExcepcionDuplicidad;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioGuardarAgenteTiempoPorEstado {

    private static final String EL_INFORME_YA_EXISTE = "El informe con esta fecha ya existe";

    private final RepositorioAgenteTiempoPorEstado repositorioAgenteTiempoPorEstado;

    private final NotificacionAgenteTiempoPorEstado notificacionAgenteTiempoPorEstado;

    public ServicioGuardarAgenteTiempoPorEstado(RepositorioAgenteTiempoPorEstado repositorioAgenteTiempoPorEstado, NotificacionAgenteTiempoPorEstado notificacionAgenteTiempoPorEstado) {
        this.repositorioAgenteTiempoPorEstado = repositorioAgenteTiempoPorEstado;
        this.notificacionAgenteTiempoPorEstado = notificacionAgenteTiempoPorEstado;
    }

    public boolean ejecutar(List<AgenteTiempoPorEstado> agenteTiempoPorEstado){

            validarExistencia(agenteTiempoPorEstado);
            return this.repositorioAgenteTiempoPorEstado.guardarArray(agenteTiempoPorEstado);
    }

    private void validarExistencia(List<AgenteTiempoPorEstado> agenteTiempoPorEstado) {
        var ini = agenteTiempoPorEstado.get(0).getFecha_inicio_carga();
        var fin = agenteTiempoPorEstado.get(0).getFecha_fin_carga();
        if(this.repositorioAgenteTiempoPorEstado.existe(ini) || this.repositorioAgenteTiempoPorEstado.existe(fin)) {
            throw new ExcepcionDuplicidad(String.format(EL_INFORME_YA_EXISTE));
        }
    }
}
