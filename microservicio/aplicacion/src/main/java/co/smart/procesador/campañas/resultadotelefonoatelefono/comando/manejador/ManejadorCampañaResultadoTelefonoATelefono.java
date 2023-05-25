package co.smart.procesador.campañas.resultadotelefonoatelefono.comando.manejador;

import co.smart.procesador.campañas.resultadotelefonoatelefono.comando.ResponseCampañaResultadoTelefonoATelefono;
import co.smart.procesador.campañas.resultadotelefonoatelefono.comando.fabrica.FabricaCampañaResultadoTelefonoATelefono;
import co.smart.procesador.campañas.resultadotelefonoatelefono.consumir.ConsumirDiarioResultadoTelefonoATelefono;
import co.smart.procesador.campañas.resultadotelefonoatelefono.servicio.ServicioGuardarCampañaResultadoTelefonoATelefono;
import co.smart.procesador.datos.servicio.ServicioGenerarFechasDiarias;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;


@RequiredArgsConstructor
@Component
public class ManejadorCampañaResultadoTelefonoATelefono {


    private final FabricaCampañaResultadoTelefonoATelefono fabricaCampañaResultadoTelefonoATelefono;
    private final ServicioGuardarCampañaResultadoTelefonoATelefono servicioGuardarCampañaResultadoTelefonoATelefono;
    private final ConsumirDiarioResultadoTelefonoATelefono consumirDiarioResultadoTelefonoATelefono;
    private final ServicioGenerarFechasDiarias servicioGenerarFechasDiarias;

    public Boolean ejecutar(ResponseCampañaResultadoTelefonoATelefono responseCampañaResultadoTelefonoATelefono, String ini, String fin){
        var datos = this.fabricaCampañaResultadoTelefonoATelefono.obtenerDatos(responseCampañaResultadoTelefonoATelefono);
        var listaCampañaResultadoTelefonoATelefonos = this.fabricaCampañaResultadoTelefonoATelefono.convertirRespuestaADominio(datos, ini, fin);
        return this.servicioGuardarCampañaResultadoTelefonoATelefono.ejecutar(listaCampañaResultadoTelefonoATelefonos);
    }


    //@Scheduled(cron= "@"+"${cron.midnight}")


    //@Scheduled(fixedDelay = 60000)
    public boolean ejecutarCiclo() throws IOException {
        String fechaString= this.servicioGenerarFechasDiarias.generarFechaIni();
        var response= this.consumirDiarioResultadoTelefonoATelefono.consumir();
        var json = response.body().string();

        Gson gson= new Gson();
        ResponseCampañaResultadoTelefonoATelefono responseCampañaResultadoTelefonoATelefono = gson.fromJson(json, ResponseCampañaResultadoTelefonoATelefono.class);
        boolean guardo= false;

        try {
            if(this.ejecutar(responseCampañaResultadoTelefonoATelefono, fechaString, fechaString)){;
                guardo = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("guardo Campaña Resultado Telefono a Telefono");

        return guardo;
    }

}
