package br.fiap.com.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fiap.com.api.models.Exames;

@RestController
public class ExamesController {

    @GetMapping("api/medico")
        public Exames exames(){
            var exames = new Exames(
                "446.283.557",
                true
            );

            return exames;
        }
    }
    
