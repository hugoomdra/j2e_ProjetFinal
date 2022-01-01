# Projet Final J2E

Dans le cadre du semestre 9, nous devons réaliser un projet web en Java.

Voici le cahier des charges : [Cliquez ici](readme/cahier_des_charges.pdf)

Pour faciliter la mise en place du travail et la qualité du rendu, nous avons utilisé un template front que nous avons modifié. 
## Installations

### Création de la base de données en local

- Création d'un conteneur docker pour MariaDB
```
docker run --detach --name mariadb_projet_final --env MARIADB_USER=user --env MARIADB_PASSWORD=pass --env MARIADB_ROOT_PASSWORD=password -p 3306:3306 mariadb:latest
```

- On rentre dans le conteneur MariaDB pour pouvoir créer la base de données
```
docker exec -it mariadb_projet_final bash
mariadb -p
```
*Le mot de passe est ***password****


- Création de la base de données
```sql
CREATE DATABASE projet_final DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
```

