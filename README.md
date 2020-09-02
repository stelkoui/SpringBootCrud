# SpringBootCrud
A simple CRUD project using MySQL, Spring Boot and VueJS

## Build with
* Maven 3.x
*	Node.js
*	Create react app with Vue.js tempalte

## How it works
Run app with mvn clean package and the server listens to http://localhost:8080/api. Frontend listen to http://localhost:9000 , in the springboot-client folder execute : npm install and then npm run dev. For storing data is used a MySql database and with liquibase tool the tables are generated (automatically).

## Other features
** Security configuration to secure the Api with basic authentication, in order to access the api need to pass the username and the password.
We alrdeady have configure axios.client to automatically parse username and password at every call.
** Swagger configuration to provide information about the Api, it listens to http://localhost:8080/swagger-ui.html.
It is not totally completed because Swagger-ui 2 is not compatible with Spring boot 2.0.

