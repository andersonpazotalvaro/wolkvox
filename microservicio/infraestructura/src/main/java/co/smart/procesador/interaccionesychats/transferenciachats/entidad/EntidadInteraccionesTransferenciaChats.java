package co.smart.procesador.interaccionesychats.transferenciachats.entidad;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name="interacciones_transferencia_chats")
public class EntidadInteraccionesTransferenciaChats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_interacciones_transferencia_chats;
    private String conn_id;
    private String transfer_agent_id;
    private String transfer_agent_name;
    private String transfer_agent_dni;
    private String receiver_agent_id;
    private String receiver_agent_name;
    private String receiver_agent_dni;
    private String channel;
    private LocalDateTime date;
    @Column(name = "fecha_carga")
    private LocalDate FECHA;
    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;


    public EntidadInteraccionesTransferenciaChats() {

    }

    public EntidadInteraccionesTransferenciaChats(String conn_id, String transfer_agent_id, String transfer_agent_name, String transfer_agent_dni, String receiver_agent_id, String receiver_agent_name, String receiver_agent_dni, String channel, LocalDateTime date, LocalDate FECHA, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
        this.conn_id = conn_id;
        this.transfer_agent_id = transfer_agent_id;
        this.transfer_agent_name = transfer_agent_name;
        this.transfer_agent_dni = transfer_agent_dni;
        this.receiver_agent_id = receiver_agent_id;
        this.receiver_agent_name = receiver_agent_name;
        this.receiver_agent_dni = receiver_agent_dni;
        this.channel = channel;
        this.date = date;
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

    public Long getId_interacciones_transferencia_chats() {
        return Id_interacciones_transferencia_chats;
    }

    public void setId_interacciones_transferencia_chats(Long id_interacciones_transferencia_chats) {
        Id_interacciones_transferencia_chats = id_interacciones_transferencia_chats;
    }

    public String getConn_id() {
        return conn_id;
    }

    public void setConn_id(String conn_id) {
        this.conn_id = conn_id;
    }

    public String getTransfer_agent_id() {
        return transfer_agent_id;
    }

    public void setTransfer_agent_id(String transfer_agent_id) {
        this.transfer_agent_id = transfer_agent_id;
    }

    public String getTransfer_agent_name() {
        return transfer_agent_name;
    }

    public void setTransfer_agent_name(String transfer_agent_name) {
        this.transfer_agent_name = transfer_agent_name;
    }

    public String getTransfer_agent_dni() {
        return transfer_agent_dni;
    }

    public void setTransfer_agent_dni(String transfer_agent_dni) {
        this.transfer_agent_dni = transfer_agent_dni;
    }

    public String getReceiver_agent_id() {
        return receiver_agent_id;
    }

    public void setReceiver_agent_id(String receiver_agent_id) {
        this.receiver_agent_id = receiver_agent_id;
    }

    public String getReceiver_agent_name() {
        return receiver_agent_name;
    }

    public void setReceiver_agent_name(String receiver_agent_name) {
        this.receiver_agent_name = receiver_agent_name;
    }

    public String getReceiver_agent_dni() {
        return receiver_agent_dni;
    }

    public void setReceiver_agent_dni(String receiver_agent_dni) {
        this.receiver_agent_dni = receiver_agent_dni;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDate getFECHA() {
        return FECHA;
    }

    public void setFECHA(LocalDate FECHA) {
        this.FECHA = FECHA;
    }
}
