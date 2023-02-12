# **<u>Gestion-Absense-Java-JEE-Microservices-projet</u>"**

#### *Application basée sur une architecture micro-service qui permet de gérer les absences dans une école.*

![projet-abs.png](Capture%2Ffront%2Fprojet-abs.png)
---
### Cahier de charge
### Objectif du projet
Créer une application web JEE **" GESTION D'ABSENCE "** avec un rendu HTML coté client qui permet de :
* Gérer les professeurs (ajout / supression / détail)
* Gérer les etudiants (ajout / supression / détail)
* Gérer les cours (ajout / supression / détail)
* Gérer les absences des etudiants (ajout / supression / détail)
* sécuriser à l'aide de kaycloak 

### Architecture du projet
Le développement de cette application est basée sur deux parties avec l'utilisation d'une architecture microservice:
* Framework : **"SPRING"** coté **Backend**
* Framework : **"Angular"** coté **Frontend**

<img alt="architecture microservice.png" src="./Capture/back/architecture%20microservice.png"/>

### Structure du projet
#### Backend
Dans l'ensemble **des microservices** qu'on va créer dans ce projet, on va utiliser la version **2.7.8 de Spring Boot** et la version **17 de Java**.

* pour les micro services **students** et **professors** ajouter les dependense suivantes
    * Lombok
    * Spring web
    * Rest repository
    * H2 database
    * Spring Boot Actuator
    * Spring DATA Jpa
    * Eureka Discovery Client
* pour les micro services **absence** et **cours** ajouter les dependense suivantes
    * Lombok
    * Spring web
    * Rest repository
    * H2 database
    * Spring Boot Actuator
    * Spring DATA Jpa
    * Eureka Discovery Client
    * Open Fein
    * Spring Hateoas
* pour le micro service **Gateway** ajouter les dependense suivantes
    * Spring boot actuator
    * Eureka discovery client
    * Gateway
* pour le micro service **Discovery** ajouter les dependense suivantes
    * Eureka server

<img alt="struct projet2.PNG" src="./Capture/back/struct%20projet2.PNG"/>

### La structure du **service professeur**

![struct prof.PNG](Capture%2Fback%2Fstruct%20prof.PNG)

Pour la creation des entities 
* class professor

![class prof.PNG](Capture%2Fback%2Fclass%20prof.PNG)

Pour la creation des repositories
* interface professor

![repo prof.PNG](Capture%2Fback%2Frepo%20prof.PNG)

Pour la creation des controllers
* class ProfessorController

<img alt="controller prof.PNG" src="./Capture/back/controller%20prof.PNG"/>

* ProfessorServiceApplication

<img alt="profServiceApp.PNG" src="./Capture/back/profServiceApp.PNG"/>

* application properties

<img alt="app-prop-prof.PNG" src="./Capture/back/app-prop-prof.PNG"/>

### La structure du **service students**

![struct student.PNG](Capture%2Fback%2Fstruct%20student.PNG)

Pour la creation des entities
* class students

![Class student.PNG](Capture%2Fback%2FClass%20student.PNG)

* class classroom

![class classroom.PNG](Capture%2Fback%2Fclass%20classroom.PNG)

Pour la creation des DTOs

* class studentsDto

![StudentDto.PNG](Capture%2Fback%2FStudentDto.PNG)

* class classroomDto 

![ClassroomsDto.PNG](Capture%2Fback%2FClassroomsDto.PNG)

Pour la creation des enums
* enum Gender

![enum Gender.PNG](Capture%2Fback%2Fenum%20Gender.PNG)

Pour la creation des mappers
* class StudentsMappers

![StudentsMappers.PNG](Capture%2Fback%2FStudentsMappers.PNG)

Pour la creation des repositories

* interface StudentRepository

![StudentRepository.PNG](Capture%2Fback%2FStudentRepository.PNG)

Pour la creation des controllers

* class StudentController

![StudentsController.PNG](Capture%2Fback%2FStudentsController.PNG)

![StudentsController2.PNG](Capture%2Fback%2FStudentsController2.PNG)

![StudentsController3.PNG](Capture%2Fback%2FStudentsController3.PNG)

StudentServiceApplication

![StudentServiceApplication.PNG](Capture%2Fback%2FStudentServiceApplication.PNG)

application properties

![app-prop-student.PNG](Capture%2Fback%2Fapp-prop-student.PNG)

### La structure du **service cours**

![struct cours.PNG](Capture%2Fback%2Fstruct%20cours.PNG)

Pour la creation des entities
* class Cours

![class Cours.PNG](Capture%2Fback%2Fclass%20Cours.PNG)

* class Session

![class Session.PNG](Capture%2Fback%2Fclass%20Session.PNG)

  pour la creation des models

* class classroom

![models classroom.PNG](Capture%2Fback%2Fmodels%20classroom.PNG)

* class professor

![models professor.PNG](Capture%2Fback%2Fmodels%20professor.PNG)

  pour la creation des repositories

* interface CoursRepository

![CoursRepository.PNG](Capture%2Fback%2FCoursRepository.PNG)

* interface SessionRepository

![SessionRepository.PNG](Capture%2Fback%2FSessionRepository.PNG)

  Pour la creation des services
* interface ClassroomRestService

![ClassroomRestService.PNG](Capture%2Fback%2FClassroomRestService.PNG)

* interface ProfessorRestService

![ProfessorRestService.PNG](Capture%2Fback%2FProfessorRestService.PNG)
  
* pour la creation des services

* interface ClassroomRestService

![ClassroomRestService.PNG](Capture%2Fback%2FClassroomRestService.PNG)
  
* interface ProfessorRestService


![ProfessorRestService.PNG](Capture%2Fback%2FProfessorRestService.PNG)


Pour la creation des controllers

* class CoursRestController

![CoursRestController.PNG](Capture%2Fback%2FCoursRestController.PNG)


![CoursRestController2.PNG](Capture%2Fback%2FCoursRestController2.PNG)

CoursServiceApplication

![CoursServiceApplication.PNG](Capture%2Fback%2FCoursServiceApplication.PNG)

 application properties

![app-prop-cours.PNG](Capture%2Fback%2Fapp-prop-cours.PNG)



### La structure du **service Absence**

![struct abs.PNG](Capture%2Fback%2Fstruct%20abs.PNG)

pour la creation des entities

* class Absence

![class Absense.PNG](Capture%2Fback%2Fclass%20Absense.PNG)


pour la creation des models

* class classroom

![models classroom abs.PNG](Capture%2Fback%2Fmodels%20classroom%20abs.PNG)

* class cours

![models cours abs.PNG](Capture%2Fback%2Fmodels%20cours%20abs.PNG)


* class professor

![models prof abs.PNG](Capture%2Fback%2Fmodels%20prof%20abs.PNG)


* class Student

![models student abs.PNG](Capture%2Fback%2Fmodels%20student%20abs.PNG)

Pour la creation des repositories
* interface AbsenceRepository

![AbsenseRepository.PNG](Capture%2Fback%2FAbsenseRepository.PNG)


Pour la creation des Services
* interface CoursRestService

![CoursRestService.PNG](Capture%2Fback%2FCoursRestService.PNG)


* interface ProfessorRestService

![ProfessorRestService abs.PNG](Capture%2Fback%2FProfessorRestService%20abs.PNG)

* interface StudentRestService

![StudentRestService abs.PNG](Capture%2Fback%2FStudentRestService%20abs.PNG)



Pour la creation des Controller

* class AbsenceController

![AbsenseController.PNG](Capture%2Fback%2FAbsenseController.PNG)


![AbsenseController2.PNG](Capture%2Fback%2FAbsenseController2.PNG)


![AbsenseController3.PNG](Capture%2Fback%2FAbsenseController3.PNG)


  AbsenceServiceApplication

![AbsenceServiceApplication.PNG](Capture%2Fback%2FAbsenceServiceApplication.PNG)


application properties

![app-prop-abs.PNG](Capture%2Fback%2Fapp-prop-abs.PNG)




### La structure du **service Gateway**

![struct Gateway.PNG](Capture%2Fback%2Fstruct%20Gateway.PNG)


GatewayServiceApplication

![GatewayServiceApplication.PNG](Capture%2Fback%2FGatewayServiceApplication.PNG)


application yml

![app-yml-gate.PNG](Capture%2Fback%2Fapp-yml-gate.PNG)

La structure du **service Discovery**

![struct discovery.PNG](Capture%2Fback%2Fstruct%20discovery.PNG)


DiscoveryServiceApplication

![DiscoveryServiceApplication.PNG](Capture%2Fback%2FDiscoveryServiceApplication.PNG)

application properties

![app-prop-discovery.PNG](Capture%2Fback%2Fapp-prop-discovery.PNG)


### Pour la partie sécurité nous avons utilisé keycloak

![keycloak5.jpeg](Capture%2Fback%2Fkeycloak5.jpeg)

![keycloak7.jpeg](Capture%2Fback%2Fkeycloak7.jpeg)

![keycloak6.jpeg](Capture%2Fback%2Fkeycloak6.jpeg)

![keycloak8.jpeg](Capture%2Fback%2Fkeycloak8.jpeg)

![keycloak.jpeg](Capture%2Fback%2Fkeycloak.jpeg)

![keycloak2.jpeg](Capture%2Fback%2Fkeycloak2.jpeg)

![keycloak3.jpeg](Capture%2Fback%2Fkeycloak3.jpeg)

![keycloak4.jpeg](Capture%2Fback%2Fkeycloak4.jpeg)


#### Frontend
éxécuter la commande pour creer le projet frontend
```shell
ng new  Absense-Management-Portal
```
Installer bootstrap
```shell
npm install bootstrap --save
npm install bootstrap-icons --save  
``` 

![struct projet3.PNG](Capture%2Fback%2Fstruct%20projet3.PNG)


Creer l'ensemble des components
```shell
ng g c le nom du component
``` 
Creer l'ensemble des services
```shell
ng g s le nom du service
``` 

![struct front.PNG](Capture%2Ffront%2Fstruct%20front.PNG)
![struct front.PNG](Capture%2Ffront%2Fstruct%20front.PNG)

Nouveau etudiant

![new std html.PNG](Capture%2Ffront%2Fnew%20std%20html.PNG)

![new std html2.PNG](Capture%2Ffront%2Fnew%20std%20html2.PNG)

![new std ts.PNG](Capture%2Ffront%2Fnew%20std%20ts.PNG)

![new std ts2.PNG](Capture%2Ffront%2Fnew%20std%20ts2.PNG)

List etudiant

![std html.PNG](Capture%2Ffront%2Fstd%20html.PNG)

![std html2.PNG](Capture%2Ffront%2Fstd%20html2.PNG)

![std ts.PNG](Capture%2Ffront%2Fstd%20ts.PNG)


Detail etudiant

![std-detail html.PNG](Capture%2Ffront%2Fstd-detail%20html.PNG)

![std-detail html2.PNG](Capture%2Ffront%2Fstd-detail%20html2.PNG)

![std-detail ts.PNG](Capture%2Ffront%2Fstd-detail%20ts.PNG)

![std-detail ts2.PNG](Capture%2Ffront%2Fstd-detail%20ts2.PNG)

Liste cours

![cours html.PNG](Capture%2Ffront%2Fcours%20html.PNG)

![cours html2.PNG](Capture%2Ffront%2Fcours%20html2.PNG)

![cours ts.PNG](Capture%2Ffront%2Fcours%20ts.PNG)

![cours ts2.PNG](Capture%2Ffront%2Fcours%20ts2.PNG)

Detail cours

![cours-detail html.PNG](Capture%2Ffront%2Fcours-detail%20html.PNG)

![cours-detail html2.PNG](Capture%2Ffront%2Fcours-detail%20html2.PNG)

![cours-detail ts.PNG](Capture%2Ffront%2Fcours-detail%20ts.PNG)

![cours-detail ts2.PNG](Capture%2Ffront%2Fcours-detail%20ts2.PNG)


Liste absence

![abs html.PNG](Capture%2Ffront%2Fabs%20html.PNG)

![abs html2.PNG](Capture%2Ffront%2Fabs%20html2.PNG)

Detail absence

![abs-detail Component ts.PNG](Capture%2Ffront%2Fabs-detail%20Component%20ts.PNG)

![abs-detail html.PNG](Capture%2Ffront%2Fabs-detail%20html.PNG)

![abs-detail html2.PNG](Capture%2Ffront%2Fabs-detail%20html2.PNG)

![abs-detail html3.PNG](Capture%2Ffront%2Fabs-detail%20html3.PNG)

### RESULTAT DU PROJET


![add prof.PNG](Capture%2Ffront%2Fadd%20prof.PNG)


![prof list.PNG](Capture%2Ffront%2Fprof%20list.PNG)


![prof detail.PNG](Capture%2Ffront%2Fprof%20detail.PNG)


![add std.PNG](Capture%2Ffront%2Fadd%20std.PNG)


![std list.PNG](Capture%2Ffront%2Fstd%20list.PNG)


![std detail.PNG](Capture%2Ffront%2Fstd%20detail.PNG)


![Cours list.PNG](Capture%2Ffront%2FCours%20list.PNG)

![Cours detail.PNG](Capture%2Ffront%2FCours%20detail.PNG)


![classroom list.PNG](Capture%2Ffront%2Fclassroom%20list.PNG)

![classroom detail.PNG](Capture%2Ffront%2Fclassroom%20detail.PNG)


![Absence list.PNG](Capture%2Ffront%2FAbsence%20list.PNG)

![Absence detail.PNG](Capture%2Ffront%2FAbsence%20detail.PNG)







