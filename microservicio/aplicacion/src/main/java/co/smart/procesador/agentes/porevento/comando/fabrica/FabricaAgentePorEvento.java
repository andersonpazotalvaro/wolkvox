package co.smart.procesador.agentes.porevento.comando.fabrica;

import co.smart.procesador.agentes.porevento.comando.ResponseAgentePorEvento;
import co.smart.procesador.agentes.porevento.modelo.dominio.AgentePorEvento;
import co.smart.procesador.agentes.porevento.modelo.respuesta.ResponseDataAgentePorEvento;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class FabricaAgentePorEvento {

    public AgentePorEvento crear(ResponseDataAgentePorEvento responseDataAgentePorEvento){

        return new AgentePorEvento(
                responseDataAgentePorEvento.getAgent_id(),
                responseDataAgentePorEvento.getAgent_status(),
                convertirLocalTime(responseDataAgentePorEvento.getTime()),
                convertirLocalDateTime(responseDataAgentePorEvento.getDate_ini()),
                convertirLocalDateTime(responseDataAgentePorEvento.getDate_end()),
                responseDataAgentePorEvento.getConn_id(),
                responseDataAgentePorEvento.getType_interaction(),
                responseDataAgentePorEvento.getDestiny(),
                responseDataAgentePorEvento.getTelephone(),
                responseDataAgentePorEvento.getCampaign_id()

        );
    }




    public List<AgentePorEvento> convertirRespuestaADominio(List<ResponseDataAgentePorEvento> responseDataAgentePorEventos){
        var listaAgentePorEvento = new ArrayList<AgentePorEvento>();

        responseDataAgentePorEventos.forEach(responseDataAgentePorEvento -> {
            listaAgentePorEvento.add(this.crear(responseDataAgentePorEvento));

        });
        return listaAgentePorEvento;
    }

    public List<ResponseDataAgentePorEvento> obtenerDatos(ResponseAgentePorEvento responseAgentePorEvento){

        var listaResponseDataAgenteTiempoPorEstados = new ArrayList<ResponseDataAgentePorEvento>();

        for (int i = 0; i<= responseAgentePorEvento.getData().length-1; i++){
            var responseDataAgentPorEstados = new ResponseDataAgentePorEvento(
                    responseAgentePorEvento.getData()[i].getAgent_id(),
                    responseAgentePorEvento.getData()[i].getAgent_status(),
                    responseAgentePorEvento.getData()[i].getTime(),
                    responseAgentePorEvento.getData()[i].getDate_ini(),
                    responseAgentePorEvento.getData()[i].getDate_end(),
                    responseAgentePorEvento.getData()[i].getConn_id(),
                    responseAgentePorEvento.getData()[i].getType_interaction(),
                    responseAgentePorEvento.getData()[i].getDestiny(),
                    responseAgentePorEvento.getData()[i].getTelephone(),
                    responseAgentePorEvento.getData()[i].getCampaign_id()

            );
            listaResponseDataAgenteTiempoPorEstados.add(responseDataAgentPorEstados);
        }
        return listaResponseDataAgenteTiempoPorEstados;
    }

    public int convertirNumero(String cadena){
        int respuesta=0;
        try {
           respuesta = Integer.valueOf(cadena);
        }catch (Exception e){

        }
        return respuesta;
    }

    public LocalTime convertirLocalTime(String cadena){
        LocalTime respuesta= null;
        try {
            respuesta = LocalTime.parse(cadena);
        }catch (Exception e){

        }
        return respuesta;
    }

    public LocalDateTime convertirLocalDateTime(String cadena){
        LocalDateTime respuesta= null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try {

             respuesta = LocalDateTime.parse(cadena, formatter);

        }catch (Exception e){

        }
        return respuesta;
    }
}
