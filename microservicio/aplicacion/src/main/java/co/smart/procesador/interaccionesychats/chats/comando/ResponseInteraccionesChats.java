package co.smart.procesador.interaccionesychats.chats.comando;

import co.smart.procesador.interaccionesychats.chats.modelo.respuesta.ResponseDataInteraccionesChats;
import co.smart.procesador.skillsyservicios.workforceporhora.modelo.respuesta.ResponseDataSkillsWorkforceHora;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseInteraccionesChats {
    private String code;
    private String error;
    private String msg;
    private ResponseDataInteraccionesChats[] data;


}
