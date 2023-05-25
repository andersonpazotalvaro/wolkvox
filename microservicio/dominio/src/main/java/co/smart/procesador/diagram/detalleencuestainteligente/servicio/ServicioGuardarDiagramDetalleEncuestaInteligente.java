package co.smart.procesador.diagram.detalleencuestainteligente.servicio;


import co.smart.procesador.diagram.detalleencuestainteligente.modelo.dominio.DiagramDetalleEncuestaInteligente;
import co.smart.procesador.diagram.detalleencuestainteligente.puerto.repositorio.RepositorioDiagramDetalleEncuestaInteligente;
import co.smart.procesador.diagram.email.servicio.NotificacionDiagramDetalleEncuestaInteligente;
import co.smart.procesador.excepcion.ExcepcionDuplicidad;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioGuardarDiagramDetalleEncuestaInteligente {

    private static final String EL_INFORME_YA_EXISTE = "El informe con esta fecha ya existe";

    private final RepositorioDiagramDetalleEncuestaInteligente repositorioDiagramDetalleEncuestaInteligente;

    private final NotificacionDiagramDetalleEncuestaInteligente notificacionDiagramDetalleEncuestaInteligente;

    public ServicioGuardarDiagramDetalleEncuestaInteligente(RepositorioDiagramDetalleEncuestaInteligente repositorioDiagramDetalleEncuestaInteligente, NotificacionDiagramDetalleEncuestaInteligente notificacionDiagramDetalleEncuestaInteligente) {
        this.repositorioDiagramDetalleEncuestaInteligente = repositorioDiagramDetalleEncuestaInteligente;
        this.notificacionDiagramDetalleEncuestaInteligente = notificacionDiagramDetalleEncuestaInteligente;
    }


    public boolean ejecutar(List<DiagramDetalleEncuestaInteligente> diagramDetalleEncuestaInteligentes){
            validarExistencia(diagramDetalleEncuestaInteligentes);
            return this.repositorioDiagramDetalleEncuestaInteligente.guardarArray(diagramDetalleEncuestaInteligentes);
    }

    private void validarExistencia(List<DiagramDetalleEncuestaInteligente> diagramDetalleEncuestaInteligentes) {
        var ini = diagramDetalleEncuestaInteligentes.get(0).getFecha_inicio_carga();
        var fin = diagramDetalleEncuestaInteligentes.get(0).getFecha_fin_carga();
        if(this.repositorioDiagramDetalleEncuestaInteligente.existe(ini) || this.repositorioDiagramDetalleEncuestaInteligente.existe(fin)) {
            throw new ExcepcionDuplicidad(String.format(EL_INFORME_YA_EXISTE));
        }
    }
}
