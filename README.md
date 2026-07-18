# Spring Boot DevOps Demo

Proyecto desarrollado como portafolio para aprender el ciclo completo de desarrollo y DevOps utilizando Java y Spring Boot.

## Objetivo

Construir una API REST sencilla siguiendo buenas prácticas de desarrollo y automatizar todo el ciclo de integración y despliegue continuo (CI/CD).

## Tecnologías

* Java 17
* Spring Boot
* Maven
* Spring Data JPA
* PostgreSQL
* MapStruct
* Bean Validation
* Springdoc OpenAPI (Swagger)
* SLF4J / Logback

## Arquitectura

El proyecto utiliza una arquitectura por capas:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
PostgreSQL
```

Además incorpora:

* DTOs
* Mapper con MapStruct
* Manejo global de excepciones
* Auditoría automática con Spring Data JPA
* Validaciones con Bean Validation

## Endpoints

| Método | Endpoint               | Descripción                 |
| ------ | ---------------------- | --------------------------- |
| GET    | /api/v1/employees      | Obtener todos los empleados |
| GET    | /api/v1/employees/{id} | Obtener un empleado por ID  |
| POST   | /api/v1/employees      | Crear empleado              |
| PUT    | /api/v1/employees/{id} | Actualizar empleado         |
| DELETE | /api/v1/employees/{id} | Eliminar empleado           |

## Ejecutar el proyecto

### Clonar

```bash
git clone <URL_DEL_REPOSITORIO>
```

### Configurar PostgreSQL

Actualizar el archivo:

```text
src/main/resources/application.yml
```

con las credenciales de la base de datos.

### Ejecutar

```bash
mvn spring-boot:run
```

### Swagger

```
http://localhost:8080/swagger-ui/index.html
```

## Próximas etapas

* Testing con JUnit 5
* Mockito
* JaCoCo
* SonarCloud
* Fortify
* Docker
* Kubernetes
* GitHub Actions
* Azure Kubernetes Service (AKS)

## Estado del proyecto

🚧 En desarrollo.
