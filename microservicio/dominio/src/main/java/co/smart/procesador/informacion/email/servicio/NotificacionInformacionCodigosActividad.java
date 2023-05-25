package co.smart.procesador.informacion.email.servicio;

import co.smart.procesador.datos.servicio.ServicioConsultarDatos;
import co.smart.procesador.email.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class NotificacionInformacionCodigosActividad {
    private final ServicioConsultarDatos servicioConsultarDatos;
    private final MailService mailService;
    public void ejecutar(boolean guardo){
        if (guardo) {
            this.mailService.sendEmail(this.servicioConsultarDatos.consultar().getCorreo(),"Se guardo Exitosamente Informacion Codigos Actividad", "fecha :"+ LocalDateTime.now());
            this.mailService.sendEmail(this.servicioConsultarDatos.consultar().getCorreo2(),"Se guardo Exitosamente Informacion Codigos Actividad", "fecha :"+ LocalDateTime.now());
            this.mailService.sendEmail(this.servicioConsultarDatos.consultar().getCorreo3(),"Se guardo Exitosamente Informacion Codigos Actividad", "fecha :"+ LocalDateTime.now());
        }else {
            this.mailService.sendEmail(this.servicioConsultarDatos.consultar().getCorreo(),"No se pudo guardar Informacion Codigos Actividad","fecha :"+ LocalDateTime.now());
            this.mailService.sendEmail(this.servicioConsultarDatos.consultar().getCorreo2(),"No se pudo guardar Informacion Codigos Actividad","fecha :"+ LocalDateTime.now());
            this.mailService.sendEmail(this.servicioConsultarDatos.consultar().getCorreo3(),"No se pudo guardar Informacion Codigos Actividad","fecha :"+ LocalDateTime.now());
        }
    }
}
