# from <basisimage>
FROM openjdk:17

WORKDIR /b-app
COPY target/spengermed-0.0.1-SNAPSHOT.jar spengermed.jar

CMD ["java","-jar","spengermed.jar"]

# workdir <name>

# copy

# cmd/entrypoint