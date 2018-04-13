# Recommendation Service #

The recommendation service manages recommendations given by users.

## Building
```./gradlew build```

## API ##  

| METHOD | PATH | Accept | Body | DESCRIPTION |
| ------ |----- | ------ |----- | ----------- |
| **GET**    | review/*{productId}* |        |      | Get all recommendations about a product; Optional query parameter for batching |
| **POST**   | review/*{productId}*  | application/json | {customerId: '123', recommendationTitle: "Recommendation Title", recommendationBody: "Recommendation Body", rating: '4'} | Add or update a recommendation |


Example curl commands:
Get data about product #1:
```
curl -H "CORRELATION-ID:<some correlation ID>" localhost:8080/review/1
```

Post a new review about product #1:
```
curl -H "Content-Type: application/json" -H "CORRELATION-ID:<some correlation ID>" -X POST -d "{\"customerId\":\"4\", \"sku\":\"12345\", \"reviewHeader\":\"Some header about the product\", \"reviewBody\":\"Some body text about the product\", \"rating\":5}" localhost:8080/review/add
```
