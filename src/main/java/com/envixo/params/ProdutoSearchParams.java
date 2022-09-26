package com.envixo.params;

import java.util.List;

import lombok.Data;

@Data
public class ProdutoSearchParams {

	private String status;
	private String titulo;
	private List<Long> ids;
	
}
