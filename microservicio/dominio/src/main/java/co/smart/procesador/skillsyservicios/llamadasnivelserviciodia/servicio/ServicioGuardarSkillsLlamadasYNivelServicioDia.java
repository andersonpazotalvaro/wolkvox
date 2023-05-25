package co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.servicio;


import co.smart.procesador.excepcion.ExcepcionDuplicidad;
import co.smart.procesador.skillsyservicios.email.servicio.NotificacionSkillLlamadaYNivelServicioDia;
import co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.modelo.dominio.SkillsLlamadasYNivelServicioDia;
import co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.puerto.repositorio.RepositorioSkillsLlamadasYNivelServicioDia;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioGuardarSkillsLlamadasYNivelServicioDia {

    private static final String EL_INFORME_YA_EXISTE = "El informe con esta fecha ya existe";

    private final RepositorioSkillsLlamadasYNivelServicioDia repositorioSkillsLlamadasYNivelServicioDia;

    private final NotificacionSkillLlamadaYNivelServicioDia notificacionSkillLlamadaYNivelServicioDia;

    public ServicioGuardarSkillsLlamadasYNivelServicioDia(RepositorioSkillsLlamadasYNivelServicioDia repositorioSkillsLlamadasYNivelServicioDia, NotificacionSkillLlamadaYNivelServicioDia notificacionSkillLlamadaYNivelServicioDia) {
        this.repositorioSkillsLlamadasYNivelServicioDia = repositorioSkillsLlamadasYNivelServicioDia;
        this.notificacionSkillLlamadaYNivelServicioDia = notificacionSkillLlamadaYNivelServicioDia;
    }

    public boolean ejecutar(List<SkillsLlamadasYNivelServicioDia> skillsLlamadasYNivelServicioDia){

            validarExistencia(skillsLlamadasYNivelServicioDia);
            return this.repositorioSkillsLlamadasYNivelServicioDia.guardarArray(skillsLlamadasYNivelServicioDia);
    }

    private void validarExistencia(List<SkillsLlamadasYNivelServicioDia> skillsLlamadasYNivelServicioDia) {
        var ini = skillsLlamadasYNivelServicioDia.get(0).getFecha_inicio_carga();
        var fin = skillsLlamadasYNivelServicioDia.get(0).getFecha_fin_carga();
        if(this.repositorioSkillsLlamadasYNivelServicioDia.existe(ini) || this.repositorioSkillsLlamadasYNivelServicioDia.existe(fin)) {
            throw new ExcepcionDuplicidad(String.format(EL_INFORME_YA_EXISTE));
        }
    }
}
