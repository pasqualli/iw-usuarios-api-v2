package br.com.innowise.api.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.innowise.api.dtos.UsuarioDTO;
import br.com.innowise.api.services.UsuarioService;

@RestController
@RequestMapping("api/v1/usuarios/")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;
	
	@PostMapping
	public ResponseEntity<UsuarioDTO>store(@RequestBody UsuarioDTO usuarioDTO, UriComponentsBuilder uriBuilder){
		usuarioDTO = service.store(usuarioDTO);
		URI location = uriBuilder.path("/{id}").buildAndExpand(usuarioDTO.get_id()).toUri();
		return ResponseEntity.created(location).body(usuarioDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO>show(@PathVariable(name = "id") String id){
		UsuarioDTO usuarioDTO = service.show(id);
		return ResponseEntity.ok(usuarioDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<UsuarioDTO>delete(@PathVariable(name = "id") String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>>index(){
		List<UsuarioDTO>list = service.index();
		return ResponseEntity.ok(list);
	}
}
