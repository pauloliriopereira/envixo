package com.envixo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ApagarArquivoRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -4524416687217615746L;

	public ApagarArquivoRuntimeException(String mensagem) { 
		super(mensagem);
	}
}