# screenshot-service
takes website's screenshots by given url.

- to run as a standalone jar file: 
```sh
./gradlew build
java -jar build/libs/screenshot-service-0.1.0.jar
```

- to create docker image. first create (if not) docker image then docker run
```sh
./gradle build docker
docker run -p 8090:8090 alparslantas/screenshot-service
```


