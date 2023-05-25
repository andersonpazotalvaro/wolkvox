package co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.comando.fabrica;

import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.comando.ResponseSkillsLlamadasYNivelServicioHora;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.modelo.dominio.SkillsLlamadasYNivelServicioHora;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.modelo.respuesta.ResponseDataSkillsLlamadasYNivelServicioHora;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.comando.ResponseSkillsLlamadasYNivelServicioTodoSkillDia;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.modelo.dominio.SkillsLlamadasYNivelServicioTodoSkillDia;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.modelo.respuesta.ResponseDataSkillsLlamadasYNivelServicioTodoSkillDia;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class FabricaSkillsLlamadasYNivelServicioTodoSkillDia {

    public SkillsLlamadasYNivelServicioTodoSkillDia crear(ResponseDataSkillsLlamadasYNivelServicioTodoSkillDia responseDataSkillsLlamadasYNivelServicioTodoSkillDia, String ini, String fin){

        return new SkillsLlamadasYNivelServicioTodoSkillDia(
                convertirLocalDate(responseDataSkillsLlamadasYNivelServicioTodoSkillDia.getDate()),
                responseDataSkillsLlamadasYNivelServicioTodoSkillDia.getSkill_id(),
                responseDataSkillsLlamadasYNivelServicioTodoSkillDia.getSkill_name(),
                responseDataSkillsLlamadasYNivelServicioTodoSkillDia.getHour(),
                convertirNumero(responseDataSkillsLlamadasYNivelServicioTodoSkillDia.getInbound_calls()),
                convertirNumero(responseDataSkillsLlamadasYNivelServicioTodoSkillDia.getAnswer_calls()),
                convertirNumero(responseDataSkillsLlamadasYNivelServicioTodoSkillDia.getAbandon_calls()),
                responseDataSkillsLlamadasYNivelServicioTodoSkillDia.getService_level_10seg(),
                responseDataSkillsLlamadasYNivelServicioTodoSkillDia.getService_level_20seg(),
                responseDataSkillsLlamadasYNivelServicioTodoSkillDia.getService_level_30seg(),
                responseDataSkillsLlamadasYNivelServicioTodoSkillDia.getWait_time(),
                responseDataSkillsLlamadasYNivelServicioTodoSkillDia.getAbandon(),
                responseDataSkillsLlamadasYNivelServicioTodoSkillDia.getAht(),
                responseDataSkillsLlamadasYNivelServicioTodoSkillDia.getAsa(),
                responseDataSkillsLlamadasYNivelServicioTodoSkillDia.getAta(),
                convertirEntradaALocalDate(ini),
                convertirEntradaALocalDate(fin)

        );
    }




    public List<SkillsLlamadasYNivelServicioTodoSkillDia> convertirRespuestaADominio(List<ResponseDataSkillsLlamadasYNivelServicioTodoSkillDia> responseDataSkillsLlamadasYNivelServicioTodoSkillDias, String ini, String fin){
        var listaSkillsLlamadasYNivelServicioTodoSkillDias = new ArrayList<SkillsLlamadasYNivelServicioTodoSkillDia>();

        responseDataSkillsLlamadasYNivelServicioTodoSkillDias.forEach(responseDataSkillsLlamadasYNivelServicioTodoSkillDia  -> {
            listaSkillsLlamadasYNivelServicioTodoSkillDias.add(this.crear(responseDataSkillsLlamadasYNivelServicioTodoSkillDia,ini,fin));

        });
        return listaSkillsLlamadasYNivelServicioTodoSkillDias;
    }

    public List<ResponseDataSkillsLlamadasYNivelServicioTodoSkillDia> obtenerDatos(ResponseSkillsLlamadasYNivelServicioTodoSkillDia responseSkillsLlamadasYNivelServicioTodoSkillDia){

        var listaResponseDataSkillsLlamadasYNivelServicioTodoSkillDias= new ArrayList<ResponseDataSkillsLlamadasYNivelServicioTodoSkillDia>();
        for (int i = 0; i<= responseSkillsLlamadasYNivelServicioTodoSkillDia.getData().length-1; i++){
            var responseDataSkillsLlamadasYNivelServicioTodoSkillDia= new ResponseDataSkillsLlamadasYNivelServicioTodoSkillDia(
                    responseSkillsLlamadasYNivelServicioTodoSkillDia.getData()[i].getDate(),
                    responseSkillsLlamadasYNivelServicioTodoSkillDia.getData()[i].getSkill_id(),
                    responseSkillsLlamadasYNivelServicioTodoSkillDia.getData()[i].getSkill_name(),
                    responseSkillsLlamadasYNivelServicioTodoSkillDia.getData()[i].getHour(),
                    responseSkillsLlamadasYNivelServicioTodoSkillDia.getData()[i].getInbound_calls(),
                    responseSkillsLlamadasYNivelServicioTodoSkillDia.getData()[i].getAnswer_calls(),
                    responseSkillsLlamadasYNivelServicioTodoSkillDia.getData()[i].getAbandon_calls(),
                    responseSkillsLlamadasYNivelServicioTodoSkillDia.getData()[i].getService_level_10seg(),
                    responseSkillsLlamadasYNivelServicioTodoSkillDia.getData()[i].getService_level_20seg(),
                    responseSkillsLlamadasYNivelServicioTodoSkillDia.getData()[i].getService_level_30seg(),
                    responseSkillsLlamadasYNivelServicioTodoSkillDia.getData()[i].getWait_time(),
                    responseSkillsLlamadasYNivelServicioTodoSkillDia.getData()[i].getAbandon(),
                    responseSkillsLlamadasYNivelServicioTodoSkillDia.getData()[i].getAht(),
                    responseSkillsLlamadasYNivelServicioTodoSkillDia.getData()[i].getAsa(),
                    responseSkillsLlamadasYNivelServicioTodoSkillDia.getData()[i].getAta()
            );
            listaResponseDataSkillsLlamadasYNivelServicioTodoSkillDias.add(responseDataSkillsLlamadasYNivelServicioTodoSkillDia);
        }
        return listaResponseDataSkillsLlamadasYNivelServicioTodoSkillDias;
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

    public LocalDate convertirLocalDate(String cadena){
        LocalDate respuesta= null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        try {

            respuesta = LocalDate.parse(cadena, formatter);

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
