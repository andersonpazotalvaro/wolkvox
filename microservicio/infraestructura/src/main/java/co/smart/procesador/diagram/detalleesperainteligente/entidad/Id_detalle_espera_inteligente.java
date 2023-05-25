package co.smart.procesador.diagram.detalleesperainteligente.entidad;

import co.smart.procesador.diagram.esperainteligente.entidad.EntidadDiagramEsperaInteligente;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class Id_detalle_espera_inteligente implements Serializable {

    @ManyToOne
    @JoinColumn(name = "espera_id")
    private EntidadDiagramEsperaInteligente entidadDiagramEsperaInteligente;

    @ManyToOne
    @JoinColumn(name = "detalle_id")
    private EntidadDiagramDetalleEsperaInteligente entidadDiagramDetalleEsperaInteligente;





    public Id_detalle_espera_inteligente() {
    }


    public Id_detalle_espera_inteligente(EntidadDiagramEsperaInteligente entidadDiagramEsperaInteligente) {
        this.entidadDiagramEsperaInteligente = entidadDiagramEsperaInteligente;
    }

    public Id_detalle_espera_inteligente(EntidadDiagramDetalleEsperaInteligente entidadDiagramDetalleEsperaInteligente) {
        this.entidadDiagramDetalleEsperaInteligente = entidadDiagramDetalleEsperaInteligente;
    }

    public Id_detalle_espera_inteligente(EntidadDiagramEsperaInteligente entidadDiagramEsperaInteligente, EntidadDiagramDetalleEsperaInteligente entidadDiagramDetalleEsperaInteligente) {
        this.entidadDiagramEsperaInteligente = entidadDiagramEsperaInteligente;
        this.entidadDiagramDetalleEsperaInteligente = entidadDiagramDetalleEsperaInteligente;
    }

    public EntidadDiagramEsperaInteligente getEntidadDiagramEsperaInteligente() {
        return entidadDiagramEsperaInteligente;
    }

    public void setEntidadDiagramEsperaInteligente(EntidadDiagramEsperaInteligente entidadDiagramEsperaInteligente) {
        this.entidadDiagramEsperaInteligente = entidadDiagramEsperaInteligente;
    }

    public EntidadDiagramDetalleEsperaInteligente getEntidadDiagramDetalleEsperaInteligente() {
        return entidadDiagramDetalleEsperaInteligente;
    }

    public void setEntidadDiagramDetalleEsperaInteligente(EntidadDiagramDetalleEsperaInteligente entidadDiagramDetalleEsperaInteligente) {
        this.entidadDiagramDetalleEsperaInteligente = entidadDiagramDetalleEsperaInteligente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Id_detalle_espera_inteligente that)) return false;
        return getEntidadDiagramEsperaInteligente().equals(that.getEntidadDiagramEsperaInteligente()) && getEntidadDiagramDetalleEsperaInteligente().equals(that.getEntidadDiagramDetalleEsperaInteligente());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEntidadDiagramEsperaInteligente(), getEntidadDiagramDetalleEsperaInteligente());
    }
}
