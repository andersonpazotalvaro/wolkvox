package co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.entidad;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="llamadas_y_nivel_servicio_hora")
public class EntidadSkillsLlamadasYNivelServicioHora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_llamadas_y_nivel_servicio_hora;
    private String skill_id;
    private String hour;
    private int inbound_calls;
    private int answer_calls;
    private int abandon_calls;
    private String service_level_10seg;
    private String service_level_20seg;
    private String service_level_30seg;
    private String abandon;
    private String aht;
    private String ata;
    @Column(name = "fecha_carga")
    private LocalDate FECHA;

    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;



    public EntidadSkillsLlamadasYNivelServicioHora() {

    }


    public EntidadSkillsLlamadasYNivelServicioHora(String skill_id, String hour, int inbound_calls, int answer_calls, int abandon_calls, String service_level_10seg, String service_level_20seg, String service_level_30seg, String abandon, String aht, String ata, LocalDate FECHA, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
        this.skill_id = skill_id;
        this.hour = hour;
        this.inbound_calls = inbound_calls;
        this.answer_calls = answer_calls;
        this.abandon_calls = abandon_calls;
        this.service_level_10seg = service_level_10seg;
        this.service_level_20seg = service_level_20seg;
        this.service_level_30seg = service_level_30seg;
        this.abandon = abandon;
        this.aht = aht;
        this.ata = ata;
        this.FECHA = FECHA;
        this.fecha_inicio_carga = fecha_inicio_carga;
        this.fecha_fin_carga = fecha_fin_carga;
    }

    public Long getId_llamadas_y_nivel_servicio_hora() {
        return Id_llamadas_y_nivel_servicio_hora;
    }

    public void setId_llamadas_y_nivel_servicio_hora(Long id_llamadas_y_nivel_servicio_hora) {
        Id_llamadas_y_nivel_servicio_hora = id_llamadas_y_nivel_servicio_hora;
    }

    public String getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(String skill_id) {
        this.skill_id = skill_id;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getInbound_calls() {
        return inbound_calls;
    }

    public void setInbound_calls(int inbound_calls) {
        this.inbound_calls = inbound_calls;
    }

    public int getAnswer_calls() {
        return answer_calls;
    }

    public void setAnswer_calls(int answer_calls) {
        this.answer_calls = answer_calls;
    }

    public int getAbandon_calls() {
        return abandon_calls;
    }

    public void setAbandon_calls(int abandon_calls) {
        this.abandon_calls = abandon_calls;
    }

    public String getService_level_10seg() {
        return service_level_10seg;
    }

    public void setService_level_10seg(String service_level_10seg) {
        this.service_level_10seg = service_level_10seg;
    }

    public String getService_level_20seg() {
        return service_level_20seg;
    }

    public void setService_level_20seg(String service_level_20seg) {
        this.service_level_20seg = service_level_20seg;
    }

    public String getService_level_30seg() {
        return service_level_30seg;
    }

    public void setService_level_30seg(String service_level_30seg) {
        this.service_level_30seg = service_level_30seg;
    }

    public String getAbandon() {
        return abandon;
    }

    public void setAbandon(String abandon) {
        this.abandon = abandon;
    }

    public String getAht() {
        return aht;
    }

    public void setAht(String aht) {
        this.aht = aht;
    }

    public String getAta() {
        return ata;
    }

    public void setAta(String ata) {
        this.ata = ata;
    }

    public LocalDate getFecha() {
        return FECHA;
    }

    public void setFecha(LocalDate fecha) {
        this.FECHA = fecha;
    }
}
