package co.smart.procesador.datos.puerto.repositorio;

import co.smart.procesador.datos.modelo.dto.Datos;

public interface RepositorioDatos {

    Datos consultar();

    boolean guardar(Datos datos);

    boolean existePorId(Long id);
}
