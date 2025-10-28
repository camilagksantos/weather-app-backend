# ☕ Weather App Backend

A Spring Boot REST API service that provides weather data management and integration with external weather APIs. Built with clean architecture principles and modern Java practices.

![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3-green?logo=springboot)
![Maven](https://img.shields.io/badge/Maven-3.9-red?logo=apachemaven)
![License](https://img.shields.io/badge/License-MIT-blue)

---

## 📋 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [Architecture](#-architecture)
- [Tech Stack](#-tech-stack)
- [Getting Started](#-getting-started)
- [API Documentation](#-api-documentation)
- [Project Structure](#-project-structure)
- [Configuration](#-configuration)
- [Development](#-development)

---

## 🎯 Overview

The Weather App Backend is a RESTful API service that acts as the data layer for the Weather App ecosystem. It integrates with the OpenWeatherMap API to fetch real-time weather data and exposes clean, well-structured endpoints for consumption by the Node.js BFF layer.

**Key Highlights:**
- Clean Architecture with separated concerns
- HTTP Interface for declarative API calls
- DTO pattern for data transfer
- CORS-enabled for BFF integration
- Type-safe with Java 21 features

---

## ✨ Features

### 🌐 Weather Data Integration
- Real-time weather information fetching
- OpenWeatherMap API integration
- Automatic JSON to Object mapping

### 🏗️ Clean Architecture
- **Controllers**: HTTP request handling
- **Services**: Business logic orchestration
- **HTTP Clients**: External API communication
- **DTOs**: Data transfer objects
- **Models**: Domain entities

### 🔒 Security & Configuration
- CORS configuration for BFF communication
- Externalized configuration with properties
- Environment-based setup

### 📊 Best Practices
- Constructor injection (no field injection)
- Interface-based HTTP clients
- Separation of concerns
- RESTful API design

---

## 🏗️ Architecture

```
┌─────────────┐      ┌──────────────┐      ┌─────────────────┐
│  Node.js    │ ───► │  Spring Boot │ ───► │ OpenWeatherMap  │
│    BFF      │      │   Backend    │      │      API        │
│ Port: 3000  │      │  Port: 8080  │      └─────────────────┘
└─────────────┘      └──────────────┘
```

### Request Flow

```
HTTP Request
    ↓
Controller (REST endpoint)
    ↓
Service (Business logic)
    ↓
WeatherApiService (Orchestration)
    ↓
WeatherApiClient (HTTP Interface)
    ↓
RestClient (HTTP call)
    ↓
OpenWeatherMap API
    ↓
JSON Response → WeatherData (Model)
    ↓
WeatherDataResponseDto
    ↓
HTTP Response
```

---

## 🛠️ Tech Stack

### Core
- **Java:** 21 (LTS)
- **Spring Boot:** 3.3.x
- **Maven:** 3.9+

### Spring Modules
- **Spring Web:** REST API
- **Spring Boot DevTools:** Hot reload
- **RestClient:** HTTP communication

### External APIs
- **OpenWeatherMap API:** Weather data

---

## 🚀 Getting Started

### Prerequisites

- Java 21 or higher
- Maven 3.9 or higher
- OpenWeatherMap API key ([Get one here](https://openweathermap.org/api))

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/weather-app-backend.git
   cd weather-app-backend
   ```

2. **Configure API key**
   
   Edit `src/main/resources/application.properties`:
   ```properties
   openweather.api.key=YOUR_API_KEY_HERE
   ```

3. **Build the project**
   ```bash
   ./mvnw clean install
   ```

4. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

5. **Access the API**
   ```
   http://localhost:8080/api/weather?city=London
   ```

---

## 📡 API Documentation

### Base URL
```
http://localhost:8080
```

### Endpoints

#### Get Weather Data

**GET** `/api/weather`

Fetch current weather data for a specific city.

**Query Parameters:**

| Parameter | Type | Required | Description |
|-----------|------|----------|-------------|
| `city` | string | Yes | City name (e.g., "London", "New York") |

**Example Request:**
```bash
curl "http://localhost:8080/api/weather?city=London"
```

**Success Response (200 OK):**
```json
{
  "data": {
    "coord": {
      "lon": -0.1257,
      "lat": 51.5085
    },
    "weather": [
      {
        "id": 800,
        "main": "Clear",
        "description": "clear sky",
        "icon": "01d"
      }
    ],
    "base": "stations",
    "main": {
      "temp": 15.5,
      "feels_like": 14.8,
      "temp_min": 14.2,
      "temp_max": 17.1,
      "pressure": 1013,
      "humidity": 72
    },
    "visibility": 10000,
    "wind": {
      "speed": 5.5,
      "deg": 230
    },
    "clouds": {
      "all": 0
    },
    "dt": 1698409200,
    "sys": {
      "type": 2,
      "id": 2019646,
      "country": "GB",
      "sunrise": 1698386400,
      "sunset": 1698422400
    },
    "timezone": 3600,
    "id": 2643743,
    "name": "London",
    "cod": 200
  }
}
```

**Error Response (400 Bad Request):**
```json
{
  "timestamp": "2025-10-28T10:00:00.000+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Required request parameter 'city' is not present",
  "path": "/api/weather"
}
```

---

## 📁 Project Structure

```
weather-app-backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/study/weather_app_backend/
│   │   │       ├── config/
│   │   │       │   └── RestClientConfig.java
│   │   │       ├── controller/
│   │   │       │   └── WeatherDataController.java
│   │   │       ├── dto/
│   │   │       │   ├── WeatherDataRequestDto.java
│   │   │       │   └── WeatherDataResponseDto.java
│   │   │       ├── httpClient/
│   │   │       │   ├── WeatherApiClient.java (interface)
│   │   │       │   └── WeatherApiService.java
│   │   │       ├── model/
│   │   │       │   ├── WeatherData.java
│   │   │       │   └── weather/
│   │   │       │       ├── Clouds.java
│   │   │       │       ├── Coord.java
│   │   │       │       ├── Main.java
│   │   │       │       ├── Sys.java
│   │   │       │       ├── Weather.java
│   │   │       │       └── Wind.java
│   │   │       ├── service/
│   │   │       │   └── WeatherDataService.java
│   │   │       └── WeatherAppBackendApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

### Key Components

- **config/** - Spring configuration classes (RestClient setup)
- **controller/** - REST API endpoints
- **dto/** - Data Transfer Objects for requests/responses
- **httpClient/** - HTTP Interface and API service
- **model/** - Domain entities (WeatherData and sub-models)
- **service/** - Business logic layer

---

## ⚙️ Configuration

### application.properties

```properties
# Server Configuration
server.port=8080

# OpenWeatherMap API
openweather.api.key=your_api_key_here
openweather.api.url=https://api.openweathermap.org/data/2.5

# CORS Configuration (handled in Controller)
# Allows requests from Node.js BFF (port 3000)
```

### Environment Variables

You can override properties using environment variables:

```bash
export OPENWEATHER_API_KEY=your_api_key
export OPENWEATHER_API_URL=https://api.openweathermap.org/data/2.5
export SERVER_PORT=8080
```

---

## 💻 Development

### Running in Development Mode

```bash
./mvnw spring-boot:run
```

The application will start with:
- Hot reload enabled (DevTools)
- Port: 8080
- Profile: default

### Building for Production

```bash
./mvnw clean package
java -jar target/weather-app-backend-0.0.1-SNAPSHOT.jar
```

### Running Tests

```bash
./mvnw test
```

---

## 🔄 Integration with BFF

The backend is designed to work seamlessly with the Node.js BFF:

1. **BFF calls backend:**
   ```javascript
   // Node.js BFF
   const response = await axios.get('http://localhost:8080/api/weather', {
     params: { city: 'London' }
   });
   ```

2. **Backend processes and returns data:**
   ```java
   // Spring Boot
   @GetMapping
   public ResponseEntity<WeatherDataResponseDto> getWeather(@RequestParam String city) {
       return ResponseEntity.ok(weatherDataService.getWeatherData(city));
   }
   ```

3. **CORS is configured to allow BFF:**
   ```java
   @CrossOrigin(origins = "http://localhost:3000")
   ```

---

## 🎨 Design Patterns

### HTTP Interface Pattern
```java
public interface WeatherApiClient {
    @GetExchange("/weather")
    WeatherData getWeatherByCity(@RequestParam("q") String city,
                                  @RequestParam("appid") String apiKey,
                                  @RequestParam("units") String units);
}
```
Spring automatically implements this interface!

### DTO Pattern
```java
public class WeatherDataResponseDto {
    private WeatherData data;
    // Separates internal models from API responses
}
```

### Constructor Injection
```java
public class WeatherApiService {
    private final WeatherApiClient weatherApiClient;
    
    public WeatherApiService(WeatherApiClient weatherApiClient) {
        this.weatherApiClient = weatherApiClient;
    }
}
```

---

## 🐛 Troubleshooting

### Common Issues

**Issue:** Application fails to start
```
Solution: Check if port 8080 is available
lsof -ti:8080 | xargs kill -9
```

**Issue:** API returns 401 Unauthorized
```
Solution: Verify your OpenWeatherMap API key in application.properties
```

**Issue:** CORS error from BFF
```
Solution: Ensure @CrossOrigin(origins = "http://localhost:3000") is present in Controller
```

**Issue:** City not found (404)
```
Solution: Check city name spelling. OpenWeatherMap is case-insensitive but requires exact names
```

---

## 🚀 Future Enhancements

- [ ] Database integration (PostgreSQL)
- [ ] Caching layer (Redis)
- [ ] Weather forecast endpoints
- [ ] Historical data storage
- [ ] User favorites management
- [ ] Authentication & Authorization (JWT)
- [ ] Rate limiting
- [ ] API documentation (Swagger/OpenAPI)
- [ ] Unit and integration tests
- [ ] Docker containerization
- [ ] CI/CD pipeline

---

## 📄 License

This project is licensed under the MIT License.

---

## 👤 Author

**Camila Kfouri**

- GitHub: [@camilagksantos](https://github.com/camilagksantos)
- Project Date: October 2025

---

## 🙏 Acknowledgments

- [OpenWeatherMap](https://openweathermap.org/) for the weather API
- [Spring Boot](https://spring.io/projects/spring-boot) for the framework
- [Java](https://www.oracle.com/java/) for the platform

---

<div align="center">
  Made with ☕ and Spring Boot
</div>
