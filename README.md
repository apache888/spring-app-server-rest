# spring-rest-app-server
# REST app server in 3-tier model (Only backend)

This backend application only provides a REST API. There is no UI. The ?????? project is a front-end application
witch consumes the REST API.

This application provides CRUD operations for entity (now it's only Developer)

# Database configuration
For select database, it is needed to choose param "spring.profiles.active=?"
defined in application.properties file.

For run server it is needed to execute: mvn spring-boot:run

You can access server here: http://localhost:9966/app-server/

... in processing ...
