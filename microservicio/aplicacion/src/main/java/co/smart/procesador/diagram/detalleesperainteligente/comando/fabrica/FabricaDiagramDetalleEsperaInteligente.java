package co.smart.procesador.diagram.detalleesperainteligente.comando.fabrica;

import co.smart.procesador.diagram.detalleesperainteligente.comando.ResponseDiagramDetalleEsperaInteligente;
import co.smart.procesador.diagram.detalleesperainteligente.modelo.dominio.DiagramDetalleEsperaInteligente;
import co.smart.procesador.diagram.detalleesperainteligente.modelo.respuesta.ResponseDataDetalleEsperaInteligente;
import co.smart.procesador.diagram.esperainteligente.comando.ResponseDiagramEsperaInteligente;
import co.smart.procesador.diagram.esperainteligente.modelo.dominio.DiagramEsperaInteligente;
import co.smart.procesador.diagram.esperainteligente.modelo.respuesta.ResponseDataEsperaInteligente;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class FabricaDiagramDetalleEsperaInteligente {

    public DiagramDetalleEsperaInteligente crear(ResponseDataDetalleEsperaInteligente responseDataDetalleEsperaInteligente, String ini, String fin){

        return new DiagramDetalleEsperaInteligente(
                responseDataDetalleEsperaInteligente.getSkill_id(),
                convertirLocalDateTime(responseDataDetalleEsperaInteligente.getDate_inbound_call()),
                convertirLocalDateTime(responseDataDetalleEsperaInteligente.getDate_last_outbound_call()),
                responseDataDetalleEsperaInteligente.getStatus(),
                convertirNumero(responseDataDetalleEsperaInteligente.getAttempts()),
                responseDataDetalleEsperaInteligente.getAni(),
                responseDataDetalleEsperaInteligente.getDial_phone(),
                convertirLocalTime(responseDataDetalleEsperaInteligente.getTime_between_calls()),
                convertirLocalTime(responseDataDetalleEsperaInteligente.getTime()),
                convertirLocalTime(responseDataDetalleEsperaInteligente.getBilled_minutes()),
                responseDataDetalleEsperaInteligente.getCustomer_id(),
                convertirEntradaALocalDate(ini),
                convertirEntradaALocalDate(fin)
        );
    }




    public List<DiagramDetalleEsperaInteligente> convertirRespuestaADominio(List<ResponseDataDetalleEsperaInteligente> responseDataDetalleEsperaInteligentes, String ini, String fin){
        var listaDiagramEsperaInteligentes = new ArrayList<DiagramDetalleEsperaInteligente>();

        responseDataDetalleEsperaInteligentes.forEach(responseDataDetalleEsperaInteligente -> {
            listaDiagramEsperaInteligentes.add(this.crear(responseDataDetalleEsperaInteligente, ini, fin));

        });
        return listaDiagramEsperaInteligentes;
    }

    public List<ResponseDataDetalleEsperaInteligente> obtenerDatos(ResponseDiagramDetalleEsperaInteligente responseDiagramDetalleEsperaInteligente){

        var listaResponseDataEsperaInteligentes= new ArrayList<ResponseDataDetalleEsperaInteligente>();

        for (int i = 0; i<= responseDiagramDetalleEsperaInteligente.getData().length-1; i++){
            var responseDataEsperaInteligente= new ResponseDataDetalleEsperaInteligente(
                    responseDiagramDetalleEsperaInteligente.getData()[i].getSkill_id(),
                    responseDiagramDetalleEsperaInteligente.getData()[i].getDate_inbound_call(),
                    responseDiagramDetalleEsperaInteligente.getData()[i].getDate_last_outbound_call(),
                    responseDiagramDetalleEsperaInteligente.getData()[i].getStatus(),
                    responseDiagramDetalleEsperaInteligente.getData()[i].getAttempts(),
                    responseDiagramDetalleEsperaInteligente.getData()[i].getAni(),
                    responseDiagramDetalleEsperaInteligente.getData()[i].getDial_phone(),
                    responseDiagramDetalleEsperaInteligente.getData()[i].getTime_between_calls(),
                    responseDiagramDetalleEsperaInteligente.getData()[i].getTime(),
                    responseDiagramDetalleEsperaInteligente.getData()[i].getBilled_minutes(),
                    responseDiagramDetalleEsperaInteligente.getData()[i].getCustomer_id()
            );
            listaResponseDataEsperaInteligentes.add(responseDataEsperaInteligente);
        }
        return listaResponseDataEsperaInteligentes;
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
