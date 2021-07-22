# Comandos e Exemplos em PostgreSQL

​																																		By: Gustavo Reis

# JOINs

- **JOIN (INNER):**  Retorna apenas as linhas que possuem ligação entre as tabelas.</br>
- **LEFT JOIN**: Retorna todas as linhas da tabela a esquerda, mesmo aquelas que não possuem ligação à direita.</br>
- **RIGHT JOIN:** Retorna todas as linhas da tabela a direita, mesmo aquelas que não possuem ligação à esquerda.</br>
- **FULL JOIN:** Retorna todas as linhas de ambas as tabelas.</br>
- **CROSS JOIN:** Cruza os dados de ambas as tabelas.</br>

---

##### *<u>Tabela cargo</u>*

| *//* | codCargo | nomeCARGO | valorCargo |
| ---: | :------: | :-------: | :--------: |
|    1 |    C1    | Dentista  |  2000.00   |
|    2 |    C2    | Advogado  |  4000.00   |
|    3 |    C3    |  Médico   |  7000.00   |

##### *<u>Tabela Funcionarios</u>*

| *//* | matricula | nomeFuncionario | codCargo |
| ---: | :-------: | :-------------: | :------: |
|    1 |    100    |      João       |    C1    |
|    2 |    110    |      Maria      |    C2    |
|    3 |    120    |     Matheus     |   NULL   |

---

####  JOIN (INNER)

```sql
SELECT funcionarios.nomeFuncionario, cargo.nomeCargo
FROM cargo
JOIN funcionarios ON funcionarios.codigoCargo = cargo.codigoCargo;
```

###### RESULTADO:

| *//* | nomeFuncionario | nomeCargo |
| ---: | :-------------: | --------- |
|    1 |      João       | Dentista  |
|    2 |      Maria      | Advogado  |

---

#### LEFT JOIN

```sql
SELECT funcionarios.nomeFuncionario, cargo.nomeCargo
FROM funcionarios
LEFT JOIN cargo ON funcionarios.codigoCargo = cargo.codigoCargo;
```

###### RESULTADO:

|   // | nomeFuncionario | nomeCargo |
| ---: | :-------------: | :-------- |
|    1 |      João       | Dentista  |
|    2 |      Maria      | Advogado  |
|    3 |     Matheus     | NULL      |

---

#### RIGHT JOIN

```sql
SELECT funcionarios.nomeFuncionario, cargo.nomeCargo
FROM funcionarios
RIGHT JOIN cargo ON funcionarios.codigoCargo = cargo.codigoCargo;
```

###### RESULTADO:

| *//* | nomeFuncionario | nomeCargo |
| ---: | :-------------: | :-------- |
|    1 |      João       | Dentista  |
|    2 |      Maria      | Advogado  |
|    3 |      NULL       | Médico    |

---

#### FULL JOIN

```sql
SELECT SELECT funcionarios.nomeFuncionario, cargo.nomeCargo
FROM funcionarios
FULL JOIN cargo ON funcionarios.codigoCargo = cargo.codigoCargo;
```

###### RESULTADO:

| *//* | nomeFuncionario | nomeCargo |
| ---: | :-------------: | :-------- |
|    1 |      João       | Dentista  |
|    2 |      Maria      | Advogado  |
|    3 |     Matheus     | NULL      |
|    4 |      NULL       | Médico    |

---

#### CROSS JOIN

```sql
SELECT funcionarios.nomeFuncionario, cargo.nomeCargo
FROM funcionarios
CROSS JOIN cargo;
```

###### RESULTADO:

| *//* | nomeFuncionario | nomeCargo |
| ---: | :-------------: | :-------- |
|    1 |      João       | Dentista  |
|    2 |      João       | Advogado  |
|    3 |      João       | Médico    |
|    4 |      Maria      | Dentista  |
|    5 |      Maria      | Advogado  |
|    6 |      Maria      | Médico    |
|    7 |     Matheus     | Dentista  |
|    8 |     Matheus     | Advogado  |
|    9 |     Matheus     | Médico    |