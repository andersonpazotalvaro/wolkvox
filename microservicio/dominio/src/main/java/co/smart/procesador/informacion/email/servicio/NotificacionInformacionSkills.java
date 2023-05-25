package co.smart.procesador.informacion.email.servicio;

import co.smart.procesador.datos.servicio.ServicioConsultarDatos;
import co.smart.procesador.email.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class NotificacionInformacionSkills {
    private final ServicioConsultarDatos servicioConsultarDatos;
    private final MailService mailService;
    public void ejecutar(boolean guardo){
        if (guardo) {
            this.mailService.sendEmail(this.servicioConsultarDatos.consultar().getCorreo(),"Se guardo Exitosamente Informacion Skills", "fecha :"+ LocalDateTime.now());
        }else {
            this.mailService.sendEmail(this.servicioConsultarDatos.consultar().getCorreo(),"No se pudo Informacion Skills","fecha :"+ LocalDateTime.now());
        }
    }
}
