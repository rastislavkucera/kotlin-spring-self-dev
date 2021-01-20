## Kotlin + Spring Self development
Based on [Crypto Exchange self-dev example project](https://docs.google.com/document/d/1V2myhqjxi_seDJlUChEq9saD0BtnAVX3dGQuE6csbxQ/edit#heading=h.4h9dx0ukq9l4).

Aim:
- Lear Kotlin
- Lear Spring
- get good

## Self-Dev Road map
(Various topics I want to touch on)
- [x] Use swagger
- [ ] Use oauth2
- [x] Use postgres with JPA
- [ ] Use File watcher for auto project reload
- [ ] Spring migration management (Flyway / Liquibase)
- [ ] :small_red_triangle_down: Use pre-commit hook for code formatting (possibly gradle task ?)
- [ ] :small_red_triangle_down: Deploy React app with this for FE - [See this](https://spring.io/guides/tutorials/react-and-spring-data-rest/#_defining_an_html_template)

## Exchange Project Dev Road map
- [ ] Users with Oauth2 (Auth)
  - [ ] User registration
  - [ ] User login / authentication
  - [ ] User logout
  - [ ] User interaction scopes
    - [ ] Read only (cannot place orders)
    - [ ] Full (can place orders)
- [ ] Change DB to auto-update
- [ ] User balance (Auth)
  - [ ] USD - BTC
- [ ] Publicly accessible Order book
  - [ ] current state
  - [ ] order book "snapshot" in given time
- [ ] User orders (Auth)
  - [ ] Simple (Market) order (Immediately satisfied)
  - [ ] Standing order
- [ ] :small_red_triangle_down: Add unit tests for critical functionality
- [ ] :small_red_triangle_down: User management similar to Django Admin
- [ ] :small_red_triangle_down: "Test Net" mode
  - [ ] Randomly create users with random funds
  - [ ] Create random orders with random bot users
  - [ ] Allow real users to participate in test net (with fake funds)

## How to run
We assume that you already have Kotlin, Java, Postgres and other dependencies installed

### Setup DB
`sudo su - postgres`

`psql`

```
CREATE DATABASE exchange;
CREATE USER exchange WITH PASSWORD 'exchange';
GRANT ALL PRIVILEGES ON DATABASE exchange TO exchange;
```

### Run Project
In root, run:
`./gradlew bootRun`

Project will run on `localhost:8080`

### Swagger
You can access Swagger on `localhost:8080/swagger`