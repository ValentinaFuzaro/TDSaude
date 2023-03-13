package br.fiap.com.api.models;

public class Medico {
    private String doc_crm;
    private String doc_name;
    private String login;
    private String senha;

    public String getDoc_crm() {
        return doc_crm;
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

    public Medico(String doc_crm, String doc_name, String login, String senha){
        this.doc_crm = doc_crm;
        this.doc_name = doc_name;
        this.login = login;
        this.senha = senha;
    }

    
    
}
