To init the project : `mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-simple -DgroupId=epf -DartifactId=rentmanager`
To run the project : `mvn tomcat7:run`


# Fonctionnalités : 

L'application Rent Manager permet de gérer les véhicules de votre établissement pour leur mise en location. 

## Accueil

* Consulter le nombre d'utilisateurs, de véhicules et de réservations

## Client

* Ajouter un client 
  * Tous les champs doivent être remplis (nom, prénom, email, date de naissance)
  * Nom et prénom doivent faire au minimum 3 charactères
  * Client doit avoir plus de 18 ans et moins de 90 ans
* Supprimer un client

## Véhicules 

*  Ajouter un véhicule / Supprimer un véhicule


## Réservations

* Ajouter une réservation
