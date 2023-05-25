package co.smart.procesador.skillsyservicios.detallellamadasabandonadas.adaptador;

import co.smart.procesador.skillsyservicios.detallellamadasabandonadas.entidad.EntidadSkillsDetalleLlamadasAbandonadas;
import co.smart.procesador.skillsyservicios.detallesllamadasabandonadas.modelo.dominio.SkillsDetalleLlamadasAbandonadas;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperSkillsDetallesLlamadasAbandonadas {



    public EntidadSkillsDetalleLlamadasAbandonadas crearEntity(SkillsDetalleLlamadasAbandonadas skillsDetalleLlamadasAbandonadas){
        return new EntidadSkillsDetalleLlamadasAbandonadas(
                skillsDetalleLlamadasAbandonadas.getSkill_name(),
                skillsDetalleLlamadasAbandonadas.getSkill_id(),
                skillsDetalleLlamadasAbandonadas.getConn_id(),
                skillsDetalleLlamadasAbandonadas.getDate(),
                skillsDetalleLlamadasAbandonadas.getResult(),
                skillsDetalleLlamadasAbandonadas.getAni(),
                skillsDetalleLlamadasAbandonadas.getAbandon_time(),
                skillsDetalleLlamadasAbandonadas.getType_interaction(),
                skillsDetalleLlamadasAbandonadas.getCustomer_id(),
                skillsDetalleLlamadasAbandonadas.getFECHA(),
                skillsDetalleLlamadasAbandonadas.getFecha_inicio_carga(),
                skillsDetalleLlamadasAbandonadas.getFecha_fin_carga()

        );
    }

    public List<EntidadSkillsDetalleLlamadasAbandonadas> convertirDominioAEntidad(List<SkillsDetalleLlamadasAbandonadas> skillsDetalleLlamadasAbandonadas){
        var listaEntidadSkill = new ArrayList<EntidadSkillsDetalleLlamadasAbandonadas>();

        skillsDetalleLlamadasAbandonadas.forEach(skillsDetalleLlamadasAbandonadas1 -> {
            listaEntidadSkill.add(this.crearEntity(skillsDetalleLlamadasAbandonadas1));

        });
        return listaEntidadSkill;
    }
}
