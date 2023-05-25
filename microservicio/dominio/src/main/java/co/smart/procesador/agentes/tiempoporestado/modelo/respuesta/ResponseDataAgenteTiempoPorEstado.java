package co.smart.procesador.agentes.tiempoporestado.modelo.respuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDataAgenteTiempoPorEstado {

    private String agent_id;
    private String agent_dni;
    private String agent_name;
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
    private String hits;
    private String rpc;
    private String aht_outbound;
    private String aht_inbound;
    private String login;
    private String logout;


}
