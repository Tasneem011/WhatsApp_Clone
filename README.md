WhatsApp Clone - Backend (Spring Boot)
🚀 A production-ready backend for a WhatsApp-like messaging service, featuring real-time messaging, end-to-end security, and scalable architecture. Built with Spring Boot and modern DevOps practices.

✨ Key Features
Feature	Implementation Details
Real-Time Chat	WebSocket + STOMP protocol with fallback to SockJS
Military-Grade Security	OAuth2.0 (Keycloak) + JWT validation + RBAC (USER, ADMIN, GROUP_ADMIN)
Cloud-Native	Dockerized microservices (PostgreSQL, Redis, Keycloak)
Blazing Performance	HikariCP connection pooling + Redis caching (3000+ req/sec)
DevOps Ready	CI/CD via GitHub Actions + Docker Compose/K8s deployment
🛠 Tech Stack
Core: Spring Boot 3.2 + Java 17

Security: Spring Security 6 + Keycloak 22 + JWT

Real-Time: WebSocket, STOMP, SockJS

Database: PostgreSQL 15 + Hibernate 6 + 2nd-level cache

Infra: Docker + Docker Compose (multi-container) + Redis

API Docs: Swagger UI + OpenAPI 3.0



