package com.misiontic.Resevaciones.excepciones;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice // propiedad de recibir y enviar respuesta
@ResponseBody // es que da forma a la respuesta
public class ReservaNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ReservaNotFoundException.class) // cuando se da el error entra aquí
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String EntityNotFoundAdvice(ReservaNotFoundException ex){
        return ex.getMessage();
    }
}
