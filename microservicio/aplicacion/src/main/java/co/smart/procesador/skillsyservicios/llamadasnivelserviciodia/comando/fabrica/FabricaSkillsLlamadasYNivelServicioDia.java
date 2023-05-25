package co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.comando.fabrica;

import co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.comando.ResponseSkillsLlamadasYNivelServicioDia;
import co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.modelo.dominio.SkillsLlamadasYNivelServicioDia;
import co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.modelo.respuesta.ResponseDataSkillsLlamadasYNivelServicioDia;
import co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.modelo.dominio.SkillsLlamadasYNivelTodos;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class FabricaSkillsLlamadasYNivelServicioDia {

    public SkillsLlamadasYNivelServicioDia crear(ResponseDataSkillsLlamadasYNivelServicioDia responseDataSkillsLlamadasYNivelServicioDia, String ini, String fin){

        return new SkillsLlamadasYNivelServicioDia(
                responseDataSkillsLlamadasYNivelServicioDia.getSkill_name(),
                convertirLocalDate(responseDataSkillsLlamadasYNivelServicioDia.getDay()),
                convertirNumero(responseDataSkillsLlamadasYNivelServicioDia.getInbound_calls()),
                convertirNumero(responseDataSkillsLlamadasYNivelServicioDia.getAnswer_calls()),
                convertirNumero(responseDataSkillsLlamadasYNivelServicioDia.getAbandon_calls()),
                responseDataSkillsLlamadasYNivelServicioDia.getService_level_10seg(),
                responseDataSkillsLlamadasYNivelServicioDia.getService_level_20seg(),
                responseDataSkillsLlamadasYNivelServicioDia.getService_level_30seg(),
                responseDataSkillsLlamadasYNivelServicioDia.getWait_time(),
                responseDataSkillsLlamadasYNivelServicioDia.getAbandon(),
                responseDataSkillsLlamadasYNivelServicioDia.getAsa(),
                responseDataSkillsLlamadasYNivelServicioDia.getAta(),
                responseDataSkillsLlamadasYNivelServicioDia.getAht(),
                convertirEntradaALocalDate(ini),
                convertirEntradaALocalDate(fin)

        );
    }




    public List<SkillsLlamadasYNivelServicioDia> convertirRespuestaADominio(List<ResponseDataSkillsLlamadasYNivelServicioDia> responseDataSkillsLlamadasYNivelServicioDia, String ini, String fin){
        var listaSkillsLlamadasYNivelServicioDia = new ArrayList<SkillsLlamadasYNivelServicioDia>();

        responseDataSkillsLlamadasYNivelServicioDia.forEach(responseDataSkillsLlamadasYNivelServicioDia1 -> {
            listaSkillsLlamadasYNivelServicioDia.add(this.crear(responseDataSkillsLlamadasYNivelServicioDia1,ini,fin));

        });
        return listaSkillsLlamadasYNivelServicioDia;
    }

    public List<ResponseDataSkillsLlamadasYNivelServicioDia> obtenerDatos(ResponseSkillsLlamadasYNivelServicioDia responseSkillsLlamadasYNivelServicioDia){

        var listaResponseDataSkillsLlamadasYNivelServicioDia= new ArrayList<ResponseDataSkillsLlamadasYNivelServicioDia>();

        for (int i = 0; i<= responseSkillsLlamadasYNivelServicioDia.getData().length-1; i++){
            var responseDataSkillsLlamadasYNivelServicioDia= new ResponseDataSkillsLlamadasYNivelServicioDia(
                    responseSkillsLlamadasYNivelServicioDia.getData()[i].getSkill_name(),
                    responseSkillsLlamadasYNivelServicioDia.getData()[i].getDay(),
                    responseSkillsLlamadasYNivelServicioDia.getData()[i].getInbound_calls(),
                    responseSkillsLlamadasYNivelServicioDia.getData()[i].getAnswer_calls(),
                    responseSkillsLlamadasYNivelServicioDia.getData()[i].getAbandon_calls(),
                    responseSkillsLlamadasYNivelServicioDia.getData()[i].getService_level_10seg(),
                    responseSkillsLlamadasYNivelServicioDia.getData()[i].getService_level_20seg(),
                    responseSkillsLlamadasYNivelServicioDia.getData()[i].getService_level_30seg(),
                    responseSkillsLlamadasYNivelServicioDia.getData()[i].getWait_time(),
                    responseSkillsLlamadasYNivelServicioDia.getData()[i].getAbandon(),
                    responseSkillsLlamadasYNivelServicioDia.getData()[i].getAsa(),
                    responseSkillsLlamadasYNivelServicioDia.getData()[i].getAta(),
                    responseSkillsLlamadasYNivelServicioDia.getData()[i].getAht()
            );
            listaResponseDataSkillsLlamadasYNivelServicioDia.add(responseDataSkillsLlamadasYNivelServicioDia);
        }
        return listaResponseDataSkillsLlamadasYNivelServicioDia;
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

    public LocalDate convertirLocalDate(String cadena){
        LocalDate respuesta= null;
        try {
            respuesta = LocalDate.parse(cadena);
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
