package co.smart.procesador.agentes.estadopohora.comando.manejador;

import co.smart.procesador.agentes.estadopohora.comando.ResponseAgenteEstadoPorHora;
import co.smart.procesador.agentes.estadopohora.comando.fabrica.FabricaAgenteEstadoPorHora;
import co.smart.procesador.agentes.estadoporhora.consumir.ConsumirDiarioEstadoPorHora;
import co.smart.procesador.agentes.estadoporhora.servicio.ServicioGuardarAgenteEstadoPorHora;

import co.smart.procesador.datos.servicio.ServicioGenerarFechasDiarias;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;


@RequiredArgsConstructor
@Component
public class ManejadorAgenteEstadoPorHora {


    private final FabricaAgenteEstadoPorHora fabricaAgenteEstadoPorHora;
    private final ServicioGuardarAgenteEstadoPorHora servicioGuardarAgenteEstadoPorHora;
   private final ConsumirDiarioEstadoPorHora consumirDiarioEstadoPorHora;
   private final ServicioGenerarFechasDiarias servicioGenerarFechasDiarias;



    public Boolean ejecutar(ResponseAgenteEstadoPorHora responseAgenteEstadoPorHora, String ini, String fin){
        var datos = this.fabricaAgenteEstadoPorHora.obtenerDatos(responseAgenteEstadoPorHora);
        var listaAgenteEstadoPorHora = this.fabricaAgenteEstadoPorHora.convertirRespuestaADominio(datos,ini, fin);
        return this.servicioGuardarAgenteEstadoPorHora.ejecutar(listaAgenteEstadoPorHora);
    }

    //@Scheduled(cron= "@"+"${cron.midnight}")


    //@Scheduled(fixedDelay = 60000)
    public boolean ejecutarCiclo() throws IOException {

        String fechaString= this.servicioGenerarFechasDiarias.generarFechaIni();

        var response= this.consumirDiarioEstadoPorHora.consumir();
        var json = response.body().string();

        Gson gson= new Gson();
        ResponseAgenteEstadoPorHora responseAgenteEstadoPorHora = gson.fromJson(json, ResponseAgenteEstadoPorHora.class);
        boolean guardo= false;

        try {
            if(this.ejecutar(responseAgenteEstadoPorHora,fechaString,fechaString)){;
                guardo = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("guardo agente estado por hora");

        return guardo;
    }

}
