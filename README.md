# Tor IP Checker

Tor IP Checker is a service allowing to check whether provided IPv4 addresss is a Tor IP or not.

## Getting Started

This is REST API Java / Maven / Spring Boot application

### Prerequisites

Make sure you are using at least JDK 1.8 and Maven 3.X

### Installing

- Clone this repository
- Build the project by running `mvn install`
- Run the service by running `mvn spring-boot:run`

## Running the tests

Execute tests by running `mvn clean test`

## API Endpoints

### `HEAD /status` 

Check status of application
Returns `HTTP 200 OK` with empty body

### `GET /status`

Check status of application
Returns `HTTP 200 OK` with number of Tor IPs as body

example response body
```
{
"tor_exit_nodes_count": 882
}
```

### `HEAD /A.B.C.D`

Check if given ip address A.B.C.D is a Tor IP
If true, returns `HTTP 200 OK` with empty body
If false, returns `HTTP 404 Not Found`

### `GET /A.B.C.D`

Check if given ip address A.B.C.D is a Tor IP
If true, returns `HTTP 200 OK` with a JSON body containing: number of Tor IPs, date of fetching Tor IPs data and requested IP.

example response body
```
{
"tor_ip_addresses_count": 882,
"date_of_tor_ip_addresses_data": "2018-02-24 11:07:02",
"requested_ip": "223.26.48.248"
}
```

If false, returns `HTTP 404 Not Found` with empty body

## Errors

When the application cannot perform an operation it returns `HTTP 500 Internal Server Error` and JSON body with details about the error

example response body
```
{
"message": "Could not fetch Tor IP data",
"errorClass": "java.io.IOException"
}
```