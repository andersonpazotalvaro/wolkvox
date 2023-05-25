package co.smart.procesador.diagram.detalleesperainteligente.comando.manejador;

import co.smart.procesador.datos.servicio.ServicioGenerarFechasDiarias;
import co.smart.procesador.diagram.detalleesperainteligente.comando.ResponseDiagramDetalleEsperaInteligente;
import co.smart.procesador.diagram.detalleesperainteligente.comando.fabrica.FabricaDiagramDetalleEsperaInteligente;
import co.smart.procesador.diagram.detalleesperainteligente.consumir.ConsumirDiarioDetalleEsperaInteligente;
import co.smart.procesador.diagram.detalleesperainteligente.servicio.ServicioGuardarDiagramDetalleEsperaInteligente;
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
public class ManejadorDiagramDetalleEsperaInteligente {


    private final FabricaDiagramDetalleEsperaInteligente fabricaDiagramDetalleEsperaInteligente;
    private final ServicioGuardarDiagramDetalleEsperaInteligente servicioGuardarDiagramDetalleEsperaInteligente;
   private final ConsumirDiarioDetalleEsperaInteligente consumirDiarioDetalleEsperaInteligente;
    private final ServicioGenerarFechasDiarias servicioGenerarFechasDiarias;



    public Boolean ejecutar(ResponseDiagramDetalleEsperaInteligente responseDiagramDetalleEsperaInteligente, String ini, String fin){
        var datos = this.fabricaDiagramDetalleEsperaInteligente.obtenerDatos(responseDiagramDetalleEsperaInteligente);
        var listaDiagramDetalleEsperaInteligentes = this.fabricaDiagramDetalleEsperaInteligente.convertirRespuestaADominio(datos, ini, fin);
        return this.servicioGuardarDiagramDetalleEsperaInteligente.ejecutar(listaDiagramDetalleEsperaInteligentes);
    }

    //@Scheduled(cron= "@"+"${cron.midnight}")


    //@Scheduled(fixedDelay = 60000)
    public boolean ejecutarCiclo() throws IOException {
        String fechaString= this.servicioGenerarFechasDiarias.generarFechaIni();
        var response= this.consumirDiarioDetalleEsperaInteligente.consumir();
        var json = response.body().string();

        Gson gson= new Gson();
        ResponseDiagramDetalleEsperaInteligente responseDiagramDetalleEsperaInteligente = gson.fromJson(json, ResponseDiagramDetalleEsperaInteligente.class);
        boolean guardo= false;

        try {
            if(this.ejecutar(responseDiagramDetalleEsperaInteligente, fechaString,fechaString)){;
                guardo = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("guardo Diagram Detalle Espera Inteligente");

        return guardo;
    }

}
