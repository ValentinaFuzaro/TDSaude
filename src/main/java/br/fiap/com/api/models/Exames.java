package br.fiap.com.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Exames {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String doc_crm;
    private boolean permission;

    protected Exames(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDoc_crm(String doc_crm) {
        this.doc_crm = doc_crm;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

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