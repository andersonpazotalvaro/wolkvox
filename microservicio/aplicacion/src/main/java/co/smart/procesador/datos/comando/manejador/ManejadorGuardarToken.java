package co.smart.procesador.datos.comando.manejador;

import co.smart.procesador.datos.comando.RequestDatos;
import co.smart.procesador.datos.comando.fabrica.FabricaDatos;
import co.smart.procesador.datos.servicio.ServicioGuardarDatos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class ManejadorGuardarToken {
    private static final String SE_ACTUALIZO_TOKEN = "Se Actualizo El Token";

    private final FabricaDatos fabricaDatos;
    private final ServicioGuardarDatos servicioGuardarDatos;

    public String ejecutar(RequestDatos requestDatos){

        var token = this.fabricaDatos.crear(requestDatos);
        this.servicioGuardarDatos.ejecutar(token);

        return SE_ACTUALIZO_TOKEN;
    }

}
