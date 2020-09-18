package br.com.innowise.api.documents;

import br.com.innowise.api.dtos.EncerecoDTO;

public class Encereco {

	private String cep;
	private String numero;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;

	
	public Encereco() {}
	
	public Encereco(String cep, String numero, String rua, String bairro, String cidade, String estado,
			String pais) {
		super();
		this.cep = cep;
		this.numero = numero;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
	}
	
	public Encereco(EncerecoDTO encereco) {
		super();
		this.cep = encereco.getCep();
		this.numero = encereco.getNumero();
		this.rua = encereco.getRua();
		this.bairro = encereco.getBairro();
		this.cidade = encereco.getCidade();
		this.estado = encereco.getEstado();
		this.pais = encereco.getPais();
	}
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
