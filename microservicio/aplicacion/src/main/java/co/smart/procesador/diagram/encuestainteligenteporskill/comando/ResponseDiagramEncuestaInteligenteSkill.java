package co.smart.procesador.diagram.encuestainteligenteporskill.comando;

import co.smart.procesador.diagram.encuestainteligenteporskill.modelo.respuesta.ResponseDataEncuestaInteligenteSkill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDiagramEncuestaInteligenteSkill {
    private String code;
    private String error;
    private String msg;
    private ResponseDataEncuestaInteligenteSkill[] data;


}
