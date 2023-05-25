package co.smart.procesador.skillsyservicios.workforceporhora.entidad;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name="workforce_hora")
public class EntidadSkillsWorkforceHora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_workforce_hora;
    private String skill_id;
    private String hour;
    private int inbound_calls;
    private int inbound_calls_unique_customers;
    private LocalTime aht;
    private int agents_needed;
    @Column(name = "fecha_carga")
    private LocalDate FECHA;

    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;


    public EntidadSkillsWorkforceHora() {

    }

    public EntidadSkillsWorkforceHora(String skill_id, String hour, int inbound_calls, int inbound_calls_unique_customers, LocalTime aht, int agents_needed, LocalDate FECHA, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
        this.skill_id = skill_id;
        this.hour = hour;
        this.inbound_calls = inbound_calls;
        this.inbound_calls_unique_customers = inbound_calls_unique_customers;
        this.aht = aht;
        this.agents_needed = agents_needed;
        this.FECHA = FECHA;
        this.fecha_inicio_carga = fecha_inicio_carga;
        this.fecha_fin_carga = fecha_fin_carga;
    }

    public Long getId_workforce_hora() {
        return Id_workforce_hora;
    }

    public void setId_workforce_hora(Long id_workforce_hora) {
        Id_workforce_hora = id_workforce_hora;
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

    public int getInbound_calls_unique_customers() {
        return inbound_calls_unique_customers;
    }

    public void setInbound_calls_unique_customers(int inbound_calls_unique_customers) {
        this.inbound_calls_unique_customers = inbound_calls_unique_customers;
    }

    public LocalTime getAht() {
        return aht;
    }

    public void setAht(LocalTime aht) {
        this.aht = aht;
    }

    public int getAgents_needed() {
        return agents_needed;
    }

    public void setAgents_needed(int agents_needed) {
        this.agents_needed = agents_needed;
    }

    public LocalDate getFECHA() {
        return FECHA;
    }

    public void setFECHA(LocalDate FECHA) {
        this.FECHA = FECHA;
    }
}
