# geode-docker-hello-world
This is just a repo where I set up the [Geode in 5 minutes](https://github.com/apache/geode) using Geode running in Docker.

## Setup
### build and run the docker image
navigate to `geode-docker-image`   
`docker build . -t geode`

Run the docker compose yml      
`docker-compose up`    
or    
`docker run -h localhost -p 40404:40404 -p 10334:10334 -p 1099:1099 geode`

### run the spring boot app
The [Geode in 5 minutes](https://github.com/apache/geode) main method is triggered by a GET call to localhost:8080/hello using a spring boot application.   

`./gradlew bootRun`

`curl localhost:8080/hello`