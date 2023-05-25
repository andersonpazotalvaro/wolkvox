package co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.adaptador.repositorio;

import co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.adaptador.MapperSkillsLlamadasYNivelServicioDia;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.adaptador.MapperSkillsLlamadasYNivelServicioHora;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.modelo.dominio.SkillsLlamadasYNivelServicioHora;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.puerto.repositorio.RepositorioSkillsLlamadasYNivelServicioHora;
import co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.modelo.dominio.SkillsLlamadasYNivelTodos;
import co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.puerto.repositorio.RepositorioSkillsLlamadasYNivelTodos;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RepositorioSkillsLlamadasYNivelServicioHoraJpaSql implements RepositorioSkillsLlamadasYNivelServicioHora {

    private final MapperSkillsLlamadasYNivelServicioHora mapperSkillsLlamadasYNivelServicioHora;
    private final RepositorioSkillsLlamadasYNivelServicioHoraJpa repositorioSkillsLlamadasYNivelServicioHoraJpa;

    public RepositorioSkillsLlamadasYNivelServicioHoraJpaSql(MapperSkillsLlamadasYNivelServicioHora mapperSkillsLlamadasYNivelServicioHora, RepositorioSkillsLlamadasYNivelServicioHoraJpa repositorioSkillsLlamadasYNivelServicioHoraJpa) {
        this.mapperSkillsLlamadasYNivelServicioHora = mapperSkillsLlamadasYNivelServicioHora;
        this.repositorioSkillsLlamadasYNivelServicioHoraJpa = repositorioSkillsLlamadasYNivelServicioHoraJpa;
    }

    @Override
    public boolean guardar(SkillsLlamadasYNivelServicioHora skillsLlamadasYNivelServicioHora) {
        var entidadSkill= this.mapperSkillsLlamadasYNivelServicioHora.crearEntity(skillsLlamadasYNivelServicioHora);
        this.repositorioSkillsLlamadasYNivelServicioHoraJpa.save(entidadSkill);
        return false;
    }



    @Override
    public boolean guardarArray(List<SkillsLlamadasYNivelServicioHora> skillsLlamadasYNivelServicioHoras) {
        var listaEntidadSkill= this.mapperSkillsLlamadasYNivelServicioHora.convertirDominioAEntidad(skillsLlamadasYNivelServicioHoras);
        this.repositorioSkillsLlamadasYNivelServicioHoraJpa.saveAll(listaEntidadSkill);
        return true;
    }

    @Override
    public boolean existe(LocalDate fecha) {
        var entidadSkillsLlamadasYNivelServicioHoras = this.repositorioSkillsLlamadasYNivelServicioHoraJpa.consultarSiExisteRegistroHoy(fecha.toString());
        if (entidadSkillsLlamadasYNivelServicioHoras == null || entidadSkillsLlamadasYNivelServicioHoras.size() == 0) {
            return false;
        }
        return true;
    }


}
