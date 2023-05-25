package co.smart.procesador.skillsyservicios.workforceporhora.modelo.respuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDataSkillsWorkforceHora {

    private String skill_id;
    private String hour;
    private String inbound_calls;
    private String inbound_calls_unique_customers;
    private String aht;
    private String agents_needed;


}
