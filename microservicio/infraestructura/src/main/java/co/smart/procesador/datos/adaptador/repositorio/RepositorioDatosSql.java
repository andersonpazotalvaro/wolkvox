package co.smart.procesador.datos.adaptador.repositorio;

import co.smart.procesador.datos.adaptador.MapperDatos;
import co.smart.procesador.datos.entidad.EntidadToken;
import co.smart.procesador.datos.modelo.dto.Datos;
import co.smart.procesador.datos.puerto.repositorio.RepositorioDatos;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioDatosSql implements RepositorioDatos {

    private final MapperDatos mapperDatos;

    private final RepositorioDatosJpa repositorioDatosJpa;

    public RepositorioDatosSql(MapperDatos mapperDatos, RepositorioDatosJpa repositorioDatosJpa) {
        this.mapperDatos = mapperDatos;
        this.repositorioDatosJpa = repositorioDatosJpa;
    }


    @Override
    public Datos consultar() {
        EntidadToken entidadToken = this.repositorioDatosJpa.selectFirstRow();
        Datos datos = this.mapperDatos.crearDominio(entidadToken);
        return datos;
    }

    @Override
    public boolean guardar(Datos datos) {
        var entidad = this.mapperDatos.crearEntidad(datos);
        if(this.repositorioDatosJpa.existsById(1L)){
            this.repositorioDatosJpa.updateFirstRow(entidad.getToken(),entidad.getIp_server(), entidad.getCorreo(), entidad.getCorreo2(), entidad.getCorreo3());
        }else{
            this.repositorioDatosJpa.saveFirstRow(entidad.getToken().toString(),entidad.getIp_server().toString(), entidad.getCorreo().toString(), entidad.getCorreo2().toString(), entidad.getCorreo3().toString());
        }

        return true;
    }

    @Override
    public boolean existePorId(Long id) {
        return this.repositorioDatosJpa.findById(id) != null;
    }
}
