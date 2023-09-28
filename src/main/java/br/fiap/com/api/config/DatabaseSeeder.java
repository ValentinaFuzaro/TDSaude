package br.fiap.com.api.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.fiap.com.api.models.Exames;
import br.fiap.com.api.repository.ExamesRepository;

import br.fiap.com.api.models.Medico;
import br.fiap.com.api.repository.MedicoRepository;

import br.fiap.com.api.models.Paciente;
import br.fiap.com.api.repository.PacienteRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    ExamesRepository   examesRepository;

    @Autowired
    MedicoRepository   medicoRepository;
    
    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public void run(String... args) throws Exception {
        examesRepository.saveAll(List.of(
            new Exames(1L, "Exame de Sangue", "81341359000", "108805-SP", true),
            new Exames(2L, "Exame de Sangue", "81341359000", "16865-SP", true),
            new Exames(3L, "Tomografia", "11085807002", "16865-SP", false),
            new Exames(4L, "Raio-X", "56267824004", "24427-DF", true)
        ));
        
        medicoRepository.saveAll(List.of(
            new Medico(1L, "108805-SP", "Adele Christina Manso Marques", "Adele108805", "******"),
            new Medico(2L, "16865-SP", "Ademar Sikara Tanaka", "Ademar16865", "******"),
            new Medico(3L, "24427-DF", "Abel de Castro Vieira", "Abel24427", "******")
        ));

        pacienteRepository.saveAll(List.of(
            new Paciente(1L, "81341359000", "Ananias Junior da Silva Castro", "Ananias", "******"),
            new Paciente(2L, "11085807002", "Priscila Silva Marques", "Pri11", "******"),
            new Paciente(3L, "56267824004", "Matheus Araujo Oliveira", "Matheus5626", "******")
        ));
        
    }
    
}

