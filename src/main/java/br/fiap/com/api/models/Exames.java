package br.fiap.com.api.models;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Exames {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotNull
    private String NomeExame;
    @NotBlank @Size(min = 9, max = 11)
    private String doc_num;
    @NotBlank @Size(min = 1, max = 10)
    private String doc_crm;
    @NotNull
    private boolean permission;

    public void setId(Long id) {
        this.id = id;
    }

    public void setNomeExame(String nome_exame) {
        this.nome_exame = nome_exame;
    }

    public void setDoc_num(String doc_num) {
        this.doc_num = doc_num;
    }

    public void setDoc_crm(String doc_crm) {
        this.doc_crm = doc_crm;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    protected Exames(){}

    public Long getId() {
        return id;
    }

    public String getNomeExame() {
        return nome_exame;
    }

    public String getDoc_num() {
        return doc_num;
    }
        
    public String getDoc_crm() {
        return doc_crm;
    }

    public boolean isPermission() {
        return permission;
    }

    public Exames(String nome_exame, String doc_num, String doc_crm, boolean permission){
        this.nome_exame = nome_exame;
        this.doc_num = doc_num;
        this.doc_crm = doc_crm;
        this.permission = permission;
    }

}