package unicam.filierafanesicardinali.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntime(RuntimeException e) {

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST) // o altro codice HTTP
                .body(Map.of(
                        "errore", e.getClass().getSimpleName(),
                        "messaggio", e.getMessage()
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneric(Exception e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of(
                        "errore", "GenericException",
                        "messaggio", "Errore interno al server"
                ));
    }
}