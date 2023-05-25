package co.smart.procesador.agentes.estadoporhora.puerto.repositorio;

import co.smart.procesador.agentes.estadoporhora.modelo.dominio.AgenteEstadoPorHora;

import java.time.LocalDate;
import java.util.List;

public interface RepositorioAgenteEstadoPorHora {

    boolean guardar(AgenteEstadoPorHora agenteEstadoPorHora);


    boolean guardarArray(List<AgenteEstadoPorHora> agenteEstadoPorHoras);

    boolean existe(LocalDate fecha);
}
