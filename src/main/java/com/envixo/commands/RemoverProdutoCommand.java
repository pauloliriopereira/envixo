package com.envixo.commands;

import java.util.List;

import lombok.Data;

@Data
public class RemoverProdutoCommand {

	List<Long> ids;
	
}
