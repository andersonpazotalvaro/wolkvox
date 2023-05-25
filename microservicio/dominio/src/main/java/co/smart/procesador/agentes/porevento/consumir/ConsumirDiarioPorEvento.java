package co.smart.procesador.agentes.porevento.consumir;

import co.smart.procesador.agentes.tiempoporestado.servicio.ServicioConsultarIpAgent;
import co.smart.procesador.datos.servicio.ServicioConsultarDatos;
import co.smart.procesador.datos.servicio.ServicioGenerarFechasDiarias;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Component
public class ConsumirDiarioPorEvento {
    private final ServicioConsultarDatos servicioConsultarDatos;

    private final ServicioGenerarFechasDiarias servicioGenerarFechasDiarias;
    private final ServicioConsultarIpAgent servicioConsultarIpAgent;


    public ConsumirDiarioPorEvento(ServicioConsultarDatos servicioConsultarDatos, ServicioGenerarFechasDiarias servicioGenerarFechasDiarias, ServicioConsultarIpAgent servicioConsultarIpAgent) {
        this.servicioConsultarDatos = servicioConsultarDatos;
        this.servicioGenerarFechasDiarias = servicioGenerarFechasDiarias;
        this.servicioConsultarIpAgent = servicioConsultarIpAgent;
    }
//@Async
    public Response consumir(String ini, String fin, String agente) throws IOException {
        var datos= this.servicioConsultarDatos.consultar();
        String token = datos.getToken();
        String ip= datos.getIp_server();

        OkHttpClient client = new OkHttpClient().newBuilder().writeTimeout(180, TimeUnit.SECONDS).build();
        client.sslSocketFactory().createSocket();

        Request request = new Request.Builder()
                .url("https://wv"+ip+".wolkvox.com/api/v2/reports_manager.php?api=agent_1&date_ini="+ini+"&date_end="+fin+"/api/v2/reports_manager.php?token="+token+"&api=agent_2&agent_id="+agente+"&date_ini="+ini+"&date_end="+fin)
                .method("GET", null)
                .addHeader("wolkvox-token", token)
                .build();
        Response response = client.newCall(request).execute();

        return response;
    }
}
