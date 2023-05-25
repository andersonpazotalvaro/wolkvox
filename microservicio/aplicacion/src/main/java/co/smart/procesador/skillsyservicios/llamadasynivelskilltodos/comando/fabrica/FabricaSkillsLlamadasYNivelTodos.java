package co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.comando.fabrica;

import co.smart.procesador.diagram.detalleesperainteligente.comando.ResponseDiagramDetalleEsperaInteligente;
import co.smart.procesador.diagram.detalleesperainteligente.modelo.dominio.DiagramDetalleEsperaInteligente;
import co.smart.procesador.diagram.detalleesperainteligente.modelo.respuesta.ResponseDataDetalleEsperaInteligente;
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
public class FabricaSkillsLlamadasYNivelTodos {

    public SkillsLlamadasYNivelTodos crear(ResponseDataSkillsLlamadasYNivelTodos responseDataSkillsLlamadasYNivelTodos, String ini, String fin){

        return new SkillsLlamadasYNivelTodos(
                responseDataSkillsLlamadasYNivelTodos.getSkill_name(),
                responseDataSkillsLlamadasYNivelTodos.getSkill_id(),
                convertirNumero(responseDataSkillsLlamadasYNivelTodos.getInbound_calls()),
                convertirNumero(responseDataSkillsLlamadasYNivelTodos.getAnswer_calls()),
                convertirNumero(responseDataSkillsLlamadasYNivelTodos.getAbandon_calls()),
                responseDataSkillsLlamadasYNivelTodos.getService_level_10seg(),
                responseDataSkillsLlamadasYNivelTodos.getService_level_20seg(),
                responseDataSkillsLlamadasYNivelTodos.getService_level_30seg(),
                responseDataSkillsLlamadasYNivelTodos.getAbandon(),
                responseDataSkillsLlamadasYNivelTodos.getAsa(),
                responseDataSkillsLlamadasYNivelTodos.getAta(),
                convertirEntradaALocalDate(ini),
                convertirEntradaALocalDate(fin)

        );
    }




    public List<SkillsLlamadasYNivelTodos> convertirRespuestaADominio(List<ResponseDataSkillsLlamadasYNivelTodos> responseDataSkillsLlamadasYNivelTodos, String ini, String fin){
        var listaSkillsLlamadasYNivelTodos = new ArrayList<SkillsLlamadasYNivelTodos>();

        responseDataSkillsLlamadasYNivelTodos.forEach(responseDataSkillsLlamadasYNivelTodos1 -> {
            listaSkillsLlamadasYNivelTodos.add(this.crear(responseDataSkillsLlamadasYNivelTodos1,ini,fin));

        });
        return listaSkillsLlamadasYNivelTodos;
    }

    public List<ResponseDataSkillsLlamadasYNivelTodos> obtenerDatos(ResponseSkillsLlamadasYNivelTodos responseSkillsLlamadasYNivelTodos){

        var listaResponseDataSkillsLlamadasYNivelTodos= new ArrayList<ResponseDataSkillsLlamadasYNivelTodos>();
        for (int i = 0; i<= responseSkillsLlamadasYNivelTodos.getData().length-1; i++){
            var responseDataSkillsLlamadasYNivelTodos= new ResponseDataSkillsLlamadasYNivelTodos(
                    responseSkillsLlamadasYNivelTodos.getData()[i].getSkill_name(),
                    responseSkillsLlamadasYNivelTodos.getData()[i].getSkill_id(),
                    responseSkillsLlamadasYNivelTodos.getData()[i].getInbound_calls(),
                    responseSkillsLlamadasYNivelTodos.getData()[i].getAnswer_calls(),
                    responseSkillsLlamadasYNivelTodos.getData()[i].getAbandon_calls(),
                    responseSkillsLlamadasYNivelTodos.getData()[i].getService_level_10seg(),
                    responseSkillsLlamadasYNivelTodos.getData()[i].getService_level_20seg(),
                    responseSkillsLlamadasYNivelTodos.getData()[i].getService_level_30seg(),
                    responseSkillsLlamadasYNivelTodos.getData()[i].getAbandon(),
                    responseSkillsLlamadasYNivelTodos.getData()[i].getAsa(),
                    responseSkillsLlamadasYNivelTodos.getData()[i].getAta()
            );
            listaResponseDataSkillsLlamadasYNivelTodos.add(responseDataSkillsLlamadasYNivelTodos);
        }
        return listaResponseDataSkillsLlamadasYNivelTodos;
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
