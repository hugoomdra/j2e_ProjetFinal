CREATE OR REPLACE TABLE client (
                        id INT(13) NOT NULL AUTO_INCREMENT,
                        firstName VARCHAR(40),
                        lastName VARCHAR(40),
                        email VARCHAR(320),
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