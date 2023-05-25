package co.smart.procesador.agentes.tiempoporestado.puerto.repositorio;

import co.smart.procesador.agentes.tiempoporestado.modelo.dominio.AgenteTiempoPorEstado;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RepositorioAgenteTiempoPorEstado {

    boolean guardar(AgenteTiempoPorEstado agenteTiempoPorEstado);


    boolean guardarArray(List<AgenteTiempoPorEstado> agenteTiempoPorEstados);

    boolean existe(LocalDate fecha);

    List<AgenteTiempoPorEstado> listarIpAgent();

}
