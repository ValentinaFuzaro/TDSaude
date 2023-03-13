package br.fiap.com.api.models;

public class Paciente {
    private String doc_num;
    private String doc_name;
    private String login;
    private String senha;

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
