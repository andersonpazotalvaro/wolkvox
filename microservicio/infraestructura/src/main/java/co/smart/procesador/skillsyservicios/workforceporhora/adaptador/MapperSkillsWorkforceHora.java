package co.smart.procesador.skillsyservicios.workforceporhora.adaptador;

import co.smart.procesador.skillsyservicios.workforceporhora.entidad.EntidadSkillsWorkforceHora;
import co.smart.procesador.skillsyservicios.workforceporhora.modelo.dominio.SkillsWorkforceHora;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperSkillsWorkforceHora {



    public EntidadSkillsWorkforceHora crearEntity(SkillsWorkforceHora skillsWorkforceHora){
        return new EntidadSkillsWorkforceHora(
                skillsWorkforceHora.getSkill_id(),
                skillsWorkforceHora.getHour(),
                skillsWorkforceHora.getInbound_calls(),
                skillsWorkforceHora.getInbound_calls_unique_customers(),
                skillsWorkforceHora.getAht(),
                skillsWorkforceHora.getAgents_needed(),
                skillsWorkforceHora.getFECHA(),
                skillsWorkforceHora.getFecha_inicio_carga(),
                skillsWorkforceHora.getFecha_fin_carga()

        );
    }

    public List<EntidadSkillsWorkforceHora> convertirDominioAEntidad(List<SkillsWorkforceHora> skillsWorkforceHoras){
        var listaEntidadSkill = new ArrayList<EntidadSkillsWorkforceHora>();

        skillsWorkforceHoras.forEach(skillsWorkforceHora  -> {
            listaEntidadSkill.add(this.crearEntity(skillsWorkforceHora));

        });
        return listaEntidadSkill;
    }
}
