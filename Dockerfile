# Estágio de Build
FROM ubuntu:latest AS build

# Atualize o repositório e instale o JDK e Maven
RUN apt-get update && apt-get install openjdk-17-jdk maven -y

# Defina o diretório de trabalho para a construção
WORKDIR /app

# Copie o arquivo pom.xml e o código-fonte do projeto para o contêiner
COPY pom.xml .
COPY src ./src

# Execute a construção do Maven ignorando os testes
RUN mvn clean install -DskipTests

# Liste o conteúdo da pasta target para verificação
RUN ls -l /app/target/
