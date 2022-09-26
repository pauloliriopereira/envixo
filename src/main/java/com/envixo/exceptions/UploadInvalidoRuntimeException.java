package com.envixo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UploadInvalidoRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 2916211760868789083L;

	public UploadInvalidoRuntimeException(String mensagem) { 
		super(mensagem);
	}
}