package co.smart.procesador.datos.comando;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestDatos {

    private String token;

    private String ip_server;
    private String correo;
    private String correo2;
    private String correo3;

}
