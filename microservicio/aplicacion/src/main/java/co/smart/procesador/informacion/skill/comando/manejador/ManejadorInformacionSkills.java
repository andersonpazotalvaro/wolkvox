package co.smart.procesador.informacion.skill.comando.manejador;

import co.smart.procesador.informacion.skill.comando.ResponseInformacionSkills;
import co.smart.procesador.informacion.skill.comando.fabrica.FabricaInformacionSkills;
import co.smart.procesador.informacion.skill.consumir.ConsumirDiarioInformacionSkills;
import co.smart.procesador.informacion.skill.servicio.ServicioGuardarInformacionSkills;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;


@RequiredArgsConstructor
@Component
public class ManejadorInformacionSkills {


    private final FabricaInformacionSkills fabricaInformacionSkills;
    private final ServicioGuardarInformacionSkills servicioGuardarInformacionSkills;
    private final ConsumirDiarioInformacionSkills consumirDiarioInformacionSkills;


    public Boolean ejecutar(ResponseInformacionSkills responseInformacionSkills){
        var datos = this.fabricaInformacionSkills.obtenerDatos(responseInformacionSkills);
        var listaInformacionSkills= this.fabricaInformacionSkills.convertirRespuestaADominio(datos);
        return this.servicioGuardarInformacionSkills.ejecutar(listaInformacionSkills);
    }

    //@Scheduled(cron= "@"+"${cron.midnight}")


    //@Scheduled(fixedDelay = 60000)
    public boolean ejecutarCiclo() throws IOException {
        var response= this.consumirDiarioInformacionSkills.consumir();
        var json = response.body().string();

        Gson gson= new Gson();
        ResponseInformacionSkills responseInformacionSkills = gson.fromJson(json, ResponseInformacionSkills.class);
        boolean guardo= false;

        try {
            if(this.ejecutar(responseInformacionSkills)){;
                guardo = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return guardo;
    }


}
