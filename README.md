# OMCProva
 
Para ejecutar el programa hay que connectarse a un servidor de base de datos, crear una nueva base de datos y cambiar el application.properties para connectarse a esta nueva BD. 
Yo lo he hecho con un container de Docker com una image de mySQL, a continuación las variables de entorno que he utilizado:
MYSQL_ROOT_USER=root
MYSQL_ROOT_PASSWORD=password 

Y mi application.properties:
spring.application.name=demo

spring.datasource.url=jdbc:mysql://localhost:3306/provaTecnica
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

Se puede tanto ejecutar el .jar (java -jar .\demo-0.0.1-SNAPSHOT.jar) como el código en si (al ejecutar por primera vez se crean las tablas).