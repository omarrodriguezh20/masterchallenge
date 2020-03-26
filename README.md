Connected Cities
================

Requirement
------------

Determine if two cities are connected. Two cities are considered
connected if there’s a series of roads that can be traveled from one city
to another.

Assumptions
----------

- There's only one road going out from one city to another.
- There is no endpoint for update cities and roads
- The file will be stored on the classpath and provided with the solution
- The file is small enough to be stored on memory
- Both responses (no connection and connection ) will return and 200 Http Status, because the search has been done

Stack
-----

- spring-boot
- swagger
- junit 4
- jacoco (unit test coverage)

Run
---

- Install java 8   
- Install maven    [https://maven.apache.org/]
- Clone the repository
```
git clone https://github.com/omarrodriguezh20/masterchallenge.git
```
- Run the test battery
```
mvn test
```
- After executing the test battery you can generate the coverage report
```
mvn jacoco:report
```
- The coverage report is located in
```
target/site/jacoco/index.html
```
- Execute the service
```
mvn spring-boot:run
```
- Go to url in your browser
```
http://localhost:8080/connected?origin=Boston&destination=New%20York
```
- Example urls
```
http://localhost:8080/connected?origin=Boston&destination=Newark
http://localhost:8080/connected?origin=Boston&destination=Philadelphia
http://localhost:8080/connected?origin=Philadelphia&destination=Albany
```
- Swagger documentation
```
http://localhost:8080/swagger-ui.html
```
