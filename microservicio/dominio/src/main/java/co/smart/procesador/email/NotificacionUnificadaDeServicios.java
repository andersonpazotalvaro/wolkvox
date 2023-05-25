package co.smart.procesador.email;

import co.smart.procesador.datos.servicio.ServicioConsultarDatos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@RequiredArgsConstructor
@Service
public class NotificacionUnificadaDeServicios {

    private final MailService mailService;
    private final ServicioConsultarDatos servicioConsultarDatos;

    private final static String GUARDO= "<font style=\"background-color: rgb(255, 255, 255);\" color=\"#6aa84f\" >Guardo Exitosamente</font> <br>";

    private final static String NO_GUARDO= "<font style=\"background-color: rgb(255, 255, 255);\" color=\"#ff0000\" >Falló al intentar guardar</font> <br>";
    private final static String NO_DATOS= "<font style=\"background-color: rgb(255, 255, 255);\" color=\"#ff0000\" >Falló al intentar guardar No se encontraron datos</font> <br>";

    private final static String ENCABEZADO="<font style=\"background-color: rgb(255, 255, 255);\" color=\"#274e13\" size=\"4\">";

    public void ejecutar(boolean ATPE, boolean AEPH, boolean APE, boolean CRMF, boolean CRTAT, boolean DEI, boolean DDEI,
                         boolean DEIA, boolean DEIS, boolean DDECI, boolean SLNT, boolean SDLA, boolean SLNSD, boolean SLNSH, boolean SLNSTSD,
                         boolean SDLC, boolean SWH, boolean IC, boolean ICO, boolean ITC){

        LocalDate hoy = LocalDate.now();
        LocalDate ayer = hoy.minusDays(1);
        Locale spanishLocale=new Locale("es", "ES");
        String dateInSpanish=ayer.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy",spanishLocale));

        String text= ENCABEZADO+dateInSpanish + "</font> <br> <br> Si el día cargado es un día no laborado no se encontrarán datos y fallará al intentar guardar <br> Sí se intenta cargar un día que ya fue cargado igualmente fallará al intentar guardar <br><br>";
       //agentetiempoporestado
        String atpe=ATPE?GUARDO:NO_GUARDO;
        text+= "Agente Tiempo Por Estado: "+ atpe +"\n";
        //agenteestadoporhora
        String aeph=AEPH?GUARDO:NO_GUARDO;
        text+= "Agente Estado Por Hora: "+ aeph +"\n";
        //agentePorEvento
        String ape=APE?GUARDO:NO_GUARDO;
        text+= "Agente Por Evento: "+ ape +"\n";
        //CampañaResultadoMaquinaFinal
        String crmf=CRMF?GUARDO:NO_DATOS;
        text+= "Campaña Resultado Maquina Final: "+ crmf +"\n";
        //CampañaResultadoTelefonoATelefono
        String crtat=CRTAT?GUARDO:NO_DATOS;
        text+= "Campaña Resultado Telefono A Telefono: "+ crtat +"\n";
        //DiagramEsperaInteligente
        String dei=DEI?GUARDO:NO_GUARDO;
        text+= "Diagram Espera Inteligente: "+ dei +"\n";
        //DiagramDetalleEsperaInteligente
        String ddei=DDEI?GUARDO:NO_GUARDO;
        text+= "Diagram Detalle Espera Inteligente: "+ ddei +"\n";
        //DiagramEncuestaInteligenteAgente
        String deia=DEIA?GUARDO:NO_GUARDO;
        text+= "Diagram Encuesta Inteligente Por Agente: "+ deia +"\n";
        //DiagramEncuestaInteligenteSkill
        String deis=DEIS?GUARDO:NO_GUARDO;
        text+= "Diagram Encuesta Inteligente Por Skill: "+ deis +"\n";
        //DiagramDetalleEncuestaInteligente
        String ddeci=DDECI?GUARDO:NO_GUARDO;
        text+= "Diagram Detalle Encuesta Inteligente: "+ ddeci +"\n";
        //SkillLlamadasYNivelServicioTodos
        String slnt=SLNT?GUARDO:NO_GUARDO;
        text+= "Llamadas Y Nivel De Servicio-Todos: "+ slnt +"\n";
        //SkillDetalleLlamadasAbandonadas
        String sdla=SDLA?GUARDO:NO_GUARDO;
        text+= "Detalle Llamadas Abandonadas: "+ sdla+"\n";
        //SkillLlamadasYNivelServicioDia
        String slnsd=SLNSD?GUARDO:NO_GUARDO;
        text+= "Llamadas Y Nivel De Servicio-Dia: "+ slnsd +"\n";
        //SkillLlamadasYNivelServicioDia
        String slnsh=SLNSH?GUARDO:NO_GUARDO;
        text+= "Llamadas Y Nivel De Servicio-Hora: "+ slnsh +"\n";
        //SkillLlamadasYNivelServicioTodoSkillDia
        String slnstsd=SLNSTSD?GUARDO:NO_GUARDO;
        text+= "Llamadas Y Nivel De Servicio-Para Todos Los Skill Dia: "+ slnstsd +"\n";
        //SkillDetalleLlamadasContestadas
        String sdlc=SDLC?GUARDO:NO_GUARDO;
        text+= "Detalle Llamadas Contestadas: "+ sdlc+"\n";
        //SkillWorkforceHora
        String swh=SWH?GUARDO:NO_GUARDO;
        text+= "Workforce Por Hora: "+ swh+"\n";
        //InteraccionesChats
        String ic=IC?GUARDO:NO_GUARDO;
        text+= "Interacciones Chats: "+ ic+"\n";
        //InteraccionesConversaciones
        String ico=ICO?GUARDO:NO_GUARDO;
        text+= "Interacciones Conversaciones: "+ ico+"\n";
        //InteraccionesTransferenciaChats
        String itc=ITC?GUARDO:NO_GUARDO;
        text+= "Interacciones Transferencia Chats: "+ itc+"\n";

       this.mailService.sendEmailMime(this.servicioConsultarDatos.consultar().getCorreo(),"Estado Guardado Wolkvox Unificado","",text);
        this.mailService.sendEmailMime(this.servicioConsultarDatos.consultar().getCorreo2(),"Estado Guardado Wolkvox Unificado","",text);
        this.mailService.sendEmailMime(this.servicioConsultarDatos.consultar().getCorreo3(),"Estado Guardado Wolkvox Unificado","",text);
    }
}
