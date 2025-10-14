# Usa a imagem oficial do Java 17 como base.
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho dentro do container.
WORKDIR /app

# Copia os ficheiros de build do Maven para o container.
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Descarrega as dependências do projeto.
RUN ./mvnw dependency:go-offline

# Copia o resto do código-fonte da sua aplicação.
COPY src ./src

# Executa o build da aplicação, criando o ficheiro .jar.
RUN ./mvnw clean install

# Define o comando que será executado quando o container iniciar.
CMD ["java", "-jar", "target/api-0.0.1-SNAPSHOT.jar"]
