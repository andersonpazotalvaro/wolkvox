package co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.modelo.respuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDataSkillsLlamadasYNivelServicioTodoSkillDia {

    private String date;
    private String skill_id;
    private String skill_name;
    private String hour;
    private String inbound_calls;
    private String answer_calls;
    private String abandon_calls;
    private String service_level_10seg;
    private String service_level_20seg;
    private String service_level_30seg;
    private String wait_time;
    private String abandon;
    private String aht;
    private String asa;
    private String ata;






}
