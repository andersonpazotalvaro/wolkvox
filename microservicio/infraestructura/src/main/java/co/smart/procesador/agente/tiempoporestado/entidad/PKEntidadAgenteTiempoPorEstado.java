package co.smart.procesador.agente.tiempoporestado.entidad;


import java.time.LocalDate;

import javax.persistence.Embeddable;

//@Embeddable
public class PKEntidadAgenteTiempoPorEstado  {

    private Long IdTiempoPorEstado;
    private LocalDate fecha= LocalDate.now();

    public PKEntidadAgenteTiempoPorEstado(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Long getIdTiempoPorEstado() {
        return IdTiempoPorEstado;
    }

    public void setIdTiempoPorEstado(Long idTiempoPorEstado) {
        IdTiempoPorEstado = idTiempoPorEstado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
