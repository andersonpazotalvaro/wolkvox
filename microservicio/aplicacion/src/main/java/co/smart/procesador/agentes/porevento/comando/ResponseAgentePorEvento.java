package co.smart.procesador.agentes.porevento.comando;

import co.smart.procesador.agentes.porevento.modelo.respuesta.ResponseDataAgentePorEvento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseAgentePorEvento {
    private String code;
    private String error;
    private String msg;
    private ResponseDataAgentePorEvento[] data;


}
