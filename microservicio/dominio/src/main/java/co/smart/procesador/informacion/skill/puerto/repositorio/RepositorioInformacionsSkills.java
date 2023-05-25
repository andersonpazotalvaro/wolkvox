package co.smart.procesador.informacion.skill.puerto.repositorio;

import co.smart.procesador.informacion.skill.modelo.dominio.InformacionSkills;

import java.time.LocalDate;
import java.util.List;

public interface RepositorioInformacionsSkills {

    boolean guardar(InformacionSkills informacionSkills);


    boolean guardarArray(List<InformacionSkills> informacionSkills);

    boolean existe(LocalDate fecha);


}
