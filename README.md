# 📡 Mobile Provider Billing System API

This is a Spring Boot-based backend project that simulates a mobile provider's billing system. It includes endpoints for user registration, usage tracking, billing calculation, and payment processing.


## 🛠️ Design Overview

This project was developed using **Java 17**, **Spring Boot**, and **PostgreSQL**, with RESTful API endpoints that follow versioning and JWT-based authentication.

### Core Components:
- **User Authentication**: JWT secured login/register endpoints.
- **Usage Tracking**: Tracks different types of usage (call, SMS, data).
- **Billing Engine**: Calculates bills based on predefined rates.
- **Payment System**: Allows full or partial payments.

### 📌 Assumptions
- Each user gets a unique subscriber ID after registration.
- Usage can only be added with a valid JWT token.
- Billing is calculated monthly based on usage logs.
- Rates are predefined and not dynamic in this version.

### 🐞 Issues Encountered
- JDBC connection failures during deployment to Render (solved by ensuring public access and credentials setup).
- JWT signature verification errors (resolved by adjusting secret and algorithm settings).
- PostgreSQL environment variables not loading in Render (fixed using Render's secret environment variable system).

---

## 🧩 Entity-Relationship (ER) Diagram

Here's a simple breakdown of the ER model:
- Subscriber

id (PK)

name

email

password

- Usage

id (PK)

subscriber_id (FK)

type (call, SMS, data)

amount

month

- Bill

id (PK)

subscriber_id (FK)

total_amount

is_paid

month

- Payment

id (PK)

bill_id (FK)

amount_paid

payment_date


The project is deployed using:
- **Render.com** (App Service)
- **PostgreSQL** database (Azure or Render hosted)
- **Key Vault** for secure secret management

---

## 🚀 Getting Started

```bash
# Clone the repository
git clone https://github.com/yourusername/mobile-billing-api.git
cd mobile-billing-api

# Run locally (requires Java 17 and Maven)
mvn spring-boot:run

