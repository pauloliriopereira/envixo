package com.envixo.handlers;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.envixo.commands.CadastrarMidiaCommand;
import com.envixo.commands.CadastrarProdutoCommand;
import com.envixo.model.Categoria;
import com.envixo.model.Midia;
import com.envixo.model.Produto;
import com.envixo.model.enuns.StatusEnum;
import com.envixo.repository.CategoriaRepository;
import com.envixo.repository.ProdutoRepository;

@Service
public class CadastarProdutoHandler {

	@Autowired ProdutoRepository produtoRepository;
	@Autowired CategoriaRepository categoriaRepository;
	@Autowired CadastrarMidiaHandler cadastrarMidiaHandler;
	
	public Produto handle(CadastrarProdutoCommand command) throws IOException {
		
		Produto produto = command.getId() != null ? this.produtoRepository.getOne(command.getId()) : new Produto();
		
		produto.setTitulo(command.getTitulo());
		produto.setDescricao(command.getDescricao());
		
		List<CadastrarMidiaCommand> commandMidias = command.getMidias();
		List<Midia> midias = new ArrayList<Midia>();
			
		for (CadastrarMidiaCommand commandMidia : commandMidias) {
			
			Midia midia = this.cadastrarMidiaHandler.handle(commandMidia);
			midia.setProduto(produto);
			midias.add(midia);
			
		}
		
		produto.setMidias(midias);
		
		Categoria categoria = this.categoriaRepository.getOne(command.getIdCategoria());
		produto.setCategoria(categoria);
		
		produto.setStatus(StatusEnum.valueOf(command.getStatus()));
		produto.setTag(command.getTag());
		produto.setPreco(new BigDecimal(command.getPreco()));
		produto.setPrecoPromocional(new BigDecimal(command.getPrecoPromocional()));
		
		return this.produtoRepository.save(produto);
		
	}
	
}
 