package co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.servicio;


import co.smart.procesador.excepcion.ExcepcionDuplicidad;
import co.smart.procesador.skillsyservicios.email.servicio.NotificacionSkillLlamadaYNivelServicioHora;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.modelo.dominio.SkillsLlamadasYNivelServicioHora;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.puerto.repositorio.RepositorioSkillsLlamadasYNivelServicioHora;
import co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.modelo.dominio.SkillsLlamadasYNivelTodos;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioGuardarSkillsLlamadasYNivelServicioHora {

    private static final String EL_INFORME_YA_EXISTE = "El informe con esta fecha ya existe";

    private final RepositorioSkillsLlamadasYNivelServicioHora repositorioSkillsLlamadasYNivelServicioHora;

    private final NotificacionSkillLlamadaYNivelServicioHora notificacionSkillLlamadaYNivelServicioHora;

    public ServicioGuardarSkillsLlamadasYNivelServicioHora(RepositorioSkillsLlamadasYNivelServicioHora repositorioSkillsLlamadasYNivelServicioHora, NotificacionSkillLlamadaYNivelServicioHora notificacionSkillLlamadaYNivelServicioHora) {
        this.repositorioSkillsLlamadasYNivelServicioHora = repositorioSkillsLlamadasYNivelServicioHora;
        this.notificacionSkillLlamadaYNivelServicioHora = notificacionSkillLlamadaYNivelServicioHora;
    }


    public boolean ejecutar(List<SkillsLlamadasYNivelServicioHora> skillsLlamadasYNivelServicioHoras){

            validarExistencia(skillsLlamadasYNivelServicioHoras);
            return this.repositorioSkillsLlamadasYNivelServicioHora.guardarArray(skillsLlamadasYNivelServicioHoras);
    }

    private void validarExistencia(List<SkillsLlamadasYNivelServicioHora> skillsLlamadasYNivelServicioHoras) {
        var ini = skillsLlamadasYNivelServicioHoras.get(0).getFecha_inicio_carga();
        var fin = skillsLlamadasYNivelServicioHoras.get(0).getFecha_fin_carga();
        if(this.repositorioSkillsLlamadasYNivelServicioHora.existe(ini) || this.repositorioSkillsLlamadasYNivelServicioHora.existe(fin)) {
            throw new ExcepcionDuplicidad(String.format(EL_INFORME_YA_EXISTE));
        }
    }
}
