# Simple REST API - Spring Boot

Uma API REST simples desenvolvida com **Spring Boot**, equivalente a uma implementação original em Python puro.

A aplicação fornece endpoints básicos para:

* Listagem de itens
* Busca por nome
* Inclusão de novos itens
* Remoção de itens

Os dados são mantidos em memória (sem banco de dados).

---

# 🚀 Tecnologias Utilizadas

* Java 21
* Spring Boot 3.3.x
* Maven
* Jackson (serialização JSON automática)

---

# 📋 Pré-requisitos

Antes de executar o projeto, certifique-se de possuir instalado:

## ☕ Java

* **Versão obrigatória: Java 21 (LTS)**

Verifique com:

```bash
java -version
```

A saída deve indicar versão 21.

---

## 📦 Maven

* **Versão obrigatória: 3.9.9**

Verifique com:

```bash
mvn -version
```

---

# ▶️ Como Executar o Projeto

No diretório raiz do projeto, execute:

```bash
mvn clean spring-boot:run
```

Ou para gerar o JAR:

```bash
mvn clean package
java -jar target/simple-rest-api-1.0.0.jar
```

---

# 🌐 Endpoints Disponíveis

A aplicação sobe por padrão na porta **5000**:

```
http://localhost:5000
```

## 🔹 GET /

Retorna informações gerais da API.

## 🔹 GET /list

Retorna todos os itens cadastrados.

## 🔹 GET /search?q=valor

Busca itens cujo nome contenha o valor informado.

Exemplo:

```
GET /search?q=cat
```

## 🔹 POST /add

Adiciona um novo item.

Body (JSON):

```json
{
  "name": "snake",
  "description": "snake is slithering"
}
```

## 🔹 POST /delete

Remove um item pelo ID.

Body (JSON):

```json
{
  "id": 1003
}
```

---

# 📌 Observações

* A aplicação utiliza armazenamento em memória.
* Ao reiniciar a aplicação, os dados voltam ao estado inicial.
* Não há persistência em banco de dados.

---

# 🧪 Build

Para validar compilação:

```bash
mvn clean verify
```

---

# 📄 Licença

Projeto para fins educacionais e demonstração de arquitetura REST com Spring Boot.
