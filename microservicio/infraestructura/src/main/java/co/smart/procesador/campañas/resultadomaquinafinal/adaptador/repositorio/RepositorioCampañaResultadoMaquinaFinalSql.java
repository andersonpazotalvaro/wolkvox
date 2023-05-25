package co.smart.procesador.campañas.resultadomaquinafinal.adaptador.repositorio;

import co.smart.procesador.campañas.resultadomaquinafinal.adaptador.MapperCampañaResultadoMaquinaFinal;
import co.smart.procesador.campañas.resultadomaquinafinal.modelo.dominio.CampañaResultadoMaquinaFinal;
import co.smart.procesador.campañas.resultadomaquinafinal.puerto.repositorio.RepositorioCampañaResultadoMaquinaFinal;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RepositorioCampañaResultadoMaquinaFinalSql implements RepositorioCampañaResultadoMaquinaFinal {

    private final MapperCampañaResultadoMaquinaFinal MapperCampañaResultadoMaquinaFinal;
    private final RepositorioCampañaResultadoMaquinaFinalJpa repositorioCampañaResultadoMaquinaFinalJpa;

    public RepositorioCampañaResultadoMaquinaFinalSql(co.smart.procesador.campañas.resultadomaquinafinal.adaptador.MapperCampañaResultadoMaquinaFinal mapperCampañaResultadoMaquinaFinal, RepositorioCampañaResultadoMaquinaFinalJpa repositorioCampañaResultadoMaquinaFinalJpa) {
        MapperCampañaResultadoMaquinaFinal = mapperCampañaResultadoMaquinaFinal;
        this.repositorioCampañaResultadoMaquinaFinalJpa = repositorioCampañaResultadoMaquinaFinalJpa;
    }


    @Override
    public boolean guardar(CampañaResultadoMaquinaFinal campañaResultadoMaquinaFinal) {
        var entidadCampañaResultado= this.MapperCampañaResultadoMaquinaFinal.crearEntity(campañaResultadoMaquinaFinal);
        this.repositorioCampañaResultadoMaquinaFinalJpa.save(entidadCampañaResultado);
        return false;
    }



    @Override
    public boolean guardarArray(List<CampañaResultadoMaquinaFinal> campañaResultadoMaquinaFinals) {
        var listaEntidadCampaña= this.MapperCampañaResultadoMaquinaFinal.convertirDominioAEntidad(campañaResultadoMaquinaFinals);
        this.repositorioCampañaResultadoMaquinaFinalJpa.saveAll(listaEntidadCampaña);
        return true;
    }

    @Override
    public boolean existe(LocalDate fecha) {
        var entidadCampañaResultadoMaquinaFinals = this.repositorioCampañaResultadoMaquinaFinalJpa.consultarSiExisteRegistroHoy(fecha.toString());
        if (entidadCampañaResultadoMaquinaFinals == null || entidadCampañaResultadoMaquinaFinals.size() == 0) {
            return false;
        }
        return true;
    }


}
