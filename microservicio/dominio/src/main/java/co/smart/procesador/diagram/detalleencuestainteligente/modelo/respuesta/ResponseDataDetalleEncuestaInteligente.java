package co.smart.procesador.diagram.detalleencuestainteligente.modelo.respuesta;

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
public class ResponseDataDetalleEncuestaInteligente {

    private String agent_id;
    private String  agent_name;
    private String agent_dni;
    private String skill_id;
    private String skill_name;
    private String date;
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
    private String voice_message_duration;
    private String type_interaction;
    private String result;
    private String time;
    private String voice_message;
    private String feeling;


}
