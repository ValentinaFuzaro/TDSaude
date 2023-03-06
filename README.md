# TDSaude
App de saúde voltado para o monitoramento das condições do cidadão.

## Endpoints
- Documentos
    - Cadastro Paciente
    - Cadastro Médico   
    - Listar exames
---

### CadastrarPaciente
`GET` /inOne/api/docs/cadastroPaciente

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|--
| doc_num | string | sim | É o número de cadstro da pessoa física.
| doc_name | string | sim | É o nome completo no documento.
| login | string | sim | Login de acesso.
| senha | string | sim | Senha.


**Exemplo de corpo do request**

```js
{
    "doc_num" : "553.318.430-93",
    "doc_name": "Ana Karol",
    "login": "AnaKarol",
    "senha": "eusou@Alun4"
    
}
```

**Códigos de Exceção**

| código | descrição 
|-|-
| 201 | Cadastrado com sucesso
| 400 | Erro de cadastro

---

### CadastrarMédico
`GET` /inOne/api/docs/cadastroMedico

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|--
| doc_crm | string | sim | É o número do registro no Conselho Federal de Medicina.
| doc_name | string | sim | É o nome completo no documento.
| login | string | sim | Login de acesso.
| senha | string | sim | Senha.


**Exemplo de corpo do request**

```js
{
    "doc_crm" : "123456",
    "doc_name": "Valentina Fuzzaro",
    "login": "MedValentina",
    "senha": "eusou@Medic4"
    
}
```

**Códigos de Exceção**

| código | descrição 
|-|-
| 201 | Cadastrado com sucesso
| 400 | Erro de cadastro

---
### Buscar Todos
`GET` /inOne/api/docs/getFields

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|--
| doc_crm | string | sim |  É o número de cadstro da pessoa física.
| permission | boolean | sim | Indica se a pessoa tem permissão para acessar os documentos ou não.

**Exemplo de corpo da resposta**

```js
{
    "doc_crm": 446.283.557,
    "permission": X,
}
```

**Códigos de Exceção**

| código | descrição 
|-|-
| 200 | Ok
| 400 | Erro de busca

---
