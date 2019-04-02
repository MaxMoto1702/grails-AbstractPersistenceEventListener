# Grails GORM Listener Problem

## Run

    ./grailsw run-app
    
or

    ./gradlew bootRun

## Requests

### Update GORM Entity 

```
PUT http://localhost:8080/document/1
Accept: */*
Cache-Control: no-cache
Content-Type: application/json

{
  "id": 1,
  "number": "0001 updated",
  "date": "2019-04-02T13:04:42Z",
}

###
```
    
### Expected result

```json
{
  "id": 1,
  "number": "0001 updated",
  "date": "2019-04-02T13:04:42Z",
  "comment": "UPDATED..."           // timestamp
}

```

### Actual result - PASS

```json
{
  "id": 1,
  "number": "0001 updated",
  "date": "2019-04-02T13:04:42Z",
  "comment": "UPDATED..."           // timestamp
  // no problem
}

```

### Get updated GORM Entity 

```
GET http://localhost:8080/document/1
Accept: */*
Cache-Control: no-cache
Content-Type: application/json

###
```

### Expected result

```json
{
  "id": 1,
  "number": "0001 updated",
  "date": "2019-04-02T13:04:42Z",
  "comment": "UPDATED..."           // timestamp
}

```

### Actual result - FAIL

```json
{
  "id": 1,
  "number": "0001 updated",
  "date": "2019-04-02T13:04:42Z",
  // missing comment value !!!
}

```
