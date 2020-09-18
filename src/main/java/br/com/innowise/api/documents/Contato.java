package br.com.innowise.api.documents;

import br.com.innowise.api.dtos.ContatoDTO;

public class Contato {

	private String nome;
	private String valor;

	public Contato() {
	}

	public Contato(String nome, String valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}

	public Contato(ContatoDTO contato) {
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
