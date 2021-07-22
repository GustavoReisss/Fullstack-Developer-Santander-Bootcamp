# Comandos e Exemplos em PostgreSQL

​																																		By: Gustavo Reis

# Funções Agregadas

- **AVG:**  Média.</br>
- **COUNT e COUNT (HAVING):**  Quantidade de algum dado.</br>
- **MAX:**  Valor Máximo.</br>
- **MIN:**  Valor Mínimo.</br>
- **SUM:**  Soma de todos os valores de alguma coluna.</br>

---

#### AVG

```sql
SELECT AVG (valor) FROM cliente_transacoes;
```

###### Retorna a media do valor da tabela cliente_transacoes.

---

#### COUNT e COUNT HAVING

```sql
SELECT COUNT (numero)
FROM cliente;
```

###### Retorna a quantidade de clientes da tabela cliente.

```sql
SELECT COUNT (numero), email
FROM cliente
WHERE email ILIKE '%gmail.com'
GROUP BY email;
```

###### Retorna a quantidade de email que terminam com gmail.com

```sql
SELECT COUNT (id), tipo_transacao_id
FROM cliente_transacoes
GROUP BY tipo_transacao_id
HAVING COUNT (id) > 150;
```

###### Retorna a quantidade de transações por tipo tipo de transação, e exclui transações menores que 150.

---

#### MAX

```sql
SELECT MAX (valor)
FROM cliente_transacoes;
```

###### Retorna o maior valor dentro da tabela cliente_transacoes.

```sql
SELECT MAX (valor), tipo_transacao_id -- (tipo_transacao_id == cartão, dinheiro, etc)
FROM cliente_transacoes
GROUP BY tipo_transacao_id;
```

###### Retorna o maior valor por tipo tipo de transação.

---

#### MIN

```sql
SELECT MIN (valor)
FROM cliente_transacoes;
```

###### Retorna o menor valor dentro da tabela cliente_transacoes.

```sql
SELECT MIN (valor), tipo_transacao_id -- (tipo_transacao_id == cartão, dinheiro, etc)
FROM cliente_transacoes
GROUP BY tipo_transacao_id;
```

###### Retorna o menor valor por tipo tipo de transação.

---

#### SUM

```sql
SELECT SUM (valor)
FROM cliente_transacoes;
```

###### Retorna a soma dos valores da tabela cliente_transacoes.

```sql
SELECT SUM (valor), tipo_transacoes_id
FROM cliente_transacoes
GROUP BY tipo_transacao_id
ORDER BY tipo_transacao_id;  -- Ou ORDER BY tipo_transacao_id DESC; -> decrescente
```

###### Retorna a soma dos valores por tipo de transação, além de ordenar por tipo de transação.

