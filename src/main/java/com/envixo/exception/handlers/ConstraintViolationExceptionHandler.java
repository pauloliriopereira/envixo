package com.envixo.exception.handlers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@ControllerAdvice
//public class ConstraintViolationExceptionHandler extends ResponseEntityExceptionHandler {
//
//	 public ConstraintViolationExceptionHandler() {
//		 
//		 super();
//		 
//	 }
//
//	@ExceptionHandler(value = { ConstraintViolationException.class })
//	protected ResponseEntity<Object> handleConstraintViolationException(RuntimeException ex, WebRequest request) {
//		
//		ConstraintViolationException exViolation = (ConstraintViolationException) ex;
//		
//		List<String> mensagens = 
//				 exViolation.getConstraintViolations().stream().map(
//						 constraint -> (constraint.getPropertyPath() != null ? 
//								 constraint.getPropertyPath().toString() + " : " + constraint.getMessage() :constraint.getMessage()))
//				 .collect(Collectors.toList());
//		System.out.println(mensagens);
//		Map<String, Object> retorno = new HashMap<String, Object>();
//		
//		retorno.put("mensagens", mensagens);
//		
//		return ResponseEntity.badRequest().body(retorno);
//		
//	}
//	
//	@ExceptionHandler(value = { IllegalStateException.class })
//	protected ResponseEntity<Object> handleIllegalStateException(RuntimeException ex, WebRequest request) {
//		
//		return ResponseEntity.badRequest().build();
//		
//	}
//	
//}
