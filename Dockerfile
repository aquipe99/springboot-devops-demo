# Imagen base con Java 17
FROM eclipse-temurin:17-jre

# Carpeta de trabajo
WORKDIR /app

# Copiar el JAR generado por Maven
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Puerto utilizado por Spring Boot
EXPOSE 8080

# Comando de inicio
ENTRYPOINT ["java","-jar","app.jar"]