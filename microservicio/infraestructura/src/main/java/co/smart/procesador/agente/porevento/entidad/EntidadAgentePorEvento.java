package co.smart.procesador.agente.porevento.entidad;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name="agente_por_evento")
public class EntidadAgentePorEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long IdPorEvento;
    private String agent_id;
    private String agent_status;
    private LocalTime time;
    private LocalDateTime date_ini;
    private LocalDateTime date_end;
    private String conn_id;
    private String type_interaction;
    private String destiny;
    private String telephone;
    private String campaign_id;

    private LocalDate FECHA;

    public EntidadAgentePorEvento(String agent_id, String agent_status, LocalTime time, LocalDateTime date_ini, LocalDateTime date_end, String conn_id, String type_interaction, String destiny, String telephone, String campaign_id, LocalDate FECHA) {
        this.agent_id = agent_id;
        this.agent_status = agent_status;
        this.time = time;
        this.date_ini = date_ini;
        this.date_end = date_end;
        this.conn_id = conn_id;
        this.type_interaction = type_interaction;
        this.destiny = destiny;
        this.telephone = telephone;
        this.campaign_id = campaign_id;
        this.FECHA = FECHA;
    }

    public EntidadAgentePorEvento() {

    }


    public Long getIdPorEvento() {
        return IdPorEvento;
    }

    public void setIdPorEvento(Long idPorEvento) {
        IdPorEvento = idPorEvento;
    }

    public String getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(String agent_id) {
        this.agent_id = agent_id;
    }

    public String getAgent_status() {
        return agent_status;
    }

    public void setAgent_status(String agent_status) {
        this.agent_status = agent_status;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDateTime getDate_ini() {
        return date_ini;
    }

    public void setDate_ini(LocalDateTime date_ini) {
        this.date_ini = date_ini;
    }

    public LocalDateTime getDate_end() {
        return date_end;
    }

    public void setDate_end(LocalDateTime date_end) {
        this.date_end = date_end;
    }

    public String getConn_id() {
        return conn_id;
    }

    public void setConn_id(String conn_id) {
        this.conn_id = conn_id;
    }

    public String getType_interaction() {
        return type_interaction;
    }

    public void setType_interaction(String type_interaction) {
        this.type_interaction = type_interaction;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCampaign_id() {
        return campaign_id;
    }

    public void setCampaign_id(String campaign_id) {
        this.campaign_id = campaign_id;
    }

    public LocalDate getFECHA() {
        return FECHA;
    }

    public void setFECHA(LocalDate FECHA) {
        this.FECHA = FECHA;
    }
}
