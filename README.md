# Consultorio (en progreso) — Agenda de pacientes (Backend)

Proyecto personal para construir un backend de gestión de agenda/citas para un consultorio odontológico.

> Estado: **En progreso** (MVP por fases). El objetivo es avanzar por capas: entidades → repositorios → servicios → endpoints → seguridad.

## Objetivo
Practicar desarrollo backend con enfoque en buenas prácticas:
- Diseño por capas / enfoque tipo DDD (en construcción)
- Persistencia con base de datos
- Pruebas con JUnit (primero repositorios, luego servicios)
- Documentación y versionamiento con Git

## Tecnologías (nivel actual)
- Java
- Spring Boot (REST, servicios, repositorios)
- PostgreSQL (aprendiendo) + Docker (aprendiendo)
- JUnit 5

## Arquitectura (idea general)
- **Domain**: entidades y reglas
- **Repository**: persistencia
- **Service**: lógica de negocio
- **API/Controller**: endpoints REST
- **Security**: Spring Security (nivel introductorio, planificado)

## Cómo ejecutar (opciones)
### Opción A — PostgreSQL con Docker (recomendado)
> Si aún no tienes `docker-compose.yml`, puedes crear uno o levantar Postgres manualmente.

1. Levanta PostgreSQL (Docker)
2. ## Configuración (sin credenciales hardcoded)
Este proyecto **no** almacena credenciales en `application.properties`. La configuración se maneja por **variables de entorno** (por ejemplo, desde IntelliJ) y/o al levantar PostgreSQL en Docker.

### Variables de entorno (ejemplo)
Configura las variables en tu entorno o en la configuración de ejecución del IDE:

- DB_URL
- DB_USERNAME
- DB_PASSWORD


3. ## Cómo ejecutar

### 1) Base de datos con Docker (PostgreSQL)
Puedes levantar PostgreSQL pasando credenciales por variables de entorno:

```bash
docker run --name consultorio-postgres \
  -e POSTGRES_DB=consultorio \
  -e POSTGRES_USER=usuario \
  -e POSTGRES_PASSWORD=clave \
  -p 5432:5432 \
  -d postgres
```
4. ## Ejecuta la app:
```bash
./mvnw spring-boot:run
```

## Pruebas

Las pruebas se ejecutan con JUnit 5. Actualmente se están trabajando primero pruebas de repositorios y luego servicios.
```bash
./mvnw test
```


