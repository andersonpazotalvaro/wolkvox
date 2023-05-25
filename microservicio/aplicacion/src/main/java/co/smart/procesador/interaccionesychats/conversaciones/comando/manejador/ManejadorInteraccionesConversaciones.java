package co.smart.procesador.interaccionesychats.conversaciones.comando.manejador;

import co.smart.procesador.datos.servicio.ServicioGenerarFechasDiarias;
import co.smart.procesador.interaccionesychats.chats.comando.ResponseInteraccionesChats;
import co.smart.procesador.interaccionesychats.chats.comando.fabrica.FabricaInteraccionesChats;
import co.smart.procesador.interaccionesychats.chats.consumir.ConsumirDiarioInteraccionesChats;
import co.smart.procesador.interaccionesychats.chats.servicio.ServicioGuardarInteraccionesChats;
import co.smart.procesador.interaccionesychats.conversaciones.comando.ResponseInteraccionesConversaciones;
import co.smart.procesador.interaccionesychats.conversaciones.comando.fabrica.FabricaInteraccionesConversaciones;
import co.smart.procesador.interaccionesychats.conversaciones.consumir.ConsumirDiarioInteraccionesConversaciones;
import co.smart.procesador.interaccionesychats.conversaciones.servicio.ServicioGuardarInteraccionesConversaciones;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;


@RequiredArgsConstructor
@Component
public class ManejadorInteraccionesConversaciones {


    private final FabricaInteraccionesConversaciones fabricaInteraccionesConversaciones;
    private final ServicioGuardarInteraccionesConversaciones servicioGuardarInteraccionesConversaciones;
    private final ConsumirDiarioInteraccionesConversaciones consumirDiarioInteraccionesConversaciones;
    private final ServicioGenerarFechasDiarias servicioGenerarFechasDiarias;




    public Boolean ejecutar(ResponseInteraccionesConversaciones responseInteraccionesConversaciones, String ini, String fin){
        var datos = this.fabricaInteraccionesConversaciones.obtenerDatos(responseInteraccionesConversaciones);
        var listaInteraccionesChats= this.fabricaInteraccionesConversaciones.convertirRespuestaADominio(datos,ini,fin);
        return this.servicioGuardarInteraccionesConversaciones.ejecutar(listaInteraccionesChats);
    }

    //@Scheduled(cron= "@"+"${cron.midnight}")


    //@Scheduled(fixedDelay = 60000)
    public boolean ejecutarCiclo() throws IOException {
        String fechaString= this.servicioGenerarFechasDiarias.generarFechaIni();
        var response= this.consumirDiarioInteraccionesConversaciones.consumir();
        var json = response.body().string();

        Gson gson= new Gson();
        ResponseInteraccionesConversaciones responseInteraccionesConversaciones = gson.fromJson(json, ResponseInteraccionesConversaciones.class);
        boolean guardo= false;

        try {
            if(this.ejecutar(responseInteraccionesConversaciones,fechaString,fechaString)){;
                guardo = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return guardo;
    }


}
