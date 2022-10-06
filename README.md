# Lp3

### Rodar o banco

``
docker container run --name lp3_db -e MYSQL_USER=root -e MYSQL_PASSWORD=toor -e MYSQL_DATABASE=lp3_db -e MYSQL_ROOT_PASSWORD=toor -p 3306:3306 -d mysql:8.0.20
``

#### Popular o banco

``
INSERT INTO $lp3_db.ingrediente
(nome)
VALUES('PERA'), ('BANANA'), ('CARNE'), ('SAL'), ('CEBOLA'), ('ALHO');

INSERT INTO $lp3_db.receita
(categoria, modo_preparo, nome, num_notas, soma_notas)
VALUES('Arabe', 'Usar o tempero na carne', 'carne temperada', 2, 10), ('Japonesa', 'Pegar a cebola e picar pequena', 'cebola pequena', 1, 5), ('Arabe', 'coloque a pimenta na comida para temparar', 'Comida apimentada', 3, 9);


INSERT INTO $lp3_db.receita_ingrediente
(receita_id, ingrediente_id)
VALUES(1, 1);

INSERT INTO $lp3_db.receita_ingrediente
(receita_id, ingrediente_id)
VALUES(1, 2);


INSERT INTO $lp3_db.receita_ingrediente
(receita_id, ingrediente_id)
VALUES(2, 3);

INSERT INTO $lp3_db.receita_ingrediente
(receita_id, ingrediente_id)
VALUES(2, 5);

INSERT INTO $lp3_db.receita_ingrediente
(receita_id, ingrediente_id)
VALUES(3, 1);

INSERT INTO $lp3_db.receita_ingrediente
(receita_id, ingrediente_id)
VALUES(3, 3);

``
INSERT INTO $lp3_db.receita
(categoria, modo_preparo, nome, num_notas, soma_notas)
VALUES('Arabe', 'Usar o tempero na carne', 'carne temperada', 2, 10), ('Japonesa', 'Pegar a cebola e picar pequena', 'cebola pequena', 1, 5);``

``
INSERT INTO $lp3_db.receita_ingrediente
(receita_id, ingrediente_id)
VALUES(1, 1);
``


select distinct * from receita r inner join receita_ingrediente ri on r.id = ri.receita_id  where ri.ingrediente_id  in (select DISTINCT i.id from ingrediente i where i.id in (1,2)
