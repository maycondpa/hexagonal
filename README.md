# Projeto: Arquitetura Hexagonal com Spring Boot
Este é um projeto desenvolvido em Spring Boot utilizando a Arquitetura Hexagonal 
como base. O objetivo principal é demonstrar a organização e estrutura desta arquitetura, 
além de incluir práticas como simulação de APIs com WireMock e validações arquiteturais com ArchUnit.

Este projeto simula um cadastro de cliente e a busca de endereço deste cliente cadastrado. Após realizar o cadastro do cliente/deletar ele da base
ou realizar alguma alteração do cadastro dele. Um evento é publicado no tópico kafka.

### Índice

* [Arquitetura Hexagonal](#arquitetura-hexagonal)
* [Tecnologias Utilizadas](#tecnologias-utilizadas)
* [Estrutura do Projeto](#estrutura-do-projeto)
* [Como executar o projeto](#como-executar-o-projeto)

### Arquitetura Hexagonal
A Arquitetura Hexagonal (também conhecida como Ports and Adapters) é uma abordagem que isola a lógica de negócios da aplicação dos detalhes técnicos, como frameworks, bancos de dados e APIs externas.

#### Princípios-Chave
1. Independência de Frameworks: O núcleo da aplicação não depende de tecnologias externas.
2. Testabilidade: A lógica central pode ser testada isoladamente.
3. Portabilidade: Adapta-se facilmente a diferentes contextos (bancos de dados, APIs, etc.).

### Tecnologias Utilizadas
* Java 17: Linguagem de programação.
* Spring Boot 2.x: Framework principal.
* WireMock: Simulação de APIs externas.
* Kafka: Produzir/consumir eventos toda vez que um novo usuário foi inserido no banco de dados.
* MongoDB: Banco de dados utilizado.
* ArchUnit: Validação de regras arquiteturais.
* JUnit 5: Framework de testes unitários.
* Gradle: Gerenciamento de dependências e build.

### Estrutura do Projeto
```plaintext
src/
├── main/
│   ├── java/com/maycon/hexagonal/
│   │   ├── adapters/
│   │   │   ├── in/          # Adaptadores de entrada (ex.: controladores REST)
│   │   │   ├── out/         # Adaptadores de saída (ex.: repositórios, APIs externas)
│   │   ├── application/
│   │   │   ├── core/        # Lógica de negócios central (casos de uso)
│   │   │   ├── ports/       # Interfaces para comunicação entre os adaptadores e o core
│   │   ├── config/          # Configurações do projeto (Beans, Security, etc.)
│   ├── resources/
│       ├── application.yml  # Configurações de ambiente
├── test/
│   ├── java/com/maycon/hexagonal/ # Testes unitários e de integração
```

#### Principais Pacotes
* adapters.in: Contém os adaptadores de entrada, como controladores REST.
* adapters.out: Contém os adaptadores de saída, como implementações para acessar APIs externas ou repositórios.
* application.core: Lógica de negócios central do projeto.
* application.ports: Interfaces para comunicação entre o core e os adaptadores.
* config: Configurações gerais da aplicação.

### Como executar o projeto
1. Realizar o download do wiremock(https://wiremock.org/docs/download-and-installation/).
2. Realizar o download do docker(https://docs.docker.com/desktop/)
3. executar o wiremock com o seguinte comando java -jar wiremock-standalone-3.9.2.jar --port 8082, ao 
executar esse comando ira criar algumas pastas no repositório onde o comando foi executado. Dentro da pasta 
mappings(pasta criada através do comando anterior), adicione arquivos no formato de Json para simular
o retorno de uma api. Exemplo da estrutura do arquivo:
```json
{
    "request": {
        "method": "GET",
        "url": "/address/38400000"
    },
    "response": {
        "status": 200,
        "headers": {
            "Content-Type": "application/json"
        },
        "jsonBody": {
            "street": "Rua Hexagonal",
            "city": "Uberlândia",
            "state": "Minas Gerais"
        }
    }
}
```
Quando a aplicação chamar esse endpoint para buscar as informações de endereço do usuário pesquisado, 
esse será o retorno.

4. Após o procedimento anterior, só executar novamente o comando java -jar wiremock-standalone-3.9.2.jar --port 8082 para executar o wiremock.
5. Após executar o passo do wiremock e após baixar o docker, ir até a pasta /docker-local e executar o comando
docker-compose up, para subir os containers do mongodb e do kafka.
6. Para finalizar, após os containers subirem, só executar a aplicação.