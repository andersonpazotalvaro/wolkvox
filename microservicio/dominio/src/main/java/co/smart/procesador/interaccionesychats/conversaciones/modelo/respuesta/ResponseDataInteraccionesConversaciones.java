package co.smart.procesador.interaccionesychats.conversaciones.modelo.respuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDataInteraccionesConversaciones {

    private String chat_id;
    private String channel;
    private String from;
    private String from_name;
    private String to_name;
    private String date;
    private String message;
    private String customer_id;


}
