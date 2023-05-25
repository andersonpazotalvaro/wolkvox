package co.smart.procesador.diagram.detalleencuestainteligente.comando;

import co.smart.procesador.diagram.detalleencuestainteligente.modelo.respuesta.ResponseDataDetalleEncuestaInteligente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDiagramDetalleEncuestaInteligente {
    private String code;
    private String error;
    private String msg;
    private ResponseDataDetalleEncuestaInteligente[] data;


}
