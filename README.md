# Recommendation Service #

The recommendation service manages recommendations given by users.

## Building
```./gradlew build```

## API ##  

| METHOD | PATH | Accept | Body | DESCRIPTION |
| ------ |----- | ------ |----- | ----------- |
| **GET**    | recommendation/*{productId}* |        |      | Get all recommendations about a product; Optional query parameter for batching |
| **GET**    | products/*{productId}* |        |      | Retrieve a product |
| **POST**   | recommendation/*{productId}*  | application/json | {customerId: '123', recommendationTitle: "Recommendation Title", recommendationBody: "Recommendation Body"} | Add or update a recommendation |
