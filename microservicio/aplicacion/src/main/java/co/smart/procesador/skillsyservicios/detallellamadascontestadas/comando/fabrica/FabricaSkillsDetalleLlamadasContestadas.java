package co.smart.procesador.skillsyservicios.detallellamadascontestadas.comando.fabrica;

import co.smart.procesador.skillsyservicios.detallellamadascontestadas.comando.ResponseSkillsDetallesLlamadasContestadas;
import co.smart.procesador.skillsyservicios.detallellamadascontestadas.modelo.dominio.SkillsDetalleLlamadasContestadas;
import co.smart.procesador.skillsyservicios.detallellamadascontestadas.modelo.respuesta.ResponseDataSkillsDetalleLlamadasContestadas;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class FabricaSkillsDetalleLlamadasContestadas {

    public SkillsDetalleLlamadasContestadas crear(ResponseDataSkillsDetalleLlamadasContestadas responseDataSkillsDetalleLlamadasContestadas, String ini, String fin){

        return new SkillsDetalleLlamadasContestadas(
                responseDataSkillsDetalleLlamadasContestadas.getConn_id(),
                responseDataSkillsDetalleLlamadasContestadas.getSkill_id(),
                responseDataSkillsDetalleLlamadasContestadas.getSkill_name(),
                convertirLocalDateTime(responseDataSkillsDetalleLlamadasContestadas.getDate()),
                responseDataSkillsDetalleLlamadasContestadas.getResult(),
                responseDataSkillsDetalleLlamadasContestadas.getAni(),
                responseDataSkillsDetalleLlamadasContestadas.getAnswer_time(),
                responseDataSkillsDetalleLlamadasContestadas.getAgent_id(),
                responseDataSkillsDetalleLlamadasContestadas.getType_interaction(),
                convertirEntradaALocalDate(ini),
                convertirEntradaALocalDate(fin)
        );
    }




    public List<SkillsDetalleLlamadasContestadas> convertirRespuestaADominio(List<ResponseDataSkillsDetalleLlamadasContestadas> responseDataSkillsDetalleLlamadasContestadas, String ini, String fin){
        var listaSkillsDetalleLlamadasContestadas = new ArrayList<SkillsDetalleLlamadasContestadas>();

        responseDataSkillsDetalleLlamadasContestadas.forEach(responseDataSkillsDetalleLlamadasContestadas1  -> {
            listaSkillsDetalleLlamadasContestadas.add(this.crear(responseDataSkillsDetalleLlamadasContestadas1,ini,fin));

        });
        return listaSkillsDetalleLlamadasContestadas;
    }

    public List<ResponseDataSkillsDetalleLlamadasContestadas> obtenerDatos(ResponseSkillsDetallesLlamadasContestadas responseSkillsDetallesLlamadasContestadas){

        var listaResponseDataSkillsDetalleLlamadasContestadas= new ArrayList<ResponseDataSkillsDetalleLlamadasContestadas>();

        for (int i = 0; i<= responseSkillsDetallesLlamadasContestadas.getData().length-1; i++){
            var responseDataSkillsDetalleLlamadasContestadas= new ResponseDataSkillsDetalleLlamadasContestadas(
                    responseSkillsDetallesLlamadasContestadas.getData()[i].getConn_id(),
                    responseSkillsDetallesLlamadasContestadas.getData()[i].getSkill_id(),
                    responseSkillsDetallesLlamadasContestadas.getData()[i].getSkill_name(),
                    responseSkillsDetallesLlamadasContestadas.getData()[i].getDate(),
                    responseSkillsDetallesLlamadasContestadas.getData()[i].getResult(),
                    responseSkillsDetallesLlamadasContestadas.getData()[i].getAni(),
                    responseSkillsDetallesLlamadasContestadas.getData()[i].getAnswer_time(),
                    responseSkillsDetallesLlamadasContestadas.getData()[i].getAgent_id(),
                    responseSkillsDetallesLlamadasContestadas.getData()[i].getType_interaction()
            );
            listaResponseDataSkillsDetalleLlamadasContestadas.add(responseDataSkillsDetalleLlamadasContestadas);
        }
        return listaResponseDataSkillsDetalleLlamadasContestadas;
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
