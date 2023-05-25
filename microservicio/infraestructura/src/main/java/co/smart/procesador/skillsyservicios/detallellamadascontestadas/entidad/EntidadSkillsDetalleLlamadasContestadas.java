package co.smart.procesador.skillsyservicios.detallellamadascontestadas.entidad;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="detalle_llamadas_contestadas")
public class EntidadSkillsDetalleLlamadasContestadas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_detalle_llamadas_contestadas;
    private String conn_id;
    private String skill_id;
    private String skill_name;
    private LocalDateTime date;
    private String result;
    private String ani;
    private String answer_time;
    private String agent_id;
    private String type_interaction;
    @Column(name = "fecha_carga")
    private LocalDate FECHA;

    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;


    public EntidadSkillsDetalleLlamadasContestadas() {

    }

    public EntidadSkillsDetalleLlamadasContestadas(String conn_id, String skill_id, String skill_name, LocalDateTime date, String result, String ani, String answer_time, String agent_id, String type_interaction, LocalDate FECHA, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
        this.conn_id = conn_id;
        this.skill_id = skill_id;
        this.skill_name = skill_name;
        this.date = date;
        this.result = result;
        this.ani = ani;
        this.answer_time = answer_time;
        this.agent_id = agent_id;
        this.type_interaction = type_interaction;
        this.FECHA = FECHA;
        this.fecha_inicio_carga = fecha_inicio_carga;
        this.fecha_fin_carga = fecha_fin_carga;
    }

    public Long getId_detalle_llamadas_contestadas() {
        return Id_detalle_llamadas_contestadas;
    }

    public void setId_detalle_llamadas_contestadas(Long id_detalle_llamadas_contestadas) {
        Id_detalle_llamadas_contestadas = id_detalle_llamadas_contestadas;
    }

    public String getConn_id() {
        return conn_id;
    }

    public void setConn_id(String conn_id) {
        this.conn_id = conn_id;
    }

    public String getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(String skill_id) {
        this.skill_id = skill_id;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAni() {
        return ani;
    }

    public void setAni(String ani) {
        this.ani = ani;
    }

    public String getAnswer_time() {
        return answer_time;
    }

    public void setAnswer_time(String answer_time) {
        this.answer_time = answer_time;
    }

    public String getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(String agent_id) {
        this.agent_id = agent_id;
    }

    public String getType_interaction() {
        return type_interaction;
    }

    public void setType_interaction(String type_interaction) {
        this.type_interaction = type_interaction;
    }

    public LocalDate getFECHA() {
        return FECHA;
    }

    public void setFECHA(LocalDate FECHA) {
        this.FECHA = FECHA;
    }
}
