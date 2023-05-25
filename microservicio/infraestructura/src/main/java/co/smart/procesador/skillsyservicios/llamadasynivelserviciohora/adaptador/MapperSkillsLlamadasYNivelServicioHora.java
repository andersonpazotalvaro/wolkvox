package co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.adaptador;

import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.entidad.EntidadSkillsLlamadasYNivelServicioHora;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.modelo.dominio.SkillsLlamadasYNivelServicioHora;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperSkillsLlamadasYNivelServicioHora {



    public EntidadSkillsLlamadasYNivelServicioHora crearEntity(SkillsLlamadasYNivelServicioHora skillsLlamadasYNivelServicioHora){
        return new EntidadSkillsLlamadasYNivelServicioHora(
                skillsLlamadasYNivelServicioHora.getSkill_id(),
                skillsLlamadasYNivelServicioHora.getHour(),
                skillsLlamadasYNivelServicioHora.getInbound_calls(),
                skillsLlamadasYNivelServicioHora.getAnswer_calls(),
                skillsLlamadasYNivelServicioHora.getAbandon_calls(),
                skillsLlamadasYNivelServicioHora.getService_level_10seg(),
                skillsLlamadasYNivelServicioHora.getService_level_20seg(),
                skillsLlamadasYNivelServicioHora.getService_level_30seg(),
                skillsLlamadasYNivelServicioHora.getAbandon(),
                skillsLlamadasYNivelServicioHora.getAht(),
                skillsLlamadasYNivelServicioHora.getAta(),
                skillsLlamadasYNivelServicioHora.getFECHA(),
                skillsLlamadasYNivelServicioHora.getFecha_inicio_carga(),
                skillsLlamadasYNivelServicioHora.getFecha_fin_carga()

        );
    }

    public List<EntidadSkillsLlamadasYNivelServicioHora> convertirDominioAEntidad(List<SkillsLlamadasYNivelServicioHora> skillsLlamadasYNivelServicioHoras){
        var listaEntidadSkill = new ArrayList<EntidadSkillsLlamadasYNivelServicioHora>();

        skillsLlamadasYNivelServicioHoras.forEach(skillsLlamadasYNivelServicioHora -> {
            listaEntidadSkill.add(this.crearEntity(skillsLlamadasYNivelServicioHora));

        });
        return listaEntidadSkill;
    }
}
