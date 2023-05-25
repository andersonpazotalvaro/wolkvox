package co.smart.procesador.campañas.resultadomaquinafinal.comando;

import co.smart.procesador.campañas.resultadomaquinafinal.modelo.respuesta.ResponseDataResultadoMaquinaFinal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCampañaResultadoMaquinaFinal {
    private String code;
    private String error;
    private String msg;
    private ResponseDataResultadoMaquinaFinal[] data;


}
