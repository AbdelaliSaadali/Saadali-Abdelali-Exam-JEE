# Insurance Management Application

## Contrôle JEE & Middlewares

### Réalisé par
**Abdelali Saadali**  
Étudiant BDCC2

### Encadré par
**Prof. Mohamed YOUSSFI**

---

# Présentation du projet

Ce projet consiste à réaliser une application de gestion des contrats d'assurance en utilisant les technologies JEE modernes étudiées dans le module **JEE & Middlewares**.

L'objectif principal est de développer une application Full Stack permettant :
- la gestion des clients,
- la gestion des contrats d'assurance,
- la gestion des paiements,
- la sécurisation de l'application avec JWT,
- ainsi qu'une communication REST entre le backend Spring Boot et le frontend Angular.

Le projet a été développé en suivant une architecture en couches similaire aux exemples réalisés en cours.

---

# Technologies utilisées

## Backend
- Spring Boot
- Spring Data JPA
- Hibernate
- Spring Security
- JWT Authentication
- Lombok
- Maven
- H2 Database / MySQL
- REST API

## Frontend
- Angular
- TypeScript
- Bootstrap
- Angular Router
- HttpClient

---

# Architecture technique

L'application suit une architecture en couches :

## Frontend Angular
Le frontend Angular permet :
- l'authentification,
- la gestion des clients,
- la gestion des contrats,
- la gestion des paiements,
- l'affichage du dashboard.

Le frontend communique avec le backend via HTTP/JSON.

---

## Backend Spring Boot

Le backend est organisé en plusieurs couches :

### Couche REST Controller
Expose les API REST :
- CustomerRestController
- InsuranceContractRestAPI
- DashboardRestController
- SecurityController

### Couche Service
Contient la logique métier :
- InsuranceService
- DashboardService

### Couche Repository
Permet l'accès aux données avec Spring Data JPA :
- CustomerRepository
- InsuranceContractRepository
- PaymentRepository

### Couche Entity
Représente les entités persistantes :
- Customer
- InsuranceContract
- CarInsuranceContract
- HomeInsuranceContract
- HealthInsuranceContract
- Payment

---

# Fonctionnalités réalisées

## Gestion des clients
- Ajouter un client
- Modifier un client
- Supprimer un client
- Rechercher un client
- Afficher la liste des clients

## Gestion des contrats
- Ajouter un contrat automobile
- Ajouter un contrat habitation
- Ajouter un contrat santé
- Valider un contrat
- Résilier un contrat
- Supprimer un contrat

## Gestion des paiements
- Ajouter un paiement
- Consulter l'historique des paiements

## Dashboard
- Nombre total des clients
- Nombre total des contrats
- Nombre total des paiements
- Montant total des paiements

## Sécurité
- Authentification JWT
- Gestion des rôles :
  - ROLE_ADMIN
  - ROLE_EMPLOYE
  - ROLE_CLIENT

---

# Structure du projet

## Backend

```text
insurance-backend/
Packages principaux
entities

dtos

repositories

services

web

security

enums

mappers

Frontend

insurance-frontend/
Dossiers principaux
services

login

dashboard

customers

contracts

payments

interceptors

guards
```

## Base de données
Le projet utilise H2 Database en mode développement.

Les relations principales :

Un client possède plusieurs contrats.

Un contrat possède plusieurs paiements.

Les contrats utilisent l'héritage JPA SINGLE_TABLE.

## Sécurité JWT
L'application utilise Spring Security avec JWT.

Après authentification :

un token JWT est généré,

le frontend stocke le token,

chaque requête sécurisée envoie :

```
Authorization: Bearer token
```

## Comptes de test
Username	Password	Role
admin	1234	ROLE_ADMIN
employe	1234	ROLE_EMPLOYE
client	1234	ROLE_CLIENT

## Lancement du backend
```bash
cd insurance-backend
mvn spring-boot:run
```

Backend :

```
http://localhost:8085
```

## Lancement du frontend
```bash
cd insurance-frontend
npm install
npm start
```

Frontend :

```
http://localhost:4200
```

# Conclusion
Ce projet m'a permis de mettre en pratique les concepts étudiés dans le module JEE & Middlewares, notamment :

Spring Boot,

Spring Data JPA,

Hibernate,

Spring Security,

JWT,

Angular,

les API REST,

ainsi que l'architecture en couches.

Il m'a également permis de comprendre l'intégration entre un backend JEE et une application frontend Angular moderne.