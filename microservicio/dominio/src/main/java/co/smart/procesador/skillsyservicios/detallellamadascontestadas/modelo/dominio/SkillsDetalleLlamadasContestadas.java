package co.smart.procesador.skillsyservicios.detallellamadascontestadas.modelo.dominio;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class SkillsDetalleLlamadasContestadas {

    private String conn_id;
    private String skill_id;
    private String skill_name;
    private LocalDateTime date;
    private String result;
    private String ani;
    private String answer_time;
    private String agent_id;
    private String type_interaction;
    private LocalDate FECHA= LocalDate.now();
    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;

    public SkillsDetalleLlamadasContestadas(String conn_id, String skill_id, String skill_name, LocalDateTime date, String result, String ani, String answer_time, String agent_id, String type_interaction, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
        this.conn_id = conn_id;
        this.skill_id = skill_id;
        this.skill_name = skill_name;
        this.date = date;
        this.result = result;
        this.ani = ani;
        this.answer_time = answer_time;
        this.agent_id = agent_id;
        this.type_interaction = type_interaction;
        this.fecha_inicio_carga = fecha_inicio_carga;
        this.fecha_fin_carga = fecha_fin_carga;
    }
}
