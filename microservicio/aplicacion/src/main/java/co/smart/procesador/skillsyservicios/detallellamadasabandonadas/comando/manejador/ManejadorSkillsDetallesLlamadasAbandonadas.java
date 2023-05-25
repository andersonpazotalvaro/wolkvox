package co.smart.procesador.skillsyservicios.detallellamadasabandonadas.comando.manejador;

import co.smart.procesador.datos.servicio.ServicioGenerarFechasDiarias;
import co.smart.procesador.skillsyservicios.detallellamadasabandonadas.comando.ResponseSkillsDetallesLlamadasAbandonadas;
import co.smart.procesador.skillsyservicios.detallellamadasabandonadas.comando.fabrica.FabricaSkillsDetalleLlamadasAbandonadas;
import co.smart.procesador.skillsyservicios.detallesllamadasabandonadas.consumir.ConsumirDiarioSkillsDetalleLlamadasAbandonadas;
import co.smart.procesador.skillsyservicios.detallesllamadasabandonadas.servicio.ServicioGuardarSkillsDetalleLlamadasAbandonadas;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;


@RequiredArgsConstructor
@Component
public class ManejadorSkillsDetallesLlamadasAbandonadas {


    private final FabricaSkillsDetalleLlamadasAbandonadas fabricaSkillsDetalleLlamadasAbandonadas;
    private final ServicioGuardarSkillsDetalleLlamadasAbandonadas servicioGuardarSkillsDetalleLlamadasAbandonadas;
    private final ConsumirDiarioSkillsDetalleLlamadasAbandonadas consumirDiarioSkillsDetalleLlamadasAbandonadas;
    private final ServicioGenerarFechasDiarias servicioGenerarFechasDiarias;


    public Boolean ejecutar(ResponseSkillsDetallesLlamadasAbandonadas responseSkillsDetalleLlamadasAbandonadas, String ini, String fin){
        var datos = this.fabricaSkillsDetalleLlamadasAbandonadas.obtenerDatos(responseSkillsDetalleLlamadasAbandonadas);
        var listaSkillsDetalleLlamadasAbandonadas= this.fabricaSkillsDetalleLlamadasAbandonadas.convertirRespuestaADominio(datos,ini,fin);
        return this.servicioGuardarSkillsDetalleLlamadasAbandonadas.ejecutar(listaSkillsDetalleLlamadasAbandonadas);
    }

    //@Scheduled(cron= "@"+"${cron.midnight}")


    //@Scheduled(fixedDelay = 60000)
    public boolean ejecutarCiclo() throws IOException {
        String fechaString= this.servicioGenerarFechasDiarias.generarFechaIni();
        var response= this.consumirDiarioSkillsDetalleLlamadasAbandonadas.consumir();
        var json = response.body().string();

        Gson gson= new Gson();
        ResponseSkillsDetallesLlamadasAbandonadas responseSkillsDetalleLlamadasAbandonadas = gson.fromJson(json, ResponseSkillsDetallesLlamadasAbandonadas.class);
        boolean guardo= false;

        try {
            if(this.ejecutar(responseSkillsDetalleLlamadasAbandonadas,fechaString,fechaString)){;
                guardo = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }

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
