# Reservaciones
Microservicio 2 para realizar Reservaciones
En  este Microservicio podemos realizar la creación de una reserva, 
y de la misma manera la podemos visualizar, una si es un usuario o todas 
si nos logueamos como administradores, tambien podemos actualizar
y eliminar una reserva.  Las pruebas locales y web la encontramos
en el Jira enlazado al repositorio de Bitbucket.

Despliegue de Microservicio en Heroku, utilizando Docker.
Para desplegar el microservicio, es necesario realizar algunas configuraciones primero, una de ellas es
añadir el código server.port=${PORT:8080} al archivo src/main/resources/application.properties.

Luego, es necesario empaquetar el proyecto en un .jar, para ello en la terminal de IntelliJ Idea se debe
utilizar el comando:

./mvnw package.

Una vez finalice este proceso, se debe crear un archivo llamado Dockerfile (sin extensión) en la raíz del
proyecto.

Una vez se ha creado el Dockerfile, dentro de este se deben indicar las siguientes instrucciones:

FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
CMD gunicorn --bind 0.0.0.0:$PORT wsgi

Despliegue en Heroku con Docker

Primero se debe iniciar sesión en el CLI de Heroku, utilizando en la terminal el comando:

heroku login

Ahora se debe crear la imagen del proyecto, para esto Docker se debe estar ejecutando en el sistema
(simplemente se debe abrir la aplicación). Así, con Docker corriendo se debe conectar la terminal con el
servicio de Docker de Heroku, para esto se ejecuta comando:

heroku container:login

Una vez se ha establecido la conexión, se debe crear la aplicación de Heroku donde se realizará el
despliegue del microservicio. Para ello, se debe utilizar el comando:

heroku create nombre-app

cambiando la palabra nombre-app por el nombre que se desea poner a la aplicación.

Posteriormente, se debe crear la imagen del proyecto con el comando:

heroku container:push web --app nombre-app

Donde nombre-app es el nombre de la aplicación de Heroku creada anteriormente.

Una vez creada la imagen del proyecto, solo falta realizar el despliegue, para ello se utiliza el comando:

heroku container:release web --app nombre-app

Donde nombre-app es el nombre de la aplicación de Heroku

Una vez realizado el despliegue del microservicio, se puede probar que las urls del servidor
funcionan correctamente. Para esto se utilizará Postman, junto con la url del componente desplegado en
heroku, cuyo formato, como ya se ha visto, es el siguiente:

https://{nombre-app}.herokuapp.com/

Este Microservicio fue realizado con Java y Framework Spring-Boot
