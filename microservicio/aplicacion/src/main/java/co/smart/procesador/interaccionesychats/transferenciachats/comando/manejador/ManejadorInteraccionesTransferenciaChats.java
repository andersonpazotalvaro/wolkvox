package co.smart.procesador.interaccionesychats.transferenciachats.comando.manejador;

import co.smart.procesador.datos.servicio.ServicioGenerarFechasDiarias;
import co.smart.procesador.interaccionesychats.transferenciachats.comando.ResponseInteraccionesTransferenciaChats;
import co.smart.procesador.interaccionesychats.transferenciachats.comando.fabrica.FabricaInteraccionesTransferenciaChats;
import co.smart.procesador.interaccionesychats.transferenciachats.consumir.ConsumirDiarioInteraccionesTransferenciaChats;
import co.smart.procesador.interaccionesychats.transferenciachats.servicio.ServicioGuardarInteraccionesTransferenciaChats;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;


@RequiredArgsConstructor
@Component
public class ManejadorInteraccionesTransferenciaChats {


    private final FabricaInteraccionesTransferenciaChats fabricaInteraccionesTransferenciaChats;
    private final ServicioGuardarInteraccionesTransferenciaChats servicioGuardarInteraccionesTransferenciaChats;
    private final ConsumirDiarioInteraccionesTransferenciaChats consumirDiarioInteraccionesTransferenciaChats;
    private final ServicioGenerarFechasDiarias servicioGenerarFechasDiarias;


    public Boolean ejecutar(ResponseInteraccionesTransferenciaChats responseInteraccionesTransferenciaChats, String ini, String fin){
        var datos = this.fabricaInteraccionesTransferenciaChats.obtenerDatos(responseInteraccionesTransferenciaChats);
        var listaInteraccionesTransferenciaChats= this.fabricaInteraccionesTransferenciaChats.convertirRespuestaADominio(datos,ini,fin);
        return this.servicioGuardarInteraccionesTransferenciaChats.ejecutar(listaInteraccionesTransferenciaChats);
    }

    //@Scheduled(cron= "@"+"${cron.midnight}")


    //@Scheduled(fixedDelay = 60000)
    public boolean ejecutarCiclo() throws IOException {
        String fechaString= this.servicioGenerarFechasDiarias.generarFechaIni();
        var response= this.consumirDiarioInteraccionesTransferenciaChats.consumir();
        var json = response.body().string();

        Gson gson= new Gson();
        ResponseInteraccionesTransferenciaChats responseInteraccionesTransferenciaChats = gson.fromJson(json, ResponseInteraccionesTransferenciaChats.class);
        boolean guardo= false;

        try {
            if(this.ejecutar(responseInteraccionesTransferenciaChats,fechaString,fechaString)){;
                guardo = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return guardo;
    }


}
