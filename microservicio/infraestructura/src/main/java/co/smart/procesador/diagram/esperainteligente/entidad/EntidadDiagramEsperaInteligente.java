package co.smart.procesador.diagram.esperainteligente.entidad;

import co.smart.procesador.diagram.detalleesperainteligente.entidad.EntidadDiagramDetalleEsperaInteligente;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="diagram_espera_inteligente")
public class EntidadDiagramEsperaInteligente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_espera_inteligente;
    private String skill_id;
    private int treatment;
    private int customer_say_no;
    private int customer_say_yes;
    private int recall_fail;
    private int recall_ok;
    private String service_level_up;
    @Column(name = "fecha_carga")
    private LocalDate FECHA;

    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;


    public EntidadDiagramEsperaInteligente() {

    }

    public EntidadDiagramEsperaInteligente(String skill_id, int treatment, int customer_say_no, int customer_say_yes, int recall_fail, int recall_ok, String service_level_up, LocalDate FECHA, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
        this.skill_id = skill_id;
        this.treatment = treatment;
        this.customer_say_no = customer_say_no;
        this.customer_say_yes = customer_say_yes;
        this.recall_fail = recall_fail;
        this.recall_ok = recall_ok;
        this.service_level_up = service_level_up;
        this.FECHA = FECHA;
        this.fecha_inicio_carga = fecha_inicio_carga;
        this.fecha_fin_carga = fecha_fin_carga;
    }

    public Long getId_espera_inteligente() {
        return Id_espera_inteligente;
    }

    public void setId_espera_inteligente(Long id_espera_inteligente) {
        Id_espera_inteligente = id_espera_inteligente;
    }

    public String getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(String skill_id) {
        this.skill_id = skill_id;
    }

    public int getTreatment() {
        return treatment;
    }

    public void setTreatment(int treatment) {
        this.treatment = treatment;
    }

    public int getCustomer_say_no() {
        return customer_say_no;
    }

    public void setCustomer_say_no(int customer_say_no) {
        this.customer_say_no = customer_say_no;
    }

    public int getCustomer_say_yes() {
        return customer_say_yes;
    }

    public void setCustomer_say_yes(int customer_say_yes) {
        this.customer_say_yes = customer_say_yes;
    }

    public int getRecall_fail() {
        return recall_fail;
    }

    public void setRecall_fail(int recall_fail) {
        this.recall_fail = recall_fail;
    }

    public int getRecall_ok() {
        return recall_ok;
    }

    public void setRecall_ok(int recall_ok) {
        this.recall_ok = recall_ok;
    }

    public String getService_level_up() {
        return service_level_up;
    }

    public void setService_level_up(String service_level_up) {
        this.service_level_up = service_level_up;
    }

    public LocalDate getFECHA() {
        return FECHA;
    }

    public void setFECHA(LocalDate FECHA) {
        this.FECHA = FECHA;
    }
}
