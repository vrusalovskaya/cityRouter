# City Router

## Overview

"City Router" is a web application that allows travelers to purchase tickets for routes between towns. The application calculates the most optimal travel price and handles the ticket purchasing process.

## Features

### API Endpoints

1. **Calculate Travel Price**
   - Endpoint: `/api/v1/route`
   - Method: `GET`
   - Description: Public endpoint to calculate the price of the most optimal travel between two towns in GBP.

2. **Buy Ticket**
   - Endpoint: `/api/v1/tickets`
   - Method: `POST`
   - Description: Private endpoint to save a ticket to storage if a traveler has enough money. Protected with username and password.

### Requirements

- **Public API** to calculate the price.
- **Layered Architecture**: Separation of concerns into different layers.
- **Persistence**: Ability to save successfully bought tickets.
- **Security**: Authentication for the buy ticket endpoint.
- **Logging**: Tracking and logging of application activities.
- **Documentation**: JavaDocs for the codebase.
- **Readme File**: This file for project overview and instructions.

## Stack

- **Java 21**
- **Spring Boot**
- **Spring Data**
- **Spring Security**
- **JUnit 5**
- **Mockito**
- **PostgreSQL**
- **Maven**

## Setup and Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/vrusalovskaya/cityRouter.git
   cd cityRouter
