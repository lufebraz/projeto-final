# Projeto Final INFNET - Arquitetura de Microsserviços Java [23E4_3]
## - MS-RESTAURANTE
### author: Luiz Fernando de Oliveira Braz Silva

Este é um projeto final da disciplina Arquitetura de Microservicos.
Fiz o projeto com Spring Boot que utiliza várias funcionalidades-chave para criar uma aplicação robusta e bem monitorada.
Neste Repositorio estão 3 pastas, 2 sao os microservicos que possuem suas funcionalidades, e um é o eureka para registrar e descobrir os serviços.


## Características

- **Java Versão**: 17
- **Spring Boot Versão**: 3.1.6
- **Gerenciador de Dependências**: Maven

## Funcionalidades Implementadas

### Actuator

O projeto está configurado para usar o Spring Boot Actuator, que fornece recursos prontos para uso para monitorar a saúde e métricas da aplicação.

### ZIPKIN

Zipkin é um sistema de rastreamento distribuído. Ele ajuda a rastrear as solicitações através de vários serviços para identificar atrasos e problemas de desempenho, proporcionando uma visão detalhada do tráfego de solicitações.

### Eureka
Eureka é um serviço de descoberta usado em arquiteturas de microserviços. Ele permite que serviços se registrem nele e descubram outros serviços de forma dinâmica, facilitando a comunicação e o balanceamento de carga

### Swagger UI

A documentação da API RESTful está disponível através do Swagger UI. Para acessar a documentação, visite:

http://localhost:8081/swagger-ui/index.html#/

![Swagger](/imagens/swagger.png)

## Instruções para Execução

Para executar o projeto, siga os passos abaixo:

1. Clone o repositório para sua máquina local.
2. Navegue até a pasta do projeto e para cada pasta pelo terminal, utilize o comando `mvn package` para gerar os pacotes.
3. Suba as imagens no Docker nas portas que deseja, lembrando que o eureka tem q ser 8761.
4. Suba uma imagem do Zipkin tbm no docker.
5. e pronto, so fazer sua primeira requisição "http://localhost:8080/actuator/health" para se certificar q o servidor subiu.

Após iniciar a aplicação, você pode acessar as funcionalidades descritas acima através dos seus respectivos endpoints.

---

