package com.envixo.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.envixo.commands.CadastrarCategoriaCommand;
import com.envixo.model.Categoria;
import com.envixo.repository.CategoriaRepository;

@Service
public class CadastrarCategoriaHandler {

	@Autowired CategoriaRepository categoriaRepository;
	
	public Categoria handle(CadastrarCategoriaCommand command) {
		
		Categoria categoria = command.getId() != null ? this.categoriaRepository.getOne(command.getId()) : new Categoria();
		categoria.setNome(command.getNome());
		
		return this.categoriaRepository.save(categoria);
		
	}
}
