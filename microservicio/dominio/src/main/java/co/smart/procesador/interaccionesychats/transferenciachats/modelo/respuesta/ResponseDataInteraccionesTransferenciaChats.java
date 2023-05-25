package co.smart.procesador.interaccionesychats.transferenciachats.modelo.respuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDataInteraccionesTransferenciaChats {

    private String conn_id;
    private String transfer_agent_id;
    private String transfer_agent_name;
    private String transfer_agent_dni;
    private String receiver_agent_id;
    private String receiver_agent_name;
    private String receiver_agent_dni;
    private String channel;
    private String date;


}
