package com.envixo.exception.handlers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorValidationHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handle(MethodArgumentNotValidException exception) {
    	
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        
        Map<String, Object> retorno = new HashMap<String, Object>();
        
        List<String> mensagens = fieldErrors.stream().map(e -> this.messageSource.getMessage(e, LocaleContextHolder.getLocale())).collect(Collectors.toList());
        retorno.put("mensagens", mensagens);
        System.out.println(mensagens);
        return ResponseEntity.badRequest().body(retorno);
        
    }
}
