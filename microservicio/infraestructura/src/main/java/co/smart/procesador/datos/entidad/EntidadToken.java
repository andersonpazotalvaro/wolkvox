package co.smart.procesador.datos.entidad;

import javax.persistence.*;

@Entity
@Table(name="datos")
public class EntidadToken {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

    private String token;

    private String ip_server;
    private String correo;
    private String correo2;
    private String correo3;

    public String getCorreo2() {
        return correo2;
    }

    public void setCorreo2(String correo2) {
        this.correo2 = correo2;
    }

    public String getCorreo3() {
        return correo3;
    }

    public void setCorreo3(String correo3) {
        this.correo3 = correo3;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public EntidadToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return Id;
    }

    public String getToken() {
        return token;
    }

    public EntidadToken(Long id, String token) {
        Id = id;
        this.token = token;
    }

    public EntidadToken() {
    }

    public String getIp_server() {
        return ip_server;
    }

    public EntidadToken(String token, String ip_server, String correo, String correo2, String correo3) {
        this.token = token;
        this.ip_server = ip_server;
        this.correo = correo;
        this.correo2 = correo2;
        this.correo3 = correo3;
    }
}
