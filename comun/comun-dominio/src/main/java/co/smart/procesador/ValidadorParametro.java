package co.smart.procesador;


import co.smart.procesador.excepcion.ExcepcionArgumentoInvalido;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Collection;

public class ValidadorParametro {

    public static void validarValorNulo(Object valor, String mensaje) {
        if(valor == null) {
            throw new ExcepcionArgumentoInvalido(mensaje);
        }
    }

    public static <T> T validarListaNulaYRetornarInstancia(T valor, T instancia) {
        if(valor == null) {
            valor = instancia;
        }
        return valor;
    }


    public static void validarValorVacio(String valor, String mensaje) {
        if(!StringUtils.hasText(valor)) {
            throw new ExcepcionArgumentoInvalido(mensaje);
        }
    }

    public static <T> void validarVacio(Collection<T> list, String mensaje) {
        if(list.isEmpty()) {
            throw new ExcepcionArgumentoInvalido(mensaje);
        }
    }

    public static void validarLocalDateTime(LocalDateTime localDateTime, String mensaje) {
        validarValorNulo(localDateTime, mensaje);

        if(localDateTime.isAfter(LocalDateTime.now())) {
            throw new ExcepcionArgumentoInvalido(mensaje);
        }
    }
}
