package com.envixo.commands;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.Data;

@Data
public class CadastrarProdutoCommand {

	private Long id;
	
	@NotBlank(message = "O campo titulo é obrigatótio") 
	private String titulo;
	
	@NotBlank(message = "O campo descrição é obrigatótio") 
	private String descricao;
	
	private List<CadastrarMidiaCommand> midias;
	private Long idCategoria;
	
	@NotBlank(message = "O campo status é obrigatótio") 
	private String status;
	
	private String tag;
	
	@NotNull(message = "O campo preco é obrigatótio")
	@PositiveOrZero(message = "O campo preço não pode ser negativo")
	private Long preco;
	
	private Long precoPromocional;
	
}
