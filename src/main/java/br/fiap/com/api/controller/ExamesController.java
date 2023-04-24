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
    ExamesRepository examesRepository;

    @GetMapping("api/exames")
        public List<Exames> index() {
        return repository.findAll();
    }

    @GetMapping
    public ResponseEntity<Exames> index(@RequestParam(required = false) String name, @PageableDefault(size = 5) Pageable pageable){
        if (name == null) return examesRepository.findAll(pageable);
        return examesRepository.findByDocsContaining(name, pageable);
    }

    @PostMapping
    public ResponseEntity<Exames> create(@RequestBody @Valid Exames exames) {
        log.info("cadastrando exame: " + exames);
        examesRepository.save(exames);
        return ResponseEntity.status(HttpStatus.CREATED).body(exames);
    }

    @GetMapping("{id}")
    public ResponseEntity<Exames> mostrarDetalhe(@PathVariable Long id) {
        log.info("Buscando exame com id " + id);
        var exameEncontrado = Examesrepository.findById(id)
                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "Exame não encontrado"));

            ExamesResourceAssembler assembler = new ExamesResourceAssembler();
            Resource<Exames> resource = assembler.toResource(exameEncontrado);

        //return ResponseEntity.ok(exame);    

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Exames> destroy(@PathVariable Long id) {
        log.info("Apagando exame com id " + id);
        var exameEncontrado = examesRepository.findById(id)
                            .orElseThrow(() -> new RestNotFoundException("Exame não encontrado"));
            examesRepository.delete(exameEncontrado);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping("{id}")
    public ResponseEntity<Exames> update(@PathVariable Long id, @RequestBody @Valid Exames exame) {
        log.info("Alterando exame de id " + id);
        examesRepository.findById(id)
                            .orElseThrow(() -> new RestNotFoundException("Exame não encontrado"));
        exame.setId(id);
        examesRepository.save(exames);
        return ResponseEntity.ok(exame);

    }

}

    
