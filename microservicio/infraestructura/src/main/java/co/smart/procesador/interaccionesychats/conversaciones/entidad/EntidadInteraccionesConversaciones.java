package co.smart.procesador.interaccionesychats.conversaciones.entidad;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="interacciones_conversaciones")
public class EntidadInteraccionesConversaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_interacciones_conversaciones;
    //@ManyToOne
    //@JoinColumn(nullable = false, updatable = false)
    private String chat_id;
    private String channel;
    @Column(name="from_e")
    private String from;
    @Column(name="from_name_e")
    private String from_name;
    private String to_name;
    private LocalDateTime date;
    @Column(length = 500)
    private String message;
    private String customer_id;
    @Column(name = "fecha_carga")
    private LocalDate FECHA;
    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;


    public EntidadInteraccionesConversaciones() {

    }

    public EntidadInteraccionesConversaciones(String chat_id, String channel, String from, String from_name, String to_name, LocalDateTime date, String message, String customer_id, LocalDate FECHA, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
        this.chat_id = chat_id;
        this.channel = channel;
        this.from = from;
        this.from_name = from_name;
        this.to_name = to_name;
        this.date = date;
        this.message = message;
        this.customer_id = customer_id;
        this.FECHA = FECHA;
        this.fecha_inicio_carga = fecha_inicio_carga;
        this.fecha_fin_carga = fecha_fin_carga;
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

    public Long getId_interacciones_conversaciones() {
        return Id_interacciones_conversaciones;
    }

    public void setId_interacciones_conversaciones(Long id_interacciones_conversaciones) {
        Id_interacciones_conversaciones = id_interacciones_conversaciones;
    }

    public String getChat_id() {
        return chat_id;
    }

    public void setChat_id(String chat_id) {
        this.chat_id = chat_id;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom_name() {
        return from_name;
    }

    public void setFrom_name(String from_name) {
        this.from_name = from_name;
    }

    public String getTo_name() {
        return to_name;
    }

    public void setTo_name(String to_name) {
        this.to_name = to_name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
