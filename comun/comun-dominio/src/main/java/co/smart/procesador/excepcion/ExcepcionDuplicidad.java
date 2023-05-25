package co.smart.procesador.excepcion;

public class ExcepcionDuplicidad extends RuntimeException {

    public ExcepcionDuplicidad(String mensaje) {
        super(mensaje);
    }
}
