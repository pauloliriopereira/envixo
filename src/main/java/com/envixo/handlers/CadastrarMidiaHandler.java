package com.envixo.handlers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.envixo.commands.CadastrarMidiaCommand;
import com.envixo.helpers.UploadHelper;
import com.envixo.model.Midia;
import com.envixo.repository.MidiaRepository;

@Service
public class CadastrarMidiaHandler {

	@Autowired MidiaRepository midiaRepository;
	@Autowired UploadHelper uploadHelper;
	
	public Midia handle(CadastrarMidiaCommand command) throws IOException {
		
		byte[] midiaDecoded = Base64.getDecoder().decode(command.getStringBase64().getBytes(StandardCharsets.UTF_8));
		InputStream midiaInputStream = new ByteArrayInputStream(midiaDecoded);
		
		Midia midia = new Midia();
		midia.setNome(command.getNome());
		midia.setDataCriacao(LocalDateTime.now());
		
		midia = this.midiaRepository.save(midia);
		
		this.uploadHelper.upload(midiaInputStream, midia);
		
		return midia;
		
	}
	
}
