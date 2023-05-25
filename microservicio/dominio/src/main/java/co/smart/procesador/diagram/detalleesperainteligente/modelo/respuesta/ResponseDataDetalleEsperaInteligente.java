package co.smart.procesador.diagram.detalleesperainteligente.modelo.respuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDataDetalleEsperaInteligente {

    private String skill_id;
    private String date_inbound_call;
    private String date_last_outbound_call;
    private String status;
    private String attempts;
    private String ani;
    private String dial_phone;
    private String time_between_calls;
    private String time;
    private String billed_minutes;
    private String customer_id;


}
