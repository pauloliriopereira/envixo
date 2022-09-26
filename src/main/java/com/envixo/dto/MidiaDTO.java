package com.envixo.dto;

import com.envixo.model.Midia;

import lombok.Data;

@Data
public class MidiaDTO {

	private Long id;
	private String nome;
	private String stringBase64;
	
	public MidiaDTO(Midia midia) {
		this.id = midia.getId();
		this.nome = midia.getNome();
	}
	
	public static MidiaDTO toDTO(Midia midia) {
		return new MidiaDTO(midia);
	}
	
}
