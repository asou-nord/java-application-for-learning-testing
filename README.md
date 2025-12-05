# Gestion de Produit - Projet Java Spring Boot

Ce dépôt GitHub contient le code source du projet "Gestion de Produit" réalisé avec Java Spring Boot. Ce projet a pour objectif de fournir une application de gestion de produits avec les opérations CRUD (Create, Read, Update, Delete). L'application utilise une base de données MySQL pour stocker les informations des produits et des utilisateurs.
Des mises à jour afin d'amméliorer le projet se feront.
## Instructions:

1- Cloning the project.

2- start the docker container for mysql:
docker run -d --name mysql-container-tp6 \
-p 3306:3306 \
-e MYSQL_USER=Charbel \
-e MYSQL_DATABASE=tp \
-e MYSQL_PASSWORD=Charbel \
-e MYSQL_ROOT_PASSWORD=root mysql:8.0

Note: Make sure that the port 3306 is free.