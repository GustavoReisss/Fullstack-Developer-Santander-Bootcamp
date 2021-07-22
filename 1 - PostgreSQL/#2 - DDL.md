# Comandos e Exemplos em PostgreSQL

​																																		By: Gustavo Reis

## DDL - Data Definition Language <br/>Linguagem de definação de dados

**<u>OBJETOS</u>:** São tabelas, views, funções, types, sequences, etc.</br>
**<u>SCHEMAS</u>:** Grupo de objetos.</br>
**<u>DATABASE</u>:** Grupo de Schemas e seus objetos.</br>

---

- **CREATE:** Cria. </br>
- **ALTER:** Altera. </br>
- **DROP:** Remove.</br>

-----------------------------------------------------------------

######    OBS: Usar o "IF NOT EXISTS" e "IF EXIST" para evitar erros! 

```sql
CREATE DATABASE IF NOT EXISTS database_name;
```

```sql
DROP SCHEMA IF EXISTS schema_name;
```

---

#### DATABASE

```sql
CREATE DATABASE IF NOT EXISTS database_name;

ALTER DATABASE database_name [opções];

DROP DATABASE IF EXISTS database_name;
```

###### Ex:

```sql
CREATE DATABASE IF NOT EXISTS financas;
```

---

#### SCHEMA

```sql
CREATE SCHEMA IF NOT EXISTS schema_name;

ALTER SCHEMA schema_name [opções];

DROP SCHEMA IF EXISTS schema_name;
```

###### Ex:

```sql
CREATE SCHEMA IF NOT EXISTS plataforma_b;
```

---

#### TABLE

```sql
CREATE TABLE IF NOT EXISTS table_name (
    [nome_do_campo] [tipo] [regras] [opções],
    [nome_do_campo] [tipo] [regras] [opções],
    [nome_do_campo] [tipo] [regras] [opções]
);

ALTER TABLE table_name [opções];

DROP TABLE IF EXISTS table_name;
```

###### Ex:

```sql
CREATE TABLE IF NOT EXISTS cargo (
	codCargo VARCHAR(2) NOT NULL,
	nomeCargo VARCHAR(40) NOT NULL,
	valorCargo REAL NOT NULL,
	PRIMARY KEY(codCargo)
);
```

```sql
CREATE TABLE IF NOT EXISTS agencia (
	banco_numero INTEGER NOT NULL,
	numero INTEGER NOT NULL,
	nome VARCHAR(80) NOT NULL,
	ativo BOOLEAN NOT NULL DEFAULT TRUE,
	data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (banco_numero,numero),
	FOREIGN KEY (banco_numero) REFERENCES banco (numero)
);
```

---

