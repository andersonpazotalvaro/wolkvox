package co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.controlador;


import co.smart.procesador.skillsyservicios.email.servicio.NotificacionSkillLlamadaYNivelServicioDia;
import co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.comando.ResponseSkillsLlamadasYNivelServicioDia;
import co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.comando.manejador.ManejadorSkillsLlamadasYNivelServicioDia;
import co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.consumir.ConsumirSkillsLlamadasYNivelServicioDia;
import com.google.gson.Gson;
import okhttp3.Response;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("Llamadasynivelserviciodia")
public class ControladorSkillsLlamadasYNivelServicioDia {

        private final static String NO_SE_ENCONTRO_DATOS = "no se encontraron datos para estas fechas";

        private final NotificacionSkillLlamadaYNivelServicioDia notificacionSkillLlamadaYNivelServicioDia;

        private final ManejadorSkillsLlamadasYNivelServicioDia manejadorSkillsLlamadasYNivelServicioDia;

        private final ConsumirSkillsLlamadasYNivelServicioDia consumirSkillsLlamadasYNivelServicioDia;


    public ControladorSkillsLlamadasYNivelServicioDia(NotificacionSkillLlamadaYNivelServicioDia notificacionSkillLlamadaYNivelServicioDia, ManejadorSkillsLlamadasYNivelServicioDia manejadorSkillsLlamadasYNivelServicioDia, ConsumirSkillsLlamadasYNivelServicioDia consumirSkillsLlamadasYNivelServicioDia) {
        this.notificacionSkillLlamadaYNivelServicioDia = notificacionSkillLlamadaYNivelServicioDia;
        this.manejadorSkillsLlamadasYNivelServicioDia = manejadorSkillsLlamadasYNivelServicioDia;
        this.consumirSkillsLlamadasYNivelServicioDia = consumirSkillsLlamadasYNivelServicioDia;
    }

    @RequestMapping(value= "/{ini}/{fin}", method = RequestMethod.POST)
    public String enviar(@PathVariable("ini") String ini, @PathVariable("fin") String fin) throws IOException  {

        Response response = null;
        try {
            response = this.consumirSkillsLlamadasYNivelServicioDia.consumirr(ini, fin);
        }catch (Exception e){

        }

        boolean guardo = false;
        Gson gson = new Gson();
        String json;
        if (response.code() != 404) {
            json = response.body().string();
            ResponseSkillsLlamadasYNivelServicioDia responseSkillsLlamadasYNivelServicioDia = gson.fromJson(json, ResponseSkillsLlamadasYNivelServicioDia.class);
            try {
                this.manejadorSkillsLlamadasYNivelServicioDia.ejecutar(responseSkillsLlamadasYNivelServicioDia,ini,fin);
                guardo = true;
            } catch (Exception e) {
                return e.getMessage()+"\n"+ response.code()+ "\n"+ responseSkillsLlamadasYNivelServicioDia.getMsg();
            }
            System.out.println("guardo");


            this.notificacionSkillLlamadaYNivelServicioDia.ejecutar(guardo);
            return json;
        } else {
            json = NO_SE_ENCONTRO_DATOS;
            return json;
        }

    }

    //@RequestMapping(value= "/{ini}/{fin}", method = RequestMethod.POST)
    /*public String enviarTodos(@PathVariable("ini") String ini, @PathVariable("fin") String fin){


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
