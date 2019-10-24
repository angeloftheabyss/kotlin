# Rest service in Kotlin

This is an example Rest service which creates a Hashmap of customers and implements the different REST calls including

  - GET
  - POST
  - DELETE
  - PUT 
  - return the list of customers (GET) 
The pattern used is an application, a REST controller calling service functions, the pattern can be extended to add a DB  
use ./mvnw spring-boot:run to build 

# Speaking to the application 

## Getting an individual record 
go to the browser and type http://localhost:8080/customer/3

## Getting all records 
go to the browser and type http://localhost:8080/customers

## Creating a record 
from the command line 
curl -X POST http://localhost:8080/customer/ -H 'content-type: application/json' -d '{ "id": id_number, "name": "customer" }' 
## Deleting a record 
from the command line 
curl -X DELETE http://localhost:8080/customer/id_number 
## Updating a record 
from the command line 
curl -X PUT http://localhost:8080/customer/2 -H 'cache-contol: no-cache' -H 'content-type: application/json' -d '{ "id": id_number, "name": "Update Customer" }'



