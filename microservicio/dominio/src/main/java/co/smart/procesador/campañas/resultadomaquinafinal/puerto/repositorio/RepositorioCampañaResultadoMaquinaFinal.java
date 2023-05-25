package co.smart.procesador.campañas.resultadomaquinafinal.puerto.repositorio;


import co.smart.procesador.campañas.resultadomaquinafinal.modelo.dominio.CampañaResultadoMaquinaFinal;

import java.time.LocalDate;
import java.util.List;

public interface RepositorioCampañaResultadoMaquinaFinal {

    boolean guardar(CampañaResultadoMaquinaFinal campañaResultadoMaquinaFinal);


    boolean guardarArray(List<CampañaResultadoMaquinaFinal> campañaResultadoMaquinaFinals);

    boolean existe(LocalDate fecha);


}
