package co.smart.procesador.skillsyservicios.workforceporhora.controlador;


import co.smart.procesador.skillsyservicios.email.servicio.NotificacionSkillWorkforceHora;
import co.smart.procesador.skillsyservicios.workforceporhora.comando.ResponseSkillsWorkforceHora;
import co.smart.procesador.skillsyservicios.workforceporhora.comando.menejador.ManejadorSkillsWorkforceHora;
import co.smart.procesador.skillsyservicios.workforceporhora.consumir.ConsumirSkillsWorkforceHora;
import com.google.gson.Gson;
import okhttp3.Response;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("Workforceporhora")
public class ControladorSkillsWorkforceHora {

        private final static String NO_SE_ENCONTRO_DATOS = "no se encontraron datos para estas fechas";

        private final NotificacionSkillWorkforceHora notificacionSkillWorkforceHora;

        private final ManejadorSkillsWorkforceHora manejadorSkillsWorkforceHora;

        private final ConsumirSkillsWorkforceHora consumirSkillsWorkforceHora;

    public ControladorSkillsWorkforceHora(NotificacionSkillWorkforceHora notificacionSkillWorkforceHora, ManejadorSkillsWorkforceHora manejadorSkillsWorkforceHora, ConsumirSkillsWorkforceHora consumirSkillsWorkforceHora) {
        this.notificacionSkillWorkforceHora = notificacionSkillWorkforceHora;
        this.manejadorSkillsWorkforceHora = manejadorSkillsWorkforceHora;
        this.consumirSkillsWorkforceHora = consumirSkillsWorkforceHora;
    }

    @RequestMapping(value= "/{ini}/{fin}", method = RequestMethod.POST)
    public String enviar(@PathVariable("ini") String ini, @PathVariable("fin") String fin) throws IOException {

        Response response= this.consumirSkillsWorkforceHora.consumirr(ini,fin);
        boolean guardo= false;
        Gson gson= new Gson();
        String json;
        if(response.code()!=404) {
             json = response.body().string();
            ResponseSkillsWorkforceHora responseSkillsWorkforceHora= gson.fromJson(json, ResponseSkillsWorkforceHora.class);
            try {
                this.manejadorSkillsWorkforceHora.ejecutar(responseSkillsWorkforceHora,ini,fin);
                guardo = true;
            } catch (Exception e) {
                return e.getMessage()+"\n"+ response.code()+ "\n"+ responseSkillsWorkforceHora.getMsg();
            }
            System.out.println("guardo");


            this.notificacionSkillWorkforceHora.ejecutar(guardo);
            return json;
        }
        else {
            json= NO_SE_ENCONTRO_DATOS;
            return json;
        }

    }



   }
