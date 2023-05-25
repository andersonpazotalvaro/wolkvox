package co.smart.procesador.diagram.esperainteligente.modelo.dominio;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class DiagramEsperaInteligente {

    private String skill_id;
    private int treatment;
    private int customer_say_no;
    private int customer_say_yes;
    private int recall_fail;
    private int recall_ok;
    private String service_level_up;
    private LocalDate FECHA= LocalDate.now();
    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;

    public DiagramEsperaInteligente(String skill_id, int treatment, int customer_say_no, int customer_say_yes, int recall_fail, int recall_ok, String service_level_up, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
        this.skill_id = skill_id;
        this.treatment = treatment;
        this.customer_say_no = customer_say_no;
        this.customer_say_yes = customer_say_yes;
        this.recall_fail = recall_fail;
        this.recall_ok = recall_ok;
        this.service_level_up = service_level_up;
        this.fecha_inicio_carga = fecha_inicio_carga;
        this.fecha_fin_carga = fecha_fin_carga;
    }
}
