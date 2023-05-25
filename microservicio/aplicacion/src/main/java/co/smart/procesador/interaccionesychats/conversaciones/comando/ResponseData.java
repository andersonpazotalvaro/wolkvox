package co.smart.procesador.interaccionesychats.conversaciones.comando;

import co.smart.procesador.interaccionesychats.conversaciones.modelo.respuesta.ResponseDataInteraccionesConversaciones;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData {
    private String conn_id;
    private String agent_name;
    private String customer_name;
    private ResponseDataInteraccionesConversaciones[] conversation;


}
