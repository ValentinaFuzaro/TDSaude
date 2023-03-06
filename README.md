# TDSa-de
App de saúde voltado para o monitoramento das condições do cidadão.

## Endpoints
- Documentos
    - Listar todos
    - Selecionar

---

### Buscar Um
`GET` /inOne/api/docs/listOne

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|--
| doc_num | string | sim | É o número de cadstro da pessoa física.
| doc_name | string | sim | É o nome do documento.
| permission | boolean | sim | Permissão para acesso aos dados.

**Exemplo de corpo do request**

```js
{
    "doc_num" : "553.318.430-93",
    "doc_name": "CPF",
    "permission": X,
}
```

**Códigos de Exceção**

| código | descrição 
|-|-
| 201 | Cadastrado com sucesso
| 400 | Erro de cadastro

---
### Buscar Todos
`GET` /inOne/api/docs

**Exemplo de corpo da resposta**

```js
{
    "doc_num": 446.283.557,
    "doc_digit": x,
    "doc_name": "RG",
    "doc_body": "assets/image/user/cats/doc/rg.pdf"
}
```

**Códigos de Exceção**

| código | descrição 
|-|-
| 200 | Ok
| 400 | Erro de busca

---
