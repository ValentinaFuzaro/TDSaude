package br.fiap.com.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fiap.com.api.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    Optional<Usuario> findByEmail(String username);

}
