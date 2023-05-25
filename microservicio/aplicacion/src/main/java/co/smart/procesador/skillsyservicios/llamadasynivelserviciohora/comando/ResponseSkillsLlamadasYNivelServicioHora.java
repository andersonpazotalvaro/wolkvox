package co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.comando;

import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.modelo.respuesta.ResponseDataSkillsLlamadasYNivelServicioHora;
import co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.modelo.respuesta.ResponseDataSkillsLlamadasYNivelTodos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSkillsLlamadasYNivelServicioHora {
    private String code;
    private String error;
    private String msg;
    private ResponseDataSkillsLlamadasYNivelServicioHora[] data;


}
