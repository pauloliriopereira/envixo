package com.envixo.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.envixo.model.enuns.StatusEnum;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Long id;
	
	@Getter @Setter
	private String titulo;
	
	@Getter @Setter
	private String descricao;
	
	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
	@Getter @Setter
	private List<Midia> midias;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria_id")
	@Getter @Setter
	private Categoria categoria;
	
	@Enumerated(value=EnumType.STRING)
	@Getter @Setter
	private StatusEnum status;
	
	@Column(name="tag", nullable=false)
	@Getter @Setter
	private String tag;
	
	@Getter @Setter
	private BigDecimal preco;
	
	@Getter @Setter
	private BigDecimal precoPromocional;
	
}
