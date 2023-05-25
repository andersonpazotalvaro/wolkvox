package co.smart.procesador.campañas.resultadotelefonoatelefono.puerto.repositorio;


import co.smart.procesador.campañas.resultadotelefonoatelefono.modelo.dominio.CampañaResultadoTelefonoATelefono;

import java.time.LocalDate;
import java.util.List;

public interface RepositorioCampañaResultadoTelefonoATelefono {

    boolean guardar(CampañaResultadoTelefonoATelefono campañaResultadoTelefonoATelefono);


    boolean guardarArray(List<CampañaResultadoTelefonoATelefono> campañaResultadoTelefonoATelefonos);

    boolean existe(LocalDate fecha);


}
