package co.smart.procesador.diagram.email.servicio;

import co.smart.procesador.datos.servicio.ServicioConsultarDatos;
import co.smart.procesador.email.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class NotificacionDiagramDetalleEncuestaInteligente {
    private final ServicioConsultarDatos servicioConsultarDatos;
    private final MailService mailService;
    public void ejecutar(boolean guardo){
        if (guardo) {
            this.mailService.sendEmail(this.servicioConsultarDatos.consultar().getCorreo(),"Se guardo Exitosamente DiagramDetalleEncuestaInteligente","fecha :"+ LocalDateTime.now());
            this.mailService.sendEmail(this.servicioConsultarDatos.consultar().getCorreo2(),"Se guardo Exitosamente DiagramDetalleEncuestaInteligente","fecha :"+ LocalDateTime.now());
            this.mailService.sendEmail(this.servicioConsultarDatos.consultar().getCorreo3(),"Se guardo Exitosamente DiagramDetalleEncuestaInteligente","fecha :"+ LocalDateTime.now());

        }else {
            this.mailService.sendEmail(this.servicioConsultarDatos.consultar().getCorreo(),"No se pudo Guardar DiagramDetalleEncuestaInteligente","fecha :"+ LocalDateTime.now());
            this.mailService.sendEmail(this.servicioConsultarDatos.consultar().getCorreo2(),"No se pudo Guardar DiagramDetalleEncuestaInteligente","fecha :"+ LocalDateTime.now());
            this.mailService.sendEmail(this.servicioConsultarDatos.consultar().getCorreo3(),"No se pudo Guardar DiagramDetalleEncuestaInteligente","fecha :"+ LocalDateTime.now());
        }
    }
}
