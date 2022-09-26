package com.envixo.dto;

import org.springframework.data.domain.Page;

import com.envixo.model.Categoria;
import com.envixo.model.Produto;

import lombok.Data;

@Data
public class ProdutoDTO {
	
	private Long id;
	private String titulo;
	private String descricao;
	private String categoria;
	private String status;
	private String tag;
	private Long preco;
	private Long precoPromocional;
	
	public ProdutoDTO(Produto produto) {
		
		this.id = produto.getId();
		this.titulo = produto.getTitulo();
		this.descricao = produto.getDescricao();
		Categoria categoria = produto.getCategoria();
		this.categoria = categoria.getNome();
		this.status = produto.getStatus().name();
		this.tag = produto.getTag();
		this.preco = produto.getPreco().longValue();
		this.precoPromocional = produto.getPrecoPromocional().longValue();
		
	}
	
	public static Page<ProdutoDTO> converter(Page<Produto> produtos) {
		return produtos.map(ProdutoDTO::new);
	}
	
	public static ProdutoDTO toDTO(Produto produto) {
		return new ProdutoDTO(produto);
	}
	
}
