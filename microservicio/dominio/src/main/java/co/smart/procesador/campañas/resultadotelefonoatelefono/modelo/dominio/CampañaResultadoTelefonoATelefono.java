package co.smart.procesador.campañas.resultadotelefonoatelefono.modelo.dominio;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class CampañaResultadoTelefonoATelefono {

    private String campaign_id;
    private String customer_name;
    private String customer_last_name;
    private int customer_id;
    private LocalDateTime date;
    private String telephone;
    private String result;
    private String opt1;
    private String opt2;
    private String opt3;
    private String opt4;
    private String opt5;
    private String opt6;
    private String opt7;
    private String opt8;
    private String opt9;
    private String opt10;
    private String opt11;
    private String opt12;
    private String  conn_id;
    private String id_type;
    private LocalDate FECHA= LocalDate.now();

    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;

    public CampañaResultadoTelefonoATelefono(String campaign_id, String customer_name, String customer_last_name, int customer_id, LocalDateTime date, String telephone, String result, String opt1, String opt2, String opt3, String opt4, String opt5, String opt6, String opt7, String opt8, String opt9, String opt10, String opt11, String opt12, String conn_id, String id_type, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
        this.campaign_id = campaign_id;
        this.customer_name = customer_name;
        this.customer_last_name = customer_last_name;
        this.customer_id = customer_id;
        this.date = date;
        this.telephone = telephone;
        this.result = result;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.opt4 = opt4;
        this.opt5 = opt5;
        this.opt6 = opt6;
        this.opt7 = opt7;
        this.opt8 = opt8;
        this.opt9 = opt9;
        this.opt10 = opt10;
        this.opt11 = opt11;
        this.opt12 = opt12;
        this.conn_id = conn_id;
        this.id_type = id_type;
        this.fecha_inicio_carga = fecha_inicio_carga;
        this.fecha_fin_carga = fecha_fin_carga;
    }
}
