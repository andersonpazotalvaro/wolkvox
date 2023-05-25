package co.smart.procesador.error;

import co.smart.procesador.excepcion.ExcepcionDuplicidad;
import co.smart.procesador.excepcion.ExcepcionInexistente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.concurrent.ConcurrentHashMap;

@ControllerAdvice
public class ManejadorError extends ResponseEntityExceptionHandler {


    private final static String OCURRIO_UN_ERROR_INESPERADO = "Ocurrio un error inesperado";
    private final static ConcurrentHashMap<String, Integer> CODIGOS_RESPUESTA = new ConcurrentHashMap<>();


    public ManejadorError() {

        // Cargar los codigos de respuesta http de las excepciones manejadas en la api

        CODIGOS_RESPUESTA.put(ExcepcionDuplicidad.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_RESPUESTA.put(ExcepcionInexistente.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());

    }


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Error> manejarExcepcion(Exception exception) {

        var excepcionNombre = exception.getClass().getSimpleName();
        var excepcionMensaje = exception.getMessage();
        Integer codigoRespuesta = CODIGOS_RESPUESTA.get(excepcionNombre);


        if(codigoRespuesta != null) {

            var error = new Error(excepcionNombre, excepcionMensaje);
            return new ResponseEntity<>(error, HttpStatus.valueOf(codigoRespuesta));
        }

        var error = new Error(excepcionNombre, OCURRIO_UN_ERROR_INESPERADO);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
