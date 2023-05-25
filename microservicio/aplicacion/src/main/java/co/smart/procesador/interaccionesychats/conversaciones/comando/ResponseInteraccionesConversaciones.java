package co.smart.procesador.interaccionesychats.conversaciones.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseInteraccionesConversaciones {
    private String code;
    private String error;
    private String msg;
    private ResponseData[] data;


}
