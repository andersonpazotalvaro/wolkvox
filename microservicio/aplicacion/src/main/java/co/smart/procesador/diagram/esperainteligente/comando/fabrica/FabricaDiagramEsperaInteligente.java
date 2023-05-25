package co.smart.procesador.diagram.esperainteligente.comando.fabrica;

import co.smart.procesador.agentes.estadopohora.comando.ResponseAgenteEstadoPorHora;
import co.smart.procesador.agentes.estadoporhora.modelo.dominio.AgenteEstadoPorHora;
import co.smart.procesador.agentes.estadoporhora.modelo.respuesta.ResponseDataAgenteEstadoPorHora;
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
public class FabricaDiagramEsperaInteligente {

    public DiagramEsperaInteligente crear(ResponseDataEsperaInteligente responseDataEsperaInteligente, String ini, String fin){

        return new DiagramEsperaInteligente(
                responseDataEsperaInteligente.getSkill_id(),
                convertirNumero(responseDataEsperaInteligente.getTreatment()),
                convertirNumero(responseDataEsperaInteligente.getCustomer_say_no()),
                convertirNumero(responseDataEsperaInteligente.getCustomer_say_yes()),
                convertirNumero(responseDataEsperaInteligente.getRecall_fail()),
                convertirNumero(responseDataEsperaInteligente.getRecall_ok()),
                responseDataEsperaInteligente.getService_level_up(),
                convertirEntradaALocalDate(ini),
                convertirEntradaALocalDate(fin)
        );
    }




    public List<DiagramEsperaInteligente> convertirRespuestaADominio(List<ResponseDataEsperaInteligente> responseDataEsperaInteligentes, String ini, String fin){
        var listaDiagramEsperaInteligentes = new ArrayList<DiagramEsperaInteligente>();

        responseDataEsperaInteligentes.forEach(responseDataEsperaInteligente -> {
            listaDiagramEsperaInteligentes.add(this.crear(responseDataEsperaInteligente, ini, fin));

        });
        return listaDiagramEsperaInteligentes;
    }

    public List<ResponseDataEsperaInteligente> obtenerDatos(ResponseDiagramEsperaInteligente responseDiagramEsperaInteligente){

        var listaResponseDataEsperaInteligentes= new ArrayList<ResponseDataEsperaInteligente>();

        for (int i = 0; i<= responseDiagramEsperaInteligente.getData().length-1; i++){
            var responseDataEsperaInteligente= new ResponseDataEsperaInteligente(
                    responseDiagramEsperaInteligente.getData()[i].getSkill_id(),
                    responseDiagramEsperaInteligente.getData()[i].getTreatment(),
                    responseDiagramEsperaInteligente.getData()[i].getCustomer_say_no(),
                    responseDiagramEsperaInteligente.getData()[i].getCustomer_say_yes(),
                    responseDiagramEsperaInteligente.getData()[i].getRecall_fail(),
                    responseDiagramEsperaInteligente.getData()[i].getRecall_ok(),
                    responseDiagramEsperaInteligente.getData()[i].getService_level_up()
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
