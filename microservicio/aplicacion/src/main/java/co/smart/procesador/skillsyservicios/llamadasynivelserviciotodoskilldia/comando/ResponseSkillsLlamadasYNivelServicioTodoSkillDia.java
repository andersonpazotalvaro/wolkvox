package co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.comando;

import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.modelo.respuesta.ResponseDataSkillsLlamadasYNivelServicioHora;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.modelo.respuesta.ResponseDataSkillsLlamadasYNivelServicioTodoSkillDia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSkillsLlamadasYNivelServicioTodoSkillDia {
    private String code;
    private String error;
    private String msg;
    private ResponseDataSkillsLlamadasYNivelServicioTodoSkillDia[] data;


}
