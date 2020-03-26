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
- The file will be stored on the classpath

Stack
-----

spring-boot
swagger
junit 4

Run
---

- Install java 8   [] 
- Install maven    [https://maven.apache.org/]
- Clone the repository
```
git clone http://github.com/repo
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

