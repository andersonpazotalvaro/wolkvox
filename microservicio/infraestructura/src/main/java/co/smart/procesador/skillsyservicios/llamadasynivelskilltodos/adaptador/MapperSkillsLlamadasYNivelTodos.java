package co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.adaptador;

import co.smart.procesador.diagram.encuestainteligenteporskill.entidad.EntidadDiagramEncuestaInteligenteSkill;
import co.smart.procesador.diagram.encuestainteligenteporskill.modelo.dominio.DiagramEncuestaInteligenteSkill;
import co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.entidad.EntidadSkillsLlamadasYNivelTodos;
import co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.modelo.dominio.SkillsLlamadasYNivelTodos;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperSkillsLlamadasYNivelTodos {



    public EntidadSkillsLlamadasYNivelTodos crearEntity(SkillsLlamadasYNivelTodos skillsLlamadasYNivelTodos){
        return new EntidadSkillsLlamadasYNivelTodos(
                skillsLlamadasYNivelTodos.getSkill_name(),
                skillsLlamadasYNivelTodos.getSkill_id(),
                skillsLlamadasYNivelTodos.getInbound_calls(),
                skillsLlamadasYNivelTodos.getAnswer_calls(),
                skillsLlamadasYNivelTodos.getAbandon_calls(),
                skillsLlamadasYNivelTodos.getService_level_10seg(),
                skillsLlamadasYNivelTodos.getService_level_20seg(),
                skillsLlamadasYNivelTodos.getService_level_30seg(),
                skillsLlamadasYNivelTodos.getAbandon(),
                skillsLlamadasYNivelTodos.getAsa(),
                skillsLlamadasYNivelTodos.getAta(),
                skillsLlamadasYNivelTodos.getFECHA(),
                skillsLlamadasYNivelTodos.getFecha_inicio_carga(),
                skillsLlamadasYNivelTodos.getFecha_fin_carga()

        );
    }

    public List<EntidadSkillsLlamadasYNivelTodos> convertirDominioAEntidad(List<SkillsLlamadasYNivelTodos> skillsLlamadasYNivelTodos){
        var listaEntidadSkill = new ArrayList<EntidadSkillsLlamadasYNivelTodos>();

        skillsLlamadasYNivelTodos.forEach(skillsLlamadasYNivelTodos1 -> {
            listaEntidadSkill.add(this.crearEntity(skillsLlamadasYNivelTodos1));

        });
        return listaEntidadSkill;
    }
}
