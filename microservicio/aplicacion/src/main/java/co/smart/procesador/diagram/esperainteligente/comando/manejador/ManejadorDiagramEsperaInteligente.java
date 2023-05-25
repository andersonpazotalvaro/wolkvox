package co.smart.procesador.diagram.esperainteligente.comando.manejador;

import co.smart.procesador.agentes.estadopohora.comando.ResponseAgenteEstadoPorHora;
import co.smart.procesador.agentes.estadopohora.comando.fabrica.FabricaAgenteEstadoPorHora;
import co.smart.procesador.agentes.estadoporhora.consumir.ConsumirDiarioEstadoPorHora;
import co.smart.procesador.agentes.estadoporhora.servicio.ServicioGuardarAgenteEstadoPorHora;
import co.smart.procesador.datos.servicio.ServicioGenerarFechasDiarias;
import co.smart.procesador.diagram.esperainteligente.comando.ResponseDiagramEsperaInteligente;
import co.smart.procesador.diagram.esperainteligente.comando.fabrica.FabricaDiagramEsperaInteligente;
import co.smart.procesador.diagram.esperainteligente.consumir.ConsumirDiarioEsperaInteligente;
import co.smart.procesador.diagram.esperainteligente.servicio.ServicioGuardarDiagramEsperaInteligente;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;


@RequiredArgsConstructor
@Component
public class ManejadorDiagramEsperaInteligente {


    private final FabricaDiagramEsperaInteligente fabricaDiagramEsperaInteligente;
    private final ServicioGuardarDiagramEsperaInteligente servicioGuardarDiagramEsperaInteligente;
   private final ConsumirDiarioEsperaInteligente consumirDiarioEsperaInteligente;
    private final ServicioGenerarFechasDiarias servicioGenerarFechasDiarias;



    public Boolean ejecutar(ResponseDiagramEsperaInteligente responseDiagramEsperaInteligente, String ini, String fin){
        var datos = this.fabricaDiagramEsperaInteligente.obtenerDatos(responseDiagramEsperaInteligente);
        var listaDiagramEsperaInteligentes = this.fabricaDiagramEsperaInteligente.convertirRespuestaADominio(datos,ini,fin);
        return this.servicioGuardarDiagramEsperaInteligente.ejecutar(listaDiagramEsperaInteligentes);
    }

    //@Scheduled(cron= "@"+"${cron.midnight}")


    //@Scheduled(fixedDelay = 60000)
    public boolean ejecutarCiclo() throws IOException {
        String fechaString= this.servicioGenerarFechasDiarias.generarFechaIni();
        var response= this.consumirDiarioEsperaInteligente.consumir();
        var json = response.body().string();

        Gson gson= new Gson();
        ResponseDiagramEsperaInteligente responseDiagramEsperaInteligente = gson.fromJson(json, ResponseDiagramEsperaInteligente.class);
        boolean guardo= false;

        try {
            if(this.ejecutar(responseDiagramEsperaInteligente,fechaString,fechaString)){;
                guardo = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("guardo Diagram Espera Inteligente");

        return guardo;
    }

}
