# Gestor de Tareas

Este proyecto es un ejemplo educativo de un gestor de tareas en Java 21 usando Maven. 

## Características

## Estructura
```
src/main/java/com/ejemplo/gestortareas/
├── model/
├── repository/
├── service/
├── exception/
└── GestorTareasApp.java
src/test/java/com/ejemplo/gestortareas/
├── service/
└── integration/
```

## Cómo compilar y probar

```bash
mvn clean install
```

## Requisitos

## Licencia
MIT
# Task Manager

This project is an educational example of a task manager implemented in Java 21 using Maven.

## Features
- Modern structure following professional guidelines (records, sealed interfaces, Optional, Streams, etc.)
- Unit tests with JUnit 5
- Integration tests with Mockito (top-down approach)
- Ready for CI/CD with GitHub Actions

## Structure
```
src/main/java/com/ejemplo/gestortareas/
├── model/
├── repository/
├── service/
├── exception/
└── GestorTareasApp.java
src/test/java/com/ejemplo/gestortareas/
├── service/
└── integration/
```


## How to build and test

You can use the following Maven commands:

```bash
# Compile the source code
mvn compile

# Run unit tests
mvn test

# Build the JAR artifact
mvn package

# Run integration tests
mvn integration-test
```

## Requirements
- Java 21+
- Maven 3.9+

## License
MIT
