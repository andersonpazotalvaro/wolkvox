package co.smart.procesador.informacion.codigosactividad.comando;

import co.smart.procesador.informacion.codigosactividad.modelo.respuesta.ResponseDataInformacionCodigosActividad;
import co.smart.procesador.informacion.skill.modelo.respuesta.ResponseDataInformacionSkills;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseInformacionCodigosActividad {
    private String code;
    private String error;
    private String msg;
    private ResponseDataInformacionCodigosActividad[] data;


}
