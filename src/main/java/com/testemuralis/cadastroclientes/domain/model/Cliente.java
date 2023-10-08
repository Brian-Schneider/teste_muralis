package com.testemuralis.cadastroclientes.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Cliente é uma entidade para o banco de dados.
 * 
 * @author Brian Schneider
 */
@Entity
@Table (name = "tb_cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo nome é obrigatório")
	@Size(max = 150, message = " O atributo nome deve ter no máximo 150 caracteres")
	@Column(name = "nome")
	private String nome;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("cliente")
	private Endereco endereco;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Contato.class)
	@JoinColumn(name = "cliente_id", referencedColumnName = "id")
	private List<Contato> contato;
	
	@NotBlank(message = "O atributo dataCadastro é obrigatório")
	@Size(max = 10, message = " O atributo dataCadastro deve ter no máximo 10 caracteres")
	@Column(name = "data_cadastro")
	private String dataCadastro;
	
	//@UpdateTimestamp
	//private LocalDateTime dataCadastro;
	
	/**
	 * Constrói um Cliente sem argumentos de entrada
	 */
	public Cliente() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Contato> getContato() {
		return contato;
	}

	public void setContato(List<Contato> contato) {
		this.contato = contato;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	

}
