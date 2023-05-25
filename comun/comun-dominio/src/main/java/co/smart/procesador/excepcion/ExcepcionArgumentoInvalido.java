package co.smart.procesador.excepcion;

public class ExcepcionArgumentoInvalido extends RuntimeException {

    public ExcepcionArgumentoInvalido(String mensaje) {
        super(mensaje);
    }
}
