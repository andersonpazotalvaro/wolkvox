package co.smart.procesador.diagram.detalleesperainteligente.entidad;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "diagram_composite")
public class CompositeEntityDiagram {
    @EmbeddedId
    private Id_detalle_espera_inteligente id;

    private LocalDate fecha_carga;


    public CompositeEntityDiagram(Id_detalle_espera_inteligente id, LocalDate fecha_carga) {
        this.id = id;
        this.fecha_carga = LocalDate.now();
    }

    public CompositeEntityDiagram() {
        this.fecha_carga = LocalDate.now();
    }

    public CompositeEntityDiagram(LocalDate fecha_carga) {
        this.fecha_carga = fecha_carga;
    }

    public Id_detalle_espera_inteligente getId() {
        return id;
    }

    public void setId(Id_detalle_espera_inteligente id) {
        this.id = id;
    }

    public LocalDate getFecha_carga() {
        return fecha_carga;
    }

    public void setFecha_carga(LocalDate fecha_carga) {
        this.fecha_carga = fecha_carga;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompositeEntityDiagram that)) return false;
        return getId().equals(that.getId()) && getFecha_carga().equals(that.getFecha_carga());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFecha_carga());
    }
}
