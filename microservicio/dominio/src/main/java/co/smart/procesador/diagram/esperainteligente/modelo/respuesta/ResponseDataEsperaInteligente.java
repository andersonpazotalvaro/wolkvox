package co.smart.procesador.diagram.esperainteligente.modelo.respuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDataEsperaInteligente {

    private String skill_id;
    private String treatment;
    private String customer_say_no;
    private String customer_say_yes;
    private String recall_fail;
    private String recall_ok;
    private String service_level_up;


}
