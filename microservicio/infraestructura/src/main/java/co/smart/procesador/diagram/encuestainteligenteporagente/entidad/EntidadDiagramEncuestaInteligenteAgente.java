package co.smart.procesador.diagram.encuestainteligenteporagente.entidad;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="diagram_encuesta_inteligente_agente")
public class EntidadDiagramEncuestaInteligenteAgente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_encuesta_inteligente_agente;
    private String agent_id;
    private String agent_name;
    private int surveys;
    private String q01;
    private String q02;
    private String q03;
    private String q04;
    private String q05;
    private String q06;
    private String q07;
    private String q08;
    private String q09;
    private String q10;
    private float average;
    @Column(name = "fecha_carga")
    private LocalDate FECHA;
    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;



    public EntidadDiagramEncuestaInteligenteAgente() {

    }


    public EntidadDiagramEncuestaInteligenteAgente(String agent_id, String agent_name, int surveys, String q01, String q02, String q03, String q04, String q05, String q06, String q07, String q08, String q09, String q10, float average, LocalDate FECHA, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
        this.agent_id = agent_id;
        this.agent_name = agent_name;
        this.surveys = surveys;
        this.q01 = q01;
        this.q02 = q02;
        this.q03 = q03;
        this.q04 = q04;
        this.q05 = q05;
        this.q06 = q06;
        this.q07 = q07;
        this.q08 = q08;
        this.q09 = q09;
        this.q10 = q10;
        this.average = average;
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

    public Long getId_encuesta_inteligente_agente() {
        return Id_encuesta_inteligente_agente;
    }

    public void setId_encuesta_inteligente_agente(Long id_encuesta_inteligente_agente) {
        Id_encuesta_inteligente_agente = id_encuesta_inteligente_agente;
    }

    public String getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(String agent_id) {
        this.agent_id = agent_id;
    }

    public String getAgent_name() {
        return agent_name;
    }

    public void setAgent_name(String agent_name) {
        this.agent_name = agent_name;
    }

    public int getSurveys() {
        return surveys;
    }

    public void setSurveys(int surveys) {
        this.surveys = surveys;
    }

    public String getQ01() {
        return q01;
    }

    public void setQ01(String q01) {
        this.q01 = q01;
    }

    public String getQ02() {
        return q02;
    }

    public void setQ02(String q02) {
        this.q02 = q02;
    }

    public String getQ03() {
        return q03;
    }

    public void setQ03(String q03) {
        this.q03 = q03;
    }

    public String getQ04() {
        return q04;
    }

    public void setQ04(String q04) {
        this.q04 = q04;
    }

    public String getQ05() {
        return q05;
    }

    public void setQ05(String q05) {
        this.q05 = q05;
    }

    public String getQ06() {
        return q06;
    }

    public void setQ06(String q06) {
        this.q06 = q06;
    }

    public String getQ07() {
        return q07;
    }

    public void setQ07(String q07) {
        this.q07 = q07;
    }

    public String getQ08() {
        return q08;
    }

    public void setQ08(String q08) {
        this.q08 = q08;
    }

    public String getQ09() {
        return q09;
    }

    public void setQ09(String q09) {
        this.q09 = q09;
    }

    public String getQ10() {
        return q10;
    }

    public void setQ10(String q10) {
        this.q10 = q10;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public LocalDate getFECHA() {
        return FECHA;
    }

    public void setFECHA(LocalDate FECHA) {
        this.FECHA = FECHA;
    }
}
