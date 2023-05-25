package co.smart.procesador.agentes.porevento.modelo.dominio;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
public class AgentePorEvento {

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

    private LocalDate FECHA= LocalDate.now();

    public AgentePorEvento(String agent_id, String agent_status, LocalTime time, LocalDateTime date_ini, LocalDateTime date_end, String conn_id, String type_interaction, String destiny, String telephone, String campaign_id) {
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
    }
}
