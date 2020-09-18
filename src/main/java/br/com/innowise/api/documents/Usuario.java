package br.com.innowise.api.documents;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.innowise.api.dtos.UsuarioDTO;

@Document(collection = "usuarios")
public class Usuario {

	private String _id;
	private String nome;
	private String cpf;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	private Boolean ativo;
	private Encereco endereco;
	private List<Contato> contatos = new ArrayList<>();
	@CreatedDate
	private LocalDateTime dataCricao;
	@LastModifiedDate
	private LocalDateTime dataAtualizacao;

	public Usuario(String _id, String nome, String cpf, LocalDate dataNascimento, Boolean ativo, Encereco endereco) {
		super();
		this._id = _id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.ativo = ativo;
		this.endereco = endereco;
	}
	
	public Usuario(UsuarioDTO usuario) {
		super();
		this._id = usuario.get_id();
		this.nome = usuario.getNome();
		this.cpf = usuario.getCpf();
		this.dataNascimento = usuario.getDataNascimento();
		this.ativo = usuario.getAtivo();
		this.endereco = new Encereco(usuario.getEndereco());
		this.contatos = usuario.getContatos().stream().map(x -> new Contato(x)).collect(Collectors.toList());
	}

	public Usuario() {
	}

	public void addContato(Contato contato) {
		this.contatos.add(contato);
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

	public Encereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Encereco endereco) {
		this.endereco = endereco;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (_id == null) {
			if (other._id != null)
				return false;
		} else if (!_id.equals(other._id))
			return false;
		return true;
	}

}
