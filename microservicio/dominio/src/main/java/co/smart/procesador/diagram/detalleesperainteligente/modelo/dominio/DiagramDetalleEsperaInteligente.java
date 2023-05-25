package co.smart.procesador.diagram.detalleesperainteligente.modelo.dominio;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
public class DiagramDetalleEsperaInteligente {

   private String skill_id;
   private LocalDateTime date_inbound_call;
   private LocalDateTime date_last_outbound_call;
   private String status;
   private int attempts;
   private String ani;

   private String dial_phone;
   private LocalTime time_between_calls;
   private LocalTime time;
   private LocalTime billed_minutes;
   private String customer_id;
    private LocalDate FECHA= LocalDate.now();
    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;

    public DiagramDetalleEsperaInteligente(String skill_id, LocalDateTime date_inbound_call, LocalDateTime date_last_outbound_call, String status, int attempts, String ani, String dial_phone, LocalTime time_between_calls, LocalTime time, LocalTime billed_minutes, String customer_id, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
        this.skill_id = skill_id;
        this.date_inbound_call = date_inbound_call;
        this.date_last_outbound_call = date_last_outbound_call;
        this.status = status;
        this.attempts = attempts;
        this.ani = ani;
        this.dial_phone = dial_phone;
        this.time_between_calls = time_between_calls;
        this.time = time;
        this.billed_minutes = billed_minutes;
        this.customer_id = customer_id;
        this.fecha_inicio_carga = fecha_inicio_carga;
        this.fecha_fin_carga = fecha_fin_carga;
    }
}
