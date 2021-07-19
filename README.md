# Clean - API

Api using kotlin and spring boot based in clean architecture structure
- Unit tests
    - mocck
    - assertJ
    - junit 5
- Different ways for implementation integration tests
    - AutoConfigureMockMvc (SpringBootTest) 
    - TestRestTemplate (SpringBootTest)
    - WebMvcTest
- String data
- Spring web

# Install
mvn clean install -DskipTests

# Run
mvn clean spring-boot:run -pl application 

# Tests
mvn clean test

# Simple Structure
- mainModule
  - application
      - config
      - controller 
      - converter
      - Application.kt
  - domain
      - entity
      - services
  - repository
    - data
    - repository 
      - person
  - usecase
     - base
      - person
        - request
        - response
  
## TODO
...






