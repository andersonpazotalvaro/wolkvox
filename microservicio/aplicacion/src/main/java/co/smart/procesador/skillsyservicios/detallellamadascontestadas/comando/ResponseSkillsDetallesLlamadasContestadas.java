package co.smart.procesador.skillsyservicios.detallellamadascontestadas.comando;

import co.smart.procesador.skillsyservicios.detallellamadascontestadas.modelo.respuesta.ResponseDataSkillsDetalleLlamadasContestadas;
import co.smart.procesador.skillsyservicios.detallesllamadasabandonadas.modelo.respuesta.ResponseDataSkillsDetalleLlamadasAbandonadas;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSkillsDetallesLlamadasContestadas {
    private String code;
    private String error;
    private String msg;
    private ResponseDataSkillsDetalleLlamadasContestadas[] data;


}
