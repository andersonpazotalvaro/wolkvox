package co.smart.procesador.interaccionesychats.conversaciones.adaptador;

import co.smart.procesador.interaccionesychats.chats.entidad.EntidadInteraccionesChats;
import co.smart.procesador.interaccionesychats.chats.modelo.dominio.InteraccionesChats;
import co.smart.procesador.interaccionesychats.conversaciones.entidad.EntidadInteraccionesConversaciones;
import co.smart.procesador.interaccionesychats.conversaciones.modelo.dominio.InteraccionesConversaciones;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperInteraccionesConversaciones {



    public EntidadInteraccionesConversaciones crearEntity(InteraccionesConversaciones interaccionesConversaciones){
        return new EntidadInteraccionesConversaciones(
                interaccionesConversaciones.getChat_id(),
                interaccionesConversaciones.getChannel(),
                interaccionesConversaciones.getFrom(),
                interaccionesConversaciones.getFrom_name(),
                interaccionesConversaciones.getTo_name(),
                interaccionesConversaciones.getDate(),
                interaccionesConversaciones.getMessage(),
                interaccionesConversaciones.getCustomer_id(),
                interaccionesConversaciones.getFECHA(),
                interaccionesConversaciones.getFecha_inicio_carga(),
                interaccionesConversaciones.getFecha_fin_carga()
        );
    }

    public List<EntidadInteraccionesConversaciones> convertirDominioAEntidad(List<InteraccionesConversaciones> interaccionesConversaciones){
        var listaEntidadInteracciones = new ArrayList<EntidadInteraccionesConversaciones>();

        interaccionesConversaciones.forEach(interaccionesConversaciones1 -> {
            listaEntidadInteracciones.add(this.crearEntity(interaccionesConversaciones1));

        });
        return listaEntidadInteracciones;
    }
}
