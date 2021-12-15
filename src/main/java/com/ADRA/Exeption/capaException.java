package com.ADRA.Exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import com.ADRA.mensaje.capmensaje;

@ControllerAdvice
public class capaException {
	
	@ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<capmensaje> maxSizeException(MaxUploadSizeExceededException exc){
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                .body(new capmensaje("Uno o mas archivos exceden el tamaño maximo"));
    }

}
