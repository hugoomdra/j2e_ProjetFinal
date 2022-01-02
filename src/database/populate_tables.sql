INSERT INTO client (firstName, lastName, email, password, rue, ville, codepostal, pays)
VALUES ('Paul', 'Bistou', 'paul.bistou@reseau.eseo.fr', 'bistou', '5 rue des coquelicots', 'Floraville', '17139', 'France');


INSERT INTO article (name, price, quantity, picture, type)
VALUES ('Call Of Duty : Vandguard', 69.99, 5, 'cod_vandguard', 'XBOX ONE'),
       ('The Legend of Zelda', 59.99, 11, 'zelda', 'SWITCH'),
       ('Fifa 22', 49.99, 7, 'fifa_22', 'PS4'),
       ('Grand Theft Auto V', 50, 65, 'gta_5', 'PS4'),
       ('Mario Kart Deluxe 8', 80, 3, 'mario_kart', 'SWITCH'),
       ('Crash Team Racing', 45, 12, 'crash', 'PS4');

INSERT INTO commande (id, client_id, type)
VALUES (1, 1, 'done'),
       (2, 1, 'done'),
       (3, 1, 'done'),
       (4, 1, 'editing');

INSERT INTO commande_article (commande_id, article_id, qte)
VALUES (1, 1, 3),
       (1, 2, 2),
       (2, 3, 12),
       (3, 5, 1),
       (3, 4, 2),
       (3, 6, 3),
       (4, 3, 1);