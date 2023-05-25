package co.smart.procesador.skillsyservicios.workforceporhora.comando.menejador;

import co.smart.procesador.datos.servicio.ServicioGenerarFechasDiarias;
import co.smart.procesador.skillsyservicios.detallellamadascontestadas.comando.ResponseSkillsDetallesLlamadasContestadas;
import co.smart.procesador.skillsyservicios.detallellamadascontestadas.comando.fabrica.FabricaSkillsDetalleLlamadasContestadas;
import co.smart.procesador.skillsyservicios.detallellamadascontestadas.consumir.ConsumirDiarioSkillsDetalleLlamadasContestadas;
import co.smart.procesador.skillsyservicios.detallellamadascontestadas.servicio.ServicioGuardarSkillsDetalleLlamadasContestadas;
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
public class ManejadorSkillsWorkforceHora {


    private final FabricaSkillsWorkforceHora fabricaSkillsWorkforceHora;
    private final ServicioGuardarSkillsWorkforceHora servicioGuardarSkillsWorkforceHora;
    private final ConsumirDiarioSkillsWorkforceHora consumirDiarioSkillsWorkforceHora;
    private final ServicioGenerarFechasDiarias servicioGenerarFechasDiarias;


    public Boolean ejecutar(ResponseSkillsWorkforceHora responseSkillsWorkforceHora, String ini, String fin){
        var datos = this.fabricaSkillsWorkforceHora.obtenerDatos(responseSkillsWorkforceHora);
        var listaSkillsWorkforceHoras= this.fabricaSkillsWorkforceHora.convertirRespuestaADominio(datos,ini,fin);
        return this.servicioGuardarSkillsWorkforceHora.ejecutar(listaSkillsWorkforceHoras);
    }

    //@Scheduled(cron= "@"+"${cron.midnight}")


    //@Scheduled(fixedDelay = 60000)
    public boolean ejecutarCiclo() throws IOException {
        String fechaString= this.servicioGenerarFechasDiarias.generarFechaIni();
        var response= this.consumirDiarioSkillsWorkforceHora.consumir();
        var json = response.body().string();

        Gson gson= new Gson();
        ResponseSkillsWorkforceHora responseSkillsWorkforceHora = gson.fromJson(json, ResponseSkillsWorkforceHora.class);
        boolean guardo= false;

        try {
            if(this.ejecutar(responseSkillsWorkforceHora,fechaString,fechaString)){;
                guardo = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return guardo;
    }


}
