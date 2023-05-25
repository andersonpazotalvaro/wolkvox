package co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.comando.fabrica;

import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.comando.ResponseSkillsLlamadasYNivelServicioHora;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.modelo.dominio.SkillsLlamadasYNivelServicioHora;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.modelo.respuesta.ResponseDataSkillsLlamadasYNivelServicioHora;
import co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.comando.ResponseSkillsLlamadasYNivelTodos;
import co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.modelo.dominio.SkillsLlamadasYNivelTodos;
import co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.modelo.respuesta.ResponseDataSkillsLlamadasYNivelTodos;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class FabricaSkillsLlamadasYNivelServicioHora {

    public SkillsLlamadasYNivelServicioHora crear(ResponseDataSkillsLlamadasYNivelServicioHora responseDataSkillsLlamadasYNivelServicioHora, String ini, String fin){

        return new SkillsLlamadasYNivelServicioHora(
                responseDataSkillsLlamadasYNivelServicioHora.getSkill_id(),
                responseDataSkillsLlamadasYNivelServicioHora.getHour(),
                convertirNumero(responseDataSkillsLlamadasYNivelServicioHora.getInbound_calls()),
                convertirNumero(responseDataSkillsLlamadasYNivelServicioHora.getAnswer_calls()),
                convertirNumero(responseDataSkillsLlamadasYNivelServicioHora.getAbandon_calls()),
                responseDataSkillsLlamadasYNivelServicioHora.getService_level_10seg(),
                responseDataSkillsLlamadasYNivelServicioHora.getService_level_20seg(),
                responseDataSkillsLlamadasYNivelServicioHora.getService_level_30seg(),
                responseDataSkillsLlamadasYNivelServicioHora.getAbandon(),
                responseDataSkillsLlamadasYNivelServicioHora.getAht(),
                responseDataSkillsLlamadasYNivelServicioHora.getAta(),
                convertirEntradaALocalDate(ini),
                convertirEntradaALocalDate(fin)

        );
    }




    public List<SkillsLlamadasYNivelServicioHora> convertirRespuestaADominio(List<ResponseDataSkillsLlamadasYNivelServicioHora> responseDataSkillsLlamadasYNivelServicioHoras, String ini, String fin){
        var listaSkillsLlamadasYNivelServicioHoras = new ArrayList<SkillsLlamadasYNivelServicioHora>();

        responseDataSkillsLlamadasYNivelServicioHoras.forEach(responseDataSkillsLlamadasYNivelServicioHora -> {
            listaSkillsLlamadasYNivelServicioHoras.add(this.crear(responseDataSkillsLlamadasYNivelServicioHora,ini,fin));

        });
        return listaSkillsLlamadasYNivelServicioHoras;
    }

    public List<ResponseDataSkillsLlamadasYNivelServicioHora> obtenerDatos(ResponseSkillsLlamadasYNivelServicioHora responseSkillsLlamadasYNivelServicioHora){

        var listaResponseDataSkillsLlamadasYNivelServicioHoras= new ArrayList<ResponseDataSkillsLlamadasYNivelServicioHora>();
        for (int i = 0; i<= responseSkillsLlamadasYNivelServicioHora.getData().length-1; i++){
            var responseDataSkillsLlamadasYNivelServicioHora= new ResponseDataSkillsLlamadasYNivelServicioHora(
                    responseSkillsLlamadasYNivelServicioHora.getData()[i].getSkill_id(),
                    responseSkillsLlamadasYNivelServicioHora.getData()[i].getHour(),
                    responseSkillsLlamadasYNivelServicioHora.getData()[i].getInbound_calls(),
                    responseSkillsLlamadasYNivelServicioHora.getData()[i].getAnswer_calls(),
                    responseSkillsLlamadasYNivelServicioHora.getData()[i].getAbandon_calls(),
                    responseSkillsLlamadasYNivelServicioHora.getData()[i].getService_level_10seg(),
                    responseSkillsLlamadasYNivelServicioHora.getData()[i].getService_level_20seg(),
                    responseSkillsLlamadasYNivelServicioHora.getData()[i].getService_level_30seg(),
                    responseSkillsLlamadasYNivelServicioHora.getData()[i].getAbandon(),
                    responseSkillsLlamadasYNivelServicioHora.getData()[i].getAht(),
                    responseSkillsLlamadasYNivelServicioHora.getData()[i].getAta()
            );
            listaResponseDataSkillsLlamadasYNivelServicioHoras.add(responseDataSkillsLlamadasYNivelServicioHora);
        }
        return listaResponseDataSkillsLlamadasYNivelServicioHoras;
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
