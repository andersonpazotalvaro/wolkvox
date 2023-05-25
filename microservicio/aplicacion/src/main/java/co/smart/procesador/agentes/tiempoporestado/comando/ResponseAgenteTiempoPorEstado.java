package co.smart.procesador.agentes.tiempoporestado.comando;

import co.smart.procesador.agentes.estadoporhora.modelo.respuesta.ResponseDataAgenteEstadoPorHora;
import co.smart.procesador.agentes.tiempoporestado.modelo.respuesta.ResponseDataAgenteTiempoPorEstado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseAgenteTiempoPorEstado {
    private String code;
    private String error;
    private String msg;
    private ResponseDataAgenteTiempoPorEstado[] data;


}
