package co.smart.procesador.skillsyservicios.detallellamadascontestadas.adaptador.repositorio;

import co.smart.procesador.skillsyservicios.detallellamadascontestadas.adaptador.MapperSkillsDetallesLlamadasContestadas;
import co.smart.procesador.skillsyservicios.detallellamadascontestadas.modelo.dominio.SkillsDetalleLlamadasContestadas;
import co.smart.procesador.skillsyservicios.detallellamadascontestadas.puerto.repositorio.RepositorioSkillsDetalleLlamadasContestadas;
import co.smart.procesador.skillsyservicios.detallesllamadasabandonadas.modelo.dominio.SkillsDetalleLlamadasAbandonadas;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RepositorioSkillsDetalleLlamadasContestadasJpaSql implements RepositorioSkillsDetalleLlamadasContestadas {

    private final MapperSkillsDetallesLlamadasContestadas mapperSkillsDetallesLlamadasContestadas;
    private final RepositorioSkillsDetalleLlamadasContestadasJpa repositorioSkillsDetalleLlamadasContestadasJpa;

    public RepositorioSkillsDetalleLlamadasContestadasJpaSql(MapperSkillsDetallesLlamadasContestadas mapperSkillsDetallesLlamadasContestadas, RepositorioSkillsDetalleLlamadasContestadasJpa repositorioSkillsDetalleLlamadasContestadasJpa) {
        this.mapperSkillsDetallesLlamadasContestadas = mapperSkillsDetallesLlamadasContestadas;
        this.repositorioSkillsDetalleLlamadasContestadasJpa = repositorioSkillsDetalleLlamadasContestadasJpa;
    }


    @Override
    public boolean guardar(SkillsDetalleLlamadasContestadas skillsDetalleLlamadasContestadas) {
        var entidadSkill= this.mapperSkillsDetallesLlamadasContestadas.crearEntity(skillsDetalleLlamadasContestadas);
        this.repositorioSkillsDetalleLlamadasContestadasJpa.save(entidadSkill);
        return false;
    }



    @Override
    public boolean guardarArray(List<SkillsDetalleLlamadasContestadas> skillsDetalleLlamadasContestadas) {
        var listaEntidadSkill= this.mapperSkillsDetallesLlamadasContestadas.convertirDominioAEntidad(skillsDetalleLlamadasContestadas);
        this.repositorioSkillsDetalleLlamadasContestadasJpa.saveAll(listaEntidadSkill);
        return true;
    }

    @Override
    public boolean existe(LocalDate fecha) {
        var entidadSkillsDetalleLlamadasContestadas = this.repositorioSkillsDetalleLlamadasContestadasJpa.consultarSiExisteRegistroHoy(fecha.toString());
        if (entidadSkillsDetalleLlamadasContestadas == null || entidadSkillsDetalleLlamadasContestadas.size() == 0) {
            return false;
        }
        return true;
    }


}
