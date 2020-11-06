Description:
Web service for car rental company (non-commercial)

Tools:
Java, Spring, Hibernate, PostgreSQL, Thymeleaf, Bootstrap, Docker, Maven.

Run Spring Boot with PostgreSQL in the Docker container:

1) Download Docker https://www.docker.com/

2) Terminal command : docker run --name some-postgres -e POSTGRES_DB=carbase -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 postgres
   (Download postgresql and create data base) after execution cmd: docker ps (show created database);

3) Cmd: docker network create myNetwork(Create network with name "myNetwork")

4) Cmd: docker network connect myNetwork some-postgres(Add container with database to our network)

5) Cmd: docker network inspect myNetwork(In the output, look for the line "IPv4Address" and copy the IP address into the application.properties file, for example: "spring.datasource.url=jdbc:postgresql://172.20.0.2:5432/carbase")

6) Cmd: docker build . (After you have made a build of your project and have the jar file available, you can launch the container)

7) Cmd: docker images (Find the ID of our image and copy to the buffer)

8) Cmd: docker run -p 8081:8081 --net myNetwork  d737457c26d5(paste copied ID here) (Run application)

9) Open your browser and enter: http://localhost:8081/

    

