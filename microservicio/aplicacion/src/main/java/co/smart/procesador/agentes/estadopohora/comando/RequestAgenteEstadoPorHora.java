package co.smart.procesador.agentes.estadopohora.comando;


import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
public class RequestAgenteEstadoPorHora {

    private String Token;
    private static String Report= "agent_1";
    private String Date_ini= generarFechaIni();
    private String Date_end= generarFechaFin();


    public String generarFechaIni(){
        LocalDate fechaCompleta= LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedLocalDate = fechaCompleta.format(formatter);
        formattedLocalDate+="000000";
        return formattedLocalDate;
    }

    public String generarFechaFin(){
        LocalDate fechaCompleta= LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedLocalDate = fechaCompleta.format(formatter);
        formattedLocalDate+="235959";
        return formattedLocalDate;
    }

    public RequestAgenteEstadoPorHora(String date_ini, String date_end) {
        Date_ini = date_ini;
        Date_end = date_end;
    }
}
