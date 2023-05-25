package co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.modelo.dominio;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class SkillsLlamadasYNivelTodos {

    private String skill_name;
    private String skill_id;
    private int inbound_calls;
    private int answer_calls;
    private int abandon_calls;
    private String service_level_10seg;
    private String service_level_20seg;
    private String service_level_30seg;
    private String abandon;
    private String asa;
    private String ata;
    private LocalDate FECHA= LocalDate.now();
    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;

    public SkillsLlamadasYNivelTodos(String skill_name, String skill_id, int inbound_calls, int answer_calls, int abandon_calls, String service_level_10seg, String service_level_20seg, String service_level_30seg, String abandon, String asa, String ata, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
        this.skill_name = skill_name;
        this.skill_id = skill_id;
        this.inbound_calls = inbound_calls;
        this.answer_calls = answer_calls;
        this.abandon_calls = abandon_calls;
        this.service_level_10seg = service_level_10seg;
        this.service_level_20seg = service_level_20seg;
        this.service_level_30seg = service_level_30seg;
        this.abandon = abandon;
        this.asa = asa;
        this.ata = ata;
        this.fecha_inicio_carga = fecha_inicio_carga;
        this.fecha_fin_carga = fecha_fin_carga;
    }
}
