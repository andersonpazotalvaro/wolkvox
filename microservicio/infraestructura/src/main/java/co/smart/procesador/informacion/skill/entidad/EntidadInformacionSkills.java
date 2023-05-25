package co.smart.procesador.informacion.skill.entidad;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name="informacion_skills")
public class EntidadInformacionSkills {

    @Id
    private Long skill_id;
    private String skill_name;
    private String skill_description;
    private  LocalDateTime last_use;
    @Column(name = "fecha_carga")
    private LocalDate FECHA;


    public EntidadInformacionSkills() {

    }

    public EntidadInformacionSkills(Long skill_id, String skill_name, String skill_description, LocalDateTime last_use, LocalDate FECHA) {
        this.skill_id = skill_id;
        this.skill_name = skill_name;
        this.skill_description = skill_description;
        this.last_use = last_use;
        this.FECHA = FECHA;
    }

    public Long getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(Long skill_id) {
        this.skill_id = skill_id;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    public String getSkill_description() {
        return skill_description;
    }

    public void setSkill_description(String skill_description) {
        this.skill_description = skill_description;
    }

    public LocalDateTime getLast_use() {
        return last_use;
    }

    public void setLast_use(LocalDateTime last_use) {
        this.last_use = last_use;
    }

    public LocalDate getFECHA() {
        return FECHA;
    }

    public void setFECHA(LocalDate FECHA) {
        this.FECHA = FECHA;
    }
}
