package br.fiap.com.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.fiap.com.api.models.Paciente;

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
public class PacienteController {

    Logger log = LoggerFactory.getLogger(PacienteController.class);

    List<Pacientes> pacientes = new ArrayList<>();

    @GetMapping("api/pacientes")
    public List<Pacientes> index() {
        return pacientes;
    }

    @PostMapping("api/pacientes")
    public ResponseEntity<Pacientes> create(@RequestBody Pacientes paciente) {
        log.info("cadastrando paciente: " + paciente);
        paciente.setDoc_id(pacientes.size() + 1l);
        pacientes.add(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(paciente);
    }

    @GetMapping("api/pacientes/{id}")
    public ResponseEntity<Pacientes> show(@PathVariable Long id) {
        log.info("buscando paciente com id " + id);
        var pacienteSelecionado = pacientes.stream().filter(d -> d.getDoc_id().equals(id)).findFirst();

        if (pacienteSelecionado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(pacienteSelecionado.get());

    }

    @DeleteMapping("api/pacientes/{id}")
    public ResponseEntity<Pacientes> destroy(@PathVariable Long id) {
        log.info("apagando paciente com id " + id);
        var pacienteSelecionado = pacientes.stream().filter(d -> d.getDoc_id().equals(id)).findFirst();

        if (pacienteSelecionado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        pacientes.remove(pacienteSelecionado.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping("api/pacientes/{id}")
    public ResponseEntity<Pacientes> update(@PathVariable Long id, @RequestBody Pacientes paciente) {
        log.info("alterando informações do pacientes de id " + id);
        var pacienteSelecionado = pacientes.stream().filter(d -> d.getDoc_id().equals(id)).findFirst();

        if (pacienteSelecionado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        pacientes.remove(pacienteSelecionado.get());
        paciente.setDoc_id(id);
        pacientes.add(paciente);

        return ResponseEntity.ok(paciente);

    }

}
