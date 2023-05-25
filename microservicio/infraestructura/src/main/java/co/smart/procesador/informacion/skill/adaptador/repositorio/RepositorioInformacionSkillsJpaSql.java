package co.smart.procesador.informacion.skill.adaptador.repositorio;

import co.smart.procesador.informacion.skill.adaptador.MapperInformacionSkills;
import co.smart.procesador.informacion.skill.modelo.dominio.InformacionSkills;
import co.smart.procesador.informacion.skill.puerto.repositorio.RepositorioInformacionsSkills;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RepositorioInformacionSkillsJpaSql implements RepositorioInformacionsSkills {

    private final MapperInformacionSkills mapperInformacionSkills;
    private final RepositorioInformacionSkillsJpa repositorioInformacionSkillsJpa;

    public RepositorioInformacionSkillsJpaSql(MapperInformacionSkills mapperInformacionSkills, RepositorioInformacionSkillsJpa repositorioInformacionSkillsJpa) {
        this.mapperInformacionSkills = mapperInformacionSkills;
        this.repositorioInformacionSkillsJpa = repositorioInformacionSkillsJpa;
    }

    @Override
    public boolean guardar(InformacionSkills informacionSkills) {
        var entidadSkill= this.mapperInformacionSkills.crearEntity(informacionSkills);
        this.repositorioInformacionSkillsJpa.save(entidadSkill);
        return false;
    }


    @Override
    public boolean guardarArray(List<InformacionSkills> informacionSkills) {
        var listaEntidadInteracciones= this.mapperInformacionSkills.convertirDominioAEntidad(informacionSkills);
        this.repositorioInformacionSkillsJpa.saveAll(listaEntidadInteracciones);
        return true;
    }

    @Override
    public boolean existe(LocalDate fecha) {
        var entidadInformacionSkills = this.repositorioInformacionSkillsJpa.consultarSiExisteRegistroHoy(fecha.toString());
        if (entidadInformacionSkills == null || entidadInformacionSkills.size() == 0) {
            return false;
        }
        return true;
    }


}
