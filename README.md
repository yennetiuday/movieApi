# Movies API

### <ins>Goal of the application</ins>

- Movies API to get movie details based on inputted criteria year/genre/actor/ratings and
  add or delete movies to watch list for user


### <ins>Movies API Business Requirements</ins>

- API endpoints with the appropriate HTTP verbs.
- API base URL and endpoints appropriately named.
- Include unit tests.
- Descriptive README to document the key features of your solution, your assumptions, approaches and future thoughts.
- API endpoints well documented.
- Error and exception handling considerations included.
- Create watchlist to add movie

### <ins>Acceptance Criteria and Assumptions</ins>

- Movie API should return the movie results based on the search criteria.
- Watch List to save movie details for User


### <ins>Key Features of the application</ins>

- Movie Recommendations based on the inputted criteria
- Middleware API creation is done using Java,SpringBoot and Spring Data JPA
- Postgres Database has been used for storing the data
- Postman is used to interact with API
- API health can be checked at /health endpoint


### <ins>Approach to the solution</ins>

- Step One:

After group discussion,
   scope of the project
 
   the tools to be used
  
   technologies to be used (java, junit 5, maven, postgresSQL )
 
   standup calls at 10 am everyday

- Step Two:

    We created the project structure.
  
    Created UML Design
  
    We made a github repo and pushed the code to git 

- Step Three: 

    Discussed the model and datatype to be used
    Created Model, repository, controller

- Step Four: 

    Followed TDD Approach to create Movie Module and also configured Database.
    
    Saving Genre Details in postgres Table

- Step Five:

     Test all apis through PostMan.
     
     
     
     
     
 ### <ins>Technologies Used</ins>

    Java
    maven
    JUnit 5
    PostgresSQL
   


### <ins>Tools used in the project</ins>

 
    Slack
    Zoom


### <ins>How to run the application and tests</ins>

To run this application - run from "MovieApiApplication.java"

Access the API from Postman (or browser)

Runs from http://localhost:8081/api/v1/


To run the tests, use the following command:

    mvn test
      
     
     

### <ins> To improve </ins>

 - Create features like recommended Movie based on weather , mood.
  
 - Create User Profile and authentication for users and implement Spring Security.
  
 - Movie recommendation according to age of User
  
 - To add actors and directors information in the movie database so that user can get data based on actors and directors.
 
 - Deployment to AWS
 
 - Create Frontend for the application.
 
