package co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.adaptador.repositorio;

import co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.adaptador.MapperSkillsLlamadasYNivelServicioTodoSkillDia;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.modelo.dominio.SkillsLlamadasYNivelServicioTodoSkillDia;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.puerto.repositorio.RepositorioSkillsLlamadasYNivelServicioTodoSkillDia;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RepositorioSkillsLlamadasYNivelServicioTodoSkillDiaJpaSql implements RepositorioSkillsLlamadasYNivelServicioTodoSkillDia {

    private final MapperSkillsLlamadasYNivelServicioTodoSkillDia mapperSkillsLlamadasYNivelServicioTodoSkillDia;
    private final RepositorioSkillsLlamadasYNivelServicioTodoSkillDiaJpa repositorioSkillsLlamadasYNivelServicioTodoSkillDiaJpa;

    public RepositorioSkillsLlamadasYNivelServicioTodoSkillDiaJpaSql(MapperSkillsLlamadasYNivelServicioTodoSkillDia mapperSkillsLlamadasYNivelServicioTodoSkillDia, RepositorioSkillsLlamadasYNivelServicioTodoSkillDiaJpa repositorioSkillsLlamadasYNivelServicioTodoSkillDiaJpa) {
        this.mapperSkillsLlamadasYNivelServicioTodoSkillDia = mapperSkillsLlamadasYNivelServicioTodoSkillDia;
        this.repositorioSkillsLlamadasYNivelServicioTodoSkillDiaJpa = repositorioSkillsLlamadasYNivelServicioTodoSkillDiaJpa;
    }


    @Override
    public boolean guardar(SkillsLlamadasYNivelServicioTodoSkillDia skillsLlamadasYNivelServicioTodoSkillDia) {
        var entidadSkill= this.mapperSkillsLlamadasYNivelServicioTodoSkillDia.crearEntity(skillsLlamadasYNivelServicioTodoSkillDia);
        this.repositorioSkillsLlamadasYNivelServicioTodoSkillDiaJpa.save(entidadSkill);
        return false;
    }



    @Override
    public boolean guardarArray(List<SkillsLlamadasYNivelServicioTodoSkillDia> skillsLlamadasYNivelServicioTodoSkillDias) {
        var listaEntidadSkill= this.mapperSkillsLlamadasYNivelServicioTodoSkillDia.convertirDominioAEntidad(skillsLlamadasYNivelServicioTodoSkillDias);
        this.repositorioSkillsLlamadasYNivelServicioTodoSkillDiaJpa.saveAll(listaEntidadSkill);
        return true;
    }

    @Override
    public boolean existe(LocalDate fecha) {
        var entidadSkillsLlamadasYNivelServicioTodoSkillDias = this.repositorioSkillsLlamadasYNivelServicioTodoSkillDiaJpa.consultarSiExisteRegistroHoy(fecha.toString());
        if (entidadSkillsLlamadasYNivelServicioTodoSkillDias == null || entidadSkillsLlamadasYNivelServicioTodoSkillDias.size() == 0) {
            return false;
        }
        return true;
    }


}
