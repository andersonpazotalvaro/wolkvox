package co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.comando.manejador;

import co.smart.procesador.datos.servicio.ServicioGenerarFechasDiarias;
import co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.comando.ResponseSkillsLlamadasYNivelTodos;
import co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.comando.fabrica.FabricaSkillsLlamadasYNivelTodos;
import co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.consumir.ConsumirDiarioSkillsLlamadasYNivelTodos;
import co.smart.procesador.skillsyservicios.llamadasynivelskilltodos.servicio.ServicioGuardarSkillsLlamadasYNivelTodos;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;


@RequiredArgsConstructor
@Component
public class ManejadorSkillsLlamadasYNivelTodos {


    private final FabricaSkillsLlamadasYNivelTodos fabricaSkillsLlamadasYNivelTodos;
    private final ServicioGuardarSkillsLlamadasYNivelTodos servicioGuardarSkillsLlamadasYNivelTodos;
    private final ConsumirDiarioSkillsLlamadasYNivelTodos consumirDiarioSkillsLlamadasYNivelTodos;
    private final ServicioGenerarFechasDiarias servicioGenerarFechasDiarias;



    public Boolean ejecutar(ResponseSkillsLlamadasYNivelTodos responseSkillsLlamadasYNivelTodos, String ini, String fin){
        var datos = this.fabricaSkillsLlamadasYNivelTodos.obtenerDatos(responseSkillsLlamadasYNivelTodos);
        var listaSkillsLlamadasYNivelTodos = this.fabricaSkillsLlamadasYNivelTodos.convertirRespuestaADominio(datos,ini,fin);
        return this.servicioGuardarSkillsLlamadasYNivelTodos.ejecutar(listaSkillsLlamadasYNivelTodos);
    }

    //@Scheduled(cron= "@"+"${cron.midnight}")


    //@Scheduled(fixedDelay = 60000)
    public boolean ejecutarCiclo() throws IOException {
        String fechaString= this.servicioGenerarFechasDiarias.generarFechaIni();
        var response= this.consumirDiarioSkillsLlamadasYNivelTodos.consumir();
        var json = response.body().string();

        Gson gson= new Gson();
        ResponseSkillsLlamadasYNivelTodos responseSkillsLlamadasYNivelTodos = gson.fromJson(json, ResponseSkillsLlamadasYNivelTodos.class);
        boolean guardo= false;

        try {
            if(this.ejecutar(responseSkillsLlamadasYNivelTodos,fechaString,fechaString)){;
                guardo = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        //System.out.println("guardo Llamadas y nivel de servicio por skill-todos");

        return guardo;
    }

    /*public boolean consumirTodos(){

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
