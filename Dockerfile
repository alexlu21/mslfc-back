# Utiliza una imagen base con Java 21 para construir el proyecto
FROM eclipse-temurin:21-jdk AS build

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia todos los archivos de tu proyecto al contenedor
COPY . .

# Da permisos al wrapper de Gradle y construye el proyecto sin ejecutar pruebas
RUN chmod +x gradlew
RUN ./gradlew clean build -x check -x test

# Crea la imagen final con el JRE
FROM eclipse-temurin:21-jre

# Copia el archivo JAR generado desde la etapa de construcción
COPY --from=build /app/build/libs/*.jar app.jar

# Expone el puerto que usará la aplicación (generalmente 8080)
EXPOSE 8080

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
