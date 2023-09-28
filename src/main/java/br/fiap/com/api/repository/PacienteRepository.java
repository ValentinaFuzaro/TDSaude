package br.fiap.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.fiap.com.api.models.Paciente;


public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
