package co.smart.procesador.diagram.detalleencuestainteligente.entidad;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name="diagram_detalle_encuesta_inteligente")
public class EntidadDiagramDetalleEncuestaInteligente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_detalle_encuesta_inteligente;

    private String agent_id;
    private String  agent_name;
    private String agent_dni;
    private String skill_id;
    private String skill_name;
    private LocalDateTime date;
    private String conn_id;
    private String ani;
    private String customer_id;
    private String q01;
    private String q02;
    private String q03;
    private String q04;
    private String q05;
    private String q06;
    private String q07;
    private String q08;
    private String q09;
    private String q10;
    private LocalTime voice_message_duration;
    private String type_interaction;
    private String result;
    private LocalTime time;
    private String voice_message;
    private String feeling;
    @Column(name = "fecha_carga")
    private LocalDate FECHA;
    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;




    public EntidadDiagramDetalleEncuestaInteligente() {

    }

    public EntidadDiagramDetalleEncuestaInteligente(String agent_id, String agent_name, String agent_dni, String skill_id, String skill_name, LocalDateTime date, String conn_id, String ani, String customer_id, String q01, String q02, String q03, String q04, String q05, String q06, String q07, String q08, String q09, String q10, LocalTime voice_message_duration, String type_interaction, String result, LocalTime time, String voice_message, String feeling, LocalDate FECHA, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
        this.agent_id = agent_id;
        this.agent_name = agent_name;
        this.agent_dni = agent_dni;
        this.skill_id = skill_id;
        this.skill_name = skill_name;
        this.date = date;
        this.conn_id = conn_id;
        this.ani = ani;
        this.customer_id = customer_id;
        this.q01 = q01;
        this.q02 = q02;
        this.q03 = q03;
        this.q04 = q04;
        this.q05 = q05;
        this.q06 = q06;
        this.q07 = q07;
        this.q08 = q08;
        this.q09 = q09;
        this.q10 = q10;
        this.voice_message_duration = voice_message_duration;
        this.type_interaction = type_interaction;
        this.result = result;
        this.time = time;
        this.voice_message = voice_message;
        this.feeling = feeling;
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

    public Long getId_detalle_encuesta_inteligente() {
        return Id_detalle_encuesta_inteligente;
    }

    public void setId_detalle_encuesta_inteligente(Long id_detalle_encuesta_inteligente) {
        Id_detalle_encuesta_inteligente = id_detalle_encuesta_inteligente;
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

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getConn_id() {
        return conn_id;
    }

    public void setConn_id(String conn_id) {
        this.conn_id = conn_id;
    }

    public String getAni() {
        return ani;
    }

    public void setAni(String ani) {
        this.ani = ani;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getQ01() {
        return q01;
    }

    public void setQ01(String q01) {
        this.q01 = q01;
    }

    public String getQ02() {
        return q02;
    }

    public void setQ02(String q02) {
        this.q02 = q02;
    }

    public String getQ03() {
        return q03;
    }

    public void setQ03(String q03) {
        this.q03 = q03;
    }

    public String getQ04() {
        return q04;
    }

    public void setQ04(String q04) {
        this.q04 = q04;
    }

    public String getQ05() {
        return q05;
    }

    public void setQ05(String q05) {
        this.q05 = q05;
    }

    public String getQ06() {
        return q06;
    }

    public void setQ06(String q06) {
        this.q06 = q06;
    }

    public String getQ07() {
        return q07;
    }

    public void setQ07(String q07) {
        this.q07 = q07;
    }

    public String getQ08() {
        return q08;
    }

    public void setQ08(String q08) {
        this.q08 = q08;
    }

    public String getQ09() {
        return q09;
    }

    public void setQ09(String q09) {
        this.q09 = q09;
    }

    public String getQ10() {
        return q10;
    }

    public void setQ10(String q10) {
        this.q10 = q10;
    }

    public LocalTime getVoice_message_duration() {
        return voice_message_duration;
    }

    public void setVoice_message_duration(LocalTime voice_message_duration) {
        this.voice_message_duration = voice_message_duration;
    }

    public String getType_interaction() {
        return type_interaction;
    }

    public void setType_interaction(String type_interaction) {
        this.type_interaction = type_interaction;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getVoice_message() {
        return voice_message;
    }

    public void setVoice_message(String voice_message) {
        this.voice_message = voice_message;
    }

    public String getFeeling() {
        return feeling;
    }

    public void setFeeling(String feeling) {
        this.feeling = feeling;
    }

    public LocalDate getFECHA() {
        return FECHA;
    }

    public void setFECHA(LocalDate FECHA) {
        this.FECHA = FECHA;
    }

    public String getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(String skill_id) {
        this.skill_id = skill_id;
    }


}
