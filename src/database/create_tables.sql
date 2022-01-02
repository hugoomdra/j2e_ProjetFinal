DROP TABLE commande_article;
DROP TABLE commande;
DROP TABLE article;
DROP TABLE client;

CREATE OR REPLACE TABLE client (
                                   id INT(13) NOT NULL AUTO_INCREMENT,
                                   firstName VARCHAR(40),
                                   lastName VARCHAR(40),
                                   email VARCHAR(320) UNIQUE,
                                   password VARCHAR(255),
                                   rue VARCHAR(255),
                                   ville VARCHAR(255),
                                   codepostal VARCHAR(255),
                                   pays VARCHAR(255),
                                   enable boolean default (false),
                                   PRIMARY KEY(id)
);


CREATE OR REPLACE TABLE article (
                                    id INT(13) NOT NULL AUTO_INCREMENT,
                                    name VARCHAR(100),
                                    price DECIMAL(10, 2),
                                    quantity INT(10),
                                    picture VARCHAR(255),
                                    type ENUM('PS4', 'SWITCH', 'XBOX ONE'),
                                    PRIMARY KEY(id)
);

CREATE OR REPLACE TABLE commande (
                                     id INT(13) NOT NULL AUTO_INCREMENT,
                                     client_id INT(13) NOT NULL,
                                     type ENUM('editing', 'done'),
                                     PRIMARY KEY(id),
                                     FOREIGN KEY (client_id) references client(id) on DELETE CASCADE
);

CREATE OR REPLACE TABLE commande_article (
                                     id INT(13) NOT NULL AUTO_INCREMENT,
                                     commande_id INT(13) NOT NULL,
                                     article_id INT(13) NOT NULL,
                                     qte INT(13) NOT NULL,
                                     PRIMARY KEY(id),

                                     FOREIGN KEY (commande_id) references commande(id) on DELETE CASCADE,
                                     FOREIGN KEY (article_id) references article(id) on DELETE CASCADE
);