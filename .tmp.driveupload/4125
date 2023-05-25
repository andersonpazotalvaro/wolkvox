package co.smart.procesador.unificados.comando.manejador;

import co.smart.procesador.agentes.estadopohora.comando.manejador.ManejadorAgenteEstadoPorHora;
import co.smart.procesador.agentes.porevento.comando.manejador.ManejadorAgentePorEvento;
import co.smart.procesador.agentes.tiempoporestado.comando.manejador.ManejadorAgenteTiempoPorEstado;
import co.smart.procesador.campañas.resultadomaquinafinal.comando.manejador.ManejadorCampañaResultadoMaquinaFinal;
import co.smart.procesador.campañas.resultadotelefonoatelefono.comando.manejador.ManejadorCampañaResultadoTelefonoATelefono;
import co.smart.procesador.diagram.detalleencuestainteligente.comando.manejador.ManejadorDiagramDetalleEncuestaInteligente;
import co.smart.procesador.diagram.detalleesperainteligente.comando.manejador.ManejadorDiagramDetalleEsperaInteligente;
import co.smart.procesador.diagram.encuestainteligenteporagente.comando.manejador.ManejadorDiagramEncuestaInteligenteAgente;
import co.smart.procesador.diagram.encuestainteligenteporskill.comando.manejador.ManejadorDiagramEncuestaInteligenteSkill;
import co.smart.procesador.diagram.esperainteligente.comando.manejador.ManejadorDiagramEsperaInteligente;
import co.smart.procesador.email.NotificacionUnificadaDeServicios;
import co.smart.procesador.email.NotificacionUnificadaDeServiciosSemanales;
import co.smart.procesador.informacion.codigosactividad.comando.manejador.ManejadorInformacionCodigosActividad;
import co.smart.procesador.informacion.skill.comando.manejador.ManejadorInformacionSkills;
import co.smart.procesador.interaccionesychats.chats.comando.manejador.ManejadorInteraccionesChats;
import co.smart.procesador.interaccionesychats.conversaciones.comando.manejador.ManejadorInteraccionesConversaciones;
import co.smart.procesador.interaccionesychats.transferenciachats.comando.manejador.ManejadorInteraccionesTransferenciaChats;
import co.smart.procesador.skillsyservicios.detallellamadasabandonadas.comando.manejador.ManejadorSkillsDetallesLlamadasAbandonadas;
import co.smart.procesador.skillsyservicios.detallellamadascontestadas.comando.manejador.ManejadorSkillsDetallesLlamadasContestadas;
import co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.comando.manejador.ManejadorSkillsLlamadasYNivelServicioDia;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.comando.manejador.ManejadorSkillsLlamadasYNivelServicioHora;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.comando.manejador.ManejadorSkillsLlamadasYNivelServicioTodoSkillDia;
import co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.comando.manejador.ManejadorSkillsLlamadasYNivelTodos;
import co.smart.procesador.skillsyservicios.workforceporhora.comando.menejador.ManejadorSkillsWorkforceHora;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class ManejadorUnificados {

    private final ManejadorAgenteTiempoPorEstado manejadorAgenteTiempoPorEstado;
    private final ManejadorAgenteEstadoPorHora manejadorAgenteEstadoPorHora;
    private final ManejadorAgentePorEvento manejadorAgentePorEvento;
    private final ManejadorCampañaResultadoMaquinaFinal manejadorCampañaResultadoMaquinaFinal;
    private final ManejadorCampañaResultadoTelefonoATelefono manejadorCampañaResultadoTelefonoATelefono;
    private final ManejadorDiagramEsperaInteligente manejadorDiagramEsperaInteligente;
    private final ManejadorDiagramDetalleEsperaInteligente manejadorDiagramDetalleEsperaInteligente;
    private final ManejadorDiagramEncuestaInteligenteAgente manejadorDiagramEncuestaInteligenteAgente;
    private final ManejadorDiagramEncuestaInteligenteSkill manejadorDiagramEncuestaInteligenteSkill;
    private final ManejadorDiagramDetalleEncuestaInteligente manejadorDiagramDetalleEncuestaInteligente;
    private final ManejadorSkillsLlamadasYNivelTodos manejadorSkillsLlamadasYNivelTodos;
    private final ManejadorSkillsDetallesLlamadasAbandonadas manejadorSkillsDetallesLlamadasAbandonadas;
    private final ManejadorSkillsLlamadasYNivelServicioDia manejadorSkillsLlamadasYNivelServicioDia;
    private final ManejadorSkillsLlamadasYNivelServicioHora manejadorSkillsLlamadasYNivelServicioHora;
    private final ManejadorSkillsLlamadasYNivelServicioTodoSkillDia manejadorSkillsLlamadasYNivelServicioTodoSkillDia;
    private final ManejadorSkillsDetallesLlamadasContestadas manejadorSkillsDetallesLlamadasContestadas;
    private final ManejadorSkillsWorkforceHora manejadorSkillsWorkforceHora;
    private final ManejadorInteraccionesChats manejadorInteraccionesChats;
    private final ManejadorInteraccionesConversaciones manejadorInteraccionesConversaciones;
    private final ManejadorInteraccionesTransferenciaChats manejadorInteraccionesTransferenciaChats;
    private final ManejadorInformacionSkills manejadorInformacionSkills;
    private final ManejadorInformacionCodigosActividad manejadorInformacionCodigosActividad;
    private final NotificacionUnificadaDeServicios notificacionUnificadaDeServicios;
    private final NotificacionUnificadaDeServiciosSemanales notificacionUnificadaDeServiciosSemanales;
    //private final HolidayUtil holidayUtil;


//@Async
   // @Scheduled(fixedDelay = 120000)
    @Scheduled(cron = "${cron.expression}")
    public void ejecutar(){
            try {
                this.notificacionUnificadaDeServicios.ejecutar(
                        this.manejadorAgenteTiempoPorEstado.ejecutarCiclo(),
                        this.manejadorAgenteEstadoPorHora.ejecutarCiclo(),
                        this.manejadorAgentePorEvento.ejecutarCiclo(),
                        this.manejadorCampañaResultadoMaquinaFinal.ejecutarCiclo(),
                        this.manejadorCampañaResultadoTelefonoATelefono.ejecutarCiclo(),
                        this.manejadorDiagramEsperaInteligente.ejecutarCiclo(),
                        this.manejadorDiagramDetalleEsperaInteligente.ejecutarCiclo(),
                        this.manejadorDiagramEncuestaInteligenteAgente.ejecutarCiclo(),
                        this.manejadorDiagramEncuestaInteligenteSkill.ejecutarCiclo(),
                        this.manejadorDiagramDetalleEncuestaInteligente.ejecutarCiclo(),
                        this.manejadorSkillsLlamadasYNivelTodos.ejecutarCiclo(),
                        this.manejadorSkillsDetallesLlamadasAbandonadas.ejecutarCiclo(),
                        this.manejadorSkillsLlamadasYNivelServicioDia.ejecutarCiclo(),
                        this.manejadorSkillsLlamadasYNivelServicioHora.ejecutarCiclo(),
                        this.manejadorSkillsLlamadasYNivelServicioTodoSkillDia.ejecutarCiclo(),
                        this.manejadorSkillsDetallesLlamadasContestadas.ejecutarCiclo(),
                        this.manejadorSkillsWorkforceHora.ejecutarCiclo(),
                        this.manejadorInteraccionesChats.ejecutarCiclo(),
                        this.manejadorInteraccionesConversaciones.ejecutarCiclo(),
                        this.manejadorInteraccionesTransferenciaChats.ejecutarCiclo()
                );
            } catch (Exception e) {
                System.out.println(e);
            }

    }

    @Scheduled(cron = "${cron.expressions}")
    public void ejecutarSemanal(){
        try {
            this.notificacionUnificadaDeServiciosSemanales.ejecutar(
                   this.manejadorInformacionSkills.ejecutarCiclo(),
                   this.manejadorInformacionCodigosActividad .ejecutarCiclo()
            );
        } catch (Exception e) {
            System.out.println(e);
        }

    }



}
