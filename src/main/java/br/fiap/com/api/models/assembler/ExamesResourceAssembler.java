package br.fiap.com.api.models.assembler;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import br.com.fiap.TdSaudeApplication.controllers.ExamesController;
import br.com.fiap.TdSaudeApplication.models.Exames;

@Component
public class ExamesResourceAssembler implements ResourceAssembler<Exames, Resource<Exames>> {
    
    @Override
    public Resource<Exames> toResource(Exames exames) {
        Resource<Exames> resource = new Resource<>(exames);

        Link selfLink = linkTo(methodOn(ExamesController.class).mostrarDetalhe(exames.getExamesId())).withSelfRel();
        resource.add(selfLink);

        return resource;
    }
}