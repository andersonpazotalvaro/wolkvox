package co.smart.procesador.skillsyservicios.detallellamadasabandonadas.comando;

import co.smart.procesador.skillsyservicios.detallesllamadasabandonadas.modelo.respuesta.ResponseDataSkillsDetalleLlamadasAbandonadas;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSkillsDetallesLlamadasAbandonadas {
    private String code;
    private String error;
    private String msg;
    private ResponseDataSkillsDetalleLlamadasAbandonadas[] data;


}
