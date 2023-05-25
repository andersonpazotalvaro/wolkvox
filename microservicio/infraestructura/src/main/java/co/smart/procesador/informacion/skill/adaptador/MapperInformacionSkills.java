package co.smart.procesador.informacion.skill.adaptador;

import co.smart.procesador.informacion.skill.entidad.EntidadInformacionSkills;
import co.smart.procesador.informacion.skill.modelo.dominio.InformacionSkills;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperInformacionSkills {



    public EntidadInformacionSkills crearEntity(InformacionSkills informacionSkills){
        return new EntidadInformacionSkills(
                informacionSkills.getSkill_id(),
                informacionSkills.getSkill_name(),
                informacionSkills.getSkill_description(),
                informacionSkills.getLast_use(),
                informacionSkills.getFECHA()
        );
    }

    public List<EntidadInformacionSkills> convertirDominioAEntidad(List<InformacionSkills> informacionSkills){
        var listaEntidadInteracciones = new ArrayList<EntidadInformacionSkills>();

        informacionSkills.forEach(informacionSkills1 -> {
            listaEntidadInteracciones.add(this.crearEntity(informacionSkills1));

        });
        return listaEntidadInteracciones;
    }
}
