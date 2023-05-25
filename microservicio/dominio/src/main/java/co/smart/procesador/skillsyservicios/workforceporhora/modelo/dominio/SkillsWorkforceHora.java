package co.smart.procesador.skillsyservicios.workforceporhora.modelo.dominio;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
public class SkillsWorkforceHora {

    private String skill_id;
    private String hour;
    private int inbound_calls;
    private int inbound_calls_unique_customers;
    private LocalTime aht;
    private int agents_needed;
    private LocalDate FECHA= LocalDate.now();
    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;

    public SkillsWorkforceHora(String skill_id, String hour, int inbound_calls, int inbound_calls_unique_customers, LocalTime aht, int agents_needed, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
        this.skill_id = skill_id;
        this.hour = hour;
        this.inbound_calls = inbound_calls;
        this.inbound_calls_unique_customers = inbound_calls_unique_customers;
        this.aht = aht;
        this.agents_needed = agents_needed;
        this.fecha_inicio_carga = fecha_inicio_carga;
        this.fecha_fin_carga = fecha_fin_carga;
    }
}
