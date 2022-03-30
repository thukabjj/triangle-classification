# Triangle Classification API
This application has the objective to build a REST API based on the Clean Architecture to classify the type of triangle. 

## Design
In this application, I focused on exploring the concepts of Clean Architecture, specifically on the dependency on rules to have less coupling possible. 
Also, to make a code with quality, I take care to respect the SOLID principles, mainly in two Single Responsibility and Interface Segregation, 
focused on the isolation of the domain to external dependency and code for interfaces evicting to work with concreted classes.
The bellow a representation of this design approach:

### Rule Dependecy Cicle
![image](https://user-images.githubusercontent.com/31043997/160742500-9b0fb2f9-1f32-46fd-b324-2e77b7ab212c.png)

### Layer Scope
![image](https://user-images.githubusercontent.com/31043997/160742733-05c2b443-7d2b-4dbc-97cd-9b270049dbaf.png)


## Requirements
- Java 17
- Gradle 7+
- Docker

## How to run
```
    docker-compose up --build  --remove-orphans
    docker-compose down -v
    
```

## Document API
After the latest step, access the link below to try the endpoints:

```
 http://localhost:8080/swagger-ui/index.html

```
Or import this collection on Postman
```
https://www.getpostman.com/collections/c2fa9a512b1a61a0b2d4
```
