package co.smart.procesador.informacion.codigosactividad.modelo.dominio;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class InformacionCodigosActividad {

    private Long cod_act;
    private String description_cod_act;
    private String hit;
    private String rpc;
    private String chat;
    private String type_code;
    private LocalDate FECHA= LocalDate.now();

    public InformacionCodigosActividad(Long cod_act, String description_cod_act, String hit, String rpc, String chat, String type_code) {
        this.cod_act = cod_act;
        this.description_cod_act = description_cod_act;
        this.hit = hit;
        this.rpc = rpc;
        this.chat = chat;
        this.type_code = type_code;
    }
}
