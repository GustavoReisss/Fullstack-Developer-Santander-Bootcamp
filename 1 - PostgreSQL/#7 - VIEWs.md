# Comandos e Exemplos em PostgreSQL

​																																		By: Gustavo Reis

## VIEWs

**VIEWs:** São objetos considerados pseudo-tabelas que recebem o conteúdo pertencente a tabelas reais do banco de dados. Podem utilizar por padrão a instrução *SELECT,* podendo também receber instruções como *INSERT*, *UPDATE* e *DELETE* quando associadas a apenas uma tabela.

---

#### SINTAXE

```sql
CREATE [OR REPLACE] [TEMP | TEMPORARY] [RECURSIVE] VIEW view_name [ (column_name, ... )]
[ WITH ( view_option_name [= view_option_value] [, ...] ) ]
AS query
[ WITH [CASCADE | LOCAL] CHECK OPTIONS]
```

---

**CREATE [OR REPLACE] :** Utilizado para criar uma VIEW ou recriar uma VIEW já existente caso já exista uma VIEW com o nome informado.

```sql
CREATE OR REPLACE VIEW vw_bancos AS (
	SELECT numero, nome
	FROM banco
);

SELECT numero, nome
FROM vw_bancos;
```

###### Neste caso a VIEW criada irá assumir os campos numero e nome de uma tabela real chamada "banco"

___

**CREATE [OR REPLACE] VIEW view_name [  ( column_name, ... ) ] :** Parâmetro utilizado para criar campos com nomes alternativos dentro da VIEW.

```sql
CREATE OR REPLACE VIEW vw_bancos (banco_numero, banco_nome) AS (
	SELECT numero, nome
	FROM banco
);

SELECT banco_numero, banco_nome
FROM vw_bancos;
```

###### Neste exemplo a VIEW "vw_bancos" também está recebendo os dados da tabela real "banco", porém os nomes utilizados para referenciar os campos serão diferentes.

---

**[ TEMP | TEMPORARY ] :** Instrução que tem como função criar uma VIEW que só estará disponível dentro da sessão do usuário, ficando indisponível para outros utilizadores do banco de dados, além de se ser utilizável somente enquanto a sessão não é finalizada.

```sql
CREATE OR REPLACE TEMPORARY VIEW vw_bancos AS (
	SELECT numero, nome
	FROM banco
);

SELECT numero, nome
FROM vw_bancos;
```

###### A VIEW criada será utilizável como qualquer outra VIEW, porém será finalizada assim que o usuário fechar a sessão que está trabalhando.

---

**[ RECURSIVE ] :** Parâmetro necessário para criar VIEWs recursivas, ou seja, VIEWs que trabalham dentro delas mesmas, havendo um comando dentro das instruções da VIEW que efetue uma chamada para ela mesma.

```sql
CREATE OR REPLACE RECURSIVE VIEW view_name (campos_da_view) AS (
	SELECT base
	UNION ALL
	SELECT campos
	FROM tabela_base
	JOIN(view_name) 
);
```

##### Vale ressaltar que (campos_da_view) e UNION ALL são instruções obrigatórias na criação de VIEWs recursivas.

---

**WITH OPTIONS [ LOCAL | CASCADED ] :** Utilizado para garantir que as verificações acontecerão dentro da VIEW, permitindo ou não que dados sejam modificados por meio de INSERTS e UPDATES.

---

**WITH LOCAL CHECK OPTION :** Utilizado para validar as opções da VIEW onde o parâmetro foi inserido.



***SEM O LOCAL CHECK OPTION***

```sql
CREATE OR REPLACE VIEW vw_bancos AS (
	SELECT numero, nome, ativo
	FROM banco
	WHERE ativo IS TRUE
);

INSERT INTO vw_bancos(numero, nome, ativo) VALUES (100,'Banco CEM', FALSE);  -- OK
```

###### Ao utilizar o comando sem o LOCAL CHECK OPTION a VIEW irá aceitar que dados sejam inseridos mesmo que não atendam as condições impostas, lembrando que ao tentarmos procurar o "Banco CEM" inserido dentro da VIEW "vw_bancos" utilizando um SELECT nada será retornado, pois só serão retornados dados onde "ativo" possui TRUE, mesmo assim o banco foi inserido. 



***COM O LOCAL CHECK OPTION***

```sql
CREATE OR REPLACE VIEW vw_bancos AS (
	SELECT numero, nome, ativo
	FROM banco
	WHERE ativo IS TRUE
) WITH LOCAL CHECK OPTION;

INSERT INTO vw_bancos(numero, nome, ativo) VALUES (100,'Banco CEM', FALSE);  -- ERRO
```

###### Neste caso o INSERT recebeu um erro pois não conseguiu validar todos os campos inseridos, pois a VIEW de destino possui uma condição que não foi atendida.

---

**WITH CASCADED CHECK OPTION :** Utilizado para verificar tanto as opções da VIEW onde o parâmetro está sendo utilizando, quanto nas VIEWs que estão sendo referenciadas dentro das instruções da VIEW utilizada.



***SEM O CASCADED***

```sql
CREATE OR REPLACE VIEW vw_bancos_ativos AS (
	SELECT numero, nome, ativo
	FROM banco
	WHERE ativo IS TRUE
);

CREATE OR REPLACE VIEW vw_bancos_maiores_que_100 AS (
	SELECT numero, nome, ativo
	FROM vw_bancos_ativos
	WHERE numero > 100
) WITH LOCAL CHECK OPTION;

INSERT INTO vw_bancos_maiores_que_100 (numero, nome, ativo) VALUES (99, 'Banco 99', FALSE);  -- ERRO 
INSERT INTO vw_bancos_maiores_que_100 (numero, nome, ativo) VALUES (200, 'Banco 200', FALSE);  -- OK
```

###### O segundo INSERT foi aceito, pois apenas a verificação da segunda VIEW foi feita.



***COM O CASCADED***

```sql
CREATE OR REPLACE VIEW vw_bancos_ativos AS (
	SELECT numero, nome, ativo
	FROM banco
	WHERE ativo IS TRUE
);

CREATE OR REPLACE VIEW vw_bancos_maiores_que_100 AS (
	SELECT numero, nome, ativo
	FROM vw_bancos_ativos
	WHERE numero > 100
) WITH CASCADED CHECK OPTION;

INSERT INTO vw_bancos_maiores_que_100 (numero, nome, ativo) VALUES (99, 'Banco 99', FALSE);  -- ERRO 
INSERT INTO vw_bancos_maiores_que_100 (numero, nome, ativo) VALUES (200, 'Banco 200', FALSE);  -- ERRO
```

###### Já ao utilizar a opção CASCADED como parâmetro de verificação ambas as VIEWs foram verificadas, garantindo que não passassem nenhum banco "desativado" com numero inferior a 100.

