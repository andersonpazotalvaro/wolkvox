package co.smart.procesador.agentes.estadoporhora.modelo.respuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDataAgenteEstadoPorHora {

    private String hour;
    private String calls;
    private String inbound;
    private String outbound;
    private String internal;
    private String ready_time;
    private String inbound_time;
    private String outbound_time;
    private String acw_time;
    private String ring_time;
    private String login_time;
    private String aht;
    private String occupancy;
    private String aux_time;


}
