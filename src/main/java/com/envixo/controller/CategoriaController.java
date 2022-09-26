package com.envixo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.envixo.commands.CadastrarCategoriaCommand;
import com.envixo.dto.CategoriaDTO;
import com.envixo.handlers.CadastrarCategoriaHandler;

@CrossOrigin
@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	private @Autowired CadastrarCategoriaHandler cadastrarCategoriaHandler;
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody CadastrarCategoriaCommand command) {
		
		return ResponseEntity.ok(CategoriaDTO.toDTO(this.cadastrarCategoriaHandler.handle(command)));
	
	}
	
}
