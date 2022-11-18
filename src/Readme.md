# Eurekalabs challenge
Challenge for Eurekalabs

### Challenge ###

* https://github.com/eurekalabs-io/challenges/blob/main/backend/java-spring/stock-market-service.md

### To start the application locally ###

* Create a postgres database named __wchallenge_db__
* Set the following environment variables: __JWT_KEY__, __STOCK_API_KEY__, __DB_USERNAME__, __DB_PASSWORD__

### To test the app ###

* After running visit __http://localhost:8080/swagger-ui.html__ to view the API documentation
* You must call /users (POST) service to register a user
* You must call /users/login (POST) service to obtain an api key
* You can call /stock/AAPL (GET) service with the token obtains in the login in a Bearer Token authentication
* You can download the postman collection for the next link: __https://www.getpostman.com/collections/d5b3c83ed568fb6d5437__
