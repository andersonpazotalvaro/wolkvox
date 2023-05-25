package co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.comando;

import co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.modelo.respuesta.ResponseDataSkillsLlamadasYNivelServicioDia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
public class ResponseSkillsLlamadasYNivelServicioDia {
    private String code;
    private String error;
    private String msg;
    private ResponseDataSkillsLlamadasYNivelServicioDia[] data;


}
