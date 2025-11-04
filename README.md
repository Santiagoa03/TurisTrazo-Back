🧭 Turistrazo - Backend

Backend desarrollado con Spring Boot para el proyecto Turistrazo, una plataforma enfocada en la promoción turística, gestión de experiencias y conexión entre viajeros y destinos.

El backend se encarga de gestionar la lógica de negocio, autenticación, persistencia de datos, y comunicación con el frontend a través de servicios REST.

🚀 Tecnologías utilizadas

 - Java 17

 - Spring Boot 3.1.4

 - Spring Web

 - Spring Data JPA

 - Spring Security (con JWT)

 - WebSocket

 - MySQL 8

 - H2 Database (para pruebas locales)

 - Lombok

 - Maven como gestor de dependencias

 - JWT (JSON Web Token) para autenticación

 - Commons IO para manejo de archivos
 

 🗂️ Estructura del proyecto
 
src/
 ├─ main/
 │   ├─ java/turistrazo/
 │   │   ├─ controller/    → Controladores REST
 │   │   ├─ service/       → Lógica de negocio
 │   │   ├─ repository/    → Repositorios JPA
 │   │   ├─ model/         → Entidades del dominio
 │   │   └─ security/      → Configuración JWT y filtros
 │   └─ resources/
 │       ├─ application.properties
 │       └─ data.sql (opcional para pruebas)
 └─ test/

 ⚙️ Configuración del entorno
1️⃣ Clonar el repositorio
git clone https://github.com/tuusuario/turistrazo-backend.git
cd turistrazo-backend

2️⃣ Configurar la base de datos

En el archivo src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/turistrazo
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
jwt.secret=tu_clave_secreta
jwt.expiration=86400000


También puedes usar H2 en modo desarrollo modificando el application.properties:

spring.datasource.url=jdbc:h2:mem:turistrazo
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=create

▶️ Ejecución del proyecto
Desde el IDE (IntelliJ / Eclipse)

Ejecuta la clase principal:

TuristrazoApplication.java

Desde terminal
mvn spring-boot:run
