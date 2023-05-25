package co.smart.procesador.informacion.skill.modelo.dominio;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
public class InformacionSkills {

    private Long skill_id;
    private String skill_name;
    private String skill_description;
    private  LocalDateTime last_use;
    private LocalDate FECHA= LocalDate.now();

    public InformacionSkills(Long skill_id, String skill_name, String skill_description, LocalDateTime last_use) {
        this.skill_id = skill_id;
        this.skill_name = skill_name;
        this.skill_description = skill_description;
        this.last_use = last_use;
    }
}
