Overview
Production-style A/B test demo using Spring Boot 3, Thymeleaf, H2 (file), and Spring Data JPA.
Users sign in, are deterministically assigned to Variant Alpha or Variant Beta (sticky via session), and button interactions are stored in H2.

Tech
Java 17+, Spring Boot 3.x (Web, Thymeleaf, Data JPA)

H2 (file mode) for metrics

Maven Wrapper (mvnw)
 
Project Structure
src/main/java/com/example/WebAppTestingAB
├─ WebAppTestingAbApplication.java      # @SpringBootApplication (root)
├─ controller/ (AuthController, DashboardController, EventApiController)
├─ model/ (ClickEvent)
├─ repository/ (ClickEventRepository)
└─ config/ (if any)
src/main/resources/templates
├─ welcome.html  # landing
├─ signin.html   # sign-in
├─ alpha.html    # Variant Alpha
└─ beta.html     # Variant Beta
src/main/resources/application.yml


Start:
# run
./mvnw spring-boot:run

# open
http://localhost:8080/
# flow: Welcome → /signin → /dashboard (Alpha or Beta)

Configuration:
spring:
thymeleaf:
cache: false
datasource:
url: jdbc:h2:file:./data/abtest;AUTO_SERVER=TRUE
driver-class-name: org.h2.Driver
username: sa
password:
jpa:
hibernate:
ddl-auto: update
show-sql: true
h2:
console:
enabled: true
server:
port: 8080

End Points:
GET / – Welcome page

GET/POST /signin – capture display name; assign variant (Alpha/Beta)

GET /dashboard – renders alpha.html or beta.html

POST /api/events – JSON body { "buttonId": "alpha-convert" } → persists a ClickEvent

GET /h2-console – DB console

JDBC URL: jdbc:h2:file:./data/abtest

User: sa, Password: (blank)

