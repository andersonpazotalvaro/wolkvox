package co.smart.procesador.campañas.resultadomaquinafinal.modelo.dominio;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
public class CampañaResultadoMaquinaFinal {

    private String result;
    private int records;
    private String porcent;
    private LocalDate FECHA= LocalDate.now();
    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;

    public CampañaResultadoMaquinaFinal(String result, int records, String porcent, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
        this.result = result;
        this.records = records;
        this.porcent = porcent;
        this.fecha_inicio_carga = fecha_inicio_carga;
        this.fecha_fin_carga = fecha_fin_carga;
    }
}
