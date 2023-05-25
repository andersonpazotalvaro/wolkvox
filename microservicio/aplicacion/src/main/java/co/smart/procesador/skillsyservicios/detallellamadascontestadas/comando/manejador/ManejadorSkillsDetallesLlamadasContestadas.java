package co.smart.procesador.skillsyservicios.detallellamadascontestadas.comando.manejador;

import co.smart.procesador.datos.servicio.ServicioGenerarFechasDiarias;
import co.smart.procesador.skillsyservicios.detallellamadascontestadas.comando.ResponseSkillsDetallesLlamadasContestadas;
import co.smart.procesador.skillsyservicios.detallellamadascontestadas.comando.fabrica.FabricaSkillsDetalleLlamadasContestadas;
import co.smart.procesador.skillsyservicios.detallellamadascontestadas.consumir.ConsumirDiarioSkillsDetalleLlamadasContestadas;
import co.smart.procesador.skillsyservicios.detallellamadascontestadas.servicio.ServicioGuardarSkillsDetalleLlamadasContestadas;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;


@RequiredArgsConstructor
@Component
public class ManejadorSkillsDetallesLlamadasContestadas {


    private final FabricaSkillsDetalleLlamadasContestadas fabricaSkillsDetalleLlamadasContestadas;
    private final ServicioGuardarSkillsDetalleLlamadasContestadas servicioGuardarSkillsDetalleLlamadasContestadas;
    private final ConsumirDiarioSkillsDetalleLlamadasContestadas consumirDiarioSkillsDetalleLlamadasContestadas;
    private final ServicioGenerarFechasDiarias servicioGenerarFechasDiarias;


    public Boolean ejecutar(ResponseSkillsDetallesLlamadasContestadas responseSkillsDetallesLlamadasContestadas, String ini, String fin){
        var datos = this.fabricaSkillsDetalleLlamadasContestadas.obtenerDatos(responseSkillsDetallesLlamadasContestadas);
        var listaSkillsDetalleLlamadasContestadas= this.fabricaSkillsDetalleLlamadasContestadas.convertirRespuestaADominio(datos,ini,fin);
        return this.servicioGuardarSkillsDetalleLlamadasContestadas.ejecutar(listaSkillsDetalleLlamadasContestadas);
    }

    //@Scheduled(cron= "@"+"${cron.midnight}")


    //@Scheduled(fixedDelay = 60000)
    public boolean ejecutarCiclo() throws IOException {
        String fechaString= this.servicioGenerarFechasDiarias.generarFechaIni();
        var response= this.consumirDiarioSkillsDetalleLlamadasContestadas.consumir();
        var json = response.body().string();

        Gson gson= new Gson();
        ResponseSkillsDetallesLlamadasContestadas responseSkillsDetallesLlamadasContestadas = gson.fromJson(json, ResponseSkillsDetallesLlamadasContestadas.class);
        boolean guardo= false;

        try {
            if(this.ejecutar(responseSkillsDetallesLlamadasContestadas,fechaString,fechaString)){;
                guardo = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return guardo;
    }


}
