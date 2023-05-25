package co.smart.procesador.datos.adaptador;

import co.smart.procesador.datos.entidad.EntidadToken;
import co.smart.procesador.datos.modelo.dto.Datos;

import org.springframework.stereotype.Component;

@Component

public class MapperDatos {

    private final AES Aes;

    private String secretKey = "ccoakey123456789";



    public MapperDatos(AES aes) {
        Aes = aes;
    }


    public EntidadToken crearEntidad(Datos datos){
        return new EntidadToken(
                this.Aes.encrypt(datos.getToken(), secretKey),
                datos.getIp_server(),
                datos.getCorreo(),
                datos.getCorreo2(),
                datos.getCorreo3()
        );
    }

    public Datos crearDominio(EntidadToken entidadToken){
        return new Datos(
                this.Aes.decrypt(entidadToken.getToken(),secretKey),
                entidadToken.getIp_server(),
                entidadToken.getCorreo(),
                entidadToken.getCorreo2(),
                entidadToken.getCorreo3()
        );
    }
}
