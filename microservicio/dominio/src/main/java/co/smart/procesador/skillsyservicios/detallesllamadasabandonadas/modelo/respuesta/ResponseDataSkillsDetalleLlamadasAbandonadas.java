package co.smart.procesador.skillsyservicios.detallesllamadasabandonadas.modelo.respuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDataSkillsDetalleLlamadasAbandonadas {

    private String skill_name;
    private String skill_id;
    private String conn_id;
    private String date;
    private String result;
    private String ani;
    private String abandon_time;
    private String type_interaction;
    private String customer_id;


}
