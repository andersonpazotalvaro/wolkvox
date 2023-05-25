package co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.controlador;


import co.smart.procesador.skillsyservicios.email.servicio.NotificacionSkillLlamadaYNivelServicioTodoSkillDia;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.comando.ResponseSkillsLlamadasYNivelServicioTodoSkillDia;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.comando.manejador.ManejadorSkillsLlamadasYNivelServicioTodoSkillDia;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.consumir.ConsumirSkillsLlamadasYNivelServicioTodoSkillDia;
import com.google.gson.Gson;
import okhttp3.Response;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("Llamadasynivelserviciotodoskilldia")
public class ControladorSkillsLlamadasYNivelServicioTodoSkillDia {

        private final static String NO_SE_ENCONTRO_DATOS = "no se encontraron datos para estas fechas";

        private final NotificacionSkillLlamadaYNivelServicioTodoSkillDia notificacionSkillLlamadaYNivelServicioTodoSkillDia;

        private final ManejadorSkillsLlamadasYNivelServicioTodoSkillDia manejadorSkillsLlamadasYNivelServicioTodoSkillDia;

        private final ConsumirSkillsLlamadasYNivelServicioTodoSkillDia consumirSkillsLlamadasYNivelServicioTodoSkillDia;

    public ControladorSkillsLlamadasYNivelServicioTodoSkillDia(NotificacionSkillLlamadaYNivelServicioTodoSkillDia notificacionSkillLlamadaYNivelServicioTodoSkillDia, ManejadorSkillsLlamadasYNivelServicioTodoSkillDia manejadorSkillsLlamadasYNivelServicioTodoSkillDia, ConsumirSkillsLlamadasYNivelServicioTodoSkillDia consumirSkillsLlamadasYNivelServicioTodoSkillDia) {
        this.notificacionSkillLlamadaYNivelServicioTodoSkillDia = notificacionSkillLlamadaYNivelServicioTodoSkillDia;
        this.manejadorSkillsLlamadasYNivelServicioTodoSkillDia = manejadorSkillsLlamadasYNivelServicioTodoSkillDia;
        this.consumirSkillsLlamadasYNivelServicioTodoSkillDia = consumirSkillsLlamadasYNivelServicioTodoSkillDia;
    }

    @RequestMapping(value= "/{ini}/{fin}", method = RequestMethod.POST)
    public String enviar(@PathVariable("ini") String ini, @PathVariable("fin") String fin) throws IOException {

        Response response= this.consumirSkillsLlamadasYNivelServicioTodoSkillDia.consumirr(ini,fin);
        boolean guardo= false;
        Gson gson= new Gson();
        String json;
        if(response.code()!=404) {
             json = response.body().string();
            ResponseSkillsLlamadasYNivelServicioTodoSkillDia responseSkillsLlamadasYNivelServicioTodoSkillDia = gson.fromJson(json, ResponseSkillsLlamadasYNivelServicioTodoSkillDia.class);
            try {
                this.manejadorSkillsLlamadasYNivelServicioTodoSkillDia.ejecutar(responseSkillsLlamadasYNivelServicioTodoSkillDia,ini,fin);
                guardo = true;
            } catch (Exception e) {
                return e.getMessage()+"\n"+ response.code()+ "\n"+ responseSkillsLlamadasYNivelServicioTodoSkillDia.getMsg();
            }
            System.out.println("guardo");


            this.notificacionSkillLlamadaYNivelServicioTodoSkillDia.ejecutar(guardo);
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
