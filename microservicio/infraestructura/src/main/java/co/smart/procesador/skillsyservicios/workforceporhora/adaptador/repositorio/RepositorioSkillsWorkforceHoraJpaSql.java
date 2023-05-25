package co.smart.procesador.skillsyservicios.workforceporhora.adaptador.repositorio;

import co.smart.procesador.skillsyservicios.workforceporhora.adaptador.MapperSkillsWorkforceHora;
import co.smart.procesador.skillsyservicios.workforceporhora.modelo.dominio.SkillsWorkforceHora;
import co.smart.procesador.skillsyservicios.workforceporhora.puerto.repositorio.RepositorioSkillsWorkforceHora;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RepositorioSkillsWorkforceHoraJpaSql implements RepositorioSkillsWorkforceHora {

    private final MapperSkillsWorkforceHora mapperSkillsWorkforceHora;
    private final RepositorioSkillsWorkforceHoraJpa repositorioSkillsWorkforceHoraJpa;

    public RepositorioSkillsWorkforceHoraJpaSql(MapperSkillsWorkforceHora mapperSkillsWorkforceHora, RepositorioSkillsWorkforceHoraJpa repositorioSkillsWorkforceHoraJpa) {
        this.mapperSkillsWorkforceHora = mapperSkillsWorkforceHora;
        this.repositorioSkillsWorkforceHoraJpa = repositorioSkillsWorkforceHoraJpa;
    }

    @Override
    public boolean guardar(SkillsWorkforceHora skillsWorkforceHora) {
        var entidadSkill= this.mapperSkillsWorkforceHora.crearEntity(skillsWorkforceHora);
        this.repositorioSkillsWorkforceHoraJpa.save(entidadSkill);
        return false;
    }



    @Override
    public boolean guardarArray(List<SkillsWorkforceHora> skillsWorkforceHoras) {
        var listaEntidadSkill= this.mapperSkillsWorkforceHora.convertirDominioAEntidad(skillsWorkforceHoras);
        this.repositorioSkillsWorkforceHoraJpa.saveAll(listaEntidadSkill);
        return true;
    }

    @Override
    public boolean existe(LocalDate fecha) {
        var entidadSkillsWorkforceHoras = this.repositorioSkillsWorkforceHoraJpa.consultarSiExisteRegistroHoy(fecha.toString());
        if (entidadSkillsWorkforceHoras == null || entidadSkillsWorkforceHoras.size() == 0) {
            return false;
        }
        return true;
    }


}
