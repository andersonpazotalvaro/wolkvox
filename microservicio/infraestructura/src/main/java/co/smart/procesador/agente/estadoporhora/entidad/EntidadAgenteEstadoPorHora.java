package co.smart.procesador.agente.estadoporhora.entidad;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name="agente_estado_por_hora")
public class EntidadAgenteEstadoPorHora {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id_estado_por_hora;
    private String hour;
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
    @Column(name = "fecha_carga")
    private LocalDate FECHA;

    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;

    public EntidadAgenteEstadoPorHora(String hour, int calls, int inbound, int outbound, int internal, LocalTime ready_time, LocalTime inbound_time, LocalTime outbound_time, LocalTime acw_time, LocalTime ring_time, LocalTime login_time, LocalTime aht, String occupancy, LocalTime aux_time, LocalDate FECHA, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
        this.hour = hour;
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
        this.FECHA = FECHA;
        this.fecha_inicio_carga = fecha_inicio_carga;
        this.fecha_fin_carga = fecha_fin_carga;
    }

    public EntidadAgenteEstadoPorHora() {

    }

    public Long getId_estado_por_hora() {
        return Id_estado_por_hora;
    }

    public void setId_estado_por_hora(Long id_estado_por_hora) {
        Id_estado_por_hora = id_estado_por_hora;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
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

    public LocalDate getFECHA() {
        return FECHA;
    }

    public void setFECHA(LocalDate FECHA) {
        this.FECHA = FECHA;
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
}
