package com.envixo.repository.specification;

import java.util.List;

import org.apache.axis.utils.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.envixo.model.Produto;
import com.envixo.model.enuns.StatusEnum;
import com.envixo.params.ProdutoSearchParams;

@Component
public class ProdutoSpecificationBuilder {
	
	public Specification<Produto> build(ProdutoSearchParams params) {
		
		return Specification
				.where(tituloLike(params.getTitulo()))
				.and(statusEqual(params.getStatus()))
				.and(idsIn(params.getIds()));
		
	}

	private Specification<Produto> idsIn(List<Long> ids) {
		
		if(ids != null && ids.size() > 0) {
			return (root, query, criteriaBuilder) ->  criteriaBuilder.in(root.get("id")).value(ids);
		}
		
		return null;
		
	}

	private Specification<Produto> tituloLike(String titulo) {
		
		if(!StringUtils.isEmpty(titulo)) {
			return (root, query, criteriaBuilder) ->  criteriaBuilder.like(root.get("titulo"), "%" + titulo + "%");
		}
		
		return null;
		
	}

	private Specification<Produto> statusEqual(String status) {

		if(!StringUtils.isEmpty(status)) {
			return (root, query, criteriaBuilder) ->  criteriaBuilder.equal(root.get("status"), StatusEnum.valueOf(status));
		}
		
		return null;
		
	}
	
}
