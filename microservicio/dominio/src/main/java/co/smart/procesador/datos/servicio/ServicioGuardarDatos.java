package co.smart.procesador.datos.servicio;

import co.smart.procesador.datos.modelo.dto.Datos;
import co.smart.procesador.datos.puerto.repositorio.RepositorioDatos;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarDatos {

    private static final String NO_SE_PUEDE_ACTUALIZAR = "No se puede actualizar ya que el vehiculo no existe";

    private final RepositorioDatos repositorioDatos;

    public ServicioGuardarDatos(RepositorioDatos repositorioDatos) {
        this.repositorioDatos = repositorioDatos;
    }


    public boolean ejecutar(Datos datos){
        return this.repositorioDatos.guardar(datos);
    }
}
