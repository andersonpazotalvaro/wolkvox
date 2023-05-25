package co.smart.procesador.informacion.codigosactividad.comando.manejador;

import co.smart.procesador.informacion.codigosactividad.comando.ResponseInformacionCodigosActividad;
import co.smart.procesador.informacion.codigosactividad.comando.fabrica.FabricaInformacionCodigosActividad;
import co.smart.procesador.informacion.codigosactividad.consumir.ConsumirDiarioInformacionCodigosActividad;
import co.smart.procesador.informacion.codigosactividad.servicio.ServicioGuardarInformacionCodigosActividad;
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
public class ManejadorInformacionCodigosActividad {


    private final FabricaInformacionCodigosActividad fabricaInformacionCodigosActividad;
    private final ServicioGuardarInformacionCodigosActividad servicioGuardarInformacionCodigosActividad;
    private final ConsumirDiarioInformacionCodigosActividad consumirDiarioInformacionCodigosActividad;


    public Boolean ejecutar(ResponseInformacionCodigosActividad responseInformacionCodigosActividad){
        var datos = this.fabricaInformacionCodigosActividad.obtenerDatos(responseInformacionCodigosActividad);
        var listaInformacionCodigosActividads= this.fabricaInformacionCodigosActividad.convertirRespuestaADominio(datos);
        return this.servicioGuardarInformacionCodigosActividad.ejecutar(listaInformacionCodigosActividads);
    }

    //@Scheduled(cron= "@"+"${cron.midnight}")


    //@Scheduled(fixedDelay = 60000)
    public boolean ejecutarCiclo() throws IOException {
        var response= this.consumirDiarioInformacionCodigosActividad.consumir();
        var json = response.body().string();

        Gson gson= new Gson();
        ResponseInformacionCodigosActividad responseInformacionCodigosActividad = gson.fromJson(json, ResponseInformacionCodigosActividad.class);
        boolean guardo= false;

        try {
            if(this.ejecutar(responseInformacionCodigosActividad)){;
                guardo = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return guardo;
    }


}
