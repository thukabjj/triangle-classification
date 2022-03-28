# Triangle Classification API

## Requirements
 - Java 17
 - Gradle 7.4.1 
 - Docker

## How to run
Running DynamoDB on localstack
```
 docker-compose -f docker-compose-dynamodb.yml up

```

Running Spring Application
```
./gradlew bootRun
```

Stop deleting the volume:
```
 docker-compose -f docker-compose-dynamodb.yml down -v
```

## Document API
After up the lasts steps access the link below:

```
 http://localhost:8080/swagger-ui/index.html

```
Or import this collection on Postman
```
https://www.getpostman.com/collections/c2fa9a512b1a61a0b2d4
```
