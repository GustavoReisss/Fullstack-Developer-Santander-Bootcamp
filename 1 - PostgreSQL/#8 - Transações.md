# Comandos e Exemplos em PostgreSQL

​																																		By: Gustavo Reis

## Transações

**Transação:** Conceito fundamental de todos os sistemas de bancos de dados.
Conceito de múltiplas etapas/códigos reunidos em apenas 1 transação, onde o resultado precisa ser **tudo ou nada.**

---

#### BEGIN E COMMIT

Responsáveis por iniciar e finalizar uma transação, sendo o BEGIN o comando responsável por iniciar a transação e COMMIT por finalizar as alterações propostas;

```sql
BEGIN; -- INICIE
UPDATE banco SET ativo = TRUE WHERE numero = 0; -- ATUALIZE O ESTADO DE ATIVO DO BANCO DE NÚMERO 0 PARA TRUE
COMMIT; -- FINALIZE
```



---

#### SAVEPOINTS

Instrução que auxilia criando pontos de controle durante a execução do código, que podem ser utilizados para a transação não seja toda perdida por algum erro de execução.

```sql
BEGIN; -- INICIE
UPDATE cliente SET saldo = 1050.00 WHERE numero = 103; -- ATUALIZE O SALDO DO CLIENTE DE NUMERO 103 PARA 1050.00
SAVEPOINT saldo_atualizado; -- PONTO DE CONTROLE SALVO
COMMIT; -- FINALIZE
```



---

#### ROLLBACK

Comando que tem como função desfazer a transação para um estado anterior, podendo ou não ser utilizado junto com o SAVEPOINT.

```sql
BEGIN; -- INICIE
UPDATE cliente SET saldo = 1050.00 WHERE numero = 103; -- ATUALIZE O SALDO DO CLIENTE DE NUMERO 103 PARA 1050.00
SAVEPOINT saldo_atualizado; -- PONTO DE CONTROLE SALVO
UPDATE cliente SET saldo = 5000.00 WHERE numero = 103;  -- ATUALIZE O SALDO DO CLIENTE DE NUMERO 103 PARA 5000.00
SELECT saldo FROM cliente WHERE numero = 103; -- SELECIONAMOS O SALDO DO CLIENTE 103 E PERCEBEMOS QUE O SALDO ESTÁ INCORRETO
ROLLBACK TO saldo_atualizado; -- RETORNE AO SAVEPOINT saldo_atualizado
SELECT saldo FROM cliente WHERE numero = 103; -- VERIFICAMOS QUE O SALDO FOI RETORNADO AO PONTO ANTERIOR
COMMIT; -- FINALIZE	
```

---
