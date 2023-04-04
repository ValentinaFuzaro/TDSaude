package br.fiap.com.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import br.fiap.com.api.models.Exames;
import br.fiap.com.api.repository.ExamesRepository;
import br.fiap.com.api.exception.RestNotFoundException;
import jakarta.validation.Valid;


import java.security.cert.CertPathValidatorException.Reason;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/exames")
public class ExamesController {
    
    Logger log = LoggerFactory.getLogger(ExamesController.class);

    List<Exames> exames = new ArrayList<>();

    @Autowired
    ExamesRepository repository;

    @GetMapping("api/exames")
        public List<Exames> index() {
        return repository.findAll();

    }

    @PostMapping
    public ResponseEntity<Exames> create(@RequestBody @Valid Exames exames) {
        log.info("cadastrando exame: " + exames);
     
        repository.save(exames);

        return ResponseEntity.status(HttpStatus.CREATED).body(exames);
    }

    @GetMapping("{id}")
    public ResponseEntity<Exames> show(@PathVariable Long id) {
        log.info("buscando exame com id " + id);

        var exame = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "Exame não encontrado"));

        

        return ResponseEntity.ok(exame);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Exames> destroy(@PathVariable Long id) {
        log.info("apagando exame com id " + id);

        var exame = repository.findById(id)
            .orElseThrow(() -> new RestNotFoundException("Exame não encontrado"));

        repository.delete(exame);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping("{id}")
    public ResponseEntity<Exames> update(@PathVariable Long id, @RequestBody Exames exame) {
        log.info("alterando exame de id " + id);

        repository.findById(id)
            .orElseThrow(() -> new RestNotFoundException("Exame não encontrado"));

        exame.setId(id);

        repository.saveAll(exames);
        
        return ResponseEntity.ok(exame);

    }

}

    
