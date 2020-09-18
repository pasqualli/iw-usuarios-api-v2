package br.com.innowise.api.dtos;

import br.com.innowise.api.documents.Contato;

public class ContatoDTO {
	private String nome;
	private String valor;

	public ContatoDTO() {
	}

	public ContatoDTO(String nome, String valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}

	public ContatoDTO(Contato contato) {
		super();
		this.nome = contato.getNome();
		this.valor = contato.getValor();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
