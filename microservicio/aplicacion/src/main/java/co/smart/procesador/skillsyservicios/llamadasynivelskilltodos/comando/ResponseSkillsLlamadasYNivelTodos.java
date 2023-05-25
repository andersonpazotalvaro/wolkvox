package co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.comando;

import co.smart.procesador.diagram.detalleesperainteligente.modelo.respuesta.ResponseDataDetalleEsperaInteligente;
import co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.modelo.respuesta.ResponseDataSkillsLlamadasYNivelTodos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSkillsLlamadasYNivelTodos {
    private String code;
    private String error;
    private String msg;
    private ResponseDataSkillsLlamadasYNivelTodos[] data;


}
