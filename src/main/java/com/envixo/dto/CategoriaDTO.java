package com.envixo.dto;

import com.envixo.model.Categoria;

import lombok.Data;

@Data
public class CategoriaDTO {

	private Long id;
	private String nome;
	
	public CategoriaDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public static CategoriaDTO toDTO(Categoria categoria) {
		return new CategoriaDTO(categoria.getId(), categoria.getNome());
	}
	
}
