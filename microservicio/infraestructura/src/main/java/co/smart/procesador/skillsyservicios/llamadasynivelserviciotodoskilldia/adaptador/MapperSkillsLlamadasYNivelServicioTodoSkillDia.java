package co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.adaptador;

import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.entidad.EntidadSkillsLlamadasYNivelServicioHora;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.modelo.dominio.SkillsLlamadasYNivelServicioHora;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.entidad.EntidadSkillsLlamadasYNivelServicioTodoSkillDia;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.modelo.dominio.SkillsLlamadasYNivelServicioTodoSkillDia;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperSkillsLlamadasYNivelServicioTodoSkillDia {



    public EntidadSkillsLlamadasYNivelServicioTodoSkillDia crearEntity(SkillsLlamadasYNivelServicioTodoSkillDia skillsLlamadasYNivelServicioTodoSkillDia){
        return new EntidadSkillsLlamadasYNivelServicioTodoSkillDia(
                skillsLlamadasYNivelServicioTodoSkillDia.getDate(),
                skillsLlamadasYNivelServicioTodoSkillDia.getSkill_id(),
                skillsLlamadasYNivelServicioTodoSkillDia.getSkill_name(),
                skillsLlamadasYNivelServicioTodoSkillDia.getHour(),
                skillsLlamadasYNivelServicioTodoSkillDia.getInbound_calls(),
                skillsLlamadasYNivelServicioTodoSkillDia.getAnswer_calls(),
                skillsLlamadasYNivelServicioTodoSkillDia.getAbandon_calls(),
                skillsLlamadasYNivelServicioTodoSkillDia.getService_level_10seg(),
                skillsLlamadasYNivelServicioTodoSkillDia.getService_level_20seg(),
                skillsLlamadasYNivelServicioTodoSkillDia.getService_level_30seg(),
                skillsLlamadasYNivelServicioTodoSkillDia.getWait_time(),
                skillsLlamadasYNivelServicioTodoSkillDia.getAbandon(),
                skillsLlamadasYNivelServicioTodoSkillDia.getAht(),
                skillsLlamadasYNivelServicioTodoSkillDia.getAsa(),
                skillsLlamadasYNivelServicioTodoSkillDia.getAta(),
                skillsLlamadasYNivelServicioTodoSkillDia.getFECHA(),
                skillsLlamadasYNivelServicioTodoSkillDia.getFecha_inicio_carga(),
                skillsLlamadasYNivelServicioTodoSkillDia.getFecha_fin_carga()

        );
    }

    public List<EntidadSkillsLlamadasYNivelServicioTodoSkillDia> convertirDominioAEntidad(List<SkillsLlamadasYNivelServicioTodoSkillDia> skillsLlamadasYNivelServicioTodoSkillDias){
        var listaEntidadSkill = new ArrayList<EntidadSkillsLlamadasYNivelServicioTodoSkillDia>();

        skillsLlamadasYNivelServicioTodoSkillDias.forEach(skillsLlamadasYNivelServicioTodoSkillDia -> {
            listaEntidadSkill.add(this.crearEntity(skillsLlamadasYNivelServicioTodoSkillDia));

        });
        return listaEntidadSkill;
    }
}
