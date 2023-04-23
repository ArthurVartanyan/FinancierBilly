package com.financier.billy.exception;

import com.financier.billy.dto.ExceptionMessageDTO;
import com.financier.billy.exception.runtime.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GeneralExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(RuntimeException ex, WebRequest request) {
        ExceptionMessageDTO exceptionMessageDTO = new ExceptionMessageDTO(HttpStatus.NOT_FOUND, ex.getMessage());
        return handleExceptionInternal(ex, exceptionMessageDTO, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}