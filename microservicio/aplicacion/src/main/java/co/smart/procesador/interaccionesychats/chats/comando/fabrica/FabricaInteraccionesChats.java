package co.smart.procesador.interaccionesychats.chats.comando.fabrica;

import co.smart.procesador.interaccionesychats.chats.comando.ResponseInteraccionesChats;
import co.smart.procesador.interaccionesychats.chats.modelo.dominio.InteraccionesChats;
import co.smart.procesador.interaccionesychats.chats.modelo.respuesta.ResponseDataInteraccionesChats;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class FabricaInteraccionesChats {

    public InteraccionesChats crear(ResponseDataInteraccionesChats responseDataInteraccionesChats, String ini, String fin){

        return new InteraccionesChats(
                responseDataInteraccionesChats.getConn_id(),
                responseDataInteraccionesChats.getChannel(),
                convertirLocalDateTime(responseDataInteraccionesChats.getDate()),
                responseDataInteraccionesChats.getCustomer_name(),
                responseDataInteraccionesChats.getCustomer_email(),
                responseDataInteraccionesChats.getCustomer_phone(),
                convertirNumero(responseDataInteraccionesChats.getCustomer_chars()),
                responseDataInteraccionesChats.getAgent_id(),
                responseDataInteraccionesChats.getAgent_name(),
                responseDataInteraccionesChats.getAgent_dni(),
                convertirNumero(responseDataInteraccionesChats.getAgent_chars()),
                convertirLocalTime(responseDataInteraccionesChats.getTime_on_agent()),
                convertirLocalTime(responseDataInteraccionesChats.getChat_duration()),
                responseDataInteraccionesChats.getCod_act(),
                responseDataInteraccionesChats.getDescription_cod_act(),

                responseDataInteraccionesChats.getComments(),
                responseDataInteraccionesChats.getCustomer_id(),
                responseDataInteraccionesChats.getSkill_id(),
                responseDataInteraccionesChats.getASA(),
                responseDataInteraccionesChats.getLast_participant_who_spoke(),
                responseDataInteraccionesChats.getExtra_field(),
                responseDataInteraccionesChats.getComment(),
                responseDataInteraccionesChats.getUser_id(),
                responseDataInteraccionesChats.getFeeling(),
                convertirNumero(responseDataInteraccionesChats.getAgent_answers()),
                convertirEntradaALocalDate(ini),
                convertirEntradaALocalDate(fin)
        );
    }




    public List<InteraccionesChats> convertirRespuestaADominio(List<ResponseDataInteraccionesChats> responseDataInteraccionesChats, String ini, String fin){
        var listaInteraccionesChats = new ArrayList<InteraccionesChats>();

        responseDataInteraccionesChats.forEach(responseDataInteraccionesChats1 -> {
            listaInteraccionesChats.add(this.crear(responseDataInteraccionesChats1, ini, fin));

        });
        return listaInteraccionesChats;
    }

    public List<ResponseDataInteraccionesChats> obtenerDatos(ResponseInteraccionesChats responseInteraccionesChats){

        var listaResponseDataInteraccionesChats= new ArrayList<ResponseDataInteraccionesChats>();

        for (int i = 0; i<= responseInteraccionesChats.getData().length-1; i++){
            var responseDataInteraccionesChats= new ResponseDataInteraccionesChats(
                    responseInteraccionesChats.getData()[i].getConn_id(),
                    responseInteraccionesChats.getData()[i].getChannel(),
                    responseInteraccionesChats.getData()[i].getDate(),
                    responseInteraccionesChats.getData()[i].getCustomer_name(),
                    responseInteraccionesChats.getData()[i].getCustomer_email(),
                    responseInteraccionesChats.getData()[i].getCustomer_phone(),
                    responseInteraccionesChats.getData()[i].getCustomer_chars(),
                    responseInteraccionesChats.getData()[i].getAgent_id(),
                    responseInteraccionesChats.getData()[i].getAgent_name(),
                    responseInteraccionesChats.getData()[i].getAgent_dni(),
                    responseInteraccionesChats.getData()[i].getAgent_chars(),
                    responseInteraccionesChats.getData()[i].getTime_on_agent(),
                    responseInteraccionesChats.getData()[i].getChat_duration(),
                    responseInteraccionesChats.getData()[i].getCod_act(),
                    responseInteraccionesChats.getData()[i].getDescription_cod_act(),
                    responseInteraccionesChats.getData()[i].getComments(),
                    responseInteraccionesChats.getData()[i].getCustomer_id(),
                    responseInteraccionesChats.getData()[i].getSkill_id(),
                    responseInteraccionesChats.getData()[i].getASA(),
                    responseInteraccionesChats.getData()[i].getLast_participant_who_spoke(),
                    responseInteraccionesChats.getData()[i].getExtra_field(),
                    responseInteraccionesChats.getData()[i].getComment(),
                    responseInteraccionesChats.getData()[i].getUser_id(),
                    responseInteraccionesChats.getData()[i].getFeeling(),
                    responseInteraccionesChats.getData()[i].getAgent_answers()
            );
            listaResponseDataInteraccionesChats.add(responseDataInteraccionesChats);
        }
        return listaResponseDataInteraccionesChats;
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
