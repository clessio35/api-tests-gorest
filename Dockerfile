# Etapa 1: Usar uma imagem oficial do Maven com JDK 17
FROM maven:3.9.6-eclipse-temurin-17 AS builder

# Cria o diretório de trabalho no container
WORKDIR /app

# Copia o arquivo pom.xml para otimizar o cache de dependências do Maven
COPY pom.xml .

# Baixa as dependências do Maven (sem compilar ainda)
RUN mvn dependency:go-offline

# Copia o restante dos arquivos do projeto
COPY . .

# Compila e roda os testes
RUN mvn clean test

CMD ["mvn", "clean", "test"]
