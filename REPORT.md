# Rapport du projet

## Informations générales

### Module
JEE & Middlewares

### Type
Contrôle

### Réalisé par
Abdelali Saadali  
Étudiant BDCC2

### Encadré par
Prof. Youssefi

---

# 1. Architecture technique

Le projet a été réalisé sous forme d’une application Full Stack basée sur Spring Boot et Angular.

L’architecture générale est organisée en plusieurs couches afin de séparer la logique métier, l’accès aux données et l’interface utilisateur.

Le frontend Angular communique avec le backend Spring Boot à travers des API REST utilisant HTTP et JSON.

Le backend contient :
- une couche REST Controller,
- une couche Service,
- une couche Repository avec Spring Data JPA,
- une couche Entity basée sur Hibernate/JPA.

Les données sont stockées dans une base H2 en développement.

---

# 2. Diagramme de classes et entités

Le système contient les entités principales suivantes :

## Customer
Représente les clients de l’application.

Attributs :
- id
- name
- email

---

## InsuranceContract

Classe abstraite représentant un contrat d’assurance.

Attributs :
- id
- subscriptionDate
- status
- validationDate
- contributionAmount
- duration
- coverageRate

L’héritage JPA SINGLE_TABLE a été utilisé.

---

## CarInsuranceContract

Hérite de InsuranceContract.

Attributs :
- vehicleRegistrationNumber
- vehicleBrand
- vehicleModel

---

## HomeInsuranceContract

Hérite de InsuranceContract.

Attributs :
- housingType
- housingAddress
- surface

---

## HealthInsuranceContract

Hérite de InsuranceContract.

Attributs :
- coverageLevel
- coveredPersons

---

## Payment

Représente les paiements liés aux contrats.

Attributs :
- id
- paymentDate
- amount
- paymentType
- description

---

# 3. Relations entre les entités

- Un client possède plusieurs contrats.
- Un contrat appartient à un seul client.
- Un contrat possède plusieurs paiements.
- Les contrats spécialisés héritent de InsuranceContract.

---

# 4. Couche Repository

La couche Repository permet l’accès aux données avec Spring Data JPA.

Les repositories réalisés :
- CustomerRepository
- InsuranceContractRepository
- PaymentRepository

Chaque repository hérite de JpaRepository.

Cette couche permet :
- l’ajout,
- la modification,
- la suppression,
- la recherche des données.

---

# 5. Couche Service

La couche Service contient la logique métier de l’application.

Services réalisés :
- InsuranceService
- DashboardService

Fonctionnalités principales :
- gestion des clients,
- gestion des contrats,
- validation des contrats,
- résiliation des contrats,
- gestion des paiements,
- statistiques du dashboard.

---

# 6. Couche Web REST

Les contrôleurs REST exposent les API consommées par Angular.

Contrôleurs réalisés :
- CustomerRestController
- InsuranceContractRestAPI
- DashboardRestController
- SecurityController

Les échanges utilisent le format JSON.

---

# 7. Sécurité

La sécurité a été réalisée avec Spring Security et JWT.

Le système d’authentification fonctionne de la manière suivante :
1. L’utilisateur s’authentifie via `/auth/login`
2. Le backend génère un token JWT
3. Le frontend stocke le token
4. Chaque requête protégée envoie le token dans l’en-tête Authorization

Les rôles utilisés :
- ROLE_ADMIN
- ROLE_EMPLOYE
- ROLE_CLIENT

---

# 8. Frontend Angular

Le frontend Angular contient plusieurs composants :

- login
- dashboard
- customers
- contracts
- new-customer
- new-contract
- contract-details
- navbar

Les services Angular utilisent HttpClient pour communiquer avec le backend REST.

L’application Angular utilise également :
- un interceptor JWT,
- un guard de sécurité,
- Angular Router,
- Bootstrap pour l’interface graphique.

---

# 9. Conclusion

Ce projet a permis de mettre en pratique les notions étudiées dans le module JEE & Middlewares, notamment :
- Spring Boot,
- Spring Data JPA,
- Hibernate,
- Spring Security,
- JWT,
- Angular,
- les API REST,
- ainsi que l’architecture en couches.

Le projet permet une gestion complète des contrats d’assurance avec une interface web moderne et sécurisée.