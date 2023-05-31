# BKOOL Technical Assesment

A REST API to create bikes and search among them

![BKOOL](https://design.bkool.com/images/download/logo/assets/logo-horizontal-yellow.png)

## How to run this app

```bash
  git clone https://github.com/BrianC9/TA-Rest-Springboot.git

  cd TA-Rest-Springboot/
  
  docker compose up sb_app

```

## Endpoints

**Base URL:**

```http
http://localhost:8080/api
```

**Default user to request a token**

```
username: bryan
password: password
```

### Get a token for the following requests

⚠ Log in with basic auth and the default user above.

```http
POST /auth/token

```

⚠ Copy the token to include as a Bearer token in the next requests.

### Create a Bike

``` http
POST /v1/bikes
Bearer Token: eyxxx...
BODY:
{
  "name": "Urban Bike",
  "manufacturer":"Trek",
  "description": "A urban bike for urban adventures",
  "price": 400.99
}
```

### Search bikes with a filters

```http
GET /v1/bikes/search?name=bikeName&manufacturer=manufacturerName&itemType=itemToFilterBy&sort=direction
Bearer Token: eyxxx...

```

| Parameter | Type | Description |
| :--- | :--- | :--- |
| `name` | `string` | **Not Required**.|
| `manufacturer` | `string` | **Not Required**.|
| `itemType` | `string` | **Not Required**.|
| `sort` | `string` | **Not Required, default value = "desc"**.|

## User stories and goal:

* Persist a Bike to the PostgresDB
* Filter the bikes by name, manufacturer and item of the bike
* Request cached
* JWT for securing the endpoints

