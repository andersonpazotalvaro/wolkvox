package co.smart.procesador.campañas.resultadomaquinafinal.comando.fabrica;

import co.smart.procesador.agentes.estadopohora.comando.ResponseAgenteEstadoPorHora;
import co.smart.procesador.agentes.estadoporhora.modelo.dominio.AgenteEstadoPorHora;
import co.smart.procesador.agentes.estadoporhora.modelo.respuesta.ResponseDataAgenteEstadoPorHora;
import co.smart.procesador.campañas.resultadomaquinafinal.comando.ResponseCampañaResultadoMaquinaFinal;
import co.smart.procesador.campañas.resultadomaquinafinal.modelo.dominio.CampañaResultadoMaquinaFinal;
import co.smart.procesador.campañas.resultadomaquinafinal.modelo.respuesta.ResponseDataResultadoMaquinaFinal;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class FabricaCampañaResultadoMaquinaFinal {

    public CampañaResultadoMaquinaFinal crear(ResponseDataResultadoMaquinaFinal responseDataResultadoMaquinaFinal, String ini, String fin){

        return new CampañaResultadoMaquinaFinal(
                responseDataResultadoMaquinaFinal.getResult(),
                convertirNumero(responseDataResultadoMaquinaFinal.getRecords()),
                responseDataResultadoMaquinaFinal.getPorcent(),
                convertirEntradaALocalDate(ini),
                convertirEntradaALocalDate(fin)
        );
    }




    public List<CampañaResultadoMaquinaFinal> convertirRespuestaADominio(List<ResponseDataResultadoMaquinaFinal> responseDataResultadoMaquinaFinals, String ini, String fin){
        var listaCampañaResultados = new ArrayList<CampañaResultadoMaquinaFinal>();

        responseDataResultadoMaquinaFinals.forEach(responseDataResultadoMaquinaFinal -> {
            listaCampañaResultados.add(this.crear(responseDataResultadoMaquinaFinal,ini ,fin));

        });
        return listaCampañaResultados;
    }

    public List<ResponseDataResultadoMaquinaFinal> obtenerDatos(ResponseCampañaResultadoMaquinaFinal responseCampañaResultadoMaquinaFinal){

        var listaResponseDataCampañaResultado= new ArrayList<ResponseDataResultadoMaquinaFinal>();

        for (int i = 0; i<= responseCampañaResultadoMaquinaFinal.getData().length-1; i++){
            var responseDataCampañaResultado = new ResponseDataResultadoMaquinaFinal(
                    responseCampañaResultadoMaquinaFinal.getData()[i].getResult(),
                    responseCampañaResultadoMaquinaFinal.getData()[i].getRecords(),
                    responseCampañaResultadoMaquinaFinal.getData()[i].getPorcent()
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
