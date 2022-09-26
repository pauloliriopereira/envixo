package com.envixo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "midia")
public class Midia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Long id;
	
	@Getter @Setter 
	private String nome;
	
	@Getter @Setter
	@ManyToOne
    @JoinColumn(name="produto_id")
	private Produto produto;
	
	@Getter @Setter
	private LocalDateTime dataCriacao;
	
}
