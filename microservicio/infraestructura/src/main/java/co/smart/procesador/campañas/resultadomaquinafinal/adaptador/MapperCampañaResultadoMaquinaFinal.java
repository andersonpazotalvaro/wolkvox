package co.smart.procesador.campañas.resultadomaquinafinal.adaptador;

import co.smart.procesador.campañas.resultadomaquinafinal.entidad.EntidadCampañaResultadoMaquinaFinal;
import co.smart.procesador.campañas.resultadomaquinafinal.modelo.dominio.CampañaResultadoMaquinaFinal;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperCampañaResultadoMaquinaFinal {



    public EntidadCampañaResultadoMaquinaFinal crearEntity(CampañaResultadoMaquinaFinal campañaResultadoMaquinaFinal){
        return new EntidadCampañaResultadoMaquinaFinal(
                campañaResultadoMaquinaFinal.getResult(),
                campañaResultadoMaquinaFinal.getRecords(),
                campañaResultadoMaquinaFinal.getPorcent(),
                campañaResultadoMaquinaFinal.getFECHA(),
                campañaResultadoMaquinaFinal.getFecha_inicio_carga(),
                campañaResultadoMaquinaFinal.getFecha_fin_carga()

        );
    }

    public List<EntidadCampañaResultadoMaquinaFinal> convertirDominioAEntidad(List<CampañaResultadoMaquinaFinal> campañaResultadoMaquinaFinals){
        var listaEntidadCampaña = new ArrayList<EntidadCampañaResultadoMaquinaFinal>();

        campañaResultadoMaquinaFinals.forEach(campañaResultadoMaquinaFinal -> {
            listaEntidadCampaña.add(this.crearEntity(campañaResultadoMaquinaFinal));

        });
        return listaEntidadCampaña;
    }
}
