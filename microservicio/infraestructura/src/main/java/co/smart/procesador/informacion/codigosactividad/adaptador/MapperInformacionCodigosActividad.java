package co.smart.procesador.informacion.codigosactividad.adaptador;

import co.smart.procesador.informacion.codigosactividad.entidad.EntidadInformacionCodigosActividad;
import co.smart.procesador.informacion.codigosactividad.modelo.dominio.InformacionCodigosActividad;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperInformacionCodigosActividad {



    public EntidadInformacionCodigosActividad crearEntity(InformacionCodigosActividad informacionCodigosActividad){
        return new EntidadInformacionCodigosActividad(
                informacionCodigosActividad.getCod_act(),
                informacionCodigosActividad.getDescription_cod_act(),
                informacionCodigosActividad.getHit(),
                informacionCodigosActividad.getRpc(),
                informacionCodigosActividad.getChat(),
                informacionCodigosActividad.getType_code(),
                informacionCodigosActividad.getFECHA()
        );
    }

    public List<EntidadInformacionCodigosActividad> convertirDominioAEntidad(List<InformacionCodigosActividad> informacionCodigosActividads){
        var listaEntidadInteracciones = new ArrayList<EntidadInformacionCodigosActividad>();

        informacionCodigosActividads.forEach(informacionSkills1 -> {
            listaEntidadInteracciones.add(this.crearEntity(informacionSkills1));

        });
        return listaEntidadInteracciones;
    }
}
