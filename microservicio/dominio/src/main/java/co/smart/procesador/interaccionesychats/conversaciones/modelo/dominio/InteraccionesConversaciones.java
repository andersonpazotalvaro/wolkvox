package co.smart.procesador.interaccionesychats.conversaciones.modelo.dominio;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class InteraccionesConversaciones {

    private String chat_id;
    private String channel;
    private String from;
    private String from_name;
    private String to_name;
    private LocalDateTime date;
    private String message;
    private String customer_id;
    private LocalDate FECHA= LocalDate.now();
    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;

    public InteraccionesConversaciones(String chat_id, String channel, String from, String from_name, String to_name, LocalDateTime date, String message, String customer_id, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
        this.chat_id = chat_id;
        this.channel = channel;
        this.from = from;
        this.from_name = from_name;
        this.to_name = to_name;
        this.date = date;
        this.message = message;
        this.customer_id = customer_id;
        this.fecha_inicio_carga = fecha_inicio_carga;
        this.fecha_fin_carga = fecha_fin_carga;
    }
}
