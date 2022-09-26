package com.envixo.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.envixo.commands.RemoverProdutoCommand;
import com.envixo.params.ProdutoSearchParams;
import com.envixo.repository.ProdutoRepository;
import com.envixo.repository.specification.ProdutoSpecificationBuilder;

@Service
public class RemoverProdutoHandler {
	
	private @Autowired ProdutoRepository produtoRepository;
	private @Autowired ProdutoSpecificationBuilder produtoSpecificationBuilder;
	
	public void handle(RemoverProdutoCommand command) {
		
		ProdutoSearchParams params = new ProdutoSearchParams();
		params.setIds(command.getIds());
		
		this.produtoRepository.deleteAll(this.produtoRepository.findAll(this.produtoSpecificationBuilder.build(params)));
		
	}

}

