package co.smart.procesador.datos.controlador;

import co.smart.procesador.datos.comando.RequestDatos;
import co.smart.procesador.datos.comando.manejador.ManejadorGuardarToken;
import co.smart.procesador.datos.consulta.ConsultaDatos;
import co.smart.procesador.datos.modelo.dto.Datos;
import co.smart.procesador.unificados.comando.manejador.ManejadorUnificados;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/datos")
public class ControladorDatos {

    private final ManejadorGuardarToken manejadorGuardarToken;
    private final ManejadorUnificados manejadorUnificados;

    private final ConsultaDatos consultaDatos;

    public ControladorDatos(ManejadorGuardarToken manejadorGuardarToken, ManejadorUnificados manejadorUnificados, ConsultaDatos consultaDatos) {
        this.manejadorGuardarToken = manejadorGuardarToken;
        this.manejadorUnificados = manejadorUnificados;
        this.consultaDatos = consultaDatos;
    }

    @PostMapping
    public String cambiarToken(@RequestBody RequestDatos requestDatos){
        return this.manejadorGuardarToken.ejecutar(requestDatos);
    }

    //@GetMapping
    /*public Datos consultarToken(){
        return this.consultaDatos.ejecutar();
    }*/
    @GetMapping(value= "/verificarestadoapp")
    public String verificarEstadoApp(){
        return "Si se lee este mensaje la aplicacion esta arriba";
    }

    @Async
    @ResponseStatus(value = HttpStatus.OK,reason = "Has intentado guardar todos los informes, La acción no recibe respuesta por este medio, por favor verificar el correo de notificaciones ")
    @GetMapping(value= "/guardartodos")
    public String enviar(){
        this.guardarTodosLosInformeAsincronicamente();
        String texto= "Has intentado guardar todos los informe, La acción no recibe respuesta por este medio, por favor verificar el correo de notificaciones ";
        return texto;
    }

    public void guardarTodosLosInformeAsincronicamente(){
        this.manejadorUnificados.ejecutar();
        this.manejadorUnificados.ejecutarSemanal();
    }

}
