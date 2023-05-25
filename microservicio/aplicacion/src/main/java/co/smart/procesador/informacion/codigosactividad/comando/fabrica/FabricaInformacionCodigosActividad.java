package co.smart.procesador.informacion.codigosactividad.comando.fabrica;

import co.smart.procesador.informacion.codigosactividad.comando.ResponseInformacionCodigosActividad;
import co.smart.procesador.informacion.codigosactividad.modelo.dominio.InformacionCodigosActividad;
import co.smart.procesador.informacion.codigosactividad.modelo.respuesta.ResponseDataInformacionCodigosActividad;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class FabricaInformacionCodigosActividad {

    public InformacionCodigosActividad crear(ResponseDataInformacionCodigosActividad responseDataInformacionCodigosActividad){

        return new InformacionCodigosActividad(
                convertirLong(responseDataInformacionCodigosActividad.getCod_act()),
                responseDataInformacionCodigosActividad.getDescription_cod_act(),
                responseDataInformacionCodigosActividad.getHit(),
                responseDataInformacionCodigosActividad.getRpc(),
                responseDataInformacionCodigosActividad.getChat(),
                responseDataInformacionCodigosActividad.getType_code()
        );
    }




    public List<InformacionCodigosActividad> convertirRespuestaADominio(List<ResponseDataInformacionCodigosActividad> responseDataInformacionCodigosActividads){
        var listaInformacionCodigosActividads = new ArrayList<InformacionCodigosActividad>();

        responseDataInformacionCodigosActividads.forEach(responseDataInformacionCodigosActividad -> {
            listaInformacionCodigosActividads.add(this.crear(responseDataInformacionCodigosActividad));

        });
        return listaInformacionCodigosActividads;
    }

    public List<ResponseDataInformacionCodigosActividad> obtenerDatos(ResponseInformacionCodigosActividad responseInformacionCodigosActividad){

        var listaResponseDataInformacionCodigosActividads= new ArrayList<ResponseDataInformacionCodigosActividad>();

        for (int i = 0; i<= responseInformacionCodigosActividad.getData().length-1; i++){
            var responseDataInformacionCodigosActividad= new ResponseDataInformacionCodigosActividad(
                    responseInformacionCodigosActividad.getData()[i].getCod_act(),
                    responseInformacionCodigosActividad.getData()[i].getDescription_cod_act(),
                    responseInformacionCodigosActividad.getData()[i].getHit(),
                    responseInformacionCodigosActividad.getData()[i].getRpc(),
                    responseInformacionCodigosActividad.getData()[i].getChat(),
                    responseInformacionCodigosActividad.getData()[i].getType_code()
            );
            listaResponseDataInformacionCodigosActividads.add(responseDataInformacionCodigosActividad);
        }
        return listaResponseDataInformacionCodigosActividads;
    }

    public int convertirNumero(String cadena){
        int respuesta=0;
        try {
           respuesta = Integer.valueOf(cadena);
        }catch (Exception e){

        }
        return respuesta;
    }

    public Long convertirLong(String cadena){
        Long respuesta=null;
        try {
            respuesta = Long.valueOf(cadena);
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
}
