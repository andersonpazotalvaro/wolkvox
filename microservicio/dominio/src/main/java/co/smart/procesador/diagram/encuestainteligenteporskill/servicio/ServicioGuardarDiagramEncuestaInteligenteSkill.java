package co.smart.procesador.diagram.encuestainteligenteporskill.servicio;


import co.smart.procesador.diagram.email.servicio.NotificacionDiagramEncuestaInteligenteSkill;
import co.smart.procesador.diagram.encuestainteligenteporskill.modelo.dominio.DiagramEncuestaInteligenteSkill;
import co.smart.procesador.diagram.encuestainteligenteporskill.puerto.repositorio.RepositorioDiagramEncuestaInteligenteSkill;
import co.smart.procesador.excepcion.ExcepcionDuplicidad;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioGuardarDiagramEncuestaInteligenteSkill {

    private static final String EL_INFORME_YA_EXISTE = "El informe con esta fecha ya existe";

    private final RepositorioDiagramEncuestaInteligenteSkill repositorioDiagramEncuestaInteligenteSkill;

    private final NotificacionDiagramEncuestaInteligenteSkill notificacionDiagramEncuestaInteligenteSkill;

    public ServicioGuardarDiagramEncuestaInteligenteSkill(RepositorioDiagramEncuestaInteligenteSkill repositorioDiagramEncuestaInteligenteSkill, NotificacionDiagramEncuestaInteligenteSkill notificacionDiagramEncuestaInteligenteSkill) {
        this.repositorioDiagramEncuestaInteligenteSkill = repositorioDiagramEncuestaInteligenteSkill;
        this.notificacionDiagramEncuestaInteligenteSkill = notificacionDiagramEncuestaInteligenteSkill;
    }


    public boolean ejecutar(List<DiagramEncuestaInteligenteSkill> diagramEncuestaInteligenteSkills){

            validarExistencia(diagramEncuestaInteligenteSkills);
            return this.repositorioDiagramEncuestaInteligenteSkill.guardarArray(diagramEncuestaInteligenteSkills);
    }

    private void validarExistencia(List<DiagramEncuestaInteligenteSkill> diagramEncuestaInteligenteSkills) {
        var ini = diagramEncuestaInteligenteSkills.get(0).getFecha_inicio_carga();
        var fin = diagramEncuestaInteligenteSkills.get(0).getFecha_fin_carga();
        if(this.repositorioDiagramEncuestaInteligenteSkill.existe(ini) || this.repositorioDiagramEncuestaInteligenteSkill.existe(fin)) {
            throw new ExcepcionDuplicidad(String.format(EL_INFORME_YA_EXISTE));
        }
    }
}
