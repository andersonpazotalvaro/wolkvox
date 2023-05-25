package co.smart.procesador.skillsyservicios.detallellamadascontestadas.adaptador;

import co.smart.procesador.skillsyservicios.detallellamadascontestadas.entidad.EntidadSkillsDetalleLlamadasContestadas;
import co.smart.procesador.skillsyservicios.detallellamadascontestadas.modelo.dominio.SkillsDetalleLlamadasContestadas;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperSkillsDetallesLlamadasContestadas {



    public EntidadSkillsDetalleLlamadasContestadas crearEntity(SkillsDetalleLlamadasContestadas skillsDetalleLlamadasContestadas){
        return new EntidadSkillsDetalleLlamadasContestadas(
                skillsDetalleLlamadasContestadas.getConn_id(),
                skillsDetalleLlamadasContestadas.getSkill_id(),
                skillsDetalleLlamadasContestadas.getSkill_name(),
                skillsDetalleLlamadasContestadas.getDate(),
                skillsDetalleLlamadasContestadas.getResult(),
                skillsDetalleLlamadasContestadas.getAni(),
                skillsDetalleLlamadasContestadas.getAnswer_time(),
                skillsDetalleLlamadasContestadas.getAgent_id(),
                skillsDetalleLlamadasContestadas.getType_interaction(),
                skillsDetalleLlamadasContestadas.getFECHA(),
                skillsDetalleLlamadasContestadas.getFecha_inicio_carga(),
                skillsDetalleLlamadasContestadas.getFecha_fin_carga()

        );
    }

    public List<EntidadSkillsDetalleLlamadasContestadas> convertirDominioAEntidad(List<SkillsDetalleLlamadasContestadas> skillsDetalleLlamadasContestadas){
        var listaEntidadSkill = new ArrayList<EntidadSkillsDetalleLlamadasContestadas>();

        skillsDetalleLlamadasContestadas.forEach(skillsDetalleLlamadasContestadas1  -> {
            listaEntidadSkill.add(this.crearEntity(skillsDetalleLlamadasContestadas1));

        });
        return listaEntidadSkill;
    }
}
