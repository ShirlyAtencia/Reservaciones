package com.misiontic.Resevaciones.excepciones;

public class ReservaNotFoundException extends RuntimeException{
    public ReservaNotFoundException(String message){
        super(message);
    }
}
