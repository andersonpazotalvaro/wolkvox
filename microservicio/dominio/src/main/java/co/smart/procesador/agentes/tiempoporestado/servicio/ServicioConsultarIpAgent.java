package co.smart.procesador.agentes.tiempoporestado.servicio;

import co.smart.procesador.agentes.tiempoporestado.modelo.dominio.AgenteTiempoPorEstado;
import co.smart.procesador.agentes.tiempoporestado.puerto.repositorio.RepositorioAgenteTiempoPorEstado;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioConsultarIpAgent {

    private static final String NO_SE_PUDO_CONSULTAR = "No se pudo consultar";

    private final RepositorioAgenteTiempoPorEstado agenteTiempoPorEstado;

    public ServicioConsultarIpAgent(RepositorioAgenteTiempoPorEstado agenteTiempoPorEstado) {
        this.agenteTiempoPorEstado = agenteTiempoPorEstado;
    }

    public List<AgenteTiempoPorEstado> ejecutar(){
       return this.agenteTiempoPorEstado.listarIpAgent();
    }
}
