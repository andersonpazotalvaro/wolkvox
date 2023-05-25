package co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.controlador;


import co.smart.procesador.skillsyservicios.email.servicio.NotificacionSkillLlamadaYNivelServicioHora;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.comando.ResponseSkillsLlamadasYNivelServicioHora;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.comando.manejador.ManejadorSkillsLlamadasYNivelServicioHora;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.consumir.ConsumirSkillsLlamadasYNivelServicioHora;
import com.google.gson.Gson;
import okhttp3.Response;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("Llamadasynivelserviciohora")
public class ControladorSkillsLlamadasYNivelServicioHora {

        private final static String NO_SE_ENCONTRO_DATOS = "no se encontraron datos para estas fechas";

        private final NotificacionSkillLlamadaYNivelServicioHora notificacionSkillLlamadaYNivelServicioHora;

        private final ManejadorSkillsLlamadasYNivelServicioHora manejadorSkillsLlamadasYNivelServicioHora;

        private final ConsumirSkillsLlamadasYNivelServicioHora consumirSkillsLlamadasYNivelServicioHora;

    public ControladorSkillsLlamadasYNivelServicioHora(NotificacionSkillLlamadaYNivelServicioHora notificacionSkillLlamadaYNivelServicioHora, ManejadorSkillsLlamadasYNivelServicioHora manejadorSkillsLlamadasYNivelServicioHora, ConsumirSkillsLlamadasYNivelServicioHora consumirSkillsLlamadasYNivelServicioHora) {
        this.notificacionSkillLlamadaYNivelServicioHora = notificacionSkillLlamadaYNivelServicioHora;
        this.manejadorSkillsLlamadasYNivelServicioHora = manejadorSkillsLlamadasYNivelServicioHora;
        this.consumirSkillsLlamadasYNivelServicioHora = consumirSkillsLlamadasYNivelServicioHora;
    }

    @RequestMapping(value= "/{ini}/{fin}", method = RequestMethod.POST)
    public String enviar(@PathVariable("ini") String ini, @PathVariable("fin") String fin) throws IOException {

        Response response= this.consumirSkillsLlamadasYNivelServicioHora.consumirr(ini,fin);
        boolean guardo= false;
        Gson gson= new Gson();
        String json;
        if(response.code()!=404) {
             json = response.body().string();
            ResponseSkillsLlamadasYNivelServicioHora responseSkillsLlamadasYNivelServicioHora = gson.fromJson(json, ResponseSkillsLlamadasYNivelServicioHora.class);
            try {
                this.manejadorSkillsLlamadasYNivelServicioHora.ejecutar(responseSkillsLlamadasYNivelServicioHora,ini,fin);
                guardo = true;
            } catch (Exception e) {
                return e.getMessage()+"\n"+ response.code()+ "\n"+ responseSkillsLlamadasYNivelServicioHora.getMsg();
            }
            System.out.println("guardo");


            this.notificacionSkillLlamadaYNivelServicioHora.ejecutar(guardo);
            return json;
        }
        else {
            json= NO_SE_ENCONTRO_DATOS;
            return json;
        }

    }

   /* @RequestMapping(value= "/{ini}/{fin}", method = RequestMethod.POST)
    public String enviarTodos(@PathVariable("ini") String ini, @PathVariable("fin") String fin){


        var listaSkills = this.servicioConsultarSkill.consultar();

        listaSkills.forEach(respuestaConsultaSkillConId -> {
            try {
                this.enviar(ini, fin, respuestaConsultaSkillConId.getId_skill());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return "Guardaron Llamadas y Nivel De Servicio Por Skill-Servicio";
    }*/


   }
