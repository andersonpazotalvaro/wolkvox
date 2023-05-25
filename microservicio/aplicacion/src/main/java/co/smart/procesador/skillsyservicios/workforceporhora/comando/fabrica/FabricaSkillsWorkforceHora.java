package co.smart.procesador.skillsyservicios.workforceporhora.comando.fabrica;

import co.smart.procesador.skillsyservicios.workforceporhora.comando.ResponseSkillsWorkforceHora;
import co.smart.procesador.skillsyservicios.workforceporhora.modelo.dominio.SkillsWorkforceHora;
import co.smart.procesador.skillsyservicios.workforceporhora.modelo.respuesta.ResponseDataSkillsWorkforceHora;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class FabricaSkillsWorkforceHora {

    public SkillsWorkforceHora crear(ResponseDataSkillsWorkforceHora responseDataSkillsWorkforceHora, String ini, String fin){

        return new SkillsWorkforceHora(
                responseDataSkillsWorkforceHora.getSkill_id(),
                responseDataSkillsWorkforceHora.getHour(),
                convertirNumero(responseDataSkillsWorkforceHora.getInbound_calls()),
                convertirNumero(responseDataSkillsWorkforceHora.getInbound_calls_unique_customers()),
                convertirLocalTime(responseDataSkillsWorkforceHora.getAht()),
                convertirNumero(responseDataSkillsWorkforceHora.getAgents_needed()),
                convertirEntradaALocalDate(ini),
                convertirEntradaALocalDate(fin)
        );
    }




    public List<SkillsWorkforceHora> convertirRespuestaADominio(List<ResponseDataSkillsWorkforceHora> responseDataSkillsWorkforceHoras, String ini, String fin){
        var listaSkillsWorkforceHoras = new ArrayList<SkillsWorkforceHora>();

        responseDataSkillsWorkforceHoras.forEach(responseDataSkillsWorkforceHora   -> {
            listaSkillsWorkforceHoras.add(this.crear(responseDataSkillsWorkforceHora,ini,fin));

        });
        return listaSkillsWorkforceHoras;
    }

    public List<ResponseDataSkillsWorkforceHora> obtenerDatos(ResponseSkillsWorkforceHora responseSkillsWorkforceHora){

        var listaResponseDataSkillsWorkforceHoras= new ArrayList<ResponseDataSkillsWorkforceHora>();

        for (int i = 0; i<= responseSkillsWorkforceHora.getData().length-1; i++){
            var responseDataSkillsWorkforceHora= new ResponseDataSkillsWorkforceHora(
                    responseSkillsWorkforceHora.getData()[i].getSkill_id(),
                    responseSkillsWorkforceHora.getData()[i].getHour(),
                    responseSkillsWorkforceHora.getData()[i].getInbound_calls(),
                    responseSkillsWorkforceHora.getData()[i].getInbound_calls_unique_customers(),
                    responseSkillsWorkforceHora.getData()[i].getAht(),
                    responseSkillsWorkforceHora.getData()[i].getAgents_needed()
            );
            listaResponseDataSkillsWorkforceHoras.add(responseDataSkillsWorkforceHora);
        }
        return listaResponseDataSkillsWorkforceHoras;
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
