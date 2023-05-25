package co.smart.procesador.interaccionesychats.transferenciachats.modelo.dominio;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class InteraccionesTransferenciaChats {

   private String conn_id;
   private String transfer_agent_id;
   private String transfer_agent_name;
   private String transfer_agent_dni;
   private String receiver_agent_id;
   private String receiver_agent_name;
   private String receiver_agent_dni;
   private String channel;
   private LocalDateTime date;
    private LocalDate FECHA= LocalDate.now();
    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;

    public InteraccionesTransferenciaChats(String conn_id, String transfer_agent_id, String transfer_agent_name, String transfer_agent_dni, String receiver_agent_id, String receiver_agent_name, String receiver_agent_dni, String channel, LocalDateTime date, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
        this.conn_id = conn_id;
        this.transfer_agent_id = transfer_agent_id;
        this.transfer_agent_name = transfer_agent_name;
        this.transfer_agent_dni = transfer_agent_dni;
        this.receiver_agent_id = receiver_agent_id;
        this.receiver_agent_name = receiver_agent_name;
        this.receiver_agent_dni = receiver_agent_dni;
        this.channel = channel;
        this.date = date;
        this.fecha_inicio_carga = fecha_inicio_carga;
        this.fecha_fin_carga = fecha_fin_carga;
    }
}
