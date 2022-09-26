package com.envixo.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.envixo.commands.CadastrarProdutoCommand;
import com.envixo.commands.RemoverProdutoCommand;
import com.envixo.dto.ProdutoDTO;
import com.envixo.handlers.CadastarProdutoHandler;
import com.envixo.handlers.RemoverProdutoHandler;
import com.envixo.model.Produto;
import com.envixo.params.ProdutoSearchParams;
import com.envixo.repository.ProdutoRepository;
import com.envixo.repository.specification.ProdutoSpecificationBuilder;

@CrossOrigin
@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	private @Autowired ProdutoRepository produtoRepository;
	private @Autowired ProdutoSpecificationBuilder produtoSpecificationBuilder;
	private @Autowired CadastarProdutoHandler cadastarProdutoHandler;
	private @Autowired RemoverProdutoHandler removerProdutoHandler;
	
	@GetMapping
	@Transactional
	public ResponseEntity<?> listar(ProdutoSearchParams params, 
			@PageableDefault (sort = "titulo", direction = Sort.Direction.ASC) Pageable paginacao) {
		
		Page<Produto> produtos = this.produtoRepository.findAll(this.produtoSpecificationBuilder.build(params), paginacao);
		
		return ResponseEntity.ok(ProdutoDTO.converter(produtos));
		
	}
	
	@DeleteMapping
	public ResponseEntity<?> remover(@RequestBody RemoverProdutoCommand command) {
		
		this.removerProdutoHandler.handle(command);
		
		return ResponseEntity.ok().build();
		
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid CadastrarProdutoCommand command) throws IOException {
		
//		if(!StringUtils.isEmpty(command.getStatus())) 
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body();
//		
//		if(command.getPreco() == null) 
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body();
		
		return ResponseEntity.ok(ProdutoDTO.toDTO(this.cadastarProdutoHandler.handle(command)));
		
	}

}
