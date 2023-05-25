package co.smart.procesador.diagram.detalleencuestainteligente.modelo.dominio;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
public class DiagramDetalleEncuestaInteligente {

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
    private LocalDate FECHA= LocalDate.now();
    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;


    public DiagramDetalleEncuestaInteligente(String agent_id, String agent_name, String agent_dni, String skill_id, String skill_name, LocalDateTime date, String conn_id, String ani, String customer_id, String q01, String q02, String q03, String q04, String q05, String q06, String q07, String q08, String q09, String q10, LocalTime voice_message_duration, String type_interaction, String result, LocalTime time, String voice_message, String feeling, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
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
        this.fecha_inicio_carga = fecha_inicio_carga;
        this.fecha_fin_carga = fecha_fin_carga;
    }
}
