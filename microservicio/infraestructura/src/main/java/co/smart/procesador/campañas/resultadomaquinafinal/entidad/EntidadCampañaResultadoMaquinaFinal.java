package co.smart.procesador.campañas.resultadomaquinafinal.entidad;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="campaña_resultado_maquina_final")
public class EntidadCampañaResultadoMaquinaFinal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id_resultado_maquina_final;
    private String result;
    private int records;
    private String porcent;
    @Column(name = "fecha_carga")
    private LocalDate FECHA;
    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;



    public EntidadCampañaResultadoMaquinaFinal() {

    }

    public EntidadCampañaResultadoMaquinaFinal(String result, int records, String porcent, LocalDate FECHA, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
        this.result = result;
        this.records = records;
        this.porcent = porcent;
        this.FECHA = FECHA;
        this.fecha_inicio_carga = fecha_inicio_carga;
        this.fecha_fin_carga = fecha_fin_carga;
    }

    public LocalDate getFecha_inicio_carga() {
        return fecha_inicio_carga;
    }

    public void setFecha_inicio_carga(LocalDate fecha_inicio_carga) {
        this.fecha_inicio_carga = fecha_inicio_carga;
    }

    public LocalDate getFecha_fin_carga() {
        return fecha_fin_carga;
    }

    public void setFecha_fin_carga(LocalDate fecha_fin_carga) {
        this.fecha_fin_carga = fecha_fin_carga;
    }

    public Long getId_resultado_maquina_final() {
        return Id_resultado_maquina_final;
    }

    public void setId_resultado_maquina_final(Long id_resultado_maquina_final) {
        Id_resultado_maquina_final = id_resultado_maquina_final;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
    }

    public String getPorcent() {
        return porcent;
    }

    public void setPorcent(String porcent) {
        this.porcent = porcent;
    }

    public LocalDate getFECHA() {
        return FECHA;
    }

    public void setFECHA(LocalDate FECHA) {
        this.FECHA = FECHA;
    }
}
