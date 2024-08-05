# Projeto API Bhub

Este projeto é uma API RESTful construída com Spring Boot e Drools para processar regras de pagamento. A API permite a execução de regras definidas em arquivos Drools (`.drl`) que operam sobre modelos de pagamento.

## Sumário

- [Estrutura do Projeto](#estrutura-do-projeto)
- [Pré-requisitos](#pré-requisitos)
- [Configuração e Execução do Projeto](#configuração-e-execução-do-projeto)
- [Testes da API](#testes-da-api)

## Estrutura do Projeto

```
api-bhub/
│
├── src/main/java/io/github/wanderlaercio/api/bhub
│   ├── model/
│   │   └── PaymentRuleModel.java
│   │   └── RuleExecutionResponse.java
│   └── service/
│   │       ├── DroolsService.java
│   │       └── DroolsServiceImpl.java
│   │       └── DroolsSessionFactory.java
│   └── controller/
│   │       └── DroolsControllerImpl.java
│   └── Application.java
│
├── src/main/resources/
│   ├── META-INF/
│   │   └── kmodule.xml
│   ├── application.properties
│   ├── drools.properties
│   └── rules/
│       └── payment.drl
│
├── src/test/java/io/github/wanderlaercio/api/bhub
│   └── BhubApplicationTests.java
│
├── .mvn/
│
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Pré-requisitos

- JDK 17
- Maven 3.8.4 ou superior

## Configuração e Execução do Projeto

1. Clone o repositório:

    ```bash
    git clone https://github.com/Wanderlaercio/api-bhub.git
    cd api-bhub
    ```

2. Compile o projeto e instale as dependências:

    ```bash
    ./mvnw clean install
    ```

3. Execute o projeto:

    ```bash
    ./mvnw spring-boot:run
    ```

4. A API estará disponível em `http://localhost:8080`.

## Testes da API

Para testar a API, você pode usar ferramentas como `curl` ou Postman.

### Endpoint: `POST /execute`

- **Descrição:** Executa regras Drools sobre um modelo de pagamento.
- **Request Body:** `PaymentRuleModel`
- **Response:** `RuleExecutionResponse`

#### Exemplo de Request e Response

**Request:**

```bash
curl -X POST http://localhost:8080/execute \
    -H "Content-Type: application/json" \
    -d '{
        "id": 1,
        "product": "Aprendendo a Esquiar",
        "price": 100.0,
        "category": "",
        "subcategories": ""
    }'
```

**Response:**

```json
{
    "actions": ["Adicionado vídeo de Primeiros Socorros"],
    "message": "Rules executed successfully"
}
```


### 5. Arquivo de Configuração `kmodule.xml`

Definição das configurações do KIE.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<kmodule xmlns="http://jboss.org/kie/6.0.0/kmodule">
    <kbase name="payment" packages="rules">
        <ksession name="paymentSession" default="true"/>
    </kbase>
</kmodule>
```

### 6. Arquivo de Regras `payment.drl`

Definição das regras Drools.

```java
package rules;

import io.github.wanderlaercio.api.bhub.model.PaymentRuleModel;
import io.github.wanderlaercio.api.bhub.model.RuleExecutionResponse;

rule "Adicionar Video"
when
$response: RuleExecutionResponse();
$payment: PaymentRuleModel(product == "Aprendendo a Esquiar");
then
    $response.addAction("Adicionado vídeo de Primeiros Socorros");
end

rule "Criar Remessa"
when
$response: RuleExecutionResponse();
$payment: PaymentRuleModel(category == "Phisical")
then
    $response.addAction("Guia de Remessa Criada para envio");
end

rule "Remessa para Royaltes"
when
$response: RuleExecutionResponse();
$payment: PaymentRuleModel(subcategories == "Book")
then
    $response.addAction("Criada Guia de Remessa para departamento de royaltes");
end

rule "Adicionar Comissao"
when
$response: RuleExecutionResponse();
$payment: PaymentRuleModel((category == "Phisical") || (subcategories == "Book"))
then
    $response.addAction("Comissao de $"+ $payment.getPrice() * 0.1 +" adicionada ao Agente");
end

```
