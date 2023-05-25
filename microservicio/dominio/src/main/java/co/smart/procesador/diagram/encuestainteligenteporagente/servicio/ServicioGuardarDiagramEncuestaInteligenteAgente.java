package co.smart.procesador.diagram.encuestainteligenteporagente.servicio;


import co.smart.procesador.diagram.email.servicio.NotificacionDiagramEncuestaInteligenteAgente;
import co.smart.procesador.diagram.encuestainteligenteporagente.modelo.dominio.DiagramEncuestaInteligenteAgente;
import co.smart.procesador.diagram.encuestainteligenteporagente.puerto.repositorio.RepositorioDiagramEncuestaInteligenteAgente;
import co.smart.procesador.excepcion.ExcepcionDuplicidad;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioGuardarDiagramEncuestaInteligenteAgente {

    private static final String EL_INFORME_YA_EXISTE = "El informe con esta fecha ya existe";

    private final RepositorioDiagramEncuestaInteligenteAgente repositorioDiagramEncuestaInteligenteAgente;

    private final NotificacionDiagramEncuestaInteligenteAgente notificacionDiagramEncuestaInteligenteAgente;

    public ServicioGuardarDiagramEncuestaInteligenteAgente(RepositorioDiagramEncuestaInteligenteAgente repositorioDiagramEncuestaInteligenteAgente, NotificacionDiagramEncuestaInteligenteAgente notificacionDiagramEncuestaInteligenteAgente) {
        this.repositorioDiagramEncuestaInteligenteAgente = repositorioDiagramEncuestaInteligenteAgente;
        this.notificacionDiagramEncuestaInteligenteAgente = notificacionDiagramEncuestaInteligenteAgente;
    }


    public boolean ejecutar(List<DiagramEncuestaInteligenteAgente> diagramEncuestaInteligenteAgentes){

            validarExistencia(diagramEncuestaInteligenteAgentes);
            return this.repositorioDiagramEncuestaInteligenteAgente.guardarArray(diagramEncuestaInteligenteAgentes);
    }

    private void validarExistencia(List<DiagramEncuestaInteligenteAgente> diagramEncuestaInteligenteAgentes) {
        var ini = diagramEncuestaInteligenteAgentes.get(0).getFecha_inicio_carga();
        var fin = diagramEncuestaInteligenteAgentes.get(0).getFecha_fin_carga();
        if(this.repositorioDiagramEncuestaInteligenteAgente.existe(ini) || this.repositorioDiagramEncuestaInteligenteAgente.existe(fin)) {
            throw new ExcepcionDuplicidad(String.format(EL_INFORME_YA_EXISTE));
        }
    }
}
