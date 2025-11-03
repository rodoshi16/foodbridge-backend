# Google Maps API Demo - Food Bank Finder

A RESTful backend API built with Java Spring Boot that integrates with the Google Places API to find nearby food banks. The application follows the Model-View-Controller (MVC) architecture pattern and efficiently queries location-based data, filtering results by proximity.

## 🌟 Features

- **Location-Based Search**: Query food banks near a specific location using latitude, longitude, and radius
- **Google Places API Integration**: Seamlessly integrates with Google Places API to fetch real-time location data
- **RESTful API**: Clean REST endpoint that returns structured JSON data
- **Proximity Filtering**: Filters results based on specified radius from user location
- **Efficient Data Handling**: Transforms and processes API responses into clean, structured data models
- **CORS Support**: Configured to work with frontend applications

## 🛠️ Technologies Used

- **Java 17**: Programming language
- **Spring Boot 3.4.0**: Framework for building the REST API
- **Spring Web Services**: For RESTful web service support
- **Maven**: Dependency management and build tool
- **Google Places API**: External API for location-based searches
- **Tomcat**: Embedded web server (included with Spring Boot)

## 📋 Prerequisites

Before running this project, ensure you have:

- **Java 17** or higher installed
- **Maven 3.6+** (or use the included Maven wrapper)
- **Google Places API Key** (get one from [Google Cloud Console](https://console.cloud.google.com/))

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone <repository-url>
cd google-maps-demo
```

### 2. Configure API Key

Update the API key in `src/main/java/com/rodoshi/googlemapsAPI/controller/MapController.java`:

```java
private static final String API_KEY = "YOUR_GOOGLE_PLACES_API_KEY";
```

**Note:** For production, store API keys in environment variables or a secure configuration file.

### 3. Build the Project

Using Maven wrapper (recommended):
```bash
./mvnw clean install
```

Or using Maven directly:
```bash
mvn clean install
```

### 4. Run the Application

Using Maven wrapper:
```bash
./mvnw spring-boot:run
```

Or using Maven directly:
```bash
mvn spring-boot:run
```

The application will start on **http://localhost:8080**

## 📡 API Documentation

### Endpoint: Get Nearby Food Banks

**GET** `/api/foodbanks`

Fetches a list of food banks near the specified location.

#### Query Parameters

| Parameter | Type   | Required | Description                    | Example    |
|-----------|--------|----------|--------------------------------|------------|
| `lat`     | double | Yes      | Latitude of the search location | 40.7128    |
| `lng`     | double | Yes      | Longitude of the search location| -74.0060   |
| `radius`  | int    | Yes      | Search radius in meters        | 5000       |

#### Example Request

```bash
GET http://localhost:8080/api/foodbanks?lat=40.7128&lng=-74.0060&radius=5000
```

Or using curl:
```bash
curl "http://localhost:8080/api/foodbanks?lat=40.7128&lng=-74.0060&radius=5000"
```

#### Example Response

```json
[
  {
    "latitude": 40.7128,
    "longitude": -74.0060,
    "name": "Food Bank NYC",
    "address": "123 Main St, New York, NY",
    "status": "Unknown",
    "hours": "Unknown"
  },
  {
    "latitude": 40.7580,
    "longitude": -73.9855,
    "name": "Community Food Bank",
    "address": "456 Broadway, New York, NY",
    "status": "Unknown",
    "hours": "Unknown"
  }
]
```

#### Response Fields

| Field      | Type   | Description                          |
|------------|--------|--------------------------------------|
| latitude   | Double | Latitude coordinate of the food bank |
| longitude  | Double | Longitude coordinate of the food bank|
| name       | String | Name of the food bank                |
| address    | String | Address/vicinity of the food bank    |
| status     | String | Operating status (currently "Unknown")|
| hours      | String | Operating hours (currently "Unknown") |

#### Error Handling

- **400 Bad Request**: Missing or invalid query parameters
- **500 Internal Server Error**: API key issues or Google API errors

## 📁 Project Structure

```
google-maps-demo/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/rodoshi/googlemapsAPI/
│   │   │       ├── GoogleMapsApiDemoApplication.java    # Main application entry point
│   │   │       ├── controller/
│   │   │       │   └── MapController.java               # REST controller handling API requests
│   │   │       └── Model/
│   │   │           ├── FoodBankData.java                # Data model for food bank information
│   │   │           └── MapData.java                     # Data model for map information
│   │   └── resources/
│   │       └── application.properties                    # Application configuration
│   └── test/
│       └── java/
│           └── com/rodoshi/googlemapsAPI/
│               └── GoogleMapsApiDemoApplicationTests.java
├── pom.xml                                               # Maven project configuration
├── mvnw                                                   # Maven wrapper (Unix)
└── mvnw.cmd                                               # Maven wrapper (Windows)
```

## 🏗️ Architecture

This project follows the **Model-View-Controller (MVC)** architectural pattern:

- **Model**: `FoodBankData.java` and `MapData.java` - Represent the data structure
- **View**: Frontend application (separate React/frontend project)
- **Controller**: `MapController.java` - Handles HTTP requests, processes data, and returns responses

### How It Works

1. **Client Request**: Frontend sends GET request with location parameters
2. **Controller Processing**: `MapController` receives the request and extracts parameters
3. **API Integration**: Controller builds Google Places API URL and makes HTTP request
4. **Data Transformation**: Raw API response is parsed and transformed into `FoodBankData` objects
5. **Response**: Clean, structured JSON data is returned to the client

## 🔧 Configuration

### Application Properties

Edit `src/main/resources/application.properties`:

```properties
spring.application.name=Google Maps API demo
```

### Port Configuration

By default, the application runs on port 8080. To change the port, add to `application.properties`:

```properties
server.port=8080
```

### CORS Configuration

CORS is currently configured for `http://localhost:3000`. To change this, modify the `@CrossOrigin` annotation in `MapController.java`:

```java
@CrossOrigin(origins = "http://localhost:3000")
```

## 🧪 Testing

Run the test suite:

```bash
./mvnw test
```

## 📊 Performance & Optimization

The current implementation includes:

- **Proximity-based filtering**: Results filtered server-side by Google API using radius parameter
- **Selective data extraction**: Only extracts necessary fields (name, address, coordinates) from API response
- **Lightweight models**: Clean data structures for efficient memory usage

### Future Optimizations

- Implement response caching to reduce redundant API calls
- Configure RestTemplate as a singleton bean for connection pooling
- Add result limiting and pagination
- Implement performance metrics and logging
- Add request/response compression

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## 📝 License

This project is open source and available under the MIT License.

## 👤 Author

**Rodoshi Mondal**

## 🙏 Acknowledgments

- Google Places API for location data
- Spring Boot team for the excellent framework
- Community contributors

## 📚 Additional Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Google Places API Documentation](https://developers.google.com/maps/documentation/places/web-service)
- [RESTful API Design Best Practices](https://restfulapi.net/)

---

**Note**: This is a demo project for educational purposes. Remember to secure your API keys in production environments!

