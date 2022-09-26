package com.envixo.helpers;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.envixo.model.Midia;

@Component
public class PathHelper {

	@Value("${file.upload.dir}") 
	private String uploadDir;
	
	private URI createFolders(String path) {
		
		File file = new File(path);
		file.mkdirs();
		
		return file.toURI();
		
	}
	
	public String pathTimestamp(LocalDateTime date) {
		return String.valueOf(date.getYear()) + "/" +
				String.valueOf(date.getMonthValue()) + "/" +
				String.valueOf(date.getDayOfMonth());
	}	
	
	public Path path(Midia midia) throws IOException { 		
		return Paths.get(
				createFolders(this.uploadDir + "/" + 
							midia.getId() + "/" + 
							pathTimestamp(midia.getDataCriacao())))
			.normalize();
	}
	
}
