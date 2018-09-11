# screenshot-service
takes website's screenshots by given url.

- source file
~/screenshot-service/src/main/resources/url-list.txt

- output folder 
~/screenshot-service/screenshot-output

- to run as a standalone jar file: 
```sh
./gradlew build
java -jar build/libs/screenshot-service-0.1.0.jar
```

then go to localhost:8090/screenshot
it will automatically start to take screenshot by listed url in url-list.txt file.


----

- to create docker image. first create (if not) docker image then docker run
```sh
./gradle build docker
docker run -p 8090:8090 alparslantas/screenshot-service
```


