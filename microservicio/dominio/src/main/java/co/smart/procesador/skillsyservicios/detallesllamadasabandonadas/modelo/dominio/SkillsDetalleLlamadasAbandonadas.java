package co.smart.procesador.skillsyservicios.detallesllamadasabandonadas.modelo.dominio;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class SkillsDetalleLlamadasAbandonadas {

    private String skill_name;
    private String skill_id;
    private String conn_id;
    private LocalDateTime date;
    private String result;
    private String ani;
    private int abandon_time;
    private String type_interaction;
    private String customer_id;
    private LocalDate FECHA= LocalDate.now();
    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;

    public SkillsDetalleLlamadasAbandonadas(String skill_name, String skill_id, String conn_id, LocalDateTime date, String result, String ani, int abandon_time, String type_interaction, String customer_id, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
        this.skill_name = skill_name;
        this.skill_id = skill_id;
        this.conn_id = conn_id;
        this.date = date;
        this.result = result;
        this.ani = ani;
        this.abandon_time = abandon_time;
        this.type_interaction = type_interaction;
        this.customer_id = customer_id;
        this.fecha_inicio_carga = fecha_inicio_carga;
        this.fecha_fin_carga = fecha_fin_carga;
    }
}
