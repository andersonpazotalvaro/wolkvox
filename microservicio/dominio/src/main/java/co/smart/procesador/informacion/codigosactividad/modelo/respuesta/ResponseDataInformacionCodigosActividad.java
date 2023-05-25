package co.smart.procesador.informacion.codigosactividad.modelo.respuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDataInformacionCodigosActividad {

    private String cod_act;
    private String description_cod_act;
    private String hit;
    private String rpc;
    private String chat;
    private String type_code;


}
