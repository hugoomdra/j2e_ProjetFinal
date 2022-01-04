INSERT INTO client (firstName, lastName, email, password, rue, ville, codepostal, pays, isAdmin)
VALUES ('Paul', 'Bistou', 'paul.bistou@reseau.eseo.fr', 'bistou', '5 rue des coquelicots', 'Floraville', '17139', 'France', false),
       ('Hugo', 'Madureira', 'hugoomdra@gmail.com', 'hmadureira', '5 rue des coquelicots', 'Floraville', '17139', 'France', true),
       ('Antoine', 'Vallet', 'antoinevallet@gmail.com', 'avallet', '5 rue des coquelicots', 'Floraville', '17139', 'France', true);


INSERT INTO article (name, description, price, quantity, picture, type)
VALUES ('Call Of Duty : Vandguard', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum massa neque, tristique et varius ac, vehicula in magna. Maecenas luctus eget metus at interdum. Mauris et viverra odio.', 69.99, 5, 'https://i.imgur.com/xh3QBkH.png', 'XBOX ONE'),
       ('The Legend of Zelda', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum massa neque, tristique et varius ac, vehicula in magna. Maecenas luctus eget metus at interdum. Mauris et viverra odio.', 59.99, 11, 'https://i.imgur.com/jXG1yYS.png', 'SWITCH'),
       ('Fifa 22', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum massa neque, tristique et varius ac, vehicula in magna. Maecenas luctus eget metus at interdum. Mauris et viverra odio.', 49.99, 7, 'https://i.imgur.com/NQ0Axst.png', 'PS4'),
       ('Grand Theft Auto V', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum massa neque, tristique et varius ac, vehicula in magna. Maecenas luctus eget metus at interdum. Mauris et viverra odio.', 50, 65, 'https://i.imgur.com/qqN9APc.png', 'PS4'),
       ('Mario Kart Deluxe 8', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum massa neque, tristique et varius ac, vehicula in magna. Maecenas luctus eget metus at interdum. Mauris et viverra odio.', 80, 3, 'https://i.imgur.com/jDXZMrl.png', 'SWITCH'),
       ('Crash Team Racing', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum massa neque, tristique et varius ac, vehicula in magna. Maecenas luctus eget metus at interdum. Mauris et viverra odio.', 45, 12, 'https://i.imgur.com/CHfFaS4.png', 'PS4');

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