package br.fiap.com.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.fiap.com.api.models.Exames;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ExamesController {
    
    Logger log = LoggerFactory.getLogger(ExamesController.class);

    List<Exames> exames = new ArrayList<>();

    @GetMapping("api/exames")
        public List<Exames> index() {
        return exames;
    }
    @PostMapping("api/exames")
    public ResponseEntity<Exames> create(@RequestBody Exames exames) {
        log.info("cadastrando exame: " + exame);
        exame.setDoc_id(exames.size() + 1l);
        exames.add(exame);
        return ResponseEntity.status(HttpStatus.CREATED).body(exame);
    }

    @GetMapping("api/exames/{id}")
    public ResponseEntity<Exames> show(@PathVariable Long id) {
        log.info("buscando exame com id " + id);
        var exameSelecionado = exames.stream().filter(d -> d.getDoc_id().equals(id)).findFirst();

        if (exameSelecionado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(exameSelecionado.get());

    }

    @DeleteMapping("api/exames/{id}")
    public ResponseEntity<Exames> destroy(@PathVariable Long id) {
        log.info("apagando exame com id " + id);
        var exameSelecionado = exames.stream().filter(d -> d.getDoc_id().equals(id)).findFirst();

        if (exameSelecionado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        exames.remove(documentoSelecionado.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping("api/exames/{id}")
    public ResponseEntity<Exames> update(@PathVariable Long id, @RequestBody Exames exame) {
        log.info("alterando exame de id " + id);
        var exameSelecionado = exames.stream().filter(d -> d.getDoc_id().equals(id)).findFirst();

        if (exameSelecionado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        exames.remove(exameSelecionado.get());
        exame.setDoc_id(id);
        exames.add(exame);

        return ResponseEntity.ok(exame);

    }

}

    
