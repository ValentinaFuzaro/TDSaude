package br.fiap.com.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotBlank @Size(min = 5, max = 255)
    private String doc_crm;
    @NotBlank @Size(min = 5, max = 255)
    private String doc_name;
    @NotBlank @Size(min = 5, max = 255)
    private String login;
    @NotBlank @Size(min = 5, max = 255)
    private String senha;
    
}
