package co.smart.procesador.interaccionesychats.conversaciones.comando.fabrica;

import co.smart.procesador.interaccionesychats.conversaciones.comando.ResponseData;
import co.smart.procesador.interaccionesychats.conversaciones.comando.ResponseInteraccionesConversaciones;
import co.smart.procesador.interaccionesychats.conversaciones.modelo.dominio.InteraccionesConversaciones;
import co.smart.procesador.interaccionesychats.conversaciones.modelo.respuesta.ResponseDataInteraccionesConversaciones;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class FabricaInteraccionesConversaciones {

    public InteraccionesConversaciones crear(ResponseDataInteraccionesConversaciones responseDataInteraccionesConversaciones, String ini, String fin){

        return new InteraccionesConversaciones(
                responseDataInteraccionesConversaciones.getChat_id(),
                responseDataInteraccionesConversaciones.getChannel(),
                responseDataInteraccionesConversaciones.getFrom(),
                responseDataInteraccionesConversaciones.getFrom_name(),
                responseDataInteraccionesConversaciones.getTo_name(),
                convertirLocalDateTime(responseDataInteraccionesConversaciones.getDate()),
                responseDataInteraccionesConversaciones.getMessage(),
                responseDataInteraccionesConversaciones.getCustomer_id(),
                convertirEntradaALocalDate(ini),
                convertirEntradaALocalDate(fin)

        );
    }




    public List<InteraccionesConversaciones> convertirRespuestaADominio(List<ResponseDataInteraccionesConversaciones> responseDataInteraccionesConversaciones, String ini, String fin){
        var listaInteraccionesConversaciones = new ArrayList<InteraccionesConversaciones>();

        responseDataInteraccionesConversaciones.forEach(responseDataInteraccionesConversaciones1 -> {
            listaInteraccionesConversaciones.add(this.crear(responseDataInteraccionesConversaciones1, ini, fin));

        });
        return listaInteraccionesConversaciones;
    }

    public List<ResponseDataInteraccionesConversaciones> obtenerDatosConversaciones(ResponseData responseData){

        var listaResponseDataInteraccionesConversaciones= new ArrayList<ResponseDataInteraccionesConversaciones>();

        for (int i = 0; i<= responseData.getConversation().length-1; i++){
            var responseDataInteraccionesConversaciones= new ResponseDataInteraccionesConversaciones(
                    responseData.getConn_id(),
                    responseData.getConversation()[i].getChannel(),
                    responseData.getConversation()[i].getFrom(),
                    responseData.getConversation()[i].getFrom_name(),
                    responseData.getConversation()[i].getTo_name(),
                    responseData.getConversation()[i].getDate(),
                    responseData.getConversation()[i].getMessage(),
                    responseData.getConversation()[i].getCustomer_id()
            );
            if (responseDataInteraccionesConversaciones.getMessage().length()>499){
                responseDataInteraccionesConversaciones.setMessage("mensaje excede el tamaño, posible archivo o imagen");
            }
            listaResponseDataInteraccionesConversaciones.add(responseDataInteraccionesConversaciones);
        }
        return listaResponseDataInteraccionesConversaciones;
    }

    public List<ResponseDataInteraccionesConversaciones> obtenerDatos(ResponseInteraccionesConversaciones responseInteraccionesConversaciones){


        var listaResponseDataInteraccionesConversaciones= new ArrayList<ResponseDataInteraccionesConversaciones>();
        //List<ResponseDataInteraccionesConversaciones> listaResponseDataInteraccionesConversaciones = null;

        for (int i = 0; i<= responseInteraccionesConversaciones.getData().length-1; i++){
            var responseData= new ResponseData(
                    responseInteraccionesConversaciones.getData()[i].getConn_id(),
                    responseInteraccionesConversaciones.getData()[i].getAgent_name(),
                    responseInteraccionesConversaciones.getData()[i].getCustomer_name(),
                    responseInteraccionesConversaciones.getData()[i].getConversation()
            );

            //System.out.println(responseInteraccionesConversaciones.getData()[i].getConversation());
            var datos = this.obtenerDatosConversaciones(responseData);
            listaResponseDataInteraccionesConversaciones.addAll(datos);

        }
        return listaResponseDataInteraccionesConversaciones;
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
