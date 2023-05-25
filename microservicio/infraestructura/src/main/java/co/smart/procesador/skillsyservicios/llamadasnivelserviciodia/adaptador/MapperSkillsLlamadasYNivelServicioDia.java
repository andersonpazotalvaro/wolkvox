package co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.adaptador;

import co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.entidad.EntidadSkillsLlamadasYNivelServicioDia;
import co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.modelo.dominio.SkillsLlamadasYNivelServicioDia;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperSkillsLlamadasYNivelServicioDia {



    public EntidadSkillsLlamadasYNivelServicioDia crearEntity(SkillsLlamadasYNivelServicioDia skillsLlamadasYNivelServicioDia){
        return new EntidadSkillsLlamadasYNivelServicioDia(
                skillsLlamadasYNivelServicioDia.getSkill_name(),
                skillsLlamadasYNivelServicioDia.getDay(),
                skillsLlamadasYNivelServicioDia.getInbound_calls(),
                skillsLlamadasYNivelServicioDia.getAnswer_calls(),
                skillsLlamadasYNivelServicioDia.getAbandon_calls(),
                skillsLlamadasYNivelServicioDia.getService_level_10seg(),
                skillsLlamadasYNivelServicioDia.getService_level_20seg(),
                skillsLlamadasYNivelServicioDia.getService_level_30seg(),
                skillsLlamadasYNivelServicioDia.getWait_time(),
                skillsLlamadasYNivelServicioDia.getAbandon(),
                skillsLlamadasYNivelServicioDia.getAsa(),
                skillsLlamadasYNivelServicioDia.getAta(),
                skillsLlamadasYNivelServicioDia.getAht(),
                skillsLlamadasYNivelServicioDia.getFECHA(),
                skillsLlamadasYNivelServicioDia.getFecha_inicio_carga(),
                skillsLlamadasYNivelServicioDia.getFecha_fin_carga()


        );
    }

    public List<EntidadSkillsLlamadasYNivelServicioDia> convertirDominioAEntidad(List<SkillsLlamadasYNivelServicioDia> skillsLlamadasYNivelServicioDia){
        var listaEntidadSkill = new ArrayList<EntidadSkillsLlamadasYNivelServicioDia>();

        skillsLlamadasYNivelServicioDia.forEach(skillsLlamadasYNivelServicioDia1 -> {
            listaEntidadSkill.add(this.crearEntity(skillsLlamadasYNivelServicioDia1));

        });
        return listaEntidadSkill;
    }
}
