package co.smart.procesador.campañas.resultadotelefonoatelefono.comando.fabrica;

import co.smart.procesador.campañas.resultadomaquinafinal.comando.ResponseCampañaResultadoMaquinaFinal;
import co.smart.procesador.campañas.resultadomaquinafinal.modelo.dominio.CampañaResultadoMaquinaFinal;
import co.smart.procesador.campañas.resultadomaquinafinal.modelo.respuesta.ResponseDataResultadoMaquinaFinal;
import co.smart.procesador.campañas.resultadotelefonoatelefono.comando.ResponseCampañaResultadoTelefonoATelefono;
import co.smart.procesador.campañas.resultadotelefonoatelefono.modelo.dominio.CampañaResultadoTelefonoATelefono;
import co.smart.procesador.campañas.resultadotelefonoatelefono.modelo.respuesta.ResponseDataResultadoTelefonoATelefono;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class FabricaCampañaResultadoTelefonoATelefono {

    public CampañaResultadoTelefonoATelefono crear(ResponseDataResultadoTelefonoATelefono responseDataResultadoTelefonoATelefono, String ini, String fin){

        return new CampañaResultadoTelefonoATelefono(
                responseDataResultadoTelefonoATelefono.getCampaign_id(),
                responseDataResultadoTelefonoATelefono.getCustomer_name(),
                responseDataResultadoTelefonoATelefono.getCustomer_last_name(),
                convertirNumero(responseDataResultadoTelefonoATelefono.getCustomer_id()),
                convertirLocalDateTime(responseDataResultadoTelefonoATelefono.getDate()),
                responseDataResultadoTelefonoATelefono.getTelephone(),
                responseDataResultadoTelefonoATelefono.getResult(),
                responseDataResultadoTelefonoATelefono.getOpt1(),
                responseDataResultadoTelefonoATelefono.getOpt2(),
                responseDataResultadoTelefonoATelefono.getOpt3(),
                responseDataResultadoTelefonoATelefono.getOpt4(),
                responseDataResultadoTelefonoATelefono.getOpt5(),
                responseDataResultadoTelefonoATelefono.getOpt6(),
                responseDataResultadoTelefonoATelefono.getOpt7(),
                responseDataResultadoTelefonoATelefono.getOpt8(),
                responseDataResultadoTelefonoATelefono.getOpt9(),
                responseDataResultadoTelefonoATelefono.getOpt10(),
                responseDataResultadoTelefonoATelefono.getOpt11(),
                responseDataResultadoTelefonoATelefono.getOpt12(),
                responseDataResultadoTelefonoATelefono.getConn_id(),
                responseDataResultadoTelefonoATelefono.getId_type(),
                convertirEntradaALocalDate(ini),
                convertirEntradaALocalDate(fin)
        );
    }




    public List<CampañaResultadoTelefonoATelefono> convertirRespuestaADominio(List<ResponseDataResultadoTelefonoATelefono> responseDataResultadoTelefonoATelefonos, String ini, String fin){
        var listaCampañaResultados = new ArrayList<CampañaResultadoTelefonoATelefono>();

        responseDataResultadoTelefonoATelefonos.forEach(responseDataResultadoTelefonoATelefono -> {
            listaCampañaResultados.add(this.crear(responseDataResultadoTelefonoATelefono, ini, fin));

        });
        return listaCampañaResultados;
    }

    public List<ResponseDataResultadoTelefonoATelefono> obtenerDatos(ResponseCampañaResultadoTelefonoATelefono responseCampañaResultadoTelefonoATelefono){

        var listaResponseDataCampañaResultado= new ArrayList<ResponseDataResultadoTelefonoATelefono>();

        for (int i = 0; i<= responseCampañaResultadoTelefonoATelefono.getData().length-1; i++){
            var responseDataCampañaResultado = new ResponseDataResultadoTelefonoATelefono(
                    responseCampañaResultadoTelefonoATelefono.getData()[i].getCampaign_id(),
                    responseCampañaResultadoTelefonoATelefono.getData()[i].getCustomer_name(),
                    responseCampañaResultadoTelefonoATelefono.getData()[i].getCustomer_last_name(),
                    responseCampañaResultadoTelefonoATelefono.getData()[i].getCustomer_id(),
                    responseCampañaResultadoTelefonoATelefono.getData()[i].getDate(),
                    responseCampañaResultadoTelefonoATelefono.getData()[i].getTelephone(),
                    responseCampañaResultadoTelefonoATelefono.getData()[i].getResult(),
                    responseCampañaResultadoTelefonoATelefono.getData()[i].getOpt1(),
                    responseCampañaResultadoTelefonoATelefono.getData()[i].getOpt2(),
                    responseCampañaResultadoTelefonoATelefono.getData()[i].getOpt3(),
                    responseCampañaResultadoTelefonoATelefono.getData()[i].getOpt4(),
                    responseCampañaResultadoTelefonoATelefono.getData()[i].getOpt5(),
                    responseCampañaResultadoTelefonoATelefono.getData()[i].getOpt6(),
                    responseCampañaResultadoTelefonoATelefono.getData()[i].getOpt7(),
                    responseCampañaResultadoTelefonoATelefono.getData()[i].getOpt8(),
                    responseCampañaResultadoTelefonoATelefono.getData()[i].getOpt9(),
                    responseCampañaResultadoTelefonoATelefono.getData()[i].getOpt10(),
                    responseCampañaResultadoTelefonoATelefono.getData()[i].getOpt11(),
                    responseCampañaResultadoTelefonoATelefono.getData()[i].getOpt12(),
                    responseCampañaResultadoTelefonoATelefono.getData()[i].getConn_id(),
                    responseCampañaResultadoTelefonoATelefono.getData()[i].getId_type()
            );
            listaResponseDataCampañaResultado.add(responseDataCampañaResultado);
        }
        return listaResponseDataCampañaResultado;
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
