****FarmCollector API****

**Overview**

FarmCollector is a Spring Boot application that collects and reports planting and harvesting data from farms. The application provides RESTful endpoints for managing planting and harvesting data for farms. It uses Springdoc OpenAPI to automatically generate and serve API documentation via Swagger UI.

**Features:**

Planting data management (crop type, area planted, expected harvest).

Harvesting data management (actual harvest).

OpenAPI documentation served via Swagger UI.

**Prerequisites**
Before running this application, ensure you have the following installed:

Java 17 or later.
Maven to build the application.
Spring Boot 3.x (the application is based on Spring Boot 3.x).

**Project Structure**
**Key Packages:**

com.farmcollector.controller: Contains REST controllers for the endpoints.

com.farmcollector.service: Contains business logic for processing data.

com.farmcollector.model: Contains the domain model for planting and harvesting data.

com.farmcollector.config: Contains configuration for Springdoc OpenAPI.

**API Endpoints**

**1. Create Planting Data**

URL: /api/farm/{farmId}/planting

Method: POST

Description: Adds new planting data for a specific farm.

Request Body:

json
{
  "cropType": "Corn",
  "areaPlanted": 10.5,
  "expectedAmount": 25.0
}

Response: HTTP 201 (Created) with the created planting data.

**Swagger UI Documentation**

Springdoc OpenAPI generates API documentation for this project, and it is available through Swagger UI.


Access Swagger UI

After running the application, you can access the Swagger UI at:

http://localhost:8080/farmcollector/swagger-ui.html

Swagger UI will allow you to interact with the API and view detailed documentation for each endpoint.

Example Response in Swagger UI:

Click on any API method (e.g., POST /api/farm/{farmId}/planting) to see the detailed request body, response, and status codes.



**Running the Application**

To run the application locally:

Clone the repository:

git clone https://github.com/your-username/farmcollector.git

cd farmcollector

Build and run the application using Maven:

mvn clean spring-boot:run

This will start the application on port 8080 by default.

You can access the application at:

API Endpoints: http://localhost:8080/farmcollector/api/farm/{farmId}/planting (for planting data), http://localhost:8080/api/farm/{farmId}/harvest (for harvest data).

Swagger UI: http://localhost:8080/farmcollector.swagger-ui.html for interactive API documentation.
