package br.fiap.com.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fiap.com.api.models.Medico;

@RestController
public class MedicoController {

    @GetMapping("api/medico")
        public Medico medico(){
            var medico = new Medico(
                "123456",
                "Valentina Fuzaro",
                "MedValentina",
                "eusou@Medic4"
            );

            return medico;
        }
    }
