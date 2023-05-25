package co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.modelo.dominio;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class SkillsLlamadasYNivelServicioDia {

    private String skill_name;
    private LocalDate day;
    private int inbound_calls;
    private int answer_calls;
    private int abandon_calls;
    private String service_level_10seg;
    private String service_level_20seg;
    private String service_level_30seg;
    private String wait_time;
    private String abandon;
    private String asa;
    private String ata;
    private String aht;
    private LocalDate FECHA= LocalDate.now();
    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;

    public SkillsLlamadasYNivelServicioDia(String skill_name, LocalDate day, int inbound_calls, int answer_calls, int abandon_calls, String service_level_10seg, String service_level_20seg, String service_level_30seg, String wait_time, String abandon, String asa, String ata, String aht, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
        this.skill_name = skill_name;
        this.day = day;
        this.inbound_calls = inbound_calls;
        this.answer_calls = answer_calls;
        this.abandon_calls = abandon_calls;
        this.service_level_10seg = service_level_10seg;
        this.service_level_20seg = service_level_20seg;
        this.service_level_30seg = service_level_30seg;
        this.wait_time = wait_time;
        this.abandon = abandon;
        this.asa = asa;
        this.ata = ata;
        this.aht = aht;
        this.fecha_inicio_carga = fecha_inicio_carga;
        this.fecha_fin_carga = fecha_fin_carga;
    }
}
