package co.smart.procesador.campañas.resultadotelefonoatelefono.consumir;

import co.smart.procesador.datos.servicio.ServicioConsultarDatos;
import co.smart.procesador.datos.servicio.ServicioGenerarFechasDiarias;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ConsumirDiarioResultadoTelefonoATelefono {
    private final ServicioConsultarDatos servicioConsultarDatos;

    private final ServicioGenerarFechasDiarias servicioGenerarFechasDiarias;


    public ConsumirDiarioResultadoTelefonoATelefono(ServicioConsultarDatos servicioConsultarDatos, ServicioGenerarFechasDiarias servicioGenerarFechasDiarias) {
        this.servicioConsultarDatos = servicioConsultarDatos;
        this.servicioGenerarFechasDiarias = servicioGenerarFechasDiarias;
    }

    public Response consumir() throws IOException {
        var datos= this.servicioConsultarDatos.consultar();
        String token = datos.getToken();
        String ip= datos.getIp_server();
        String ini= this.servicioGenerarFechasDiarias.generarFechaIni();
        String fin= this.servicioGenerarFechasDiarias.generarFechaFin();

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url("https://wv"+ip+".wolkvox.com/api/v2/reports_manager.php?api=campaign_3&campaign_id="+"22109"+"&date_ini="+ini+"&date_end="+fin)
                .method("GET", null)
                .addHeader("wolkvox-token", token)
                .build();
        Response response = client.newCall(request).execute();

        return response;
    }
}
