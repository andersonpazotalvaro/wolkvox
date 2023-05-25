package co.smart.procesador.interaccionesychats.chats.modelo.dominio;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
public class InteraccionesChats {

    private String conn_id;
    private String channel;
    private LocalDateTime date;
    private String customer_name;
    private String customer_email;
    private String customer_phone;
    private int customer_chars;
    private  String agent_id;
    private String agent_name;
    private String agent_dni;
    private int agent_chars;
    private LocalTime time_on_agent;
    private LocalTime chat_duration;
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
    private int agent_answers;
    private LocalDate FECHA= LocalDate.now();
    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;

    public InteraccionesChats(String conn_id, String channel, LocalDateTime date, String customer_name, String customer_email, String customer_phone, int customer_chars, String agent_id, String agent_name, String agent_dni, int agent_chars, LocalTime time_on_agent, LocalTime chat_duration, String cod_act, String description_cod_act, String comments, String customer_id, String skill_id, String ASA, String last_participant_who_spoke, String extra_field, String comment, String user_id, String feeling, int agent_answers, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
        this.conn_id = conn_id;
        this.channel = channel;
        this.date = date;
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.customer_phone = customer_phone;
        this.customer_chars = customer_chars;
        this.agent_id = agent_id;
        this.agent_name = agent_name;
        this.agent_dni = agent_dni;
        this.agent_chars = agent_chars;
        this.time_on_agent = time_on_agent;
        this.chat_duration = chat_duration;
        this.cod_act = cod_act;
        this.description_cod_act = description_cod_act;
        this.comments = comments;
        this.customer_id = customer_id;
        this.skill_id = skill_id;
        this.ASA = ASA;
        this.last_participant_who_spoke = last_participant_who_spoke;
        this.extra_field = extra_field;
        this.comment = comment;
        this.user_id = user_id;
        this.feeling = feeling;
        this.agent_answers = agent_answers;
        this.fecha_inicio_carga = fecha_inicio_carga;
        this.fecha_fin_carga = fecha_fin_carga;
    }
}
