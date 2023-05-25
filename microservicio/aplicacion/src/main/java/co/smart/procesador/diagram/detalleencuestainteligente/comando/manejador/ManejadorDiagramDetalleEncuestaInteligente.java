package co.smart.procesador.diagram.detalleencuestainteligente.comando.manejador;

import co.smart.procesador.datos.servicio.ServicioGenerarFechasDiarias;
import co.smart.procesador.diagram.detalleencuestainteligente.comando.ResponseDiagramDetalleEncuestaInteligente;
import co.smart.procesador.diagram.detalleencuestainteligente.comando.fabrica.FabricaDiagramDetalleEncuestaInteligente;
import co.smart.procesador.diagram.detalleencuestainteligente.consumir.ConsumirDiarioDetalleEncuestaInteligente;
import co.smart.procesador.diagram.detalleencuestainteligente.servicio.ServicioGuardarDiagramDetalleEncuestaInteligente;
import co.smart.procesador.diagram.detalleesperainteligente.comando.ResponseDiagramDetalleEsperaInteligente;
import co.smart.procesador.diagram.detalleesperainteligente.comando.fabrica.FabricaDiagramDetalleEsperaInteligente;
import co.smart.procesador.diagram.detalleesperainteligente.consumir.ConsumirDiarioDetalleEsperaInteligente;
import co.smart.procesador.diagram.detalleesperainteligente.servicio.ServicioGuardarDiagramDetalleEsperaInteligente;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;


@RequiredArgsConstructor
@Component
public class ManejadorDiagramDetalleEncuestaInteligente {


    private final FabricaDiagramDetalleEncuestaInteligente fabricaDiagramDetalleEncuestaInteligente;
    private final ServicioGuardarDiagramDetalleEncuestaInteligente servicioGuardarDiagramDetalleEncuestaInteligente;
   private final ConsumirDiarioDetalleEncuestaInteligente consumirDiarioDetalleEncuestaInteligente;
    private final ServicioGenerarFechasDiarias servicioGenerarFechasDiarias;



    public Boolean ejecutar(ResponseDiagramDetalleEncuestaInteligente responseDiagramDetalleEncuestaInteligente, String ini, String fin){
        var datos = this.fabricaDiagramDetalleEncuestaInteligente.obtenerDatos(responseDiagramDetalleEncuestaInteligente);
        var listaDiagramDetalleEncuestaInteligentes = this.fabricaDiagramDetalleEncuestaInteligente.convertirRespuestaADominio(datos, ini, fin);
        return this.servicioGuardarDiagramDetalleEncuestaInteligente.ejecutar(listaDiagramDetalleEncuestaInteligentes);
    }

    //@Scheduled(cron= "@"+"${cron.midnight}")


    //@Scheduled(fixedDelay = 60000)
    public boolean ejecutarCiclo() throws IOException {
        String fechaString= this.servicioGenerarFechasDiarias.generarFechaIni();
        var response= this.consumirDiarioDetalleEncuestaInteligente.consumir();
        var json = response.body().string();

        Gson gson= new Gson();
        ResponseDiagramDetalleEncuestaInteligente responseDiagramDetalleEncuestaInteligente = gson.fromJson(json, ResponseDiagramDetalleEncuestaInteligente.class);
        boolean guardo= false;

        try {
            if(this.ejecutar(responseDiagramDetalleEncuestaInteligente,fechaString,fechaString)){;
                guardo = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("guardo Diagram Detalle Encuesta Inteligente");

        return guardo;
    }

}
