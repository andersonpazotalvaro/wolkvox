package co.smart.procesador.datos.servicio;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ServicioGenerarFechasDiarias {

    public String generarFechaIni(){
        LocalDate fechaCompleta= LocalDate.now();
        LocalDate ayer = fechaCompleta.minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedLocalDate = ayer.format(formatter);
        formattedLocalDate+="000000";
        return formattedLocalDate;
    }

    public String generarFechaFin(){
        LocalDate fechaCompleta= LocalDate.now();
        LocalDate ayer = fechaCompleta.minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedLocalDate = ayer.format(formatter);
        formattedLocalDate+="235959";
        return formattedLocalDate;
    }


}
