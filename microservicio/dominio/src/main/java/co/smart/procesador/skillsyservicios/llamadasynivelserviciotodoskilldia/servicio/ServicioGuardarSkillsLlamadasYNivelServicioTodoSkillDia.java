package co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.servicio;


import co.smart.procesador.excepcion.ExcepcionDuplicidad;
import co.smart.procesador.skillsyservicios.email.servicio.NotificacionSkillLlamadaYNivelServicioHora;
import co.smart.procesador.skillsyservicios.email.servicio.NotificacionSkillLlamadaYNivelServicioTodoSkillDia;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.modelo.dominio.SkillsLlamadasYNivelServicioHora;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.puerto.repositorio.RepositorioSkillsLlamadasYNivelServicioHora;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.modelo.dominio.SkillsLlamadasYNivelServicioTodoSkillDia;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.puerto.repositorio.RepositorioSkillsLlamadasYNivelServicioTodoSkillDia;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioGuardarSkillsLlamadasYNivelServicioTodoSkillDia {

    private static final String EL_INFORME_YA_EXISTE = "El informe con esta fecha ya existe";

    private final RepositorioSkillsLlamadasYNivelServicioTodoSkillDia repositorioSkillsLlamadasYNivelServicioTodoSkillDia;

    private final NotificacionSkillLlamadaYNivelServicioTodoSkillDia notificacionSkillLlamadaYNivelServicioTodoSkillDia;

    public ServicioGuardarSkillsLlamadasYNivelServicioTodoSkillDia(RepositorioSkillsLlamadasYNivelServicioTodoSkillDia repositorioSkillsLlamadasYNivelServicioTodoSkillDia, NotificacionSkillLlamadaYNivelServicioTodoSkillDia notificacionSkillLlamadaYNivelServicioTodoSkillDia) {
        this.repositorioSkillsLlamadasYNivelServicioTodoSkillDia = repositorioSkillsLlamadasYNivelServicioTodoSkillDia;
        this.notificacionSkillLlamadaYNivelServicioTodoSkillDia = notificacionSkillLlamadaYNivelServicioTodoSkillDia;
    }

    public boolean ejecutar(List<SkillsLlamadasYNivelServicioTodoSkillDia> skillsLlamadasYNivelServicioTodoSkillDias){

            validarExistencia(skillsLlamadasYNivelServicioTodoSkillDias);
            return this.repositorioSkillsLlamadasYNivelServicioTodoSkillDia.guardarArray(skillsLlamadasYNivelServicioTodoSkillDias);
    }

    private void validarExistencia(List<SkillsLlamadasYNivelServicioTodoSkillDia> skillsLlamadasYNivelServicioTodoSkillDias) {
        var ini = skillsLlamadasYNivelServicioTodoSkillDias.get(0).getFecha_inicio_carga();
        var fin = skillsLlamadasYNivelServicioTodoSkillDias.get(0).getFecha_fin_carga();
        if(this.repositorioSkillsLlamadasYNivelServicioTodoSkillDia.existe(ini) || this.repositorioSkillsLlamadasYNivelServicioTodoSkillDia.existe(fin)) {
            throw new ExcepcionDuplicidad(String.format(EL_INFORME_YA_EXISTE));
        }
    }
}
