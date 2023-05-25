package co.smart.procesador.campañas.resultadomaquinafinal.controlador;

import co.smart.procesador.campañas.email.servicio.NotificacionCampañaResultadoMaquinaFinal;
import co.smart.procesador.campañas.resultadomaquinafinal.comando.ResponseCampañaResultadoMaquinaFinal;
import co.smart.procesador.campañas.resultadomaquinafinal.comando.manejador.ManejadorCampañaResultadoMaquinaFinal;
import co.smart.procesador.campañas.resultadomaquinafinal.consumir.ConsumirResultadoMaquinaFinal;
import com.google.gson.Gson;
import okhttp3.Response;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("CampañaResultadoMaquinaFinal")
public class ControladorCampañaResultadoMaquinaFinal {

        private final static String NO_SE_ENCONTRO_CAMPAÑA = "no se encontro campaña para esta fecha";

        private final NotificacionCampañaResultadoMaquinaFinal notificacionCampañaResultadoMaquinaFinal;

        private final ManejadorCampañaResultadoMaquinaFinal manejadorCampañaResultadoMaquinaFinal;

        private final ConsumirResultadoMaquinaFinal consumirResultadoMaquinaFinal;

    public ControladorCampañaResultadoMaquinaFinal(NotificacionCampañaResultadoMaquinaFinal notificacionCampañaResultadoMaquinaFinal, ManejadorCampañaResultadoMaquinaFinal manejadorCampañaResultadoMaquinaFinal, ConsumirResultadoMaquinaFinal consumirResultadoMaquinaFinal) {
        this.notificacionCampañaResultadoMaquinaFinal = notificacionCampañaResultadoMaquinaFinal;
        this.manejadorCampañaResultadoMaquinaFinal = manejadorCampañaResultadoMaquinaFinal;
        this.consumirResultadoMaquinaFinal = consumirResultadoMaquinaFinal;
    }


    @RequestMapping(value= "/{ini}/{fin}/{campana}", method = RequestMethod.POST)
    public String enviar(@PathVariable("ini") String ini, @PathVariable("fin") String fin, @PathVariable("campana") String campaña) throws IOException {

        Response response= this.consumirResultadoMaquinaFinal.consumirr(ini,fin,campaña);
        boolean guardo= false;
        Gson gson= new Gson();
        String json;
        if(response.code()!=404) {
             json = response.body().string();
            ResponseCampañaResultadoMaquinaFinal responseCampañaResultadoMaquinaFinal = gson.fromJson(json, ResponseCampañaResultadoMaquinaFinal.class);
            try {
                this.manejadorCampañaResultadoMaquinaFinal.ejecutar(responseCampañaResultadoMaquinaFinal, ini, fin);
                guardo = true;
            } catch (Exception e) {
                return e.getMessage()+"\n"+ response.code()+ "\n"+ responseCampañaResultadoMaquinaFinal.getMsg();
            }
            System.out.println("guardo");


            this.notificacionCampañaResultadoMaquinaFinal.ejecutar(guardo);
            return json;
        }
        else {
            json= NO_SE_ENCONTRO_CAMPAÑA;
            return json;
        }

    }


   }
