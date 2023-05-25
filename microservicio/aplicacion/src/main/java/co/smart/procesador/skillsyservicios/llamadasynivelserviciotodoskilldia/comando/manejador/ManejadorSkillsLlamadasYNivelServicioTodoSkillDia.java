package co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.comando.manejador;

import co.smart.procesador.datos.servicio.ServicioGenerarFechasDiarias;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.comando.ResponseSkillsLlamadasYNivelServicioTodoSkillDia;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.comando.fabrica.FabricaSkillsLlamadasYNivelServicioTodoSkillDia;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.consumir.ConsumirDiarioSkillsLlamadasYNivelServicioTodoSkillDia;
import co.smart.procesador.skillsyservicios.llamadasynivelserviciotodoskilldia.servicio.ServicioGuardarSkillsLlamadasYNivelServicioTodoSkillDia;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;


@RequiredArgsConstructor
@Component
public class ManejadorSkillsLlamadasYNivelServicioTodoSkillDia {


    private final FabricaSkillsLlamadasYNivelServicioTodoSkillDia fabricaSkillsLlamadasYNivelServicioTodoSkillDia;
    private final ServicioGuardarSkillsLlamadasYNivelServicioTodoSkillDia servicioGuardarSkillsLlamadasYNivelServicioTodoSkillDia;
    private final ConsumirDiarioSkillsLlamadasYNivelServicioTodoSkillDia consumirDiarioSkillsLlamadasYNivelServicioTodoSkillDia;
    private final ServicioGenerarFechasDiarias servicioGenerarFechasDiarias;



    public Boolean ejecutar(ResponseSkillsLlamadasYNivelServicioTodoSkillDia responseSkillsLlamadasYNivelServicioTodoSkillDia, String ini, String fin){
        var datos = this.fabricaSkillsLlamadasYNivelServicioTodoSkillDia.obtenerDatos(responseSkillsLlamadasYNivelServicioTodoSkillDia);
        var listaSkillsLlamadasYNivelServicioTodoSkillDias = this.fabricaSkillsLlamadasYNivelServicioTodoSkillDia.convertirRespuestaADominio(datos,ini,fin);
        return this.servicioGuardarSkillsLlamadasYNivelServicioTodoSkillDia.ejecutar(listaSkillsLlamadasYNivelServicioTodoSkillDias);
    }

    //@Scheduled(cron= "@"+"${cron.midnight}")


    //@Scheduled(fixedDelay = 60000)
    public boolean ejecutarCiclo() throws IOException {
        String fechaString= this.servicioGenerarFechasDiarias.generarFechaIni();
        var response= this.consumirDiarioSkillsLlamadasYNivelServicioTodoSkillDia.consumir();
        var json = response.body().string();

        Gson gson= new Gson();
        ResponseSkillsLlamadasYNivelServicioTodoSkillDia responseSkillsLlamadasYNivelServicioTodoSkillDia = gson.fromJson(json, ResponseSkillsLlamadasYNivelServicioTodoSkillDia.class);
        boolean guardo= false;

        try {
            if(this.ejecutar(responseSkillsLlamadasYNivelServicioTodoSkillDia,fechaString,fechaString)){;
                guardo = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return guardo;
    }



}
