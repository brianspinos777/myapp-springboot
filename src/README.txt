Notes:

@RestController
@RequestMapping("/foo", method=POST)
@RequestParam(value="age") String age
@Entity

com.spinos.model
com.spinos.dao
com.spinos.controller
com.spinos.repository

// spring initializer
https://start.spring.io/

documentation:
https://spring.io/projects/spring-boot

$ gradle wrapper # generates the gradle wrapper folders
$ lsof -i tcp:8080
$ ./gradlew bootRun
$ ./gradlew build --refresh-dependencies
$ ./gradlew bootJar
$ java -jar foo.jar # just an example


request --> controller --> service --> repository/DAO  --> model

================================================================= Docker
$ docker run --name my-container
$ docker port my-container
# 5432/tcp -> 0.0.0.0:5432
$ docker container list
$ docker version


===== Dockerfile
FROM node:alpine
COPY . /app
WORKDIR /app
CMD node app.js

$ docker build -t my-app . # where the Dockerfile is, creates the image
$ docker image list # to see your image listed
$ docker run my-app # run your image, creating a container
$ docker pull foo/my-app # download an image
$ docker run foo/my-app # run downloaded image

========================== docker & Gradle

===== Dockerfile
FROM openjdk:8-jdk-alpine
COPY build/libs/myapp-0.0.1-SNAPSHOT.jar ./myapp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","myapp-0.0.1-SNAPSHOT.jar"]

# make sure you generate the JAR with task bootJar
$ ./gradlew bootJar
$ docker build -t spinos/myapp . # create image from Dockerfile
$ docker run --name myapp-1 -d -p 8080:8080 spinos/myapp:latest # run in detached mode
$ docker container list
$ docker container list --all # including stopped ones
$ docker container stop <container-id>
$ docker container start <container-id>
$ docker container pause <container-id>
$ docker container unpause <container-id>
$ docker container rm <container-id> # need to stop first

// couchbase
$ docker run --name brian-couchbase -d -p 8091-8094:8091-8094 -p 11210:11210 couchbase

// push image to docker
$ docker login
$ docker tag spinos/myapp:latest brianspinos777/spinos-repo # needed to create repo in dockerHub
$ docker push brianspinos777/spinos-repo:latest



================= GCP
https://cloud.google.com/
using my gmail account
https://console.cloud.google.com/getting-started?project=cool-citadel-322401



=============== DockerHub
https://hub.docker.com/
user: brianspinos777
pass: **************


================= Postgres
$ docker run --name my-postgres-db -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres:alpine
$ docker ps
$ docker port my-postgres-db
$ docker exec -it my-postgres-db bin/bash # interactive shell
$ psql -U postgres # start postgres, with user "postgres"
$ \l # lowercase L, list databases
$ CREATE DATABASE mypostgresdb; # no dashes allowed
$ \c mypostgresdb; # connect to DB
$ \d # list all stuff
$ \dt # list tables ?
$ \d <my-table> # describes the table
$ SELECT * from foo;
$ CREATE EXTENSION "uuid-ossp";
$ SELECT uuid_generate_v4(); # generate UUID, format: b59f19e6-e677-4720-9997-284010ce9ddd
$ INSERT INTO foo (id, name) VALUES (uuid_generate_v4(), 'brian'); # GOTCHA: needs to be single quotes



========================= GIT
$ git init
$ git remote add origin git@github.com:sammy/my-new-project.git
$ git push -u -f origin master # -f to force changes




.