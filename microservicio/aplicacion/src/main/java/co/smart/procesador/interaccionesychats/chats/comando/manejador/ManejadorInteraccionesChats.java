package co.smart.procesador.interaccionesychats.chats.comando.manejador;

import co.smart.procesador.datos.servicio.ServicioGenerarFechasDiarias;
import co.smart.procesador.interaccionesychats.chats.comando.ResponseInteraccionesChats;
import co.smart.procesador.interaccionesychats.chats.comando.fabrica.FabricaInteraccionesChats;
import co.smart.procesador.interaccionesychats.chats.consumir.ConsumirDiarioInteraccionesChats;
import co.smart.procesador.interaccionesychats.chats.servicio.ServicioGuardarInteraccionesChats;
import co.smart.procesador.skillsyservicios.workforceporhora.comando.ResponseSkillsWorkforceHora;
import co.smart.procesador.skillsyservicios.workforceporhora.comando.fabrica.FabricaSkillsWorkforceHora;
import co.smart.procesador.skillsyservicios.workforceporhora.consumir.ConsumirDiarioSkillsWorkforceHora;
import co.smart.procesador.skillsyservicios.workforceporhora.servicio.ServicioGuardarSkillsWorkforceHora;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;


@RequiredArgsConstructor
@Component
public class ManejadorInteraccionesChats {


    private final FabricaInteraccionesChats fabricaInteraccionesChats;
    private final ServicioGuardarInteraccionesChats servicioGuardarInteraccionesChats;
    private final ConsumirDiarioInteraccionesChats consumirDiarioInteraccionesChats;
    private final ServicioGenerarFechasDiarias servicioGenerarFechasDiarias;

    public Boolean ejecutar(ResponseInteraccionesChats responseInteraccionesChats, String ini, String fin){
        var datos = this.fabricaInteraccionesChats.obtenerDatos(responseInteraccionesChats);
        var listaInteraccionesChats= this.fabricaInteraccionesChats.convertirRespuestaADominio(datos, ini,fin);
        return this.servicioGuardarInteraccionesChats.ejecutar(listaInteraccionesChats);
    }

    //@Scheduled(cron= "@"+"${cron.midnight}")


    //@Scheduled(fixedDelay = 60000)
    public boolean ejecutarCiclo() throws IOException {
        String fechaString= this.servicioGenerarFechasDiarias.generarFechaIni();
        var response= this.consumirDiarioInteraccionesChats.consumir();
        var json = response.body().string();

        Gson gson= new Gson();
        ResponseInteraccionesChats responseInteraccionesChats = gson.fromJson(json, ResponseInteraccionesChats.class);
        boolean guardo= false;

        try {
            if(this.ejecutar(responseInteraccionesChats,fechaString,fechaString)){;
                guardo = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return guardo;
    }


}
