package com.projeto.ifood.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "numero", length = 100, nullable = false)
	private Integer numero;
	@Column(name = "endereco", length = 50, nullable = false)
	private String endereco;
	@Column(name = "preco", length = 50, nullable = false)
	private Double preco;
	@Column(name = "acompanhamento", length = 50, nullable = false)
	private Boolean acompanhamento;
	@Column(name = "cupom", length = 50, nullable = false)
	private Boolean cupom;
	@Column(name = "telefone", length = 50, nullable = false)
	private Integer telefone;
	@Column(name = "imagem", length = 50, nullable = false)
	private String imagem;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Boolean getAcompanhamento() {
		return acompanhamento;
	}
	public void setAcompanhamento(Boolean acompanhamento) {
		this.acompanhamento = acompanhamento;
	}
	public Boolean getCupom() {
		return cupom;
	}
	public void setCupom(Boolean cupom) {
		this.cupom = cupom;
	}
	public Integer getTelefone() {
		return telefone;
	}
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
}