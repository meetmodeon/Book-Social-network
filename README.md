# 📚 Book Social Network

> **Latest Implementation Update:** *April 27, 2025*

A **full-stack** web application built for book lovers, enabling users to connect, share, and review books — with a focus on **security**, **role management**, and **scalability**.

---

## ✨ Features

- 🔐 **Authentication and Authorization** using **Spring Security** integrated with **Keycloak**.
- 📧 **Email Verification** for new user accounts.
- 🧑‍🤝‍🧑 **Role-Based Access Control** (`Admin`, `User`, `Moderator`).
- 🐳 **Docker** and **Docker Compose** setup for both frontend and backend.
- 🛡️ **Secure APIs** protected by Keycloak tokens.
- 📚 **Manage Books**, **User Profiles**, and **Book Reviews**.

---

## 🏗️ Tech Stack

- **Frontend:** Angular
- **Backend:** Spring Boot (Java 17)
- **Authentication:** Keycloak + Spring Security
- **Database:** PostgreSQL (Dockerized)
- **Containerization:** Docker, Docker Compose
- **Mail Service:** Spring Boot JavaMailSender

---

## 🚀 Getting Started

### Prerequisites
- Docker and Docker Compose
- Java 17+
- Node.js and Angular CLI

---

### 🐳 Running with Docker Compose

```bash
docker-compose up --build
