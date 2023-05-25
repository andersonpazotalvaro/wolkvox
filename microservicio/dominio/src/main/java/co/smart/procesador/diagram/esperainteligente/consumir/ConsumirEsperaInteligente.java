package co.smart.procesador.diagram.esperainteligente.consumir;

import co.smart.procesador.datos.servicio.ServicioConsultarDatos;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ConsumirEsperaInteligente {

private final ServicioConsultarDatos servicioConsultarDatos;

    public ConsumirEsperaInteligente(ServicioConsultarDatos servicioConsultarDatos) {
        this.servicioConsultarDatos = servicioConsultarDatos;
    }


    public Response consumirr(String ini, String fin) throws IOException {
            var datos= this.servicioConsultarDatos.consultar();
            String token = datos.getToken();
            String ip= datos.getIp_server();

            OkHttpClient client = new OkHttpClient().newBuilder().build();
            Request request = new Request.Builder()
                    .url("https://wv"+ip+".wolkvox.com/api/v2/reports_manager.php?api=diagram_2&date_ini="+ini+"&date_end="+fin)
                    .method("GET", null)
                    .addHeader("wolkvox-token", token)
                    .build();
            Response response = client.newCall(request).execute();

            return response;
        }




}
