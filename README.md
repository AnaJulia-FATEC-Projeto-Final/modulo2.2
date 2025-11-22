# Projeto Final de Programação Multiplataforma - Módulo 1

> Projeto desenvolvido por Ana Julia Lima de Oliveira como uma API de Login.

> Esta aplicação faz parte do módulo 2.2 do projeto de Programação Multiplataforma da FATEC.
> Atua em conjunto com o Gateway desenvolvido no módulo 2.1.

---

## Como iniciar o projeto localmente

### 1. Git clone
```bash
git clone https://github.com/AnaJulia-FATEC-Projeto-Final/modulo2.2.git

cd modulo2.2
````

### 2. Construir containers e Rodar via IDE (recomendado)
```bash
docker-compose up -d

# Abra a IDE (IntelliJ recomendado) e importe o projeto
```

### 3. Você também pode rodar via Docker:
```bash
mvn clean package -DskipTests

docker build -t anajulia/modulo2.2:latest .

# Descomente a última seção do docker-compose.yml para rodar via Docker Compose
docker-compose up -d
```

> A API Rest fica na porta 8081 do Localhost.