package co.smart.procesador.campañas.resultadotelefonoatelefono.adaptador;

import co.smart.procesador.campañas.resultadomaquinafinal.entidad.EntidadCampañaResultadoMaquinaFinal;
import co.smart.procesador.campañas.resultadomaquinafinal.modelo.dominio.CampañaResultadoMaquinaFinal;
import co.smart.procesador.campañas.resultadotelefonoatelefono.entidad.EntidadCampañaResultadoTelefonoATelefono;
import co.smart.procesador.campañas.resultadotelefonoatelefono.modelo.dominio.CampañaResultadoTelefonoATelefono;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class MapperCampañaResultadoTelefonoATelefono {



    public EntidadCampañaResultadoTelefonoATelefono crearEntity(CampañaResultadoTelefonoATelefono campañaResultadoTelefonoATelefono){
        return new EntidadCampañaResultadoTelefonoATelefono(
                campañaResultadoTelefonoATelefono.getResult(),
                campañaResultadoTelefonoATelefono.getCustomer_name(),
                campañaResultadoTelefonoATelefono.getCustomer_last_name(),
                campañaResultadoTelefonoATelefono.getCustomer_id(),
                campañaResultadoTelefonoATelefono.getDate(),
                campañaResultadoTelefonoATelefono.getTelephone(),
                campañaResultadoTelefonoATelefono.getResult(),
                campañaResultadoTelefonoATelefono.getOpt1(),
                campañaResultadoTelefonoATelefono.getOpt2(),
                campañaResultadoTelefonoATelefono.getOpt3(),
                campañaResultadoTelefonoATelefono.getOpt4(),
                campañaResultadoTelefonoATelefono.getOpt5(),
                campañaResultadoTelefonoATelefono.getOpt6(),
                campañaResultadoTelefonoATelefono.getOpt7(),
                campañaResultadoTelefonoATelefono.getOpt8(),
                campañaResultadoTelefonoATelefono.getOpt9(),
                campañaResultadoTelefonoATelefono.getOpt10(),
                campañaResultadoTelefonoATelefono.getOpt11(),
                campañaResultadoTelefonoATelefono.getOpt12(),
                campañaResultadoTelefonoATelefono.getConn_id(),
                campañaResultadoTelefonoATelefono.getId_type(),
                campañaResultadoTelefonoATelefono.getFECHA(),
                campañaResultadoTelefonoATelefono.getFecha_inicio_carga(),
                campañaResultadoTelefonoATelefono.getFecha_fin_carga()
        );
    }

    public List<EntidadCampañaResultadoTelefonoATelefono> convertirDominioAEntidad(List<CampañaResultadoTelefonoATelefono> campañaResultadoTelefonoATelefonos){
        var listaEntidadCampaña = new ArrayList<EntidadCampañaResultadoTelefonoATelefono>();

        campañaResultadoTelefonoATelefonos.forEach(campañaResultadoTelefonoATelefono -> {
            listaEntidadCampaña.add(this.crearEntity(campañaResultadoTelefonoATelefono));

        });
        return listaEntidadCampaña;
    }
}
