# Comandos e Exemplos em PostgreSQL

​																																		By: Gustavo Reis

## Criando e Administrando Usuários

- **CREATE ROLE:** Comando para criar uma role. </br>
- **IN ROLE:** Passa a pertencer a role informada. </br>
- **ROLE:** A role informada passa a pertencer a nova role. </br>
- **GRANT:** Serve para trocar a role de uma de uma role já criada. </br>
- **REVOKE:** Desassocia um membro de uma role. </br>
- **ALTER ROLE:** Altera as opções de uma role.</br>
- **DROP ROLE:** Exclui uma role.</br>

---

####  CREATE ROLE 

```sql
CREATE ROLE professores
 NOCREATEDB
 NOCREATEROLE
 INHERIT
 NOLOGIN
 NOBYPASSRLS
 CONNECTION LIMIT -1;
```

---

#### IN ROLE

```sql
CREATE ROLE daniel LOGIN CONNECTION LIMIT 1 PASSWORD '123' IN ROLE professores;
```

###### A role daniel passa a assumir as permissões da role professores.

---

#### ROLE

```sql
CREATE ROLE daniel LOGIN CONNECTION LIMIT 1 PASSWORD '123' ROLE professores;
```

###### A role professores passa a fazer parte da role daniel assumindo suas permissões.

---

#### GRANT

```sql
CREATE ROLE daniel LOGIN CONNECTION LIMIT 1 PASSWORD '123';
GRANT professores TO daniel;
```

###### Daniel passa a fazer parte de professores.

---

#### REVOKE

```sql
REVOKE professores FROM daniel;
```

###### Daniel deixa de fazer parte do quadro de professores.

---

#### ALTER ROLE

```sql
ALTER ROLE daniel PASSWORD `1324`;
```

###### Daniel recebeu uma alteração.

---

#### DROP ROLE

```sql
DROP ROLE daniel;
```

###### Daniel foi retirado do banco de dados.

---
