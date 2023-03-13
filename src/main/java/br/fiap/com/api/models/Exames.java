package br.fiap.com.api.models;

public class Exames {
    private String doc_crm;
    private boolean permission;

    public String getDoc_crm() {
        return doc_crm;
    }

    public boolean isPermission() {
        return permission;
    }
    
    public Exames(String doc_crm, boolean permission){
        this.doc_crm = doc_crm;
        this.permission = permission;
    }
}