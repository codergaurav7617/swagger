# README #

Accompanying source code for blog entry at http://tech.asimio.net/2017/06/12/Implementing-APIs-using-Spring-Boot-CXF-and-Swagger.html

### Requirements ###

* Java 8
* Maven 3.3.x

### Building and executing the application from command line ###

```
mvn clean package
java -jar target/springboot-cxf-swagger.jar
or
mvn spring-boot:run
```

### URLs ###

- App available at http://localhost:8080
- API available at:
  - http://localhost:8080/api/v1/hello/{name}
  - http://localhost:8080/api/hello/{name} with version passed in Accept header
- WADL available at http://localhost:8080/api/?_wadl
- Swagger JSON doc available at http://localhost:8080/api/swagger.json
- Swagger UI available at http://localhost:8080/api/api-docs?url=/api/swagger.json

### Who do I talk to? ###

* ootero at asimio dot net
* https://www.linkedin.com/in/ootero