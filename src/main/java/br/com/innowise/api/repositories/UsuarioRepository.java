package br.com.innowise.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.innowise.api.documents.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

}
