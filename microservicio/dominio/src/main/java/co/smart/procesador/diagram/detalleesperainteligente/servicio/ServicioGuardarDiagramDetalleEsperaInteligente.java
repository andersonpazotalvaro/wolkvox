package co.smart.procesador.diagram.detalleesperainteligente.servicio;


import co.smart.procesador.diagram.detalleesperainteligente.modelo.dominio.DiagramDetalleEsperaInteligente;
import co.smart.procesador.diagram.detalleesperainteligente.puerto.repositorio.RepositorioDiagramDetalleEsperaInteligente;
import co.smart.procesador.diagram.email.servicio.NotificacionDiagramDetalleEsperaInteligente;
import co.smart.procesador.excepcion.ExcepcionDuplicidad;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioGuardarDiagramDetalleEsperaInteligente {

    private static final String EL_INFORME_YA_EXISTE = "El informe con esta fecha ya existe";

    private final RepositorioDiagramDetalleEsperaInteligente repositorioDiagramDetalleEsperaInteligente;

    private final NotificacionDiagramDetalleEsperaInteligente notificacionDiagramDetalleEsperaInteligente;

    public ServicioGuardarDiagramDetalleEsperaInteligente(RepositorioDiagramDetalleEsperaInteligente repositorioDiagramDetalleEsperaInteligente, NotificacionDiagramDetalleEsperaInteligente notificacionDiagramDetalleEsperaInteligente) {
        this.repositorioDiagramDetalleEsperaInteligente = repositorioDiagramDetalleEsperaInteligente;
        this.notificacionDiagramDetalleEsperaInteligente = notificacionDiagramDetalleEsperaInteligente;
    }

    public boolean ejecutar(List<DiagramDetalleEsperaInteligente> diagramDetalleEsperaInteligentes){
            validarExistencia(diagramDetalleEsperaInteligentes);
            return this.repositorioDiagramDetalleEsperaInteligente.guardarArray(diagramDetalleEsperaInteligentes);
    }

    private void validarExistencia(List<DiagramDetalleEsperaInteligente> diagramDetalleEsperaInteligentes) {
        var ini = diagramDetalleEsperaInteligentes.get(0).getFecha_inicio_carga();
        var fin = diagramDetalleEsperaInteligentes.get(0).getFecha_fin_carga();
        if(this.repositorioDiagramDetalleEsperaInteligente.existe(ini) || this.repositorioDiagramDetalleEsperaInteligente.existe(fin)) {
            throw new ExcepcionDuplicidad(String.format(EL_INFORME_YA_EXISTE));
        }
    }
}
