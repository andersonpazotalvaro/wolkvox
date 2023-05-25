package co.smart.procesador.diagram.esperainteligente.comando;

import co.smart.procesador.agentes.estadoporhora.modelo.respuesta.ResponseDataAgenteEstadoPorHora;
import co.smart.procesador.diagram.esperainteligente.modelo.respuesta.ResponseDataEsperaInteligente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDiagramEsperaInteligente {
    private String code;
    private String error;
    private String msg;
    private ResponseDataEsperaInteligente[] data;


}
