package co.smart.procesador.interaccionesychats.chats.entidad;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name="interacciones_chats")
public class EntidadInteraccionesChats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_interacciones_chats;
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
    @Column(length = 500)
    private String comments;
    private String customer_id;
    private String skill_id;
    private String ASA;
    private String last_participant_who_spoke;
    private String extra_field;
    @Column(length = 500)
    private String comment;
    private String user_id;
    private String feeling;
    private int agent_answers;
    @Column(name = "fecha_carga")
    private LocalDate FECHA;
    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;


    public EntidadInteraccionesChats() {

    }

    public EntidadInteraccionesChats(String conn_id, String channel, LocalDateTime date, String customer_name, String customer_email, String customer_phone, int customer_chars, String agent_id, String agent_name, String agent_dni, int agent_chars, LocalTime time_on_agent, LocalTime chat_duration, String cod_act, String description_cod_act, String comments, String customer_id, String skill_id, String ASA, String last_participant_who_spoke, String extra_field, String comment, String user_id, String feeling, int agent_answers, LocalDate FECHA, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
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

    public Long getId_interacciones_chats() {
        return Id_interacciones_chats;
    }

    public void setId_interacciones_chats(Long id_interacciones_chats) {
        Id_interacciones_chats = id_interacciones_chats;
    }

    public String getConn_id() {
        return conn_id;
    }

    public void setConn_id(String conn_id) {
        this.conn_id = conn_id;
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

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public int getCustomer_chars() {
        return customer_chars;
    }

    public void setCustomer_chars(int customer_chars) {
        this.customer_chars = customer_chars;
    }

    public String getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(String agent_id) {
        this.agent_id = agent_id;
    }

    public String getAgent_name() {
        return agent_name;
    }

    public void setAgent_name(String agent_name) {
        this.agent_name = agent_name;
    }

    public String getAgent_dni() {
        return agent_dni;
    }

    public void setAgent_dni(String agent_dni) {
        this.agent_dni = agent_dni;
    }

    public int getAgent_chars() {
        return agent_chars;
    }

    public void setAgent_chars(int agent_chars) {
        this.agent_chars = agent_chars;
    }

    public LocalTime getTime_on_agent() {
        return time_on_agent;
    }

    public void setTime_on_agent(LocalTime time_on_agent) {
        this.time_on_agent = time_on_agent;
    }

    public LocalTime getChat_duration() {
        return chat_duration;
    }

    public void setChat_duration(LocalTime chat_duration) {
        this.chat_duration = chat_duration;
    }

    public String getCod_act() {
        return cod_act;
    }

    public void setCod_act(String cod_act) {
        this.cod_act = cod_act;
    }

    public String getDescription_cod_act() {
        return description_cod_act;
    }

    public void setDescription_cod_act(String description_cod_act) {
        this.description_cod_act = description_cod_act;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(String skill_id) {
        this.skill_id = skill_id;
    }

    public String getASA() {
        return ASA;
    }

    public void setASA(String ASA) {
        this.ASA = ASA;
    }

    public String getLast_participant_who_spoke() {
        return last_participant_who_spoke;
    }

    public void setLast_participant_who_spoke(String last_participant_who_spoke) {
        this.last_participant_who_spoke = last_participant_who_spoke;
    }

    public String getExtra_field() {
        return extra_field;
    }

    public void setExtra_field(String extra_field) {
        this.extra_field = extra_field;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFeeling() {
        return feeling;
    }

    public void setFeeling(String feeling) {
        this.feeling = feeling;
    }

    public int getAgent_answers() {
        return agent_answers;
    }

    public void setAgent_answers(int agent_answers) {
        this.agent_answers = agent_answers;
    }

    public LocalDate getFECHA() {
        return FECHA;
    }

    public void setFECHA(LocalDate FECHA) {
        this.FECHA = FECHA;
    }
}
