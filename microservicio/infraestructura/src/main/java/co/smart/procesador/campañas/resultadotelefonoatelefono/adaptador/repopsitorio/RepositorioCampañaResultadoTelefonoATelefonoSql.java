package co.smart.procesador.campañas.resultadotelefonoatelefono.adaptador.repopsitorio;

import co.smart.procesador.campañas.resultadomaquinafinal.modelo.dominio.CampañaResultadoMaquinaFinal;
import co.smart.procesador.campañas.resultadotelefonoatelefono.adaptador.MapperCampañaResultadoTelefonoATelefono;
import co.smart.procesador.campañas.resultadotelefonoatelefono.modelo.dominio.CampañaResultadoTelefonoATelefono;
import co.smart.procesador.campañas.resultadotelefonoatelefono.puerto.repositorio.RepositorioCampañaResultadoTelefonoATelefono;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RepositorioCampañaResultadoTelefonoATelefonoSql implements RepositorioCampañaResultadoTelefonoATelefono {

    private final MapperCampañaResultadoTelefonoATelefono mapperCampañaResultadoTelefonoATelefono;
    private final RepositorioCampañaResultadoTelefonoATelefonoJpa repositorioCampañaResultadoTelefonoATelefonoJpa;

    public RepositorioCampañaResultadoTelefonoATelefonoSql(MapperCampañaResultadoTelefonoATelefono mapperCampañaResultadoTelefonoATelefono, RepositorioCampañaResultadoTelefonoATelefonoJpa repositorioCampañaResultadoTelefonoATelefonoJpa) {
        this.mapperCampañaResultadoTelefonoATelefono = mapperCampañaResultadoTelefonoATelefono;
        this.repositorioCampañaResultadoTelefonoATelefonoJpa = repositorioCampañaResultadoTelefonoATelefonoJpa;
    }


    @Override
    public boolean guardar(CampañaResultadoTelefonoATelefono campañaResultadoTelefonoATelefono) {
        var entidadCampañaResultado= this.mapperCampañaResultadoTelefonoATelefono.crearEntity(campañaResultadoTelefonoATelefono);
        this.repositorioCampañaResultadoTelefonoATelefonoJpa.save(entidadCampañaResultado);
        return false;
    }



    @Override
    public boolean guardarArray(List<CampañaResultadoTelefonoATelefono> campañaResultadoTelefonoATelefonos) {
        var listaEntidadCampaña= this.mapperCampañaResultadoTelefonoATelefono.convertirDominioAEntidad(campañaResultadoTelefonoATelefonos);
        this.repositorioCampañaResultadoTelefonoATelefonoJpa.saveAll(listaEntidadCampaña);
        return true;
    }

    @Override
    public boolean existe(LocalDate fecha) {
        var entidadCampañaResultadoTelefonoATelefonos= this.repositorioCampañaResultadoTelefonoATelefonoJpa.consultarSiExisteRegistroHoy(fecha.toString());
        if (entidadCampañaResultadoTelefonoATelefonos == null || entidadCampañaResultadoTelefonoATelefonos.size() == 0) {
            return false;
        }
        return true;
    }


}
