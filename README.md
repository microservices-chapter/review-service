# Review Service #

The review service manages reviews given by users.

## Building
```./gradlew build```

## API ##  

| METHOD | PATH | Accept | Body | DESCRIPTION |
| ------ |----- | ------ |----- | ----------- |
| **GET**    | review/list |        |      | Get all reviews |
| **GET**    | review/list/product/{sku} |        |      | Get all reviews about a particular product |
| **GET**    | review/list/product/{sku}/rating/{rating} |        |      | Get all reviews about a particular product with a particular rating |
| **GET**    | review/list/customer/{customerId} |        |      | Get all reviews written by a particular customer |
| **POST**   | review/add  | application/json | {"customerId": "123", "sku":"12345", "header": "A review header", "body": "Some review body", "rating": 4} | Add or update a recommendation |


Example curl commands:
Get all reviews in the system:
```
curl -H "CORRELATION-ID:<some correlation ID>" localhost:8080/review/list/
```

Get all reviews about product 1:
```
curl -H "CORRELATION-ID:<some correlation ID>" localhost:8080/review/list/product/1
```

Get all reviews about product 1 with a rating of 5:
```
curl -H "CORRELATION-ID:<some correlation ID>" localhost:8080/review/list/product/1/rating/5
```

Get all reviews made by customer 5:
```
curl -H "CORRELATION-ID:<some correlation ID>" localhost:8080/review/list/customer/5
```

Post a new review about product 1:
```
curl -H "Content-Type: application/json" -H "CORRELATION-ID:<some correlation ID>" -X POST -d "{\"customerId\":\"4\", \"sku\":\"12345\", \"header\":\"Some header about the product\", \"body\":\"Some body text about the product\", \"rating\":5}" localhost:8080/review/add
```
