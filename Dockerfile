FROM maven:3.9.6-eclipse-temurin-21
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

ARG APP_PORT=7000
ENV PORT=$APP_PORT
CMD ["sh", "-c", "java -jar target/maVille-1.0-SNAPSHOT.jar --port=$PORT"]

# sudo docker build -t maville .
# sudo docker run --name maville_app -e PORT=8000 -p 8001:8000 maville
