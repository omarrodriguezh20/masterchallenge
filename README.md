Connected Cities
================

Requirement
------------

Determine if two cities are connected. Two cities are considered connected if there’s 
a series of roads that can be traveled from one city to another.

Assumptions
----------

- There is no endpoint for update cities and roads
- The file will be stored on the classpath and provided with the solution
- The file is small enough to be stored on memory
- Both responses (no connection and connection ) will return and 200 Http Status, because the search has been done

Design
-----
Since the cities could be visited in both directions we are dealing with a graph. The implementation
is based on and Adjacent list [https://en.wikipedia.org/wiki/Adjacency_list] and for the search 
we are using a depth first search [https://en.wikipedia.org/wiki/Depth-first_search].

For the storage of the Graph in memory we use a Singleton, granted that the file size isn't going to be
of considerable size, and to improve the performance (the file will be readed only once)

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

Parametrization
---------------
If you want to change the list of cities and values, you can modify the file

```
/src/main/resources/city.txt
```

The current file has this contents
```
Boston, New York
Philadelphia, Newark
Newark, Boston
Trenton, Albany
``` 
