package co.smart.procesador.interaccionesychats.email.servicio;

import co.smart.procesador.datos.servicio.ServicioConsultarDatos;
import co.smart.procesador.email.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class NotificacionInteraccionesTransferenciaChats {
    private final ServicioConsultarDatos servicioConsultarDatos;
    private final MailService mailService;
    public void ejecutar(boolean guardo){
        if (guardo) {
            this.mailService.sendEmail(this.servicioConsultarDatos.consultar().getCorreo(),"Se guardo Exitosamente Transferencia Chats", "fecha :"+ LocalDateTime.now());
            this.mailService.sendEmail(this.servicioConsultarDatos.consultar().getCorreo2(),"Se guardo Exitosamente Transferencia Chats", "fecha :"+ LocalDateTime.now());
            this.mailService.sendEmail(this.servicioConsultarDatos.consultar().getCorreo3(),"Se guardo Exitosamente Transferencia Chats", "fecha :"+ LocalDateTime.now());
        }else {
            this.mailService.sendEmail(this.servicioConsultarDatos.consultar().getCorreo(),"No se pudo Guardar Transferencia Chats","fecha :"+ LocalDateTime.now());
            this.mailService.sendEmail(this.servicioConsultarDatos.consultar().getCorreo2(),"No se pudo Guardar Transferencia Chats","fecha :"+ LocalDateTime.now());
            this.mailService.sendEmail(this.servicioConsultarDatos.consultar().getCorreo3(),"No se pudo Guardar Transferencia Chats","fecha :"+ LocalDateTime.now());
        }
    }
}
