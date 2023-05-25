package co.smart.procesador.datos.servicio;

import co.smart.procesador.datos.modelo.dto.Datos;
import co.smart.procesador.datos.puerto.repositorio.RepositorioDatos;
import org.springframework.stereotype.Service;

@Service
public class ServicioConsultarDatos {
    private static final String NO_SE_PUEDE_CONSULTAR = "No se pudo consultar el token";

    private final RepositorioDatos repositorioDatos;

    public ServicioConsultarDatos(RepositorioDatos repositorioDatos) {
        this.repositorioDatos = repositorioDatos;
    }

    public Datos consultar(){
        return this.repositorioDatos.consultar();
    }
}
