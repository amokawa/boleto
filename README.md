# boleto

Desafio Itaú para criação de serviço de boleto

## Requisitos

* O serviço carshop deve estar rodando. [Link para o projeto](https://github.com/amokawa/carshop)
* o API gateway (Zuul) deve esta estar rodando. [Link do projeto](https://github.com/amokawa/zull-api-gateway)

## Como executar

* Baixar o código para a máquina destino.
* Executar: `.\mvnw spring-boot:run`.

## Verificando a aplicação

* Acessar `http://localhost:8080/boleto/boleto` (caso o serviço do API Gateway esteja rodando) OU
  `http://localhost:8100/boleto` para acessar diretamente. Isto deve retornar um erro pois o método de chamada é o POST,
  ao invés de GET.

## Exemplos

### Chamada do método "/boleto"

* Requisição:

```text
curl --location --request POST 'localhost:8080/boleto/boleto' \
--header 'Content-Type: application/json' \
--data-raw '{
    "carId":7
}'
```

* Resposta:

```json
{
  "expireDate": "2021-02-10",
  "total": 70900.0,
  "code": "6d8a5925-2ed3-4b98-9e51-5f68dd688f3b"
}
```
