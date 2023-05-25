package co.smart.procesador.skillsyservicios.workforceporhora.comando;

import co.smart.procesador.skillsyservicios.workforceporhora.modelo.respuesta.ResponseDataSkillsWorkforceHora;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSkillsWorkforceHora {
    private String code;
    private String error;
    private String msg;
    private ResponseDataSkillsWorkforceHora[] data;


}
