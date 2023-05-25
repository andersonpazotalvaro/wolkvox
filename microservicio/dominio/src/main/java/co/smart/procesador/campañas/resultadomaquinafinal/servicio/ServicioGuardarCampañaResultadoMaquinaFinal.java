package co.smart.procesador.campañas.resultadomaquinafinal.servicio;


import co.smart.procesador.campañas.email.servicio.NotificacionCampañaResultadoMaquinaFinal;
import co.smart.procesador.campañas.resultadomaquinafinal.modelo.dominio.CampañaResultadoMaquinaFinal;
import co.smart.procesador.campañas.resultadomaquinafinal.puerto.repositorio.RepositorioCampañaResultadoMaquinaFinal;
import co.smart.procesador.excepcion.ExcepcionDuplicidad;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioGuardarCampañaResultadoMaquinaFinal {

    private static final String EL_INFORME_YA_EXISTE = "El informe con esta fecha ya existe";

    private final RepositorioCampañaResultadoMaquinaFinal repositorioCampañaResultadoMaquinaFinal;

    private final NotificacionCampañaResultadoMaquinaFinal notificacionCampañaResultadoMaquinaFinal;

    public ServicioGuardarCampañaResultadoMaquinaFinal(RepositorioCampañaResultadoMaquinaFinal repositorioCampañaResultadoMaquinaFinal, NotificacionCampañaResultadoMaquinaFinal notificacionCampañaResultadoMaquinaFinal) {
        this.repositorioCampañaResultadoMaquinaFinal = repositorioCampañaResultadoMaquinaFinal;
        this.notificacionCampañaResultadoMaquinaFinal = notificacionCampañaResultadoMaquinaFinal;
    }


    public boolean ejecutar(List<CampañaResultadoMaquinaFinal> campañaResultadoMaquinaFinals){

            validarExistencia(campañaResultadoMaquinaFinals);
            return this.repositorioCampañaResultadoMaquinaFinal.guardarArray(campañaResultadoMaquinaFinals);
    }

    private void validarExistencia(List<CampañaResultadoMaquinaFinal> campañaResultadoMaquinaFinals) {
        var ini = campañaResultadoMaquinaFinals.get(0).getFecha_inicio_carga();
        var fin = campañaResultadoMaquinaFinals.get(0).getFecha_fin_carga();
        if(this.repositorioCampañaResultadoMaquinaFinal.existe(ini) || this.repositorioCampañaResultadoMaquinaFinal.existe(fin)) {
            throw new ExcepcionDuplicidad(String.format(EL_INFORME_YA_EXISTE));
        }
    }
}
