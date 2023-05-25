package co.smart.procesador.agentes.tiempoporestado.modelo.dominio;

import lombok.Getter;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
public class AgenteTiempoPorEstado {

    private String agent_id;
    private String agent_dni;
    private String agent_name;
    private int calls;
    private int inbound;
    private int outbound;
    private int internal;
    private LocalTime ready_time;
    private LocalTime inbound_time;
    private LocalTime outbound_time;
    private LocalTime acw_time;
    private LocalTime ring_time;
    private LocalTime login_time;
    private LocalTime aht;
    private String occupancy;
    private LocalTime aux_time;
    private int hits;
    private int rpc;
    private String aht_outbound;
    private LocalTime aht_inbound;
    private LocalDateTime login;
    private LocalDateTime logout;

    private LocalDate FECHA= LocalDate.now();
    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;

    public AgenteTiempoPorEstado(String agent_id, String agent_dni, String agent_name, int calls, int inbound, int outbound, int internal, LocalTime ready_time, LocalTime inbound_time, LocalTime outbound_time, LocalTime acw_time, LocalTime ring_time, LocalTime login_time, LocalTime aht, String occupancy, LocalTime aux_time, int hits, int rpc, String aht_outbound, LocalTime aht_inbound, LocalDateTime login, LocalDateTime logout, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
        this.agent_id = agent_id;
        this.agent_dni = agent_dni;
        this.agent_name = agent_name;
        this.calls = calls;
        this.inbound = inbound;
        this.outbound = outbound;
        this.internal = internal;
        this.ready_time = ready_time;
        this.inbound_time = inbound_time;
        this.outbound_time = outbound_time;
        this.acw_time = acw_time;
        this.ring_time = ring_time;
        this.login_time = login_time;
        this.aht = aht;
        this.occupancy = occupancy;
        this.aux_time = aux_time;
        this.hits = hits;
        this.rpc = rpc;
        this.aht_outbound = aht_outbound;
        this.aht_inbound = aht_inbound;
        this.login = login;
        this.logout = logout;
        this.fecha_inicio_carga = fecha_inicio_carga;
        this.fecha_fin_carga = fecha_fin_carga;
    }

    public LocalDateTime getLogout() {
        return logout;
    }

    public String getAgent_id() {
        return agent_id;
    }
}
