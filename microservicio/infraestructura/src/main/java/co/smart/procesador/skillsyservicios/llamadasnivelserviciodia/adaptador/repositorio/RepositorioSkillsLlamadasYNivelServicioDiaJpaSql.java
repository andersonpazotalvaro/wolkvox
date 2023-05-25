package co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.adaptador.repositorio;

import co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.adaptador.MapperSkillsLlamadasYNivelServicioDia;
import co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.modelo.dominio.SkillsLlamadasYNivelServicioDia;
import co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.puerto.repositorio.RepositorioSkillsLlamadasYNivelServicioDia;
import co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.modelo.dominio.SkillsLlamadasYNivelTodos;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RepositorioSkillsLlamadasYNivelServicioDiaJpaSql implements RepositorioSkillsLlamadasYNivelServicioDia {

    private final MapperSkillsLlamadasYNivelServicioDia mapperSkillsLlamadasYNivelServicioDia;
    private final RepositorioSkillsLlamadasYNivelServicioDiaJpa repositorioSkillsLlamadasYNivelServicioDiajpa;

    public RepositorioSkillsLlamadasYNivelServicioDiaJpaSql(MapperSkillsLlamadasYNivelServicioDia mapperSkillsLlamadasYNivelServicioDia, RepositorioSkillsLlamadasYNivelServicioDiaJpa repositorioSkillsLlamadasYNivelServicioDiajpa) {
        this.mapperSkillsLlamadasYNivelServicioDia = mapperSkillsLlamadasYNivelServicioDia;
        this.repositorioSkillsLlamadasYNivelServicioDiajpa = repositorioSkillsLlamadasYNivelServicioDiajpa;
    }


    @Override
    public boolean guardar(SkillsLlamadasYNivelServicioDia skillsLlamadasYNivelServicioDia) {
        var entidadSkill= this.mapperSkillsLlamadasYNivelServicioDia.crearEntity(skillsLlamadasYNivelServicioDia);
        this.repositorioSkillsLlamadasYNivelServicioDiajpa.save(entidadSkill);
        return false;
    }



    @Override
    public boolean guardarArray(List<SkillsLlamadasYNivelServicioDia> skillsLlamadasYNivelServicioDia) {
        var listaEntidadSkill= this.mapperSkillsLlamadasYNivelServicioDia.convertirDominioAEntidad(skillsLlamadasYNivelServicioDia);
        this.repositorioSkillsLlamadasYNivelServicioDiajpa.saveAll(listaEntidadSkill);
        return true;
    }

    @Override
    public boolean existe(LocalDate fecha) {
        var entidadSkillsLlamadasYNivelServicioDia = this.repositorioSkillsLlamadasYNivelServicioDiajpa.consultarSiExisteRegistroHoy(fecha.toString());
        if (entidadSkillsLlamadasYNivelServicioDia == null || entidadSkillsLlamadasYNivelServicioDia.size() == 0) {
            return false;
        }
        return true;
    }


}
