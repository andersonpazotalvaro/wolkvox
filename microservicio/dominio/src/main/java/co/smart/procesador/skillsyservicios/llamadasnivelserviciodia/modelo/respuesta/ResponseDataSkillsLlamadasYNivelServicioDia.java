package co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.modelo.respuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDataSkillsLlamadasYNivelServicioDia {

    private String skill_name;
    private String day;
    private String inbound_calls;
    private String answer_calls;
    private String abandon_calls;
    private String service_level_10seg;
    private String service_level_20seg;
    private String service_level_30seg;
    private String wait_time;
    private String abandon;
    private String asa;
    private String ata;
    private String aht;


}
