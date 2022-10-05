# Lp3

### Rodar o banco

``
docker container run --name lp3_db -e MYSQL_USER=root -e MYSQL_PASSWORD=toor -e MYSQL_DATABASE=lp3_db -e MYSQL_ROOT_PASSWORD=toor -p 3306:3306 -d mysql:8.0.20
``

#### Popular o banco

``
INSERT INTO $lp3_db.ingrediente
(nome)
VALUES('PERA'), ('BANANA'), ('CARNE'), ('SAL'), ('CEBOLA'), ('ALHO');``

``
INSERT INTO $lp3_db.receita
(categoria, modo_preparo, nome, num_notas, soma_notas)
VALUES('Arabe', 'Usar o tempero na carne', 'carne temperada', 2, 10), ('Japonesa', 'Pegar a cebola e picar pequena', 'cebola pequena', 1, 5);``

``
INSERT INTO $lp3_db.receita_ingrediente
(receita_id, ingrediente_id)
VALUES(1, 1);
``
