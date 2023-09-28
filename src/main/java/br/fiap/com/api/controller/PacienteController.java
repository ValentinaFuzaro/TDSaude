package br.fiap.com.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import br.fiap.com.api.models.Paciente;
import br.fiap.com.api.repository.PacienteRepository;
import br.fiap.com.api.exception.RestNotFoundException;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/paciente")
public class PacienteController {

    Logger log = LoggerFactory.getLogger(PacienteController.class);

    List<Paciente> pacientes = new ArrayList<>();

    @Autowired
    PacienteRepository repository;

    @GetMapping
    public List<Paciente> index() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Paciente> create(@RequestBody @Valid Paciente paciente) {
        log.info("cadastrando paciente: " + paciente);
        
        repository.save(paciente);

        return ResponseEntity.status(HttpStatus.CREATED).body(paciente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> show(@PathVariable Long id) {
        log.info("buscando paciente com id " + id);

        var paciente = repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "Paciente não encontrado"));

        return ResponseEntity.ok(paciente);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Paciente> destroy(@PathVariable Long id) {
        log.info("apagando paciente com id " + id);
       
        var paciente = repository.findById(id)
            .orElseThrow(() -> new RestNotFoundException("Paciente não encontrado"));

        repository.delete(paciente);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> update(@PathVariable Long id, @RequestBody Paciente paciente) {
        log.info("alterando informações do pacientes de id " + id);
   
        repository.findById(id)
            .orElseThrow(() -> new RestNotFoundException("Paciente não encontrado"));

        paciente.setId(id);

        repository.saveAll(pacientes);
        
        return ResponseEntity.ok(paciente);

    }


}
