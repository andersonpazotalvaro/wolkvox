package co.smart.procesador.agentes.porevento.modelo.respuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDataAgentePorEvento {

    private String agent_id;
    private String agent_status;
    private String time;
    private String date_ini;
    private String date_end;
    private String conn_id;
    private String type_interaction;
    private String destiny;
    private String telephone;
    private String campaign_id;


}
