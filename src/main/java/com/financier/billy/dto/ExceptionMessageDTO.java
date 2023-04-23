package com.financier.billy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionMessageDTO {

    private HttpStatus httpStatusCode;
    private String message;
}