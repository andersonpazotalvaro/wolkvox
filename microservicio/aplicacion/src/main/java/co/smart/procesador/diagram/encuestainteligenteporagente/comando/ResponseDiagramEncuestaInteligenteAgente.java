package co.smart.procesador.diagram.encuestainteligenteporagente.comando;

import co.smart.procesador.diagram.encuestainteligenteporagente.modelo.respuesta.ResponseDataEncuestaInteligenteAgente;
import co.smart.procesador.diagram.esperainteligente.modelo.respuesta.ResponseDataEsperaInteligente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDiagramEncuestaInteligenteAgente {
    private String code;
    private String error;
    private String msg;
    private ResponseDataEncuestaInteligenteAgente[] data;


}
