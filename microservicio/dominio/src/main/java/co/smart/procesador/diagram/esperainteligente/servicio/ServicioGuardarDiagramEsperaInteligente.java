package co.smart.procesador.diagram.esperainteligente.servicio;


import co.smart.procesador.diagram.email.servicio.NotificacionDiagramEsperaInteligente;
import co.smart.procesador.diagram.esperainteligente.modelo.dominio.DiagramEsperaInteligente;
import co.smart.procesador.diagram.esperainteligente.puerto.repositorio.RepositorioDiagramEsperaInteligente;
import co.smart.procesador.excepcion.ExcepcionDuplicidad;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioGuardarDiagramEsperaInteligente {

    private static final String EL_INFORME_YA_EXISTE = "El informe con esta fecha ya existe";

    private final RepositorioDiagramEsperaInteligente repositorioDiagramEsperaInteligente;

    private final NotificacionDiagramEsperaInteligente notificacionDiagramEsperaInteligente;

    public ServicioGuardarDiagramEsperaInteligente(RepositorioDiagramEsperaInteligente repositorioDiagramEsperaInteligente, NotificacionDiagramEsperaInteligente notificacionDiagramEsperaInteligente) {
        this.repositorioDiagramEsperaInteligente = repositorioDiagramEsperaInteligente;
        this.notificacionDiagramEsperaInteligente = notificacionDiagramEsperaInteligente;
    }


    public boolean ejecutar(List<DiagramEsperaInteligente> diagramEsperaInteligentes){

            validarExistencia(diagramEsperaInteligentes);
            return this.repositorioDiagramEsperaInteligente.guardarArray(diagramEsperaInteligentes);
    }

    private void validarExistencia(List<DiagramEsperaInteligente> diagramEsperaInteligentes) {
        var ini = diagramEsperaInteligentes.get(0).getFecha_inicio_carga();
        var fin = diagramEsperaInteligentes.get(0).getFecha_fin_carga();
        if(this.repositorioDiagramEsperaInteligente.existe(ini) || this.repositorioDiagramEsperaInteligente.existe(fin)) {
            throw new ExcepcionDuplicidad(String.format(EL_INFORME_YA_EXISTE));
        }
    }
}
