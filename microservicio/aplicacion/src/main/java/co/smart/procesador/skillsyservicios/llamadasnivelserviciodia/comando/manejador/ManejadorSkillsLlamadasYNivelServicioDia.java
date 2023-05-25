package co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.comando.manejador;

import co.smart.procesador.datos.servicio.ServicioGenerarFechasDiarias;
import co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.comando.ResponseSkillsLlamadasYNivelServicioDia;
import co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.comando.fabrica.FabricaSkillsLlamadasYNivelServicioDia;
import co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.consumir.ConsumirDiarioSkillsLlamadasYNivelServicioDia;
import co.smart.procesador.skillsyservicios.llamadasnivelserviciodia.servicio.ServicioGuardarSkillsLlamadasYNivelServicioDia;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;


@RequiredArgsConstructor
@Component
public class ManejadorSkillsLlamadasYNivelServicioDia {


    private final FabricaSkillsLlamadasYNivelServicioDia fabricaSkillsLlamadasYNivelServicioDia;
    private final ServicioGuardarSkillsLlamadasYNivelServicioDia servicioGuardarSkillsLlamadasYNivelServicioDia;
    private final ConsumirDiarioSkillsLlamadasYNivelServicioDia consumirDiarioSkillsLlamadasYNivelServicioDia;
    private final ServicioGenerarFechasDiarias servicioGenerarFechasDiarias;


    public Boolean ejecutar(ResponseSkillsLlamadasYNivelServicioDia responseSkillsLlamadasYNivelServicioDia, String ini, String fin){
        var datos = this.fabricaSkillsLlamadasYNivelServicioDia.obtenerDatos(responseSkillsLlamadasYNivelServicioDia);
        var listaSkillsLlamadasYNivelServicioDia = this.fabricaSkillsLlamadasYNivelServicioDia.convertirRespuestaADominio(datos,ini,fin);
        return this.servicioGuardarSkillsLlamadasYNivelServicioDia.ejecutar(listaSkillsLlamadasYNivelServicioDia);
    }

    //@Scheduled(cron= "@"+"${cron.midnight}")


    //@Scheduled(fixedDelay = 60000)
    public boolean ejecutarCiclo() throws IOException {
        String fechaString= this.servicioGenerarFechasDiarias.generarFechaIni();
        var response= this.consumirDiarioSkillsLlamadasYNivelServicioDia.consumir();
        var json = response.body().string();

        Gson gson= new Gson();
        ResponseSkillsLlamadasYNivelServicioDia responseSkillsLlamadasYNivelServicioDia = gson.fromJson(json, ResponseSkillsLlamadasYNivelServicioDia.class);
        boolean guardo= false;

        try {
            if(this.ejecutar(responseSkillsLlamadasYNivelServicioDia,fechaString,fechaString)){;
                guardo = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("guardo Llamadas y nivel de servicio por skill-Dia");

        return guardo;
    }

   /* public boolean consumirTodos(){

        var listaSkills = this.servicioConsultarSkill.consultar();

        listaSkills.forEach(respuestaConsultaSkillConId -> {
            try {
                this.ejecutarCiclo(respuestaConsultaSkillConId.getId_skill());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return true;
    }*/

}
