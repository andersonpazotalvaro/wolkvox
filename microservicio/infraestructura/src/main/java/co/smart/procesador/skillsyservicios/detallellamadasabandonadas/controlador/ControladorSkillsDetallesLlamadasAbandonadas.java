package co.smart.procesador.skillsyservicios.detallellamadasabandonadas.controlador;


import co.smart.procesador.skillsyservicios.detallellamadasabandonadas.comando.ResponseSkillsDetallesLlamadasAbandonadas;
import co.smart.procesador.skillsyservicios.detallellamadasabandonadas.comando.manejador.ManejadorSkillsDetallesLlamadasAbandonadas;
import co.smart.procesador.skillsyservicios.detallesllamadasabandonadas.consumir.ConsumirSkillsDetallesLlamadasAbandonadas;
import co.smart.procesador.skillsyservicios.email.servicio.NotificacionSkillDetalleLlamadasAbandonadas;
import com.google.gson.Gson;
import okhttp3.Response;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("Detallellamadasabandonadas")
public class ControladorSkillsDetallesLlamadasAbandonadas {

        private final static String NO_SE_ENCONTRO_DATOS = "no se encontraron datos para estas fechas";

        private final NotificacionSkillDetalleLlamadasAbandonadas notificacionSkillDetalleLlamadasAbandonadas;

        private final ManejadorSkillsDetallesLlamadasAbandonadas manejadorSkillsDetalleLlamadasAbandonadas;

        private final ConsumirSkillsDetallesLlamadasAbandonadas consumirSkillsDetalleLlamadasAbandonadas;


    public ControladorSkillsDetallesLlamadasAbandonadas(NotificacionSkillDetalleLlamadasAbandonadas notificacionSkillDetalleLlamadasAbandonadas, ManejadorSkillsDetallesLlamadasAbandonadas manejadorSkillsDetalleLlamadasAbandonadas, ConsumirSkillsDetallesLlamadasAbandonadas consumirSkillsDetalleLlamadasAbandonadas) {
        this.notificacionSkillDetalleLlamadasAbandonadas = notificacionSkillDetalleLlamadasAbandonadas;
        this.manejadorSkillsDetalleLlamadasAbandonadas = manejadorSkillsDetalleLlamadasAbandonadas;
        this.consumirSkillsDetalleLlamadasAbandonadas = consumirSkillsDetalleLlamadasAbandonadas;
    }


     @RequestMapping(value= "/{ini}/{fin}", method = RequestMethod.POST)
    public String enviar(@PathVariable("ini") String ini, @PathVariable("fin") String fin) throws IOException {

        Response response= this.consumirSkillsDetalleLlamadasAbandonadas.consumirr(ini,fin);
        boolean guardo= false;
        Gson gson= new Gson();
        String json;
        if(response.code()!=404) {
             json = response.body().string();
            ResponseSkillsDetallesLlamadasAbandonadas responseSkillsDetalleLlamadasAbandonadas= gson.fromJson(json, ResponseSkillsDetallesLlamadasAbandonadas.class);
            try {
                this.manejadorSkillsDetalleLlamadasAbandonadas.ejecutar(responseSkillsDetalleLlamadasAbandonadas,ini,fin);
                guardo = true;
            } catch (Exception e) {
                return e.getMessage()+"\n"+ response.code()+ "\n"+ responseSkillsDetalleLlamadasAbandonadas.getMsg();
            }
            System.out.println("guardo");


            this.notificacionSkillDetalleLlamadasAbandonadas.ejecutar(guardo);
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
        return "Guardaron Detalle Llamadas Abandonadas";
    }*/


   }
