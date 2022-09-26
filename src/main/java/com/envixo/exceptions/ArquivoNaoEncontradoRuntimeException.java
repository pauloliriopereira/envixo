package com.envixo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ArquivoNaoEncontradoRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -4524416687217615746L;

	public ArquivoNaoEncontradoRuntimeException(String mensagem) { 
		super(mensagem);
	}
}