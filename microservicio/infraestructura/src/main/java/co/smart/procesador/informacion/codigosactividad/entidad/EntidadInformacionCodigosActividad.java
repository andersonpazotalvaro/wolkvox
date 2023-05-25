package co.smart.procesador.informacion.codigosactividad.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="informacion_codigos_actividad")
public class EntidadInformacionCodigosActividad {

    @Id
    private Long cod_act;
    private String description_cod_act;
    private String hit;
    private String rpc;
    private String chat;
    private String type_code;
    @Column(name = "fecha_carga")
    private LocalDate FECHA;


    public EntidadInformacionCodigosActividad() {

    }

    public EntidadInformacionCodigosActividad(Long cod_act, String description_cod_act, String hit, String rpc, String chat, String type_code, LocalDate FECHA) {
        this.cod_act = cod_act;
        this.description_cod_act = description_cod_act;
        this.hit = hit;
        this.rpc = rpc;
        this.chat = chat;
        this.type_code = type_code;
        this.FECHA = FECHA;
    }

    public Long getCod_act() {
        return cod_act;
    }

    public void setCod_act(Long cod_act) {
        this.cod_act = cod_act;
    }

    public String getDescription_cod_act() {
        return description_cod_act;
    }

    public void setDescription_cod_act(String description_cod_act) {
        this.description_cod_act = description_cod_act;
    }

    public String getHit() {
        return hit;
    }

    public void setHit(String hit) {
        this.hit = hit;
    }

    public String getRpc() {
        return rpc;
    }

    public void setRpc(String rpc) {
        this.rpc = rpc;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public String getType_code() {
        return type_code;
    }

    public void setType_code(String type_code) {
        this.type_code = type_code;
    }

    public LocalDate getFECHA() {
        return FECHA;
    }

    public void setFECHA(LocalDate FECHA) {
        this.FECHA = FECHA;
    }
}
