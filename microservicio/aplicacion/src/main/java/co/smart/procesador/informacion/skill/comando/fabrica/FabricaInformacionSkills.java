package co.smart.procesador.informacion.skill.comando.fabrica;

import co.smart.procesador.informacion.skill.comando.ResponseInformacionSkills;
import co.smart.procesador.informacion.skill.modelo.dominio.InformacionSkills;
import co.smart.procesador.informacion.skill.modelo.respuesta.ResponseDataInformacionSkills;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class FabricaInformacionSkills {

    public InformacionSkills crear(ResponseDataInformacionSkills responseDataInformacionSkills){

        return new InformacionSkills(
                convertirLong(responseDataInformacionSkills.getSkill_id()),
                responseDataInformacionSkills.getSkill_name(),
                responseDataInformacionSkills.getSkill_description(),
                convertirLocalDateTime(responseDataInformacionSkills.getLast_use())

        );
    }




    public List<InformacionSkills> convertirRespuestaADominio(List<ResponseDataInformacionSkills> responseDataInformacionSkills){
        var listaInformacionSkills = new ArrayList<InformacionSkills>();

        responseDataInformacionSkills.forEach(responseDataInformacionSkills1 -> {
            listaInformacionSkills.add(this.crear(responseDataInformacionSkills1));

        });
        return listaInformacionSkills;
    }

    public List<ResponseDataInformacionSkills> obtenerDatos(ResponseInformacionSkills responseInformacionSkills){

        var listaResponseDataInformacionSkills= new ArrayList<ResponseDataInformacionSkills>();

        for (int i = 0; i<= responseInformacionSkills.getData().length-1; i++){
            var responseDataInformacionSkills= new ResponseDataInformacionSkills(
                    responseInformacionSkills.getData()[i].getSkill_id(),
                    responseInformacionSkills.getData()[i].getSkill_name(),
                    responseInformacionSkills.getData()[i].getSkill_description(),
                    responseInformacionSkills.getData()[i].getLast_use()
            );
            listaResponseDataInformacionSkills.add(responseDataInformacionSkills);
        }
        return listaResponseDataInformacionSkills;
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
