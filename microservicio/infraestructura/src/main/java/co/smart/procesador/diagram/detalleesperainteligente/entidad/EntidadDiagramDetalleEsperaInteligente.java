package co.smart.procesador.diagram.detalleesperainteligente.entidad;

import co.smart.procesador.diagram.esperainteligente.entidad.EntidadDiagramEsperaInteligente;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name="diagram_detalle_espera_inteligente")
public class EntidadDiagramDetalleEsperaInteligente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_detalle_espera_inteligente;

    private String skill_id;
    private LocalDateTime date_inbound_call;
    private LocalDateTime date_last_outbound_call;
    private String status;
    private int attempts;
    private String ani;

    private String dial_phone;
    private LocalTime time_between_calls;
    private LocalTime time;
    private LocalTime billed_minutes;
    private String customer_id;
    @Column(name = "fecha_carga")
    private LocalDate FECHA;
    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;




    public EntidadDiagramDetalleEsperaInteligente() {

    }

    public EntidadDiagramDetalleEsperaInteligente(String skill_id, LocalDateTime date_inbound_call, LocalDateTime date_last_outbound_call, String status, int attempts, String ani, String dial_phone, LocalTime time_between_calls, LocalTime time, LocalTime billed_minutes, String customer_id, LocalDate FECHA, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
        this.skill_id = skill_id;
        this.date_inbound_call = date_inbound_call;
        this.date_last_outbound_call = date_last_outbound_call;
        this.status = status;
        this.attempts = attempts;
        this.ani = ani;
        this.dial_phone = dial_phone;
        this.time_between_calls = time_between_calls;
        this.time = time;
        this.billed_minutes = billed_minutes;
        this.customer_id = customer_id;
        this.FECHA = FECHA;
        this.fecha_inicio_carga = fecha_inicio_carga;
        this.fecha_fin_carga = fecha_fin_carga;
    }

    public Long getId_detalle_espera_inteligente() {
        return Id_detalle_espera_inteligente;
    }

    public void setId_detalle_espera_inteligente(Long id_detalle_espera_inteligente) {
        Id_detalle_espera_inteligente = id_detalle_espera_inteligente;
    }

    public String getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(String skill_id) {
        this.skill_id = skill_id;
    }

    public LocalDateTime getDate_inbound_call() {
        return date_inbound_call;
    }

    public void setDate_inbound_call(LocalDateTime date_inbound_call) {
        this.date_inbound_call = date_inbound_call;
    }

    public LocalDateTime getDate_last_outbound_call() {
        return date_last_outbound_call;
    }

    public void setDate_last_outbound_call(LocalDateTime date_last_outbound_call) {
        this.date_last_outbound_call = date_last_outbound_call;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public String getAni() {
        return ani;
    }

    public void setAni(String ani) {
        this.ani = ani;
    }

    public String getDial_phone() {
        return dial_phone;
    }

    public void setDial_phone(String dial_phone) {
        this.dial_phone = dial_phone;
    }

    public LocalTime getTime_between_calls() {
        return time_between_calls;
    }

    public void setTime_between_calls(LocalTime time_between_calls) {
        this.time_between_calls = time_between_calls;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalTime getBilled_minutes() {
        return billed_minutes;
    }

    public void setBilled_minutes(LocalTime billed_minutes) {
        this.billed_minutes = billed_minutes;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public LocalDate getFECHA() {
        return FECHA;
    }

    public void setFECHA(LocalDate FECHA) {
        this.FECHA = FECHA;
    }
}
