package co.smart.procesador.interaccionesychats.chats.adaptador;

import co.smart.procesador.interaccionesychats.chats.entidad.EntidadInteraccionesChats;
import co.smart.procesador.interaccionesychats.chats.modelo.dominio.InteraccionesChats;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperInteraccionesChats {



    public EntidadInteraccionesChats crearEntity(InteraccionesChats interaccionesChats){
        return new EntidadInteraccionesChats(
                interaccionesChats.getConn_id(),
                interaccionesChats.getChannel(),
                interaccionesChats.getDate(),
                interaccionesChats.getCustomer_name(),
                interaccionesChats.getCustomer_email(),
                interaccionesChats.getCustomer_phone(),
                interaccionesChats.getCustomer_chars(),
                interaccionesChats.getAgent_id(),
                interaccionesChats.getAgent_name(),
                interaccionesChats.getAgent_dni(),
                interaccionesChats.getAgent_chars(),
                interaccionesChats.getTime_on_agent(),
                interaccionesChats.getChat_duration(),
                interaccionesChats.getCod_act(),
                interaccionesChats.getDescription_cod_act(),
                interaccionesChats.getComments(),
                interaccionesChats.getCustomer_id(),
                interaccionesChats.getSkill_id(),
                interaccionesChats.getASA(),
                interaccionesChats.getLast_participant_who_spoke(),
                interaccionesChats.getExtra_field(),
                interaccionesChats.getComment(),
                interaccionesChats.getUser_id(),
                interaccionesChats.getFeeling(),
                interaccionesChats.getAgent_answers(),
                interaccionesChats.getFECHA(),
                interaccionesChats.getFecha_inicio_carga(),
                interaccionesChats.getFecha_fin_carga()


        );
    }

    public List<EntidadInteraccionesChats> convertirDominioAEntidad(List<InteraccionesChats> interaccionesChats){
        var listaEntidadInteracciones = new ArrayList<EntidadInteraccionesChats>();

        interaccionesChats.forEach(interaccionesChats1   -> {
            listaEntidadInteracciones.add(this.crearEntity(interaccionesChats1));

        });
        return listaEntidadInteracciones;
    }
}
