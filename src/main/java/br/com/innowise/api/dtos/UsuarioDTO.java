package br.com.innowise.api.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.innowise.api.documents.Usuario;

public class UsuarioDTO {

	private String _id;
	private String nome;
	private String cpf;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	private Boolean ativo;
	private EncerecoDTO endereco;
	private List<ContatoDTO> contatos = new ArrayList<>();

	
	public UsuarioDTO(String _id, String nome, String cpf, LocalDate dataNascimento, Boolean ativo, EncerecoDTO endereco) {
		super();
		this._id = _id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.ativo = ativo;
		this.endereco = endereco;
	}
	
	public UsuarioDTO(Usuario usuario) {
		super();
		this._id = usuario.get_id();
		this.nome = usuario.getNome();
		this.cpf = usuario.getCpf();
		this.dataNascimento = usuario.getDataNascimento();
		this.ativo = usuario.getAtivo();
		this.endereco = new EncerecoDTO(usuario.getEndereco());
		this.contatos = usuario.getContatos().stream().map(x -> new ContatoDTO(x)).collect(Collectors.toList());
	}

	public UsuarioDTO() {
	}

	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public EncerecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EncerecoDTO endereco) {
		this.endereco = endereco;
	}

	public List<ContatoDTO> getContatos() {
		return contatos;
	}

	public void setContatos(List<ContatoDTO> contatos) {
		this.contatos = contatos;
	}

}
