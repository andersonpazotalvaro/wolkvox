package co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.comando.manejador;

import co.smart.procesador.datos.servicio.ServicioGenerarFechasDiarias;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.comando.ResponseSkillsLlamadasYNivelServicioHora;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.comando.fabrica.FabricaSkillsLlamadasYNivelServicioHora;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.consumir.ConsumirDiarioSkillsLlamadasYNivelServicioHora;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciohora.servicio.ServicioGuardarSkillsLlamadasYNivelServicioHora;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;


@RequiredArgsConstructor
@Component
public class ManejadorSkillsLlamadasYNivelServicioHora {


    private final FabricaSkillsLlamadasYNivelServicioHora fabricaSkillsLlamadasYNivelServicioHora;
    private final ServicioGuardarSkillsLlamadasYNivelServicioHora servicioGuardarSkillsLlamadasYNivelServicioHora;
    private final ConsumirDiarioSkillsLlamadasYNivelServicioHora consumirDiarioSkillsLlamadasYNivelServicioHora;
    private final ServicioGenerarFechasDiarias servicioGenerarFechasDiarias;



    public Boolean ejecutar(ResponseSkillsLlamadasYNivelServicioHora responseSkillsLlamadasYNivelServicioHora, String ini, String fin){
        var datos = this.fabricaSkillsLlamadasYNivelServicioHora.obtenerDatos(responseSkillsLlamadasYNivelServicioHora);
        var listaSkillsLlamadasYNivelServicioHoras = this.fabricaSkillsLlamadasYNivelServicioHora.convertirRespuestaADominio(datos,ini,fin);
        return this.servicioGuardarSkillsLlamadasYNivelServicioHora.ejecutar(listaSkillsLlamadasYNivelServicioHoras);
    }

    //@Scheduled(cron= "@"+"${cron.midnight}")


    //@Scheduled(fixedDelay = 60000)
    public boolean ejecutarCiclo() throws IOException {
        String fechaString= this.servicioGenerarFechasDiarias.generarFechaIni();
        var response= this.consumirDiarioSkillsLlamadasYNivelServicioHora.consumir();
        var json = response.body().string();

        Gson gson= new Gson();
        ResponseSkillsLlamadasYNivelServicioHora responseSkillsLlamadasYNivelServicioHora = gson.fromJson(json, ResponseSkillsLlamadasYNivelServicioHora.class);
        boolean guardo= false;

        try {
            if(this.ejecutar(responseSkillsLlamadasYNivelServicioHora,fechaString,fechaString)){;
                guardo = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return guardo;
    }



}
