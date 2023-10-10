## Script json do paciente

`GET` /api/paciente
```
[
	{
		"id": 1,
		"doc_num": "81341359000",
		"doc_name": "Ananias Junior da Silva Castro",
		"login": "Ananias",
		"senha": "******"
	},
	{
		"id": 4,
		"doc_num": "81341359000",
		"doc_name": "Fernanda",
		"login": "Fernanda",
		"senha": "******"
	},
	{
		"id": 5,
		"doc_num": "81341359000",
		"doc_name": "Paula",
		"login": "Paula",
		"senha": "******"
	}
]
```

`POST` /api/paciente

```
{
	"doc_num": "81341359000",
	"doc_name": "Fernanda",
	"login": "Fernanda",
	"senha": "******"
}
```

`PUT` /api/paciente/{id}
```
{
	"doc_num": "81341359000",
	"doc_name": "Fernanda Porfirio",
	"login": "Fernanda",
	"senha": "******"
}
```

`DELETE` /api/paciente/{id}

## Script json do medico

`GET` /api/medico
```
[
	{
		"id": 1,
		"doc_crm": "108805-SP",
		"doc_name": "Adele Christina Manso Marques",
		"login": "Adele108805",
		"senha": "******"
	},
	{
		"id": 5,
		"doc_crm": "101305-SP",
		"doc_name": "Pedro",
		"login": "Pedro108805",
		"senha": "******"
	},
	{
		"id": 6,
		"doc_crm": "100005-PR",
		"doc_name": "Junior",
		"login": "Junior108805",
		"senha": "******"
	}
]
```

`POST` /api/medico

```
{
	"doc_crm": "109005-MG",
	"doc_name": "Marcos",
	"login": "Marcos108805",
	"senha": "******"
}
```

`PUT` /api/medico/{id}
```
{
	"doc_crm": "109005-MG",
	"doc_name": "Marcos Roberto",
	"login": "Marcos108805",
	"senha": "******"
}
```

`DEELTE` /api/medico/{id}