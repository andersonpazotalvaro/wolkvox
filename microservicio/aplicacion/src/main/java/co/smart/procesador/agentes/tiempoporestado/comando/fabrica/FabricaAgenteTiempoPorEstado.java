package co.smart.procesador.agentes.tiempoporestado.comando.fabrica;

import co.smart.procesador.agentes.tiempoporestado.comando.ResponseAgenteTiempoPorEstado;
import co.smart.procesador.agentes.tiempoporestado.modelo.respuesta.ResponseDataAgenteTiempoPorEstado;
import co.smart.procesador.agentes.tiempoporestado.modelo.dominio.AgenteTiempoPorEstado;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class FabricaAgenteTiempoPorEstado {

    public AgenteTiempoPorEstado crear(ResponseDataAgenteTiempoPorEstado responseDataAgenteTiempoPorEstado,  String ini, String fin){

        return new AgenteTiempoPorEstado(
                responseDataAgenteTiempoPorEstado.getAgent_id(),
                responseDataAgenteTiempoPorEstado.getAgent_dni(),
                responseDataAgenteTiempoPorEstado.getAgent_name(),
                convertirNumero(responseDataAgenteTiempoPorEstado.getCalls()),
                convertirNumero(responseDataAgenteTiempoPorEstado.getInbound()),
                convertirNumero(responseDataAgenteTiempoPorEstado.getOutbound()),
                convertirNumero(responseDataAgenteTiempoPorEstado.getInternal()),
                convertirLocalTime(responseDataAgenteTiempoPorEstado.getReady_time()),
                convertirLocalTime(responseDataAgenteTiempoPorEstado.getInbound_time()),
                convertirLocalTime(responseDataAgenteTiempoPorEstado.getOutbound_time()),
                convertirLocalTime(responseDataAgenteTiempoPorEstado.getAcw_time()),
                convertirLocalTime(responseDataAgenteTiempoPorEstado.getRing_time()),
                convertirLocalTime(responseDataAgenteTiempoPorEstado.getLogin_time()),
                convertirLocalTime(responseDataAgenteTiempoPorEstado.getAht()),
                responseDataAgenteTiempoPorEstado.getOccupancy(),
                convertirLocalTime(responseDataAgenteTiempoPorEstado.getAux_time()),
                convertirNumero(responseDataAgenteTiempoPorEstado.getHits()),
                convertirNumero(responseDataAgenteTiempoPorEstado.getRpc()),
                responseDataAgenteTiempoPorEstado.getAht_outbound(),
                convertirLocalTime(responseDataAgenteTiempoPorEstado.getAht_inbound()),
                convertirLocalDateTime(responseDataAgenteTiempoPorEstado.getLogin()),
                convertirLocalDateTime(responseDataAgenteTiempoPorEstado.getLogout()),
                convertirEntradaALocalDate(ini),
                convertirEntradaALocalDate(fin)
        );
    }




    public List<AgenteTiempoPorEstado> convertirRespuestaADominio(List<ResponseDataAgenteTiempoPorEstado> responseDataAgenteTiempoPorEstados,  String ini, String fin){
        var listaAgenteTiempoPorEstado = new ArrayList<AgenteTiempoPorEstado>();

        responseDataAgenteTiempoPorEstados.forEach(responseDataAgenteTiempoPorEstado -> {
            listaAgenteTiempoPorEstado.add(this.crear(responseDataAgenteTiempoPorEstado, ini, fin));

        });
        return listaAgenteTiempoPorEstado;
    }

    public List<ResponseDataAgenteTiempoPorEstado> obtenerDatos(ResponseAgenteTiempoPorEstado responseAgenteTiempoPorEstado){

        var listaResponseDataAgenteTiempoPorEstados = new ArrayList<ResponseDataAgenteTiempoPorEstado>();

        for (int i = 0; i<= responseAgenteTiempoPorEstado.getData().length-1; i++){
            var responseDataAgentPorEstados = new ResponseDataAgenteTiempoPorEstado(
                    responseAgenteTiempoPorEstado.getData()[i].getAgent_id(),
                    responseAgenteTiempoPorEstado.getData()[i].getAgent_dni(),
                    responseAgenteTiempoPorEstado.getData()[i].getAgent_name(),
                    responseAgenteTiempoPorEstado.getData()[i].getCalls(),
                    responseAgenteTiempoPorEstado.getData()[i].getInbound(),
                    responseAgenteTiempoPorEstado.getData()[i].getOutbound(),
                    responseAgenteTiempoPorEstado.getData()[i].getInternal(),
                    responseAgenteTiempoPorEstado.getData()[i].getReady_time(),
                    responseAgenteTiempoPorEstado.getData()[i].getInbound_time(),
                    responseAgenteTiempoPorEstado.getData()[i].getOutbound_time(),
                    responseAgenteTiempoPorEstado.getData()[i].getAcw_time(),
                    responseAgenteTiempoPorEstado.getData()[i].getRing_time(),
                    responseAgenteTiempoPorEstado.getData()[i].getLogin_time(),
                    responseAgenteTiempoPorEstado.getData()[i].getAht(),
                    responseAgenteTiempoPorEstado.getData()[i].getOccupancy(),
                    responseAgenteTiempoPorEstado.getData()[i].getAux_time(),
                    responseAgenteTiempoPorEstado.getData()[i].getHits(),
                    responseAgenteTiempoPorEstado.getData()[i].getRpc(),
                    responseAgenteTiempoPorEstado.getData()[i].getAht_outbound(),
                    responseAgenteTiempoPorEstado.getData()[i].getAht_inbound(),
                    responseAgenteTiempoPorEstado.getData()[i].getLogin(),
                    responseAgenteTiempoPorEstado.getData()[i].getLogout()
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

    public LocalDate convertirEntradaALocalDate(String cadena){
        String fecha4 = cadena.substring(0, 8);
        //someString = someString.substring(1);
        LocalDate fechaCompleta= null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        try {
            fechaCompleta = LocalDate.parse(fecha4, formatter);
        }catch (Exception e){

        }
        return fechaCompleta;
    }
}
