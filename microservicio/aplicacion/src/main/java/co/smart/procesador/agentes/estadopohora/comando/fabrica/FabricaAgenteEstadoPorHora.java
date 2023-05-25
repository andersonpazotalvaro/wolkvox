package co.smart.procesador.agentes.estadopohora.comando.fabrica;

import co.smart.procesador.agentes.estadopohora.comando.ResponseAgenteEstadoPorHora;
import co.smart.procesador.agentes.estadoporhora.modelo.dominio.AgenteEstadoPorHora;
import co.smart.procesador.agentes.estadoporhora.modelo.respuesta.ResponseDataAgenteEstadoPorHora;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class FabricaAgenteEstadoPorHora {

    public AgenteEstadoPorHora crear(ResponseDataAgenteEstadoPorHora responseDataAgenteEstadoPorHora, String ini, String fin){

        return new AgenteEstadoPorHora(
                responseDataAgenteEstadoPorHora.getHour(),
                convertirNumero(responseDataAgenteEstadoPorHora.getCalls()),
                convertirNumero(responseDataAgenteEstadoPorHora.getInbound()),
                convertirNumero(responseDataAgenteEstadoPorHora.getOutbound()),
                convertirNumero(responseDataAgenteEstadoPorHora.getInternal()),
                convertirLocalTime(responseDataAgenteEstadoPorHora.getReady_time()),
                convertirLocalTime(responseDataAgenteEstadoPorHora.getInbound_time()),
                convertirLocalTime(responseDataAgenteEstadoPorHora.getOutbound_time()),
                convertirLocalTime(responseDataAgenteEstadoPorHora.getAcw_time()),
                convertirLocalTime(responseDataAgenteEstadoPorHora.getRing_time()),
                convertirLocalTime(responseDataAgenteEstadoPorHora.getLogin_time()),
                convertirLocalTime(responseDataAgenteEstadoPorHora.getAht()),
                responseDataAgenteEstadoPorHora.getOccupancy(),
                convertirLocalTime(responseDataAgenteEstadoPorHora.getAux_time()),
                convertirEntradaALocalDate(ini),
                convertirEntradaALocalDate(fin)
        );
    }




    public List<AgenteEstadoPorHora> convertirRespuestaADominio(List<ResponseDataAgenteEstadoPorHora> responseDataAgenteEstadoPorHoras, String ini, String fin){
        var listaAgenteEstadoPorHora = new ArrayList<AgenteEstadoPorHora>();

        responseDataAgenteEstadoPorHoras.forEach(responseDataAgenteEstadoPorHora -> {
            listaAgenteEstadoPorHora.add(this.crear(responseDataAgenteEstadoPorHora, ini, fin));

        });
        return listaAgenteEstadoPorHora;
    }

    public List<ResponseDataAgenteEstadoPorHora> obtenerDatos(ResponseAgenteEstadoPorHora responseAgenteEstadoPorHora){

        var listaResponseDataAgenteEstadoPorHora= new ArrayList<ResponseDataAgenteEstadoPorHora>();

        for (int i = 0; i<= responseAgenteEstadoPorHora.getData().length-1; i++){
            var responseDataAgenteEstadoPorHora = new ResponseDataAgenteEstadoPorHora(
                    responseAgenteEstadoPorHora.getData()[i].getHour(),
                    responseAgenteEstadoPorHora.getData()[i].getCalls(),
                    responseAgenteEstadoPorHora.getData()[i].getInbound(),
                    responseAgenteEstadoPorHora.getData()[i].getOutbound(),
                    responseAgenteEstadoPorHora.getData()[i].getInternal(),
                    responseAgenteEstadoPorHora.getData()[i].getReady_time(),
                    responseAgenteEstadoPorHora.getData()[i].getInbound_time(),
                    responseAgenteEstadoPorHora.getData()[i].getOutbound_time(),
                    responseAgenteEstadoPorHora.getData()[i].getAcw_time(),
                    responseAgenteEstadoPorHora.getData()[i].getRing_time(),
                    responseAgenteEstadoPorHora.getData()[i].getLogin_time(),
                    responseAgenteEstadoPorHora.getData()[i].getAht(),
                    responseAgenteEstadoPorHora.getData()[i].getOccupancy(),
                    responseAgenteEstadoPorHora.getData()[i].getAux_time()
            );
            listaResponseDataAgenteEstadoPorHora.add(responseDataAgenteEstadoPorHora);
        }
        return listaResponseDataAgenteEstadoPorHora;
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
