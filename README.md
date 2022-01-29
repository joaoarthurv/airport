# Airport System

The purpose of this repository is to manage an airport flight schedule system.

## Diagram

![image](https://user-images.githubusercontent.com/34632499/151645499-23f86ad7-0c69-41c9-9aea-ea473b8a1e5f.png)

Obs: The frames marked in red will be implemented in a next version.


## Requirements

- Java 17
- Maven
- DynamoDB

## Run project

1 - Create a table in DynamoDB and configure credentials.

2 - Build / Execute application.

3 - Open Postman(or similar tool), and import collection (Airport.postman_collection.csv) 

## Project in execution

### Table: `flight_information`

![image](https://user-images.githubusercontent.com/34632499/151645682-bcba6c0a-275d-4fab-9912-d279b49a93d4.png)

### Table: `user_information`

![image](https://user-images.githubusercontent.com/34632499/151645715-7a501076-e917-40de-8ec0-83d10e0bd385.png)

### Postman (Example): `getFlightList | getAllFlights`

![image](https://user-images.githubusercontent.com/34632499/151645763-7740efa4-4c56-4c44-9c2f-d3f486e51c1d.png)

