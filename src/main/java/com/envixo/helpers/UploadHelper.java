package com.envixo.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.envixo.exceptions.UploadInvalidoRuntimeException;
import com.envixo.model.Midia;

@Component
public class UploadHelper {
	
	private @Autowired PathHelper pathHelper;
	
	public void upload(InputStream file, Midia midia) {
		
		try {	        
	        Files.copy(file, this.pathHelper.path(midia).resolve(midia.getId().toString()), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) { 
			throw new UploadInvalidoRuntimeException("Não foi Possível Gravar a Midia."); 
		}
		
	}
	
}
