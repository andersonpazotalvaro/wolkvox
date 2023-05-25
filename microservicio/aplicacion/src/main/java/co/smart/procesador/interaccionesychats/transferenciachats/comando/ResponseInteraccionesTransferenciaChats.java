package co.smart.procesador.interaccionesychats.transferenciachats.comando;

import co.smart.procesador.interaccionesychats.transferenciachats.modelo.respuesta.ResponseDataInteraccionesTransferenciaChats;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseInteraccionesTransferenciaChats {
    private String code;
    private String error;
    private String msg;
    private ResponseDataInteraccionesTransferenciaChats[] data;


}
