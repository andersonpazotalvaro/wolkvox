package co.smart.procesador.interaccionesychats.transferenciachats.comando.fabrica;

import co.smart.procesador.interaccionesychats.transferenciachats.comando.ResponseInteraccionesTransferenciaChats;
import co.smart.procesador.interaccionesychats.transferenciachats.modelo.dominio.InteraccionesTransferenciaChats;
import co.smart.procesador.interaccionesychats.transferenciachats.modelo.respuesta.ResponseDataInteraccionesTransferenciaChats;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class FabricaInteraccionesTransferenciaChats {

    public InteraccionesTransferenciaChats crear(ResponseDataInteraccionesTransferenciaChats responseDataInteraccionesTransferenciaChats, String ini, String fin){

        return new InteraccionesTransferenciaChats(
                responseDataInteraccionesTransferenciaChats.getConn_id(),
                responseDataInteraccionesTransferenciaChats.getTransfer_agent_id(),
                responseDataInteraccionesTransferenciaChats.getTransfer_agent_name(),
                responseDataInteraccionesTransferenciaChats.getTransfer_agent_dni(),
                responseDataInteraccionesTransferenciaChats.getReceiver_agent_id(),
                responseDataInteraccionesTransferenciaChats.getReceiver_agent_name(),
                responseDataInteraccionesTransferenciaChats.getReceiver_agent_dni(),
                responseDataInteraccionesTransferenciaChats.getChannel(),
                convertirLocalDateTime(responseDataInteraccionesTransferenciaChats.getDate()),
                convertirEntradaALocalDate(ini),
                convertirEntradaALocalDate(fin)
        );
    }




    public List<InteraccionesTransferenciaChats> convertirRespuestaADominio(List<ResponseDataInteraccionesTransferenciaChats> responseDataInteraccionesTransferenciaChats, String ini, String fin){
        var listaInteraccionesTransferenciaChats = new ArrayList<InteraccionesTransferenciaChats>();

        responseDataInteraccionesTransferenciaChats.forEach(responseDataInteraccionesTransferenciaChats1 -> {
            listaInteraccionesTransferenciaChats.add(this.crear(responseDataInteraccionesTransferenciaChats1, ini, fin));

        });
        return listaInteraccionesTransferenciaChats;
    }

    public List<ResponseDataInteraccionesTransferenciaChats> obtenerDatos(ResponseInteraccionesTransferenciaChats responseInteraccionesTransferenciaChats){

        var listaResponseDataInteraccionesTransferenciaChats= new ArrayList<ResponseDataInteraccionesTransferenciaChats>();

        for (int i = 0; i<= responseInteraccionesTransferenciaChats.getData().length-1; i++){
            var responseDataInteraccionesTransferenciaChats= new ResponseDataInteraccionesTransferenciaChats(
                    responseInteraccionesTransferenciaChats.getData()[i].getConn_id(),
                    responseInteraccionesTransferenciaChats.getData()[i].getTransfer_agent_id(),
                    responseInteraccionesTransferenciaChats.getData()[i].getTransfer_agent_name(),
                    responseInteraccionesTransferenciaChats.getData()[i].getTransfer_agent_dni(),
                    responseInteraccionesTransferenciaChats.getData()[i].getReceiver_agent_id(),
                    responseInteraccionesTransferenciaChats.getData()[i].getReceiver_agent_name(),
                    responseInteraccionesTransferenciaChats.getData()[i].getReceiver_agent_dni(),
                    responseInteraccionesTransferenciaChats.getData()[i].getChannel(),
                    responseInteraccionesTransferenciaChats.getData()[i].getDate()

            );
            listaResponseDataInteraccionesTransferenciaChats.add(responseDataInteraccionesTransferenciaChats);
        }
        return listaResponseDataInteraccionesTransferenciaChats;
    }

    public int convertirNumero(String cadena){
        int respuesta=0;
        try {
           respuesta = Integer.valueOf(cadena);
        }catch (Exception e){

        }
        return respuesta;
    }

    public Float convertirFloat(String cadena){
        Float respuesta = (float) 0;
        try {
            respuesta = Float.valueOf(cadena);
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
