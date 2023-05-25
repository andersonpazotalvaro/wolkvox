package co.smart.procesador.diagram.detalleencuestainteligente.comando.fabrica;

import co.smart.procesador.diagram.detalleencuestainteligente.comando.ResponseDiagramDetalleEncuestaInteligente;
import co.smart.procesador.diagram.detalleencuestainteligente.modelo.dominio.DiagramDetalleEncuestaInteligente;
import co.smart.procesador.diagram.detalleencuestainteligente.modelo.respuesta.ResponseDataDetalleEncuestaInteligente;
import co.smart.procesador.diagram.detalleesperainteligente.comando.ResponseDiagramDetalleEsperaInteligente;
import co.smart.procesador.diagram.detalleesperainteligente.modelo.dominio.DiagramDetalleEsperaInteligente;
import co.smart.procesador.diagram.detalleesperainteligente.modelo.respuesta.ResponseDataDetalleEsperaInteligente;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class FabricaDiagramDetalleEncuestaInteligente {

    public DiagramDetalleEncuestaInteligente crear(ResponseDataDetalleEncuestaInteligente responseDataDetalleEncuestaInteligente, String ini, String fin){

        return new DiagramDetalleEncuestaInteligente(
                responseDataDetalleEncuestaInteligente.getAgent_id(),
                responseDataDetalleEncuestaInteligente.getAgent_name(),
                responseDataDetalleEncuestaInteligente.getAgent_dni(),
                responseDataDetalleEncuestaInteligente.getSkill_id(),
                responseDataDetalleEncuestaInteligente.getSkill_name(),
                convertirLocalDateTime(responseDataDetalleEncuestaInteligente.getDate()),
                responseDataDetalleEncuestaInteligente.getConn_id(),
                responseDataDetalleEncuestaInteligente.getAni(),
                responseDataDetalleEncuestaInteligente.getCustomer_id(),
                responseDataDetalleEncuestaInteligente.getQ01(),
                responseDataDetalleEncuestaInteligente.getQ02(),
                responseDataDetalleEncuestaInteligente.getQ03(),
                responseDataDetalleEncuestaInteligente.getQ04(),
                responseDataDetalleEncuestaInteligente.getQ05(),
                responseDataDetalleEncuestaInteligente.getQ06(),
                responseDataDetalleEncuestaInteligente.getQ07(),
                responseDataDetalleEncuestaInteligente.getQ08(),
                responseDataDetalleEncuestaInteligente.getQ09(),
                responseDataDetalleEncuestaInteligente.getQ10(),
                convertirLocalTime(responseDataDetalleEncuestaInteligente.getVoice_message()),
                responseDataDetalleEncuestaInteligente.getType_interaction(),
                responseDataDetalleEncuestaInteligente.getResult(),
                convertirLocalTime(responseDataDetalleEncuestaInteligente.getTime()),
                responseDataDetalleEncuestaInteligente.getVoice_message(),
                responseDataDetalleEncuestaInteligente.getFeeling(),
                convertirEntradaALocalDate(ini),
                convertirEntradaALocalDate(fin)
        );
    }




    public List<DiagramDetalleEncuestaInteligente> convertirRespuestaADominio(List<ResponseDataDetalleEncuestaInteligente> responseDataDetalleEncuestaInteligentes, String ini, String fin){
        var listaDiagramEncuestaInteligentes = new ArrayList<DiagramDetalleEncuestaInteligente>();

        responseDataDetalleEncuestaInteligentes.forEach(responseDataDetalleEncuestaInteligente -> {
            listaDiagramEncuestaInteligentes.add(this.crear(responseDataDetalleEncuestaInteligente, ini, fin));

        });
        return listaDiagramEncuestaInteligentes;
    }

    public List<ResponseDataDetalleEncuestaInteligente> obtenerDatos(ResponseDiagramDetalleEncuestaInteligente responseDiagramDetalleEncuestaInteligente){

        var listaResponseDataEncuestaInteligentes= new ArrayList<ResponseDataDetalleEncuestaInteligente>();

        for (int i = 0; i<= responseDiagramDetalleEncuestaInteligente.getData().length-1; i++){
            var responseDataEncuestaInteligente= new ResponseDataDetalleEncuestaInteligente(
                    responseDiagramDetalleEncuestaInteligente.getData()[i].getAgent_id(),
                    responseDiagramDetalleEncuestaInteligente.getData()[i].getAgent_name(),
                    responseDiagramDetalleEncuestaInteligente.getData()[i].getAgent_dni(),
                    responseDiagramDetalleEncuestaInteligente.getData()[i].getSkill_id(),
                    responseDiagramDetalleEncuestaInteligente.getData()[i].getSkill_name(),
                    responseDiagramDetalleEncuestaInteligente.getData()[i].getDate(),
                    responseDiagramDetalleEncuestaInteligente.getData()[i].getConn_id(),
                    responseDiagramDetalleEncuestaInteligente.getData()[i].getAni(),
                    responseDiagramDetalleEncuestaInteligente.getData()[i].getCustomer_id(),
                    responseDiagramDetalleEncuestaInteligente.getData()[i].getQ01(),
                    responseDiagramDetalleEncuestaInteligente.getData()[i].getQ02(),
                    responseDiagramDetalleEncuestaInteligente.getData()[i].getQ03(),
                    responseDiagramDetalleEncuestaInteligente.getData()[i].getQ04(),
                    responseDiagramDetalleEncuestaInteligente.getData()[i].getQ05(),
                    responseDiagramDetalleEncuestaInteligente.getData()[i].getQ06(),
                    responseDiagramDetalleEncuestaInteligente.getData()[i].getQ07(),
                    responseDiagramDetalleEncuestaInteligente.getData()[i].getQ08(),
                    responseDiagramDetalleEncuestaInteligente.getData()[i].getQ09(),
                    responseDiagramDetalleEncuestaInteligente.getData()[i].getQ10(),
                    responseDiagramDetalleEncuestaInteligente.getData()[i].getVoice_message_duration(),
                    responseDiagramDetalleEncuestaInteligente.getData()[i].getType_interaction(),
                    responseDiagramDetalleEncuestaInteligente.getData()[i].getResult(),
                    responseDiagramDetalleEncuestaInteligente.getData()[i].getTime(),
                    responseDiagramDetalleEncuestaInteligente.getData()[i].getVoice_message(),
                    responseDiagramDetalleEncuestaInteligente.getData()[i].getFeeling()
            );
            listaResponseDataEncuestaInteligentes.add(responseDataEncuestaInteligente);
        }
        return listaResponseDataEncuestaInteligentes;
    }

    public int convertirNumero(String cadena){
        int respuesta=0;
        try {
           respuesta = Integer.valueOf(cadena);
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
