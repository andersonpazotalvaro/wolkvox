package co.smart.procesador.campañas.resultadotelefonoatelefono.comando;

import co.smart.procesador.campañas.resultadomaquinafinal.modelo.respuesta.ResponseDataResultadoMaquinaFinal;
import co.smart.procesador.campañas.resultadotelefonoatelefono.modelo.respuesta.ResponseDataResultadoTelefonoATelefono;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCampañaResultadoTelefonoATelefono {
    private String code;
    private String error;
    private String msg;
    private ResponseDataResultadoTelefonoATelefono[] data;


}
