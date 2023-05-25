package co.smart.procesador.skillsyservicios.detallellamadasabandonadas.entidad;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="detalle_llamadas_abandonadas")
public class EntidadSkillsDetalleLlamadasAbandonadas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_detalle_llamadas_abandonadas;
    private String skill_name;
    private String skill_id;
    private String conn_id;
    private LocalDateTime date;
    private String result;
    private String ani;
    private int abandon_time;
    private String type_interaction;
    private String customer_id;
    @Column(name = "fecha_carga")
    private LocalDate FECHA;

    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;



    public EntidadSkillsDetalleLlamadasAbandonadas() {

    }


    public EntidadSkillsDetalleLlamadasAbandonadas(String skill_name, String skill_id, String conn_id, LocalDateTime date, String result, String ani, int abandon_time, String type_interaction, String customer_id, LocalDate FECHA, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
        this.skill_name = skill_name;
        this.skill_id = skill_id;
        this.conn_id = conn_id;
        this.date = date;
        this.result = result;
        this.ani = ani;
        this.abandon_time = abandon_time;
        this.type_interaction = type_interaction;
        this.customer_id = customer_id;
        this.FECHA = FECHA;
        this.fecha_inicio_carga = fecha_inicio_carga;
        this.fecha_fin_carga = fecha_fin_carga;
    }

    public Long getId_detalle_llamadas_abandonadas() {
        return Id_detalle_llamadas_abandonadas;
    }

    public void setId_detalle_llamadas_abandonadas(Long id_detalle_llamadas_abandonadas) {
        Id_detalle_llamadas_abandonadas = id_detalle_llamadas_abandonadas;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    public String getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(String skill_id) {
        this.skill_id = skill_id;
    }

    public String getConn_id() {
        return conn_id;
    }

    public void setConn_id(String conn_id) {
        this.conn_id = conn_id;
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

    public int getAbandon_time() {
        return abandon_time;
    }

    public void setAbandon_time(int abandon_time) {
        this.abandon_time = abandon_time;
    }

    public String getType_interaction() {
        return type_interaction;
    }

    public void setType_interaction(String type_interaction) {
        this.type_interaction = type_interaction;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public LocalDate getFECHA() {
        return FECHA;
    }

    public void setFECHA(LocalDate FECHA) {
        this.FECHA = FECHA;
    }
}
