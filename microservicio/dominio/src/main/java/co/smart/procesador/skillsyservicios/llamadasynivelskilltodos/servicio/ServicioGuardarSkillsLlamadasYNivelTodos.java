package co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.servicio;


import co.smart.procesador.diagram.encuestainteligenteporskill.modelo.dominio.DiagramEncuestaInteligenteSkill;
import co.smart.procesador.excepcion.ExcepcionDuplicidad;
import co.smart.procesador.skillsyservicios.email.servicio.NotificacionSkillLlamadaYNivelTodos;
import co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.modelo.dominio.SkillsLlamadasYNivelTodos;
import co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.puerto.repositorio.RepositorioSkillsLlamadasYNivelTodos;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioGuardarSkillsLlamadasYNivelTodos {

    private static final String EL_INFORME_YA_EXISTE = "El informe con esta fecha ya existe";

    private final RepositorioSkillsLlamadasYNivelTodos repositorioSkillsLlamadasYNivelTodos;

    private final NotificacionSkillLlamadaYNivelTodos notificacionSkillLlamadaYNivelTodos;

    public ServicioGuardarSkillsLlamadasYNivelTodos(RepositorioSkillsLlamadasYNivelTodos repositorioSkillsLlamadasYNivelTodos, NotificacionSkillLlamadaYNivelTodos notificacionSkillLlamadaYNivelTodos) {
        this.repositorioSkillsLlamadasYNivelTodos = repositorioSkillsLlamadasYNivelTodos;
        this.notificacionSkillLlamadaYNivelTodos = notificacionSkillLlamadaYNivelTodos;
    }


    public boolean ejecutar(List<SkillsLlamadasYNivelTodos> skillsLlamadasYNivelTodos){

            validarExistencia(skillsLlamadasYNivelTodos);
            return this.repositorioSkillsLlamadasYNivelTodos.guardarArray(skillsLlamadasYNivelTodos);
    }

    private void validarExistencia(List<SkillsLlamadasYNivelTodos> skillsLlamadasYNivelTodos) {
        var ini = skillsLlamadasYNivelTodos.get(0).getFecha_inicio_carga();
        var fin = skillsLlamadasYNivelTodos.get(0).getFecha_fin_carga();
        if(this.repositorioSkillsLlamadasYNivelTodos.existe(ini) || this.repositorioSkillsLlamadasYNivelTodos.existe(fin)) {
            throw new ExcepcionDuplicidad(String.format(EL_INFORME_YA_EXISTE));
        }
    }
}
