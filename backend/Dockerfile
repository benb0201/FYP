# try building the app using some debian12 based image
# and run it using gcr.io/distroless/java17-debian12
FROM debian:12-slim AS builder
RUN apt-get update && apt-get install -y openjdk-17-jdk-headless
COPY . /app
RUN chmod 750 /app/mvnw
WORKDIR /app
RUN MAVEN_OPTS=-Dmaven.test.failure.ignore=true /app/mvnw package
# the command above generates /app/target/travelpal-0.0.1-SNAPSHOT.jar file

FROM gcr.io/distroless/java17-debian12 AS runner
COPY --from=builder /app/target/travelpal-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8080
CMD ["/app.jar"]
