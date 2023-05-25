package co.smart.procesador.interaccionesychats.transferenciachats.adaptador;

import co.smart.procesador.interaccionesychats.transferenciachats.entidad.EntidadInteraccionesTransferenciaChats;
import co.smart.procesador.interaccionesychats.transferenciachats.modelo.dominio.InteraccionesTransferenciaChats;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperInteraccionesTransferenciaChats {



    public EntidadInteraccionesTransferenciaChats crearEntity(InteraccionesTransferenciaChats interaccionesTransferenciaChats){
        return new EntidadInteraccionesTransferenciaChats(
                interaccionesTransferenciaChats.getConn_id(),
                interaccionesTransferenciaChats.getTransfer_agent_id(),
                interaccionesTransferenciaChats.getTransfer_agent_name(),
                interaccionesTransferenciaChats.getTransfer_agent_dni(),
                interaccionesTransferenciaChats.getReceiver_agent_id(),
                interaccionesTransferenciaChats.getReceiver_agent_name(),
                interaccionesTransferenciaChats.getReceiver_agent_dni(),
                interaccionesTransferenciaChats.getChannel(),
                interaccionesTransferenciaChats.getDate(),
                interaccionesTransferenciaChats.getFECHA(),
                interaccionesTransferenciaChats.getFecha_inicio_carga(),
                interaccionesTransferenciaChats.getFecha_fin_carga()
        );
    }

    public List<EntidadInteraccionesTransferenciaChats> convertirDominioAEntidad(List<InteraccionesTransferenciaChats> interaccionesTransferenciaChats){
        var listaEntidadInteracciones = new ArrayList<EntidadInteraccionesTransferenciaChats>();

        interaccionesTransferenciaChats.forEach(interaccionesTransferenciaChats1 -> {
            listaEntidadInteracciones.add(this.crearEntity(interaccionesTransferenciaChats1));

        });
        return listaEntidadInteracciones;
    }
}
