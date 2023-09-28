package br.fiap.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.fiap.com.api.models.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}