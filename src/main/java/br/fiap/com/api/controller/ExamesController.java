package br.fiap.com.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.fiap.com.api.models.Exames;
import br.fiap.com.api.repository.ExamesRepository;
import br.fiap.com.api.exception.RestNotFoundException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@Slf4j
@RequestMapping("/api/exames")
public class ExamesController {

    List<Exames> exames = new ArrayList<>();

    @Autowired
    ExamesRepository repository;

    @GetMapping
    public List<Exames> index() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid Exames exames) {
        log.info("cadastrando exames: " + exames);
        repository.save(exames);
        return ResponseEntity.status(HttpStatus.CREATED).body(exames);
    }

    @GetMapping("{id}")
    public ResponseEntity<Exames> show(@PathVariable Long id) {
        log.info("buscando exames com id " + id);
        var exames = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "Exames não encontrado"));
        return ResponseEntity.ok(exames);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Exames> destroy(@PathVariable Long id) {
        log.info("apagando exames com id " + id);
        var exames = repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Exames não encontrado"));

        repository.delete(exames);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("{id}")
    public ResponseEntity<Exames> update(@PathVariable Long id, @RequestBody @Valid Exames exames) {
        log.info("alterando exames com id " + id);
        repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("exames não encontrado"));

        exames.setId(id);
        repository.save(exames);

        return ResponseEntity.ok(exames);

    }

}
