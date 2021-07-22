# Comandos e Exemplos em PostgreSQL

​																																		By: Gustavo Reis

## Funções

Conjunto de códigos que são executados dentro de uma transação com a finalidade de facilitar a programação e obter o reaproveitamento / reutilização de códigos.

---

#### SINTAXE

```sql
CREATE [ OR REPLACE ] FUNCTION
    name ( [ [ argmode ] [ argname ] argtype [ { DEFAULT | = } default_expr ] [, ...] ] )
    [ RETURNS rettype
      | RETURNS TABLE ( column_name column_type [, ...] ) ]
  { LANGUAGE lang_name
    | WINDOW
    | IMMUTABLE | STABLE | VOLATILE
    | CALLED ON NULL INPUT | RETURNS NULL ON NULL INPUT | STRICT
    | [ EXTERNAL ] SECURITY INVOKER | [ EXTERNAL ] SECURITY DEFINER
    | COST execution_cost
    | ROWS result_rows
    | SET configuration_parameter { TO value | = value | FROM CURRENT }
    | AS 'definition'
    | AS 'obj_file', 'link_symbol'
  } ...
    [ WITH ( attribute [, ...] ) ]
```

### Alguns Parâmetros

**CREATE [ OR REPLACE ] FUNCTION:** O parâmetro *OR REPLACE* é utilizado para manter a idempotência recriando a função caso ela já exista, lembrando que este parâmetro só pode ser utilizado ao mantermos o mesmo nome, o mesmo tipo de retorno e o mesmo número de parâmetros / argumentos.

---

**RETURNS rettype:** Responsável por informar qual será o retorno após a finalização do código.

###### rettype: INTEGER, CHAR / VARCHAR, BOOLEAN, ROW, TABLE, JSON

---

**LANGUAGE lang_name:** Neste parâmetro informamos qual linguagem utilizaremos no código.

###### lang_name: SQL, PLPGSQL, PLJAVA, PLPY, ...

---

**SECURITY:** O parâmetro *SECURITY* é utilizado para informarmos com que permissões a função será executada.

**SECURITY INVOKER:** Permite que a função seja executada com as permissões do usuário que está executando a função.

###### Ex: Caso um usuário que não tenha permissão para fazer modificações no banco de dados tente executar uma função que execute um INSERT em alguma tabela,e esta função possua o parâmetro SECURITY INVOKER o usuário receberá um alerta de erro.

**SECURITY DEFINER:** Garante que a função seja executada com as permissões do usuário que criou a função.

###### Ex: Se um usuário com permissão de alterar tabelas crie uma função que execute INSERT em alguma tabela e escolha definir o parâmetro SECURITY como DEFINER, todos os usuários que tentem executar esta função conseguirão utilizar todas as instruções mesmo que não possuam a permissão para isso.

---

###### **Comportamento da função **
**(IMMUTABLE, STABLE E VOLATILLE):** Pode modificar o comportamento da função, podemos escolher se a função pode ou não fazer alterações no banco de dado.

**IMMUTABLE:** Não permite alteração no banco de dados (INSERT, UPDATE, DELETE), não são recomendados comandos dinâmicos como o SELECT, já que o conteúdo da tabela em que estaremos utilizando o SELECT pode alterar.

**STABLE:** O comportamento STABLE é bem parecido com o IMMUTABLE, possuindo semelhanças como não permitir alterações no banco de dado, mas diferente da IMMUTABLE este tipo de comportamento trabalha  com comandos dinâmicos como o SELECT.

**VOLATILLE:** Comportamento padrão. Aceita todos os cenários.

---

###### **SEGURANÇA E BOAS PRÁTICAS **
**(CALLED ON NULL INPUT e RETURNS NULL ON NULL INPUT):** Comportamento da função ao receber valores do tipo NULL.

**CALLED ON NULL INPUT:** Valor padrão, se qualquer argumento / parâmetro for NULL,  a função será executada.

**RETURNS NULL ON NULL INPUT:** se qualquer argumento / parâmetro for NUL, a função retornará NULL.

---

## SQL FUNCTIONS

- Não é possível utilizar TRANSAÇÕES
- O corpo da função fica entre os $$
- O retorno da função é feito utilizando um SELECT

###### EX 1:

```sql
CREATE OR REPLACE FUNCTION fc_somar (INTEGER, INTEGER)
RETURNS INTEGER
LANGUAGE SQL
AS $$
	SELECT $1 + $2; -- ($1: parametro 1 | $2: parametro 2)
$$;
```

Ou

```sql
CREATE OR REPLACE FUNCTION fc_somar (num1 INTEGER, num2 INTEGER)
RETURNS INTEGER
LANGUAGE SQL
AS $$
	SELECT num1 + num2;
$$;
```

###### Ex 2:

```sql
CREATE OR REPLACE FUNCTION fc_bancos_add(p_numero INTEGER, p_nome VARCHAR,p_ativo BOOLEAN)
RETURNS TABLE (numero INTEGER, nome VARCHAR)
RETURNS NULL ON NULL INPUT
LANGUAGE SQL
AS $$
	INSERT INTO banco (numero, nome, ativo)
	VALUES (p_numero, p_nome, p_ativo);
	
	SELECT numero, nome
	FROM banco
	WHERE numero = p_numero;
$$;
```

---

## PLPGSQL FUNCTIONS

- Possibilita a utilização de Transações
- O corpo da função fica entre os $$
- O retorno é feito através de RETURNs

###### EX:

```sql
CREATE OR REPLACE FUNCTION banco_add (p_numero INTEGER, p_nome VARCHAR, p_ativo BOOLEAN)
RETURNS BOOLEAN
LANGUAGE PLPGSQL
AS $$
DECLARE varialvel_id INTEGER;
BEGIN
	SELECT INTO variavel_id numero FROM banco WHERE nome = p_nome;
	
	IF variavel_id IS NULL THEN
		INSERT INTO banco (numero, nome, ativo) VALUES (p_numero, p_nome, p_ativo);
	ELSE
		RETURN FALSE;
	END IF;
	
	SELECT INTO variavel_id numero FROM banco WHERE nome = p_nome;
	IF variavel_id IS NULL THEN
		RETURN FALSE;
	ELSE
		RETURN TRUE;
	END IF;
END; $$;

SELECT banco_add (15, 'Banco Quinze', TRUE); -- INSERINDO 'Banco Quinze' na tabela 'banco'
```

---

