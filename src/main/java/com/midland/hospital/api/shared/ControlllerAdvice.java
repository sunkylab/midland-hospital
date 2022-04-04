package com.midland.hospital.api.shared;

import com.midland.hospital.core.exceptions.AppBaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.List;


@ControllerAdvice
public class ControlllerAdvice {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @ExceptionHandler({AppBaseException.class,Exception.class})
    public final ResponseEntity<?> handleException(Exception ex, WebRequest request) {

        if (ex instanceof AppBaseException) {
            APIResponse response = new APIResponse();
            response.setCode("96");
            response.setMessage(ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else if (ex instanceof MethodArgumentNotValidException) {
            APIResponse response = new APIResponse();
            response.setCode("96");
            MethodArgumentNotValidException e = (MethodArgumentNotValidException) ex;
            List<FieldError> errors = e.getBindingResult().getFieldErrors();
            response.setMessage(errors.get(0).getField()+" "+errors.get(0).getDefaultMessage() );
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }else{
            ex.printStackTrace();
            APIResponse response = new APIResponse();
            response.setCode("96");
            response.setMessage(ex.getMessage());

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
