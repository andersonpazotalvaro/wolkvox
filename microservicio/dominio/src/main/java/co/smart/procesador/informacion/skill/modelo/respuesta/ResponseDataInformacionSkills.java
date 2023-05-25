package co.smart.procesador.informacion.skill.modelo.respuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDataInformacionSkills {

    private String skill_id;
    private String skill_name;
    private String skill_description;
    private String last_use;


}
