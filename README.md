# PlataformaIVULES-backend
# IVULES - Backend API

[![Java Version](https://img.shields.io/badge/Java-11-blue.svg)](https://adoptium.net/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.8.x-orange.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)
[![Coverage](https://img.shields.io/badge/Coverage-85%25-green.svg)](https://github.com/leticiamendieta/ivules-backend/actions)

## 📋 Descripción

API RESTful desarrollada en **Spring Boot** para el sistema **IVULES**, una plataforma web para el seguimiento clínico-laboratorial de pacientes con Lupus Eritematoso Sistémico (LES).

Este backend proporciona los servicios necesarios para:
- ✅ Gestión de pacientes y seguimiento clínico
- ✅ Registro de resultados de laboratorio
- ✅ Autenticación y autorización con JWT
- ✅ Generación de reportes en Excel
- ✅ Control de acceso basado en roles (RBAC)

## 🏗️ Tecnologías

| Tecnología | Versión | Descripción |
|------------|---------|-------------|
| Java | 11 | Lenguaje base |
| Spring Boot | 2.7.x | Framework principal |
| Spring Security | 2.7.x | Autenticación y autorización |
| Spring Data JPA | 2.7.x | Persistencia |
| PostgreSQL | 13+ | Base de datos relacional |
| Maven | 3.8.x | Gestión de dependencias |
| JWT | 0.11.x | Tokens de autenticación |

## 🚀 Requisitos previos

- Java 11 o superior
- Maven 3.8+
- PostgreSQL 13+

### Base de datos

```sql
CREATE DATABASE ivules;

⚠️ AVISO: Este software fue desarrollado con fines de investigación académica. Su uso en entornos clínicos reales requiere validación institucional y cumplimiento de normativas locales de salud. Los autores no se hacen responsables por el uso indebido de la herramienta.
