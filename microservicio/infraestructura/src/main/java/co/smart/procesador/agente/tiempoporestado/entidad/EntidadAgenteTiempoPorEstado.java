package co.smart.procesador.agente.tiempoporestado.entidad;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name="agente_tiempo_por_estado")
public class EntidadAgenteTiempoPorEstado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long IdTiempoPorEstado;
    @Column
    private String agent_id;
    @Column
    private String agent_dni;
    @Column
    private String agent_name;
    @Column
    private int calls;
    @Column
    private int inbound;
    @Column
    private int outbound;
    @Column
    private int internal;
    @Column
    private LocalTime ready_time;
    @Column
    private LocalTime inbound_time;
    @Column
    private LocalTime outbound_time;
    @Column
    private LocalTime acw_time;
    @Column
    private LocalTime ring_time;
    @Column
    private LocalTime login_time;
    @Column
    private LocalTime aht;
    @Column
    private String occupancy;
    @Column
    private LocalTime aux_time;
    @Column
    private int hits;
    @Column
    private int rpc;
    @Column
    private String aht_outbound;
    @Column
    private LocalTime aht_inbound;
    @Column
    private LocalDateTime login;
    @Column
    private LocalDateTime logout;
    @Column(name = "fecha_carga")
    private LocalDate FECHA;

    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;

    public EntidadAgenteTiempoPorEstado(String agent_id, String agent_dni, String agent_name, int calls, int inbound, int outbound, int internal, LocalTime ready_time, LocalTime inbound_time, LocalTime outbound_time, LocalTime acw_time, LocalTime ring_time, LocalTime login_time, LocalTime aht, String occupancy, LocalTime aux_time, int hits, int rpc, String aht_outbound, LocalTime aht_inbound, LocalDateTime login, LocalDateTime logout, LocalDate FECHA, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
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
        this.FECHA = FECHA;
        this.fecha_inicio_carga = fecha_inicio_carga;
        this.fecha_fin_carga = fecha_fin_carga;
    }

    public EntidadAgenteTiempoPorEstado() {

    }

    public Long getIdTiempoPorEstado() {
        return IdTiempoPorEstado;
    }

    public void setIdTiempoPorEstado(Long idTiempoPorEstado) {
        IdTiempoPorEstado = idTiempoPorEstado;
    }

    public LocalDate getFecha_inicio_carga() {
        return fecha_inicio_carga;
    }

    public void setFecha_inicio_carga(LocalDate fecha_inicio_carga) {
        this.fecha_inicio_carga = fecha_inicio_carga;
    }

    public LocalDate getFecha_fin_carga() {
        return fecha_fin_carga;
    }

    public void setFecha_fin_carga(LocalDate fecha_fin_carga) {
        this.fecha_fin_carga = fecha_fin_carga;
    }

    public Long getId() {
        return IdTiempoPorEstado;
    }

    public void setId(Long id) {
        this.IdTiempoPorEstado = id;
    }

    public String getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(String agent_id) {
        this.agent_id = agent_id;
    }

    public String getAgent_dni() {
        return agent_dni;
    }

    public void setAgent_dni(String agent_dni) {
        this.agent_dni = agent_dni;
    }

    public String getAgent_name() {
        return agent_name;
    }

    public void setAgent_name(String agent_name) {
        this.agent_name = agent_name;
    }

    public int getCalls() {
        return calls;
    }

    public void setCalls(int calls) {
        this.calls = calls;
    }

    public int getInbound() {
        return inbound;
    }

    public void setInbound(int inbound) {
        this.inbound = inbound;
    }

    public int getOutbound() {
        return outbound;
    }

    public void setOutbound(int outbound) {
        this.outbound = outbound;
    }

    public int getInternal() {
        return internal;
    }

    public void setInternal(int internal) {
        this.internal = internal;
    }

    public LocalTime getReady_time() {
        return ready_time;
    }

    public void setReady_time(LocalTime ready_time) {
        this.ready_time = ready_time;
    }

    public LocalTime getInbound_time() {
        return inbound_time;
    }

    public void setInbound_time(LocalTime inbound_time) {
        this.inbound_time = inbound_time;
    }

    public LocalTime getOutbound_time() {
        return outbound_time;
    }

    public void setOutbound_time(LocalTime outbound_time) {
        this.outbound_time = outbound_time;
    }

    public LocalTime getAcw_time() {
        return acw_time;
    }

    public void setAcw_time(LocalTime acw_time) {
        this.acw_time = acw_time;
    }

    public LocalTime getRing_time() {
        return ring_time;
    }

    public void setRing_time(LocalTime ring_time) {
        this.ring_time = ring_time;
    }

    public LocalTime getLogin_time() {
        return login_time;
    }

    public void setLogin_time(LocalTime login_time) {
        this.login_time = login_time;
    }

    public LocalTime getAht() {
        return aht;
    }

    public void setAht(LocalTime aht) {
        this.aht = aht;
    }

    public String getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(String occupancy) {
        this.occupancy = occupancy;
    }

    public LocalTime getAux_time() {
        return aux_time;
    }

    public void setAux_time(LocalTime aux_time) {
        this.aux_time = aux_time;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getRpc() {
        return rpc;
    }

    public void setRpc(int rpc) {
        this.rpc = rpc;
    }

    public String getAht_outbound() {
        return aht_outbound;
    }

    public void setAht_outbound(String aht_outbound) {
        this.aht_outbound = aht_outbound;
    }

    public LocalTime getAht_inbound() {
        return aht_inbound;
    }

    public void setAht_inbound(LocalTime aht_inbound) {
        this.aht_inbound = aht_inbound;
    }

    public LocalDateTime getLogin() {
        return login;
    }

    public void setLogin(LocalDateTime login) {
        this.login = login;
    }

    public LocalDateTime getLogout() {
        return logout;
    }

    public void setLogout(LocalDateTime logout) {
        this.logout = logout;
    }

    public LocalDate getFECHA() {
        return FECHA;
    }

    public void setFECHA(LocalDate FECHA) {
        this.FECHA = FECHA;
    }
}
