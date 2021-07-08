package io.github.glaucials.controleveiculos.repository;

import io.github.glaucials.controleveiculos.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
