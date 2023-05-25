package co.smart.procesador.datos.consulta;

import co.smart.procesador.datos.modelo.dto.Datos;
import co.smart.procesador.datos.servicio.ServicioConsultarDatos;
import org.springframework.stereotype.Component;

@Component
public class ConsultaDatos {

    private final ServicioConsultarDatos servicioConsultarDatos;

    public ConsultaDatos(ServicioConsultarDatos servicioConsultarDatos) {
        this.servicioConsultarDatos = servicioConsultarDatos;
    }

    public Datos ejecutar(){

        return this.servicioConsultarDatos.consultar();
    }
}
