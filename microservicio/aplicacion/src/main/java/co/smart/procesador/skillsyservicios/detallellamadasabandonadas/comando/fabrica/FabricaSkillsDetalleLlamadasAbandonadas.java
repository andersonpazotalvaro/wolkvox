package co.smart.procesador.skillsyservicios.detallellamadasabandonadas.comando.fabrica;

import co.smart.procesador.skillsyservicios.detallellamadasabandonadas.comando.ResponseSkillsDetallesLlamadasAbandonadas;
import co.smart.procesador.skillsyservicios.detallesllamadasabandonadas.modelo.dominio.SkillsDetalleLlamadasAbandonadas;
import co.smart.procesador.skillsyservicios.detallesllamadasabandonadas.modelo.respuesta.ResponseDataSkillsDetalleLlamadasAbandonadas;
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
public class FabricaSkillsDetalleLlamadasAbandonadas {

    public SkillsDetalleLlamadasAbandonadas crear(ResponseDataSkillsDetalleLlamadasAbandonadas responseDataSkillsDetalleLlamadasAbandonadas, String ini, String fin){

        return new SkillsDetalleLlamadasAbandonadas(
                responseDataSkillsDetalleLlamadasAbandonadas.getSkill_name(),
                responseDataSkillsDetalleLlamadasAbandonadas.getSkill_id(),
                responseDataSkillsDetalleLlamadasAbandonadas.getConn_id(),
                convertirLocalDateTime(responseDataSkillsDetalleLlamadasAbandonadas.getDate()),
                responseDataSkillsDetalleLlamadasAbandonadas.getResult(),
                responseDataSkillsDetalleLlamadasAbandonadas.getAni(),
                convertirNumero(responseDataSkillsDetalleLlamadasAbandonadas.getAbandon_time()),
                responseDataSkillsDetalleLlamadasAbandonadas.getType_interaction(),
                responseDataSkillsDetalleLlamadasAbandonadas.getCustomer_id(),
                convertirEntradaALocalDate(ini),
                convertirEntradaALocalDate(fin)
        );
    }




    public List<SkillsDetalleLlamadasAbandonadas> convertirRespuestaADominio(List<ResponseDataSkillsDetalleLlamadasAbandonadas> responseDataSkillsDetalleLlamadasAbandonadas, String ini, String fin){
        var listaSkillsDetalleLlamadasAbandonadas = new ArrayList<SkillsDetalleLlamadasAbandonadas>();

        responseDataSkillsDetalleLlamadasAbandonadas.forEach(responseDataSkillsDetalleLlamadasAbandonadas1 -> {
            listaSkillsDetalleLlamadasAbandonadas.add(this.crear(responseDataSkillsDetalleLlamadasAbandonadas1,ini,fin));

        });
        return listaSkillsDetalleLlamadasAbandonadas;
    }

    public List<ResponseDataSkillsDetalleLlamadasAbandonadas> obtenerDatos(ResponseSkillsDetallesLlamadasAbandonadas responseSkillsDetallesLlamadasAbandonadas){

        var listaResponseDataSkillsDetalleLlamadasAbandonadas= new ArrayList<ResponseDataSkillsDetalleLlamadasAbandonadas>();

        for (int i = 0; i<= responseSkillsDetallesLlamadasAbandonadas.getData().length-1; i++){
            var responseDataSkillsDetalleLlamadasAbandonadas= new ResponseDataSkillsDetalleLlamadasAbandonadas(
                    responseSkillsDetallesLlamadasAbandonadas.getData()[i].getSkill_name(),
                    responseSkillsDetallesLlamadasAbandonadas.getData()[i].getSkill_id(),
                    responseSkillsDetallesLlamadasAbandonadas.getData()[i].getConn_id(),
                    responseSkillsDetallesLlamadasAbandonadas.getData()[i].getDate(),
                    responseSkillsDetallesLlamadasAbandonadas.getData()[i].getResult(),
                    responseSkillsDetallesLlamadasAbandonadas.getData()[i].getAni(),
                    responseSkillsDetallesLlamadasAbandonadas.getData()[i].getAbandon_time(),
                    responseSkillsDetallesLlamadasAbandonadas.getData()[i].getType_interaction(),
                    responseSkillsDetallesLlamadasAbandonadas.getData()[i].getCustomer_id()
            );
            listaResponseDataSkillsDetalleLlamadasAbandonadas.add(responseDataSkillsDetalleLlamadasAbandonadas);
        }
        return listaResponseDataSkillsDetalleLlamadasAbandonadas;
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
