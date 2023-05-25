package co.smart.procesador.excepcion;

public class ExcepcionInexistente extends RuntimeException {

    public ExcepcionInexistente(String mensaje) {
        super(mensaje);
    }
}
