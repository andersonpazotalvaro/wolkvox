package co.smart.procesador.skillsyservicios.detallellamadasabandonadas.adaptador.repositorio;

import co.smart.procesador.skillsyservicios.detallellamadasabandonadas.adaptador.MapperSkillsDetallesLlamadasAbandonadas;
import co.smart.procesador.skillsyservicios.detallesllamadasabandonadas.modelo.dominio.SkillsDetalleLlamadasAbandonadas;
import co.smart.procesador.skillsyservicios.detallesllamadasabandonadas.puerto.repositorio.RepositorioSkillsDetalleLlamadasAbandonadas;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RepositorioSkillsDetalleLlamadasAbandonadasJpaSql implements RepositorioSkillsDetalleLlamadasAbandonadas {

    private final MapperSkillsDetallesLlamadasAbandonadas mapperSkillsDetallesLlamadasAbandonadas;
    private final RepositorioSkillsDetalleLlamadasAbandonadasJpa repositorioSkillsDetalleLlamadasAbandonadasjpa;

    public RepositorioSkillsDetalleLlamadasAbandonadasJpaSql(MapperSkillsDetallesLlamadasAbandonadas mapperSkillsDetallesLlamadasAbandonadas, RepositorioSkillsDetalleLlamadasAbandonadasJpa repositorioSkillsDetalleLlamadasAbandonadasjpa) {
        this.mapperSkillsDetallesLlamadasAbandonadas = mapperSkillsDetallesLlamadasAbandonadas;
        this.repositorioSkillsDetalleLlamadasAbandonadasjpa = repositorioSkillsDetalleLlamadasAbandonadasjpa;
    }


    @Override
    public boolean guardar(SkillsDetalleLlamadasAbandonadas skillsDetalleLlamadasAbandonadas) {
        var entidadSkill= this.mapperSkillsDetallesLlamadasAbandonadas.crearEntity(skillsDetalleLlamadasAbandonadas);
        this.repositorioSkillsDetalleLlamadasAbandonadasjpa.save(entidadSkill);
        return false;
    }



    @Override
    public boolean guardarArray(List<SkillsDetalleLlamadasAbandonadas> skillsDetalleLlamadasAbandonadas) {
        var listaEntidadSkill= this.mapperSkillsDetallesLlamadasAbandonadas.convertirDominioAEntidad(skillsDetalleLlamadasAbandonadas);
        this.repositorioSkillsDetalleLlamadasAbandonadasjpa.saveAll(listaEntidadSkill);
        return true;
    }

    @Override
    public boolean existe(LocalDate fecha) {
        var entidadSkillsDetalleLlamadasAbandonadas = this.repositorioSkillsDetalleLlamadasAbandonadasjpa.consultarSiExisteRegistroHoy(fecha.toString());
        if (entidadSkillsDetalleLlamadasAbandonadas == null || entidadSkillsDetalleLlamadasAbandonadas.size() == 0) {
            return false;
        }
        return true;
    }


}
