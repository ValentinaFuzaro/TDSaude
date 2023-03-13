package br.fiap.com.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fiap.com.api.models.Paciente;

@RestController
public class PacienteController {

    @GetMapping("api/peciente")
    public Paciente paciente(){
        new Paciente(
            "553.318.430-93",
            "Ana Karol",
            "AnaKarol",
            "eusou@Alun4"
        );

        return paciente();
        
    }
    
}
