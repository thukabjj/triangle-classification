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


## Technologies
- Java 17
- Spring Boot 2.6.4
- jUnit 5
- Spring Security (to JWT)
- Spring Data Dynamo
- Swagger 3.0
- JaCoCo
- Gradle 7+
- Docker
- Localstack (DynamoDB)

## How to run
Up application and Localstack with DynamoDB 
```yaml
docker-compose up --build  --remove-orphans
```
Turn off
```yaml
docker-compose down
```
Or If you want remove the volumes
```yaml
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
# What needs to be implemented?
- Terraform to provide DynamoDB resource on Localstack
- Logs formatted adding request, response and routeSteps on console with a way to filter and replace sensibilities information and censor them to improve security and observability.
- Mock of DynamoDB to make possible integrations tests.
