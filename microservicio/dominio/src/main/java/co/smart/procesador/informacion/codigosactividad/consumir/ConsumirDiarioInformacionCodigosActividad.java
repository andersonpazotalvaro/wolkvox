package co.smart.procesador.informacion.codigosactividad.consumir;

import co.smart.procesador.datos.servicio.ServicioConsultarDatos;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ConsumirDiarioInformacionCodigosActividad {
    private final ServicioConsultarDatos servicioConsultarDatos;




    public ConsumirDiarioInformacionCodigosActividad(ServicioConsultarDatos servicioConsultarDatos) {
        this.servicioConsultarDatos = servicioConsultarDatos;
    }

    public Response consumir() throws IOException {
        var datos= this.servicioConsultarDatos.consultar();
        String token = datos.getToken();
        String ip= datos.getIp_server();

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url("https://wv"+ip+".wolkvox.com/api/v2/information.php?api=activity_codes")
                .method("GET", null)
                .addHeader("wolkvox-token", token)
                .build();
        Response response = client.newCall(request).execute();

        return response;
    }


}
