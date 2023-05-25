package co.smart.procesador.interaccionesychats.chats.modelo.respuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDataInteraccionesChats {

    private String conn_id;
    private String channel;
    private String date;
    private String customer_name;
    private String customer_email;
    private String customer_phone;
    private String customer_chars;
    private String agent_id;
    private String agent_name;
    private String agent_dni;
    private String agent_chars;
    private String time_on_agent;
    private String chat_duration;
    private String cod_act;
    private String description_cod_act;
    private String comments;
    private String customer_id;
    private String skill_id;
    private String ASA;
    private String last_participant_who_spoke;
    private String extra_field;
    private String comment;
    private String user_id;
    private String feeling;
    private String agent_answers;


}
