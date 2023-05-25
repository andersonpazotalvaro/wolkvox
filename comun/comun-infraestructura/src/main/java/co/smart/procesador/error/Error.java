package co.smart.procesador.error;

public class Error {

    private String excepcionNombre;
    private String excepcionMensaje;

    public Error(String excepcionNombre, String excepcionMensaje) {
        this.excepcionNombre = excepcionNombre;
        this.excepcionMensaje = excepcionMensaje;
    }

    public String getExcepcionNombre() {
        return this.excepcionNombre;
    }

    public String getExcepcionMensaje() {
        return this.excepcionMensaje;
    }
}
