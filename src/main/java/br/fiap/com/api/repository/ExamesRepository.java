package br.fiap.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.fiap.com.api.models.Exames;

public interface ExamesRepository extends JpaRepository<Exames, Long> {
}
