package co.smart.procesador.interaccionesychats.conversaciones.consumir;

import co.smart.procesador.datos.servicio.ServicioConsultarDatos;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Component
public class ConsumirInteraccionesConversaciones {

private final ServicioConsultarDatos servicioConsultarDatos;


    public ConsumirInteraccionesConversaciones(ServicioConsultarDatos servicioConsultarDatos) {
        this.servicioConsultarDatos = servicioConsultarDatos;
    }


    public Response consumirr(String ini, String fin) throws IOException {
            var datos= this.servicioConsultarDatos.consultar();
            String token = datos.getToken();
            String ip= datos.getIp_server();
            String jsonCompleto;


            //OkHttpClient client = new OkHttpClient().newBuilder().build();

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30, TimeUnit.SECONDS) // connect timeout
                .writeTimeout(30, TimeUnit.SECONDS) // write timeout
                .readTimeout(30, TimeUnit.SECONDS); // read timeout

        OkHttpClient client = builder.build();
                    
            Request request = new Request.Builder()
                    .url("https://wv"+ip+".wolkvox.com/api/v2/reports_manager.php?api=chat_2&date_ini="+ini+"&date_end="+fin)
                    .method("GET", null)
                    .addHeader("wolkvox-token", token)
                    .build();
            Response response = client.newCall(request).execute();

            //devuelva json

            return response;
        }




}
