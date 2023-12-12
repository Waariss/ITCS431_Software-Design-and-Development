# GEMINI-4

## Team Members

|  No.  |             Name             |   ID    | 
| :---: | :--------------------------: | :-----: |
|   1   |         Waris Damkham        | 6388014 | 
|   2   |    Chatkawin Phongpawarit    | 6388041 | 
|   3   |      Chanisara Kotrachai     | 6388087 |

# General Information
## Selected use cases
- Login
- Create a science plan
- Test a science plan
- Submit a science plan

## Updated use case descriptions, activity diagrams, class diagram and sequence diagrams
https://github.com/Waariss/ITCS431_Software-Design-and-Development/tree/main/Gemini/design

## Design Pattern
The design pattern used in this phase is called Singleton because it enables us to ensure that a class has only one instance while providing a global access point to this instance, as in the case of this example, ModelMapper.java, where the ocs is a single instance that is accessible to all clients.
```json
public class ModelMapper {
    static OCS ocs = new OCS(true);
    
    public static OCS getInstance() {
        return ocs;
    }
    .....
}
```
# Instruction

- Clone this GitHub Repo and access this folder.
- Run servers
  - Access to folder `implementations` and run `./gradlew spring-boot:run` to start a server

# Technology used in this project

## Frontend : 
- Thymeleaf – Java template 
-  CSS – CSS Framework
- JavaScript - Frontend

## Backend: Spring Boot
- Spring Boot – Framework
- H2 Database – Database
- Gemini – OCS Module

# User Database

|  uID  |   Firstname    |      Lastname      |       Email       |    Username    |  Password  |        Role        |
| :---: | :------------: | :----------------: | :---------------: | :------------: | :--------: | :----------------: |
|   1   |    Waris       |     Damkham        |  waris@gemini4.dev  |  Test1   | Test1|   ADMINISTRATOR    |
|   2   | Chanisara      |    Kotrachai       |  chanisra@gemini4.dev   |   Test2    | Test2 |     ASTRONOMER     |

# API Endpoints

## Use case 1: Login
### POST `/login` – Login to the system 

- In Postman, create a new POST request with the /login URL (e.g., http://localhost:8080/login).
- Select the "Body" tab below the URL input field.
- Choose the "x-www-form-urlencoded" radio button.
- Add two key-value pairs:

  Key: username, Value: Test1
  
  Key: password, Value: Test1
  
- Click "Send" to make the request.

### POST `/admin/adduser` – Create a new user

```json
Request: POST /admin/adduser
{
  "username": "Test1",
  "password": "Test1",
  "firstName": "Test",
  "lastName": "User",
  "email": "TEST.user@gmail.com",
  "role": "Astronomer"
}
Response: 200 OK
```

## Use case 2: Create Science Plan

### GET `/api/science_plan` – Get All Science Plan in the System

```json
Request: GET /api/science_plan
Response: 200 OK
[
  {
    "planNo": 1,
    "creator": "John Doe",
    "submitter": "John Doe",
    "fundingInUSD": 1000.0,
    "objectives": "1. To explore Neptune.\n2. To collect astronomical data for future research.",
    "starSystem": "Andromeda",
    "startDate": "2021-04-15 09:00:00",
    "endDate": "2021-04-15 10:00:00",
    "telescopeLocation": "HAWAII",
    "dataProcRequirements": {
      "fileType": "PNG",
      "fileQuality": "Fine",
      "colorType": "B&W mode",
      "contrast": 20.0,
      "brightness": 0.0,
      "saturation": 0.0,
      "highlights": 10.0,
      "exposure": 15.0,
      "shadows": 5.0,
      "whites": 7.0,
      "blacks": 10.0,
      "luminance": 0.0,
      "hue": 0.0
    },
    "status": "SUBMITTED"
  },
  {
    "planNo": 2,
    "creator": "Jane Dunn",
    "submitter": "Andrew Griffin",
    "fundingInUSD": 2500.0,
    "objectives": "1. To explore Mars.\n2. To collect astronomical data for future research.",
    "starSystem": "Antlia",
    "startDate": "2021-05-15 13:00:00",
    "endDate": "2021-05-15 15:00:00",
    "telescopeLocation": "CHILE",
    "dataProcRequirements": {
      "fileType": "JPEG",
      "fileQuality": "Low",
      "colorType": "Color mode",
      "contrast": 11.0,
      "brightness": 10.0,
      "saturation": 5.0,
      "highlights": 0.0,
      "exposure": 7.0,
      "shadows": 0.0,
      "whites": 0.0,
      "blacks": 0.0,
      "luminance": 10.0,
      "hue": 8.0
    },
    "status": "SUBMITTED"
  }
]
```

### GET `/api/science_plan/{planNo}` – Get a Science Plan by Plan No

```json
Request: GET /api/science_plan/1
Response: 200 OK
{
  "planNo": 1,
  "creator": "John Doe",
  "submitter": "John Doe",
  "fundingInUSD": 1000.0,
  "objectives": "1. To explore Neptune.\n2. To collect astronomical data for future research.",
  "starSystem": "Andromeda",
  "startDate": "2021-04-15 09:00:00",
  "endDate": "2021-04-15 10:00:00",
  "telescopeLocation": "HAWAII",
  "dataProcRequirements": {
    "fileType": "PNG",
    "fileQuality": "Fine",
    "colorType": "B&W mode",
    "contrast": 20.0,
    "brightness": 0.0,
    "saturation": 0.0,
    "highlights": 10.0,
    "exposure": 15.0,
    "shadows": 5.0,
    "whites": 7.0,
    "blacks": 10.0,
    "luminance": 0.0,
    "hue": 0.0
  },
  "status": "SUBMITTED"
}
```

### POST `/api/science_plan` – Create a Science Plan

```json
Request: POST /api/science_plan
{
  {
    "creator": "Morakot Choetkiertikul",
    "submitter": "Chaiyong Ragkhitwetsagul",
    "fundingInUSD": 1000.0,
    "objectives": "To study the Auriga star system.",
    "starSystem": "Auriga",
    "startDate": "22/02/2021 23:00:00",
    "endDate": "23/02/2021 02:00:00",
    "telescopeLocation": "HAWAII",
    "dataProcRequirements":
        {
            "fileType": "JPEG",
            "fileQuality": "Low",
            "colorType": "Color mode",
            "contrast": 0.0,
            "brightness": 10.0,
            "saturation": 5.0,
            "highlights": 0.0,
            "exposure": 7.0,
            "shadows": 0.0,
            "whites": 0.0,
            "blacks": 0.0,
            "luminance": 10.0,
            "hue": 8.0
        },
    "status": "SAVED"
  }
}

Response: 200 OK
{
    "planNo": 3,
    "creator": "Morakot Choetkiertikul",
    "submitter": "Chaiyong Ragkhitwetsagul",
    "fundingInUSD": 1000.0,
    "objectives": "To study the Auriga star system.",
    "starSystem": "Auriga",
    "startDate": "2021-02-22 23:00:00",
    "endDate": "2021-02-23 02:00:00",
    "telescopeLocation": "HAWAII",
    "dataProcRequirements": [
        {
            "fileType": "JPEG",
            "fileQuality": "Low",
            "colorType": "Color mode",
            "contrast": 0.0,
            "brightness": 10.0,
            "saturation": 5.0,
            "highlights": 0.0,
            "exposure": 7.0,
            "shadows": 0.0,
            "whites": 0.0,
            "blacks": 0.0,
            "luminance": 10.0,
            "hue": 8.0
        }
    ],
    "status": "SAVED"
}
```

### DELETE `/api/science_plan/{planNo}` – Delete a Science Plan by Plan No

```json
Request: DELETE /api/science_plan/1
Response: 200 OK
```

### DELETE `/api/science_plan` – Delete all Science Plan in the system

```json
Request: DELETE /api/science_plan
Response: 200 OK
```


## Use Case 3: Test Science plan 

### GET `/api/science_plan/test/{planNo}` - Test Science Plan with Plan No

```json
  Request: GET /api/science_plan/test/{planNo}
  Response: 200 OK
  TEST RESULTS:
  testSelectedStarSystem: OK
  Image processing configuration: OK
  Telescope Location: OK
  testDuration: OK.
```

## Use Case 4: Submit Science Plan

### POST `/api/science_plan/submit/{planNo}` - Submit Science Plan with Plan No

```json
Request: GET /api/science_plan/submit/{planNo}
  Response: 200 OK
```
