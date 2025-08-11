# IT Scenario Generator

A Spring Boot REST API that generates realistic, random IT scenarios based on user inputs for technology, role, and environment. It uses predefined datasets to create a challenge, incident, and troubleshooting step tailored to the inputs, making it useful for training, simulations, and role-based exercises.

---

## Features

- Accepts validated user inputs for:  
  - Technology (e.g., Cloud Computing, Cybersecurity, DevOps)  
  - Role (e.g., System Administrator, Software Engineer, Security Analyst)  
  - Environment (e.g., Enterprise Network, Cloud Infrastructure, On-Prem Data Center)  
- Randomly generates:  
  - Challenge  
  - Incident  
  - Troubleshooting step  
  - (Easily extendable with more scenario elements)  
- Input validation using Jakarta Bean Validation  
- Centralized global exception handling  
- TDD-style unit tests using JUnit 5  

---

## Tech Stack

- Java 20  
- Spring Boot  
- REST API  
- JUnit 5 (Testing)  

---

## Installation

### Prerequisites

- Java 20+  
- Maven  
- Git  

### Steps

# Clone the repository
git clone https://github.com/your-username/random-it-scenario-generator.git
cd random-it-scenario-generator

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run

The API will be available at:  
`http://localhost:8080`

---

## API Usage

### Endpoint

`POST /api/scenario/generate`

```json
{
  "technology": "Cloud Computing",
  "role": "System Administrator",
  "environment": "Cloud Infrastructure"
}
```

## Example cURL Command

```bash
curl -X POST http://localhost:8080/api/scenario/generate \
  -H "Content-Type: application/json" \
  -d '{ "technology": "Cloud Computing", "role": "System Administrator", "environment": "Cloud Infrastructure" }'
```

## Example Response

```json
{
  "technology": "Cloud Computing",
  "role": "System Administrator",
  "environment": "Cloud Infrastructure",
  "challenge": "Managing multi-cloud resource optimization",
  "incident": "Unexpected downtime in cloud storage service",
  "troubleshootingStep": "Check cloud provider status dashboard"
}
```

## Application Flow

```plaintext
+--------------+     +----------------+     +----------------+     +------------------+
|    Client    | --> |   Controller   | --> |    Service     | --> | Dataset & Logic  |
| (Postman,    |     | (API Endpoint) |     | (Business Logic)|     | (Random Scenario |
|  cURL, etc.) |     |                |     |                |     |   Generation)    |
+--------------+     +----------------+     +----------------+     +------------------+
                            |                                               ^
                            |                                               |
                            +------------------ Response (JSON) ------------+

```

## Flow Explanation

- Client sends a POST request with technology, role, and environment.  
- Controller receives and validates the request.  
- Service checks datasets and randomly picks appropriate challenge, incident, and troubleshooting step.  
- Dataset & Logic ensures variety and realism in generated scenarios.  
- Response is returned as JSON.

## Testing

Run all unit tests:

```bash
mvn test
```

## Error Handling

Example validation error response:

```json
{
    "timestamp": "2025-08-11T15:29:16.20362",
    "status": 400,
    "errors": [
        "technology: Technology must not be blank"
    ]
}
```

## TDD Approach

This project follows a Test Driven Development (TDD) methodology:

- Write failing unit tests for service logic and input validation.
- Implement functionality to pass the tests.
- Refactor and enhance code while keeping tests green.

## Future Enhancements

- Add more scenario categories (e.g., Security Breaches, Performance Tuning, Disaster Recovery)
- Integrate with a database for dynamic data storage instead of hardcoded datasets
- Add user authentication to save and track generated scenarios
- Support multiple random scenarios per request
- Create a frontend dashboard for interactive scenario generation
- Export scenarios as PDF or CSV
- Integrate AI models for more realistic, context-aware scenario generation

## License

This project is licensed under the MIT License.
