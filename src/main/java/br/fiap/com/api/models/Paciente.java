package br.fiap.com.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String doc_num;
    private String doc_name;
    private String login;
    private String senha;

    public void setId(Long id) {
        this.id = id;
    }

    public void setDoc_num(String doc_num) {
        this.doc_num = doc_num;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDoc_num() {
        return doc_num;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public String getLogin() {
        return login;
    }
    
    public String getSenha() {
        return senha;
    }

    public Paciente(String doc_num, String doc_name, String login, String senha){
        this.doc_num = doc_num;
        this.doc_name = doc_name;
        this.login = login;
        this.senha = senha;
    }
    
}
