# tweetero-api-spring

## How to run
- Docker is required
- run `docker compose up --build`

## Rebuild needed?
- run `./mvnw clean package -DskipTests`
-- It will create a `.jar` file
- run `cp target/api-0.0.1-SNAPSHOT.jar src/main/docker/`
-- It copy that file to docker directory
- Now you can run docker compose command again

## Testimonial
I'm really proud making this project, it took me a lot of pacience and dedication, Java was the first language that I had troubles at college 8 years ago. I'm glad that I prove to myself that I can do it.
