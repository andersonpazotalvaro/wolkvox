package co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.entidad;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="llamadas_y_nivel_servicio_todos")
public class EntidadSkillsLlamadasYNivelTodos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_llamadas_y_nivel_servicio_todos;
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
    @Column(name = "fecha_carga")
    private LocalDate FECHA;

    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;



    public EntidadSkillsLlamadasYNivelTodos() {

    }


    public EntidadSkillsLlamadasYNivelTodos(String skill_name, String skill_id, int inbound_calls, int answer_calls, int abandon_calls, String service_level_10seg, String service_level_20seg, String service_level_30seg, String abandon, String asa, String ata, LocalDate FECHA, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
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
        this.FECHA = FECHA;
        this.fecha_inicio_carga = fecha_inicio_carga;
        this.fecha_fin_carga = fecha_fin_carga;
    }

    public Long getId_llamadas_y_nivel_servicio_todos() {
        return Id_llamadas_y_nivel_servicio_todos;
    }

    public void setId_llamadas_y_nivel_servicio_todos(Long id_llamadas_y_nivel_servicio_todos) {
        Id_llamadas_y_nivel_servicio_todos = id_llamadas_y_nivel_servicio_todos;
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

    public int getInbound_calls() {
        return inbound_calls;
    }

    public void setInbound_calls(int inbound_calls) {
        this.inbound_calls = inbound_calls;
    }

    public int getAnswer_calls() {
        return answer_calls;
    }

    public void setAnswer_calls(int answer_calls) {
        this.answer_calls = answer_calls;
    }

    public int getAbandon_calls() {
        return abandon_calls;
    }

    public void setAbandon_calls(int abandon_calls) {
        this.abandon_calls = abandon_calls;
    }

    public String getService_level_10seg() {
        return service_level_10seg;
    }

    public void setService_level_10seg(String service_level_10seg) {
        this.service_level_10seg = service_level_10seg;
    }

    public String getService_level_20seg() {
        return service_level_20seg;
    }

    public void setService_level_20seg(String service_level_20seg) {
        this.service_level_20seg = service_level_20seg;
    }

    public String getService_level_30seg() {
        return service_level_30seg;
    }

    public void setService_level_30seg(String service_level_30seg) {
        this.service_level_30seg = service_level_30seg;
    }

    public String getAbandon() {
        return abandon;
    }

    public void setAbandon(String abandon) {
        this.abandon = abandon;
    }

    public String getAsa() {
        return asa;
    }

    public void setAsa(String asa) {
        this.asa = asa;
    }

    public String getAta() {
        return ata;
    }

    public void setAta(String ata) {
        this.ata = ata;
    }

    public LocalDate getFECHA() {
        return FECHA;
    }

    public void setFECHA(LocalDate FECHA) {
        this.FECHA = FECHA;
    }
}
