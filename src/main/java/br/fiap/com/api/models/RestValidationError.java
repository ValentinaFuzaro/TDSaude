package br.fiap.com.api.models;

public record RestValidationError (
    Integer code,
    String field,
    String mesage
    ){}

