package co.smart.procesador.campañas.resultadotelefonoatelefono.consumir;

import co.smart.procesador.datos.servicio.ServicioConsultarDatos;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ConsumirResultadoTelefonoATelefono {

private final ServicioConsultarDatos servicioConsultarDatos;

    public ConsumirResultadoTelefonoATelefono(ServicioConsultarDatos servicioConsultarDatos) {
        this.servicioConsultarDatos = servicioConsultarDatos;
    }


    public Response consumirr(String ini, String fin, String campaña) throws IOException {
            var datos= this.servicioConsultarDatos.consultar();
            String token = datos.getToken();
            String ip= datos.getIp_server();

            OkHttpClient client = new OkHttpClient().newBuilder().build();
            Request request = new Request.Builder()
                    .url("https://wv"+ip+".wolkvox.com/api/v2/reports_manager.php?api=campaign_3&campaign_id="+campaña+"&date_ini="+ini+"&date_end="+fin)
                    .method("GET", null)
                    .addHeader("wolkvox-token", token)
                    .build();
            Response response = client.newCall(request).execute();

            return response;
        }




}
