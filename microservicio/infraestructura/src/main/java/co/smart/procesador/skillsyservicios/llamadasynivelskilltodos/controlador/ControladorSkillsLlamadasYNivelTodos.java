package co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.controlador;


import co.smart.procesador.skillsyservicios.email.servicio.NotificacionSkillLlamadaYNivelTodos;
import co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.comando.ResponseSkillsLlamadasYNivelTodos;
import co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.comando.manejador.ManejadorSkillsLlamadasYNivelTodos;
import co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.consumir.ConsumirSkillsLlamadasYNivelTodos;
import com.google.gson.Gson;
import okhttp3.Response;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("Llamadasyniveltodos")
public class ControladorSkillsLlamadasYNivelTodos {

        private final static String NO_SE_ENCONTRO_DATOS = "no se encontraron datos para estas fechas";

        private final NotificacionSkillLlamadaYNivelTodos notificacionSkillLlamadaYNivelTodos;

        private final ManejadorSkillsLlamadasYNivelTodos manejadorSkillsLlamadasYNivelTodos;

        private final ConsumirSkillsLlamadasYNivelTodos consumirSkillsLlamadasYNivelTodos;

    public ControladorSkillsLlamadasYNivelTodos(NotificacionSkillLlamadaYNivelTodos notificacionSkillLlamadaYNivelTodos, ManejadorSkillsLlamadasYNivelTodos manejadorSkillsLlamadasYNivelTodos, ConsumirSkillsLlamadasYNivelTodos consumirSkillsLlamadasYNivelTodos) {
        this.notificacionSkillLlamadaYNivelTodos = notificacionSkillLlamadaYNivelTodos;
        this.manejadorSkillsLlamadasYNivelTodos = manejadorSkillsLlamadasYNivelTodos;
        this.consumirSkillsLlamadasYNivelTodos = consumirSkillsLlamadasYNivelTodos;
    }


    @RequestMapping(value= "/{ini}/{fin}", method = RequestMethod.POST)
    public String enviar(@PathVariable("ini") String ini, @PathVariable("fin") String fin) throws IOException {

        Response response= this.consumirSkillsLlamadasYNivelTodos.consumirr(ini,fin);
        boolean guardo= false;
        Gson gson= new Gson();
        String json;
        if(response.code()!=404) {
             json = response.body().string();
            ResponseSkillsLlamadasYNivelTodos responseSkillsLlamadasYNivelTodos = gson.fromJson(json, ResponseSkillsLlamadasYNivelTodos.class);
            try {
                this.manejadorSkillsLlamadasYNivelTodos.ejecutar(responseSkillsLlamadasYNivelTodos,ini,fin);
                guardo = true;
            } catch (Exception e) {
                return e.getMessage()+"\n"+ response.code()+ "\n"+ responseSkillsLlamadasYNivelTodos.getMsg();
            }
            System.out.println("guardo");


            this.notificacionSkillLlamadaYNivelTodos.ejecutar(guardo);
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
