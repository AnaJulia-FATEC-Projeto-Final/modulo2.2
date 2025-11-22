FROM amazoncorretto:17-alpine3.15
LABEL MANTAINER="Ana Julia 12"

WORKDIR /app

EXPOSE 8081

RUN wget -O dd-java-agent.jar 'https://dtdg.co/latest-java-tracer'

COPY springboot/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]