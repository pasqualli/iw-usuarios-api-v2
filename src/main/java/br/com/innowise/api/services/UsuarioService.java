package br.com.innowise.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.innowise.api.documents.Usuario;
import br.com.innowise.api.dtos.UsuarioDTO;
import br.com.innowise.api.exceptions.ObjectNotFoundException;
import br.com.innowise.api.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public UsuarioDTO store(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario(usuarioDTO);
		usuario = usuarioRepository.save(usuario);

		usuarioDTO = new UsuarioDTO(usuario);

		return usuarioDTO;

	}

	public List<UsuarioDTO> index() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
	}

	public UsuarioDTO show(String id) {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Object not fount -> " + id));
		return new UsuarioDTO(usuario);
	}
}
