package co.smart.procesador.diagram.encuestainteligenteporskill.comando;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
public class RequestDiagramEncuestaInteligenteSkill {

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

    public RequestDiagramEncuestaInteligenteSkill(String date_ini, String date_end) {
        Date_ini = date_ini;
        Date_end = date_end;
    }
}
