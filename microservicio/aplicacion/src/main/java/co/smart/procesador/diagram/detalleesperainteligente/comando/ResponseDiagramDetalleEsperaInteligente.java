package co.smart.procesador.diagram.detalleesperainteligente.comando;

import co.smart.procesador.diagram.detalleesperainteligente.modelo.respuesta.ResponseDataDetalleEsperaInteligente;
import co.smart.procesador.diagram.esperainteligente.modelo.respuesta.ResponseDataEsperaInteligente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDiagramDetalleEsperaInteligente {
    private String code;
    private String error;
    private String msg;
    private ResponseDataDetalleEsperaInteligente[] data;


}
