# Estágio de Construção
FROM maven:3.8.6-openjdk-17 AS build

# Defina o diretório de trabalho
WORKDIR /app

# Copie o pom.xml e o código-fonte para o contêiner
COPY pom.xml .
COPY src ./src

# Execute a construção do Maven ignorando os testes
RUN mvn clean package -DskipTests

# Liste o conteúdo da pasta target para verificação
RUN ls -l /app/target/

# Estágio Final
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo JAR gerado do estágio de construção
COPY --from=build /app/target/lojadebrinquedo-0.0.1-SNAPSHOT.jar app.jar

# Exponha a porta que a aplicação usa
EXPOSE 8080

# Comando para executar o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]
