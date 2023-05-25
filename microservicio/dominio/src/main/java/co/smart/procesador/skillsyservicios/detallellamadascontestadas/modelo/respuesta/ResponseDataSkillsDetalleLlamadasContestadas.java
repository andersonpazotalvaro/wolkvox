package co.smart.procesador.skillsyservicios.detallellamadascontestadas.modelo.respuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDataSkillsDetalleLlamadasContestadas {

    private String conn_id;
    private String skill_id;
    private String skill_name;
    private String date;
    private String result;
    private String ani;
    private String answer_time;
    private String agent_id;
    private String type_interaction;


}
