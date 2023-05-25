package co.smart.procesador.diagram.encuestainteligenteporskill.modelo.dominio;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class DiagramEncuestaInteligenteSkill {

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
    private LocalDate FECHA= LocalDate.now();

    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;

    public DiagramEncuestaInteligenteSkill(String agent_id, String agent_name, int surveys, String q01, String q02, String q03, String q04, String q05, String q06, String q07, String q08, String q09, String q10, float average, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
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
        this.fecha_inicio_carga = fecha_inicio_carga;
        this.fecha_fin_carga = fecha_fin_carga;
    }

}
