To init the project : `mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-simple -DgroupId=epf -DartifactId=rentmanager`
To run the project : `mvn tomcat7:run`


# Fonctionnalités : 

L'application Rent Manager permet de gérer les véhicules de votre établissement pour leur mise en location. 
Voici la liste des fonctionnalités proposées par l'application.

## Accueil

* Consulter le nombre d'utilisateurs, de véhicules et de réservations

## Client

* Ajouter un client 
  * Tous les champs doivent être remplis (nom, prénom, email, date de naissance)
  * Nom et prénom doivent faire au minimum 3 charactères
  * Client doit avoir plus de 18 ans et moins de 90 ans
* Modifier les informations d'un client
  * Les informations actuelles sont récupérées puis peuvent être modifiées
* Consulter les détails d'un client : toutes les réservations qui ont été faites par ce dernier
* Supprimer un client
  * on supprime alors la/les réservations associées à ce client

## Véhicules 

* Ajouter un véhicule
  * Tous les champs doivent être remplis
  * Un véhicule peut avoir 2 places au minimum et 9 places au maximum
* Supprimer un véhicule
  * on supprime alors la/les réservations associées à ce véhicule


## Réservations

* Ajouter une réservation
  * Tous les champs sont requis
* Supprimer une réservation
