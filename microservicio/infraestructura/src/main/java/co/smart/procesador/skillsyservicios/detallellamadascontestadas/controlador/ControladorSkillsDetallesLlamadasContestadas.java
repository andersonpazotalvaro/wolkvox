package co.smart.procesador.skillsyservicios.detallellamadascontestadas.controlador;


import co.smart.procesador.skillsyservicios.detallellamadascontestadas.comando.ResponseSkillsDetallesLlamadasContestadas;
import co.smart.procesador.skillsyservicios.detallellamadascontestadas.comando.manejador.ManejadorSkillsDetallesLlamadasContestadas;
import co.smart.procesador.skillsyservicios.detallellamadascontestadas.consumir.ConsumirSkillsDetallesLlamadasContestadas;
import co.smart.procesador.skillsyservicios.email.servicio.NotificacionSkillDetalleLlamadasContestadas;
import com.google.gson.Gson;
import okhttp3.Response;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("Detallellamadascontestadas")
public class ControladorSkillsDetallesLlamadasContestadas {

        private final static String NO_SE_ENCONTRO_DATOS = "no se encontraron datos para estas fechas";

        private final NotificacionSkillDetalleLlamadasContestadas notificacionSkillDetalleLlamadasContestadas;

        private final ManejadorSkillsDetallesLlamadasContestadas manejadorSkillsDetallesLlamadasContestadas;

        private final ConsumirSkillsDetallesLlamadasContestadas consumirSkillsDetallesLlamadasContestadas;

    public ControladorSkillsDetallesLlamadasContestadas(NotificacionSkillDetalleLlamadasContestadas notificacionSkillDetalleLlamadasContestadas, ManejadorSkillsDetallesLlamadasContestadas manejadorSkillsDetallesLlamadasContestadas, ConsumirSkillsDetallesLlamadasContestadas consumirSkillsDetallesLlamadasContestadas) {
        this.notificacionSkillDetalleLlamadasContestadas = notificacionSkillDetalleLlamadasContestadas;
        this.manejadorSkillsDetallesLlamadasContestadas = manejadorSkillsDetallesLlamadasContestadas;
        this.consumirSkillsDetallesLlamadasContestadas = consumirSkillsDetallesLlamadasContestadas;
    }

    @RequestMapping(value= "/{ini}/{fin}", method = RequestMethod.POST)
    public String enviar(@PathVariable("ini") String ini, @PathVariable("fin") String fin) throws IOException {

        Response response= this.consumirSkillsDetallesLlamadasContestadas.consumirr(ini,fin);
        boolean guardo= false;
        Gson gson= new Gson();
        String json;
        if(response.code()!=404) {
             json = response.body().string();
            ResponseSkillsDetallesLlamadasContestadas responseSkillsDetallesLlamadasContestadas= gson.fromJson(json, ResponseSkillsDetallesLlamadasContestadas.class);
            try {
                this.manejadorSkillsDetallesLlamadasContestadas.ejecutar(responseSkillsDetallesLlamadasContestadas,ini,fin);
                guardo = true;
            } catch (Exception e) {
                return e.getMessage()+"\n"+ response.code()+ "\n"+ responseSkillsDetallesLlamadasContestadas.getMsg();
            }
            System.out.println("guardo");


            this.notificacionSkillDetalleLlamadasContestadas.ejecutar(guardo);
            return json;
        }
        else {
            json= NO_SE_ENCONTRO_DATOS;
            return json;
        }

    }



   }
