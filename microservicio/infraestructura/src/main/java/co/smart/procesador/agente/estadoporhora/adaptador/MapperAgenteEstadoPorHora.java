package co.smart.procesador.agente.estadoporhora.adaptador;

import co.smart.procesador.agente.estadoporhora.entidad.EntidadAgenteEstadoPorHora;
import co.smart.procesador.agentes.estadoporhora.modelo.dominio.AgenteEstadoPorHora;
import co.smart.procesador.agentes.tiempoporestado.modelo.dominio.AgenteTiempoPorEstado;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperAgenteEstadoPorHora {



    public EntidadAgenteEstadoPorHora crearEntity(AgenteEstadoPorHora agenteEstadoPorHora){
        return new EntidadAgenteEstadoPorHora(
                agenteEstadoPorHora.getHour(),
                agenteEstadoPorHora.getCalls(),
                agenteEstadoPorHora.getInbound(),
                agenteEstadoPorHora.getOutbound(),
                agenteEstadoPorHora.getInternal(),
                agenteEstadoPorHora.getReady_time(),
                agenteEstadoPorHora.getInbound_time(),
                agenteEstadoPorHora.getOutbound_time(),
                agenteEstadoPorHora.getAcw_time(),
                agenteEstadoPorHora.getRing_time(),
                agenteEstadoPorHora.getLogin_time(),
                agenteEstadoPorHora.getAht(),
                agenteEstadoPorHora.getOccupancy(),
                agenteEstadoPorHora.getAux_time(),
                agenteEstadoPorHora.getFECHA(),
                agenteEstadoPorHora.getFecha_inicio_carga(),
                agenteEstadoPorHora.getFecha_fin_carga()

        );
    }

    public List<EntidadAgenteEstadoPorHora> convertirDominioAEntidad(List<AgenteEstadoPorHora> agenteEstadoPorHoras){
        var listaEntidadAgenteEstadoPorHora = new ArrayList<EntidadAgenteEstadoPorHora>();

        agenteEstadoPorHoras.forEach(agenteEstadoPorHora -> {
            listaEntidadAgenteEstadoPorHora.add(this.crearEntity(agenteEstadoPorHora));

        });
        return listaEntidadAgenteEstadoPorHora;
    }
}
