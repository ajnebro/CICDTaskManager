# Task Manager

This project is an educational example of a task manager implemented in Java 21 using Maven.

## Features
- Modern structure following professional guidelines (records, sealed interfaces, Optional, Streams, guard clauses, custom exceptions)
- Unit tests with JUnit 5
- Integration tests with Mockito (top-down approach, file names ending with `IT.java`)
- Ready for CI/CD with GitHub Actions

## Project Structure
```
src/main/java/org/iips/actions/
├── model/                # Task.java (record)
├── repository/           # TaskRepository.java (sealed interface), InMemoryTaskRepository.java
├── service/              # TaskService.java
├── exception/            # TaskNotFoundException.java, InvalidTaskException.java

src/test/java/org/iips/actions/
├── model/                # TaskTest.java
├── repository/           # InMemoryTaskRepositoryTest.java
├── service/              # TaskServiceTest.java
├── exception/            # ExceptionTest.java
└── integration/          # TaskServiceIT.java (integration tests with Mockito)
```

## CI/CD Workflows: Single Job vs Multi Job

Este repositorio incluye dos versiones del workflow de GitHub Actions para ilustrar diferentes enfoques de CI/CD:

- **Single Job** (`ci-single-job.yml`): Todas las etapas (compilación, test, build, integración) se ejecutan como pasos dentro de un único job. Es más simple y suficiente para proyectos pequeños, pero limita la visibilidad y el control por etapa.
- **Multi Job** (`ci-multi-job.yml`): Cada etapa se ejecuta en un job independiente, permitiendo mayor paralelismo, control y visibilidad (por ejemplo, integración de badges por job y gestión de dependencias entre etapas).

### Ejemplo de badge por job (multi-job)

Puedes añadir un badge para cada job usando la siguiente sintaxis:
# Task Manager

This project is an educational example of a task manager in Java 21 using Maven.

## Features
- Modern structure following professional guidelines (records, sealed interfaces, Optional, Streams, guard clauses, custom exceptions)
- Unit tests with JUnit 5
- Integration tests with Mockito (top-down approach, file names ending with `IT.java`)
- Ready for CI/CD with GitHub Actions

## Project Structure
```
src/main/java/org/iips/actions/
├── model/                # Task.java (record)
├── repository/           # TaskRepository.java (sealed interface), InMemoryTaskRepository.java
├── service/              # TaskService.java
├── exception/            # TaskNotFoundException.java, InvalidTaskException.java

src/test/java/org/iips/actions/
├── model/                # TaskTest.java
├── repository/           # InMemoryTaskRepositoryTest.java
├── service/              # TaskServiceTest.java
├── exception/            # ExceptionTest.java
└── integration/          # TaskServiceIT.java (integration tests with Mockito)
```



## CI/CD Workflows: Single Job, Multi Job, and One Workflow per Stage

This repository includes three approaches to CI/CD with GitHub Actions, so you can compare their structure and badge behavior:

- **Single Job** (`ci-single-job.yml`): All stages (compile, test, build, integration) run as steps within a single job. This workflow uses a matrix to run on multiple operating systems (`ubuntu-latest`, `windows-latest`, `macos-latest`) and Java versions (21, 25), demonstrating how to test portability and compatibility across platforms and JDKs. Simpler and sufficient for small projects, but limits visibility and control per stage.
- **Multi Job** (`ci-multi-job.yml`): Each stage runs in a separate job, allowing more parallelism, control, and visibility (e.g., per-job badge integration and dependency management between stages). The badge text always shows the workflow name, not the job name.
- **One Workflow per Stage** (`compile.yml`, `test.yml`, `build.yml`, `integration-test.yml`): Each stage has its own workflow file. This allows each badge to show the name of the stage (workflow), making it clearer for educational purposes.

### Example: Badges for each approach

**Multi Job (badge text = workflow name):**

![Compile](https://github.com/ajnebro/CICDTaskManager/actions/workflows/ci-multi-job.yml/badge.svg?branch=main&job=compile)
![Test](https://github.com/ajnebro/CICDTaskManager/actions/workflows/ci-multi-job.yml/badge.svg?branch=main&job=test)
![Build](https://github.com/ajnebro/CICDTaskManager/actions/workflows/ci-multi-job.yml/badge.svg?branch=main&job=build)
![Integration Test](https://github.com/ajnebro/CICDTaskManager/actions/workflows/ci-multi-job.yml/badge.svg?branch=main&job=integration-test)

**One Workflow per Stage (badge text = stage name):**

![Compile](https://github.com/ajnebro/CICDTaskManager/actions/workflows/compile.yml/badge.svg?branch=main)
![Test](https://github.com/ajnebro/CICDTaskManager/actions/workflows/test.yml/badge.svg?branch=main)
![Build](https://github.com/ajnebro/CICDTaskManager/actions/workflows/build.yml/badge.svg?branch=main)
![Integration Test](https://github.com/ajnebro/CICDTaskManager/actions/workflows/integration-test.yml/badge.svg?branch=main)

> Note: The badge text for multi-job workflows always shows the workflow name, not the job name. With one workflow per stage, the badge text matches the stage name, which is useful for teaching and documentation.

## How to build and test

You can use the following Maven commands:

```bash
# Compile the source code
mvn compile

# Run unit tests (files ending with Test.java)
mvn test

# Build the JAR artifact
mvn package

# Run integration tests (files ending with IT.java)
mvn integration-test
```

## Main Dependencies
- Java 21+
- Maven 3.9+
- JUnit 5
- Mockito (core + mockito-junit-jupiter)

## License
MIT
