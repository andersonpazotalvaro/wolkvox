package co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.modelo.respuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDataSkillsLlamadasYNivelServicioHora {

    private String skill_id;
    private String hour;
    private String inbound_calls;
    private String answer_calls;
    private String abandon_calls;
    private String service_level_10seg;
    private String service_level_20seg;
    private String service_level_30seg;
    private String abandon;
    private String aht;
    private String ata;






}
