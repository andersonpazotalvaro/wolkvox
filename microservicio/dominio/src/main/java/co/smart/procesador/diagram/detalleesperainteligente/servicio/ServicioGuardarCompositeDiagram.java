package co.smart.procesador.diagram.detalleesperainteligente.servicio;


import co.smart.procesador.diagram.detalleesperainteligente.modelo.dominio.DiagramDetalleEsperaInteligente;
import co.smart.procesador.diagram.detalleesperainteligente.puerto.repositorio.RepositorioDiagramDetalleEsperaInteligente;
import co.smart.procesador.diagram.email.servicio.NotificacionDiagramDetalleEsperaInteligente;
import co.smart.procesador.diagram.esperainteligente.puerto.repositorio.RepositorioDiagramEsperaInteligente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioGuardarCompositeDiagram {

   /* private static final String EL_INFORME_YA_EXISTE = "El informe con esta fecha ya existe";

    private final RepositorioDiagramDetalleEsperaInteligente repositorioDiagramDetalleEsperaInteligente;

    private final RepositorioDiagramEsperaInteligente repositorioDiagramEsperaInteligente;

    private final NotificacionDiagramDetalleEsperaInteligente notificacionDiagramDetalleEsperaInteligente;

    public ServicioGuardarCompositeDiagram(RepositorioDiagramDetalleEsperaInteligente repositorioDiagramDetalleEsperaInteligente, RepositorioDiagramEsperaInteligente repositorioDiagramEsperaInteligente, NotificacionDiagramDetalleEsperaInteligente notificacionDiagramDetalleEsperaInteligente) {
        this.repositorioDiagramDetalleEsperaInteligente = repositorioDiagramDetalleEsperaInteligente;
        this.repositorioDiagramEsperaInteligente = repositorioDiagramEsperaInteligente;
        this.notificacionDiagramDetalleEsperaInteligente = notificacionDiagramDetalleEsperaInteligente;
    }

    public boolean ejecutar(List<DiagramDetalleEsperaInteligente> diagramDetalleEsperaInteligentes, List){
            //validarExistencia(diagramDetalleEsperaInteligentes);
            return this.repositorioDiagramDetalleEsperaInteligente.guardarArray(diagramDetalleEsperaInteligentes);
    }

    /*private void validarExistencia(List<DiagramDetalleEsperaInteligente> diagramDetalleEsperaInteligentes) {
        LocalDate fecha= diagramDetalleEsperaInteligentes.get(0).getFECHA();
        if(this.repositorioDiagramDetalleEsperaInteligente.existe(fecha)) {
            throw new ExcepcionDuplicidad(String.format(EL_INFORME_YA_EXISTE));
        }
    }*/
}
