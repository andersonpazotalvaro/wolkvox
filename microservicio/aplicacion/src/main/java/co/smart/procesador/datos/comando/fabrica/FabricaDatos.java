package co.smart.procesador.datos.comando.fabrica;

import co.smart.procesador.datos.comando.RequestDatos;
import co.smart.procesador.datos.modelo.dto.Datos;
import org.springframework.stereotype.Component;

@Component
public class FabricaDatos {

    public Datos crear(RequestDatos requestDatos){
        return new Datos(requestDatos.getToken(),
                requestDatos.getIp_server(),
                requestDatos.getCorreo(),
                requestDatos.getCorreo2(),
                requestDatos.getCorreo3()
        );
    }

}
