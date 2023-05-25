package co.smart.procesador.diagram.encuestainteligenteporskill.comando.fabrica;

import co.smart.procesador.diagram.encuestainteligenteporskill.comando.ResponseDiagramEncuestaInteligenteSkill;
import co.smart.procesador.diagram.encuestainteligenteporskill.modelo.dominio.DiagramEncuestaInteligenteSkill;
import co.smart.procesador.diagram.encuestainteligenteporskill.modelo.respuesta.ResponseDataEncuestaInteligenteSkill;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class FabricaDiagramEncuestaInteligenteSkill {

    public DiagramEncuestaInteligenteSkill crear(ResponseDataEncuestaInteligenteSkill responseDataEncuestaInteligenteSkill, String ini, String fin){

        return new DiagramEncuestaInteligenteSkill(
                responseDataEncuestaInteligenteSkill.getAgent_id(),
                responseDataEncuestaInteligenteSkill.getAgent_name(),
                convertirNumero(responseDataEncuestaInteligenteSkill.getSurveys()),
                responseDataEncuestaInteligenteSkill.getQ01(),
                responseDataEncuestaInteligenteSkill.getQ02(),
                responseDataEncuestaInteligenteSkill.getQ03(),
                responseDataEncuestaInteligenteSkill.getQ04(),
                responseDataEncuestaInteligenteSkill.getQ05(),
                responseDataEncuestaInteligenteSkill.getQ06(),
                responseDataEncuestaInteligenteSkill.getQ07(),
                responseDataEncuestaInteligenteSkill.getQ08(),
                responseDataEncuestaInteligenteSkill.getQ09(),
                responseDataEncuestaInteligenteSkill.getQ10(),
                convertirFloat(responseDataEncuestaInteligenteSkill.getAverage()),
                convertirEntradaALocalDate(ini),
                convertirEntradaALocalDate(fin)
        );
    }




    public List<DiagramEncuestaInteligenteSkill> convertirRespuestaADominio(List<ResponseDataEncuestaInteligenteSkill> responseDataEncuestaInteligenteSkills, String ini, String fin){
        var listaDiagramEncuestaInteligenteSkills = new ArrayList<DiagramEncuestaInteligenteSkill>();

        responseDataEncuestaInteligenteSkills.forEach(responseDataEncuestaInteligenteSkill -> {
            listaDiagramEncuestaInteligenteSkills.add(this.crear(responseDataEncuestaInteligenteSkill, ini, fin));

        });
        return listaDiagramEncuestaInteligenteSkills;
    }

    public List<ResponseDataEncuestaInteligenteSkill> obtenerDatos(ResponseDiagramEncuestaInteligenteSkill responseDiagramEncuestaInteligenteSkill){

        var listaResponseDataEncuestaInteligenteSkills= new ArrayList<ResponseDataEncuestaInteligenteSkill>();

        for (int i = 0; i<= responseDiagramEncuestaInteligenteSkill.getData().length-1; i++){
            var responseDataEncuestaInteligenteSkill= new ResponseDataEncuestaInteligenteSkill(
                    responseDiagramEncuestaInteligenteSkill.getData()[i].getAgent_id(),
                    responseDiagramEncuestaInteligenteSkill.getData()[i].getAgent_name(),
                    responseDiagramEncuestaInteligenteSkill.getData()[i].getSurveys(),
                    responseDiagramEncuestaInteligenteSkill.getData()[i].getQ01(),
                    responseDiagramEncuestaInteligenteSkill.getData()[i].getQ02(),
                    responseDiagramEncuestaInteligenteSkill.getData()[i].getQ03(),
                    responseDiagramEncuestaInteligenteSkill.getData()[i].getQ04(),
                    responseDiagramEncuestaInteligenteSkill.getData()[i].getQ05(),
                    responseDiagramEncuestaInteligenteSkill.getData()[i].getQ06(),
                    responseDiagramEncuestaInteligenteSkill.getData()[i].getQ07(),
                    responseDiagramEncuestaInteligenteSkill.getData()[i].getQ08(),
                    responseDiagramEncuestaInteligenteSkill.getData()[i].getQ09(),
                    responseDiagramEncuestaInteligenteSkill.getData()[i].getQ10(),
                    responseDiagramEncuestaInteligenteSkill.getData()[i].getAverage()
            );
            listaResponseDataEncuestaInteligenteSkills.add(responseDataEncuestaInteligenteSkill);
        }
        return listaResponseDataEncuestaInteligenteSkills;
    }

    public int convertirNumero(String cadena){
        int respuesta=0;
        try {
           respuesta = Integer.valueOf(cadena);
        }catch (Exception e){

        }
        return respuesta;
    }

    public float convertirFloat(String cadena){
        float respuesta=0;
        try {
            respuesta = Float.parseFloat(cadena);
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
