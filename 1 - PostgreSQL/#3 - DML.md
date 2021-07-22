# Comandos e Exemplos em PostgreSQL

​																																		By: Gustavo Reis

DML - Data Manipulation Language<br/>Linguagem de manipulação de dados
===

- **INSERT:** Insere.</br>
- **UPDATE:** Atualiza.</br>
- **DELETE:** Remove.</br>
- **SELECT:** Seleciona.</br>
- **TRUNCATE:** Esvazia uma tabela.</br>

---

#### INSERT

```sql
INSERT INTO table_name (campos da tabela)
VALUES (valores de acordo com a ordem dos campos acima);
```

```sql
INSERT INTO table_name (campos da tabela)
SELECT(valores de acordo com a ordem dos campos acima);
```

---

#### UPDATE 

```sql
UPDATE table_name SET
campo1 = novo valor do campo1,
campo2 = novo valor do campo2,
...
WHERE condição;
```

###### ATENÇÃO: muito cuidado com os updates. Sempre utilize-os com condição.

---

#### DELETE

```sql
DELETE FROM table_name
WHERE condição;
```

###### ATENÇÃO: muito cuidado com os deletes. Sempre utilize-os com condição.

---

#### SELECT

```sql
SELECT campos da tabela
FROM table_name
WHERE condição;
```

###### BOAS PRÁTICAS: evite sempre que puder o SELECT *

---

#### TRUNCATE

```sql
TRUNCATE TABLE pedidos;
```

---
