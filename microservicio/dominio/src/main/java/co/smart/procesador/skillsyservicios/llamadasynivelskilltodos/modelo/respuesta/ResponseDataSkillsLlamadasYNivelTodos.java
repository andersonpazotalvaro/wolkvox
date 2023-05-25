package co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.modelo.respuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDataSkillsLlamadasYNivelTodos {

    private String skill_name;
    private String skill_id;
    private String inbound_calls;
    private String answer_calls;
    private String abandon_calls;
    private String service_level_10seg;
    private String service_level_20seg;
    private String service_level_30seg;
    private String abandon;
    private String asa;
    private String ata;




}
