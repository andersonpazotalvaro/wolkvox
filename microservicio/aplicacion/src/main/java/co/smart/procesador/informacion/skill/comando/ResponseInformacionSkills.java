package co.smart.procesador.informacion.skill.comando;

import co.smart.procesador.informacion.skill.modelo.respuesta.ResponseDataInformacionSkills;
import co.smart.procesador.interaccionesychats.chats.modelo.respuesta.ResponseDataInteraccionesChats;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseInformacionSkills {
    private String code;
    private String error;
    private String msg;
    private ResponseDataInformacionSkills[] data;


}
