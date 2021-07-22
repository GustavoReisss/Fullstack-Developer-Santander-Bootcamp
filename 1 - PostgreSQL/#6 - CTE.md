# Comandos e Exemplos em PostgreSQL

​																																		By: Gustavo Reis

## CTE - Common Table Expressions

**WITH STATEMENTS:** Forma auxiliar de organizar "statements", ou seja, blocos de códigos, para consultas muito grandes, gerando tabelas temporárias que facilitam a legibilidade e organização.

###### Podem haver SELECTs, INSERTs, UPDATEs ou DELETEs dentro dos statements.

---

#### Exemplos:

```sql
WITH tabela_temporaria_banco AS (
	SELECT numero, nome
	FROM banco
)
SELECT numero, nome
FROM tabela_temporaria_banco;
```

###### Neste exemplo a tabela "tabela_temporaria_banco" assume os campos "numero" e "nome" da tabela "banco", ficando disponível para receber consultas.

---

```sql
WITH clientes_e_transacoes AS (
	SELECT 	cliente.nome AS cliente_nome, 
			tipo_transacao.nome AS tipo_transacao_nome,
			cliente_transacoes.valor AS tipo_transacao_valor,
			banco.nome AS banco_nome
	FROM cliente_transacoes
	JOIN cliente ON cliente.numero = cliente_transacoes.cliente_numero  -- Selecionando as transações por cliente
	JOIN tipo_transacao ON tipo_transacao.id = cliente_transacoes.tipo_transacao_id -- Buscando o tipo de transação
	JOIN banco ON banco.numero = cliente_transacoes.banco_numero AND banco.nome ILIKE '%Itaú%' -- Selecionando bancos com Itaú
)
SELECT cliente_nome, tipo_transacao_nome, banco_nome, tipo_transacao_valor -- Retornando apenas as transações do banco Itaú
FROM clientes_e_transacoes;
```

###### Já neste exemplo o WITH já utiliza o conteúdo de outras tabelas, recebendo 4 tipos de dados, que vão sendo filtrados até sobrarem apenas os dados que atingem todos os requisitos feitos nos JOINs.

---

