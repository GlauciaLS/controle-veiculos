package io.github.glaucials.controleveiculos.repository;

import io.github.glaucials.controleveiculos.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
