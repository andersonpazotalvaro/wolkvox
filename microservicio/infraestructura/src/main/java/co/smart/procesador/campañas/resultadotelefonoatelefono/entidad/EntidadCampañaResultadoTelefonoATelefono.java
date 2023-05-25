package co.smart.procesador.campañas.resultadotelefonoatelefono.entidad;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="campaña_resultado_telefono_a_telefono")
public class EntidadCampañaResultadoTelefonoATelefono {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id_resultado_telefono_a_telefono;
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
    @Column(name = "fecha_carga")
    private LocalDate FECHA;
    private LocalDate fecha_inicio_carga;
    private LocalDate fecha_fin_carga;



    public EntidadCampañaResultadoTelefonoATelefono() {

    }

    public EntidadCampañaResultadoTelefonoATelefono(String campaign_id, String customer_name, String customer_last_name, int customer_id, LocalDateTime date, String telephone, String result, String opt1, String opt2, String opt3, String opt4, String opt5, String opt6, String opt7, String opt8, String opt9, String opt10, String opt11, String opt12, String conn_id, String id_type, LocalDate FECHA, LocalDate fecha_inicio_carga, LocalDate fecha_fin_carga) {
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
        this.FECHA = FECHA;
        this.fecha_inicio_carga = fecha_inicio_carga;
        this.fecha_fin_carga = fecha_fin_carga;
    }

    public LocalDate getFecha_inicio_carga() {
        return fecha_inicio_carga;
    }

    public void setFecha_inicio_carga(LocalDate fecha_inicio_carga) {
        this.fecha_inicio_carga = fecha_inicio_carga;
    }

    public LocalDate getFecha_fin_carga() {
        return fecha_fin_carga;
    }

    public void setFecha_fin_carga(LocalDate fecha_fin_carga) {
        this.fecha_fin_carga = fecha_fin_carga;
    }

    public Long getId_resultado_telefono_a_telefono() {
        return Id_resultado_telefono_a_telefono;
    }

    public void setId_resultado_telefono_a_telefono(Long id_resultado_telefono_a_telefono) {
        Id_resultado_telefono_a_telefono = id_resultado_telefono_a_telefono;
    }

    public String getCampaign_id() {
        return campaign_id;
    }

    public void setCampaign_id(String campaign_id) {
        this.campaign_id = campaign_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_last_name() {
        return customer_last_name;
    }

    public void setCustomer_last_name(String customer_last_name) {
        this.customer_last_name = customer_last_name;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getOpt1() {
        return opt1;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }

    public String getOpt4() {
        return opt4;
    }

    public void setOpt4(String opt4) {
        this.opt4 = opt4;
    }

    public String getOpt5() {
        return opt5;
    }

    public void setOpt5(String opt5) {
        this.opt5 = opt5;
    }

    public String getOpt6() {
        return opt6;
    }

    public void setOpt6(String opt6) {
        this.opt6 = opt6;
    }

    public String getOpt7() {
        return opt7;
    }

    public void setOpt7(String opt7) {
        this.opt7 = opt7;
    }

    public String getOpt8() {
        return opt8;
    }

    public void setOpt8(String opt8) {
        this.opt8 = opt8;
    }

    public String getOpt9() {
        return opt9;
    }

    public void setOpt9(String opt9) {
        this.opt9 = opt9;
    }

    public String getOpt10() {
        return opt10;
    }

    public void setOpt10(String opt10) {
        this.opt10 = opt10;
    }

    public String getOpt11() {
        return opt11;
    }

    public void setOpt11(String opt11) {
        this.opt11 = opt11;
    }

    public String getOpt12() {
        return opt12;
    }

    public void setOpt12(String opt12) {
        this.opt12 = opt12;
    }

    public String getConn_id() {
        return conn_id;
    }

    public void setConn_id(String conn_id) {
        this.conn_id = conn_id;
    }

    public String getId_type() {
        return id_type;
    }

    public void setId_type(String id_type) {
        this.id_type = id_type;
    }

    public LocalDate getFECHA() {
        return FECHA;
    }

    public void setFECHA(LocalDate FECHA) {
        this.FECHA = FECHA;
    }
}
