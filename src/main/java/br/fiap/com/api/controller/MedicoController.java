package br.fiap.com.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.fiap.com.api.models.Medico;
import br.fiap.com.api.repository.MedicoRepository;
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
@RequestMapping("/api/medico")
public class MedicoController {

Logger log = LoggerFactory.getLogger(MedicoController.class);

    List<Medico> medicos = new ArrayList<>();

    @Autowired
    MedicoRepository repository;

    @GetMapping
    public List<Medico> index() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Medico> create(@RequestBody @Valid Medico medico) {
        log.info("cadastrando medico: " + medico);
        repository.save(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(medico);
    }

    @GetMapping("{id}")
    public ResponseEntity<Medico> show(@PathVariable Long id) {
        log.info("buscando medico com id " + id);
        var medico = repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "Médico não encontrado"));
        return ResponseEntity.ok(medico);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Medico> destroy(@PathVariable Long id) {
        log.info("apagando medico com id " + id);

        var medico = repository.findById(id)
            .orElseThrow(() -> new RestNotFoundException("Médico não encontrado"));

        repository.delete(medico);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping("{id}")
    public ResponseEntity<Medico> update(@PathVariable Long id, @RequestBody Medico medico) {
        log.info("alterando medico de id " + id);
    
        repository.findById(id)
            .orElseThrow(() -> new RestNotFoundException("Médico não encontrado"));

        medico.setId(id);

        repository.saveAll(medicos);
        
        return ResponseEntity.ok(medico);

    }

}

