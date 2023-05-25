package co.smart.procesador.campañas.resultadotelefonoatelefono.servicio;


import co.smart.procesador.campañas.email.servicio.NotificacionCampañaResultadoTelefonoATelefono;
import co.smart.procesador.campañas.resultadomaquinafinal.modelo.dominio.CampañaResultadoMaquinaFinal;
import co.smart.procesador.campañas.resultadotelefonoatelefono.modelo.dominio.CampañaResultadoTelefonoATelefono;
import co.smart.procesador.campañas.resultadotelefonoatelefono.puerto.repositorio.RepositorioCampañaResultadoTelefonoATelefono;
import co.smart.procesador.excepcion.ExcepcionDuplicidad;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioGuardarCampañaResultadoTelefonoATelefono {

    private static final String EL_INFORME_YA_EXISTE = "El informe con esta fecha ya existe";

    private final RepositorioCampañaResultadoTelefonoATelefono repositorioCampañaResultadoTelefonoATelefono;
    private final NotificacionCampañaResultadoTelefonoATelefono notificacionCampañaResultadoTelefonoATelefono;

    public ServicioGuardarCampañaResultadoTelefonoATelefono(RepositorioCampañaResultadoTelefonoATelefono repositorioCampañaResultadoTelefonoATelefono, NotificacionCampañaResultadoTelefonoATelefono notificacionCampañaResultadoTelefonoATelefono) {
        this.repositorioCampañaResultadoTelefonoATelefono = repositorioCampañaResultadoTelefonoATelefono;
        this.notificacionCampañaResultadoTelefonoATelefono = notificacionCampañaResultadoTelefonoATelefono;
    }


    public boolean ejecutar(List<CampañaResultadoTelefonoATelefono> campañaResultadoTelefonoATelefonos){

            validarExistencia(campañaResultadoTelefonoATelefonos);
            return this.repositorioCampañaResultadoTelefonoATelefono.guardarArray(campañaResultadoTelefonoATelefonos);
    }

    private void validarExistencia(List<CampañaResultadoTelefonoATelefono> campañaResultadoTelefonoATelefonos) {
        var ini = campañaResultadoTelefonoATelefonos.get(0).getFecha_inicio_carga();
        var fin = campañaResultadoTelefonoATelefonos.get(0).getFecha_fin_carga();
        if(this.repositorioCampañaResultadoTelefonoATelefono.existe(ini) || this.repositorioCampañaResultadoTelefonoATelefono.existe(fin)) {
            throw new ExcepcionDuplicidad(String.format(EL_INFORME_YA_EXISTE));
        }
    }
}
