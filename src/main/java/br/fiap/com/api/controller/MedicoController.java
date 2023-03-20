package br.fiap.com.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.fiap.com.api.models.Medico;

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
public class MedicoController {

Logger log = LoggerFactory.getLogger(MedicoController.class);

    List<Medicos> medicos = new ArrayList<>();

    @GetMapping("api/medicos")
    public List<Medicos> index() {
        return medicos;
    }

    @PostMapping("api/medicos")
    public ResponseEntity<Medicos> create(@RequestBody Medicos medicos) {
        log.info("cadastrando medico: " + medico);
        medico.setDoc_id(documentos.size() + 1l);
        medicos.add(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(medico);
    }

    @GetMapping("api/medicos/{id}")
    public ResponseEntity<Medicos> show(@PathVariable Long id) {
        log.info("buscando medico com id " + id);
        var medicoSelecionado = medicos.stream().filter(d -> d.getDoc_id().equals(id)).findFirst();

        if (medicoSelecionado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(medicoSelecionado.get());

    }

    @DeleteMapping("api/medicos/{id}")
    public ResponseEntity<Medicos> destroy(@PathVariable Long id) {
        log.info("apagando medico com id " + id);
        var medicoSelecionado = medicos.stream().filter(d -> d.getDoc_id().equals(id)).findFirst();

        if (medicoSelecionado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        medicos.remove(medicoSelecionado.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping("api/medicos/{id}")
    public ResponseEntity<Medicos> update(@PathVariable Long id, @RequestBody Medicos medico) {
        log.info("alterando medico de id " + id);
        var medicoSelecionado = medicos.stream().filter(d -> d.getDoc_id().equals(id)).findFirst();

        if (medicoSelecionado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        medicos.remove(medicoSelecionado.get());
        medico.setDoc_id(id);
        medicos.add(medico);

        return ResponseEntity.ok(medico);

    }

}

