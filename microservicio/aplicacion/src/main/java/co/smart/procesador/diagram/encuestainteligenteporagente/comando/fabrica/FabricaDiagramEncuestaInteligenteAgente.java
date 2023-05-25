package co.smart.procesador.diagram.encuestainteligenteporagente.comando.fabrica;

import co.smart.procesador.diagram.encuestainteligenteporagente.comando.ResponseDiagramEncuestaInteligenteAgente;
import co.smart.procesador.diagram.encuestainteligenteporagente.modelo.dominio.DiagramEncuestaInteligenteAgente;
import co.smart.procesador.diagram.encuestainteligenteporagente.modelo.respuesta.ResponseDataEncuestaInteligenteAgente;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class FabricaDiagramEncuestaInteligenteAgente {

    public DiagramEncuestaInteligenteAgente crear(ResponseDataEncuestaInteligenteAgente responseDataEncuestaInteligenteAgente, String ini, String fin){

        return new DiagramEncuestaInteligenteAgente(
                responseDataEncuestaInteligenteAgente.getAgent_id(),
                responseDataEncuestaInteligenteAgente.getAgent_name(),
                convertirNumero(responseDataEncuestaInteligenteAgente.getSurveys()),
                responseDataEncuestaInteligenteAgente.getQ01(),
                responseDataEncuestaInteligenteAgente.getQ02(),
                responseDataEncuestaInteligenteAgente.getQ03(),
                responseDataEncuestaInteligenteAgente.getQ04(),
                responseDataEncuestaInteligenteAgente.getQ05(),
                responseDataEncuestaInteligenteAgente.getQ06(),
                responseDataEncuestaInteligenteAgente.getQ07(),
                responseDataEncuestaInteligenteAgente.getQ08(),
                responseDataEncuestaInteligenteAgente.getQ09(),
                responseDataEncuestaInteligenteAgente.getQ10(),
                convertirFloat(responseDataEncuestaInteligenteAgente.getAverage()),
                convertirEntradaALocalDate(ini),
                convertirEntradaALocalDate(fin)
        );
    }




    public List<DiagramEncuestaInteligenteAgente> convertirRespuestaADominio(List<ResponseDataEncuestaInteligenteAgente> responseDataEncuestaInteligenteAgentes, String ini, String fin){
        var listaDiagramEncuestaInteligenteAgentes = new ArrayList<DiagramEncuestaInteligenteAgente>();

        responseDataEncuestaInteligenteAgentes.forEach(responseDataEncuestaInteligenteAgente -> {
            listaDiagramEncuestaInteligenteAgentes.add(this.crear(responseDataEncuestaInteligenteAgente, ini, fin));

        });
        return listaDiagramEncuestaInteligenteAgentes;
    }

    public List<ResponseDataEncuestaInteligenteAgente> obtenerDatos(ResponseDiagramEncuestaInteligenteAgente responseDiagramEncuestaInteligenteAgente){

        var listaResponseDataEncuestaInteligenteAgentes= new ArrayList<ResponseDataEncuestaInteligenteAgente>();

        for (int i = 0; i<= responseDiagramEncuestaInteligenteAgente.getData().length-1; i++){
            var responseDataEncuestaInteligenteAgente= new ResponseDataEncuestaInteligenteAgente(
                    responseDiagramEncuestaInteligenteAgente.getData()[i].getAgent_id(),
                    responseDiagramEncuestaInteligenteAgente.getData()[i].getAgent_name(),
                    responseDiagramEncuestaInteligenteAgente.getData()[i].getSurveys(),
                    responseDiagramEncuestaInteligenteAgente.getData()[i].getQ01(),
                    responseDiagramEncuestaInteligenteAgente.getData()[i].getQ02(),
                    responseDiagramEncuestaInteligenteAgente.getData()[i].getQ03(),
                    responseDiagramEncuestaInteligenteAgente.getData()[i].getQ04(),
                    responseDiagramEncuestaInteligenteAgente.getData()[i].getQ05(),
                    responseDiagramEncuestaInteligenteAgente.getData()[i].getQ06(),
                    responseDiagramEncuestaInteligenteAgente.getData()[i].getQ07(),
                    responseDiagramEncuestaInteligenteAgente.getData()[i].getQ08(),
                    responseDiagramEncuestaInteligenteAgente.getData()[i].getQ09(),
                    responseDiagramEncuestaInteligenteAgente.getData()[i].getQ10(),
                    responseDiagramEncuestaInteligenteAgente.getData()[i].getAverage()
            );
            listaResponseDataEncuestaInteligenteAgentes.add(responseDataEncuestaInteligenteAgente);
        }
        return listaResponseDataEncuestaInteligenteAgentes;
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
