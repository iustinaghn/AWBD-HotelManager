# Hotel Manager – Java Spring Boot App

Această aplicație este un sistem de gestiune pentru hoteluri, camere, clienți, rezervări și servicii,
creată cu **Spring Boot** și interfață web folosind **Thymeleaf**.

---

## Funcționalități

- Login cu Spring Security (autentificare cu useri din baza de date)
- CRUD Hoteluri
- CRUD Camere (cu sortare și paginare)
- CRUD Clienți
- CRUD Profiluri Clienți (cu legătură OneToOne)
- CRUD Rezervări (cu legături la camere, clienți și servicii)
- CRUD Facturi
- CRUD Servicii
- CRUD Recenzii
- Meniu principal modern pentru navigare ușoară
- Filtrare și sortare camere
- Pagină Login / Logout
- Bază de date H2 cu date demo predefinite

---

## Tehnologii folosite

- Java 17
- Spring Boot 3
- Spring Security (JDBC Authentication)
- Spring Data JPA
- H2 In-Memory Database
- Thymeleaf (motor de template-uri HTML)
- Maven

---

## Cum rulezi proiectul

1. Clonează repository-ul:
   ```bash
   git clone https://github.com/iustinaghn/AWBD-HotelManager.git
