package co.smart.procesador.email;

import co.smart.procesador.datos.servicio.ServicioConsultarDatos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@RequiredArgsConstructor
@Service
public class NotificacionUnificadaDeServiciosSemanales {

    private final MailService mailService;
    private final ServicioConsultarDatos servicioConsultarDatos;

    private final static String GUARDO= "<font style=\"background-color: rgb(255, 255, 255);\" color=\"#6aa84f\" >Guardo Exitosamente</font> <br>";

    private final static String NO_GUARDO= "<font style=\"background-color: rgb(255, 255, 255);\" color=\"#ff0000\" >Falló al intentar guardar</font> <br>";

    private final static String ENCABEZADO="<font style=\"background-color: rgb(255, 255, 255);\" color=\"#274e13\" size=\"4\">";

    public void ejecutar(boolean IS, boolean ICA){

        LocalDate hoy = LocalDate.now();
        LocalDate ayer = hoy.minusDays(1);
        Locale spanishLocale=new Locale("es", "ES");
        String dateInSpanish=ayer.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy",spanishLocale));

        String text= ENCABEZADO+dateInSpanish + "</font> <br> <br> Si el día cargado es un día no laborado, no se encontrarán datos y fallará al intentar guardar <br> <br>";
       //agentetiempoporestado
        String is=IS?GUARDO:NO_GUARDO;
        text+= "Informacion Skills: "+ is +"\n";
        //agenteestadoporhora
        String ica=ICA?GUARDO:NO_GUARDO;
        text+= "Informacions Codigos Actividades: "+ ica +"\n";


       this.mailService.sendEmailMime(this.servicioConsultarDatos.consultar().getCorreo(),"Estado Guardado Wolkvox Unificado","",text);
        this.mailService.sendEmailMime(this.servicioConsultarDatos.consultar().getCorreo2(),"Estado Guardado Wolkvox Unificado","",text);
        this.mailService.sendEmailMime(this.servicioConsultarDatos.consultar().getCorreo3(),"Estado Guardado Wolkvox Unificado","",text);
    }
}
