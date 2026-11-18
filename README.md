# FlugVerwaltung (Flight & Reservation Management System)

An object-oriented Java application designed to manage flights, passenger reservations, capacity utilization, and revenue calculations. Developed as part of a Software Engineering (*Softwaretechnik*) coursework project.

## Features
- **Flight Management (`Flug`):** Models flight details with automatic, unique flight number generation via static class fields.
- **Reservation Handling (`Reservierung`):** Links passengers and booked seats directly to specific flights while tracking available capacity.
- **Capacity & Revenue Analytics:** Built-in methods to calculate seat utilization percentages (*Auslastung*) and total ticket revenue (*Umsatz*) based on pricing parameters.
- **Formatted Object Output:** Custom `toString()` implementations for clear console summaries of flight statuses and booking details.
- **Test Suite:** Includes a dedicated test/main class to verify flight creation, booking scenarios, capacity limits, and revenue outputs.

## Technologies Used
- **Language:** Java (Object-Oriented Programming)
- **IDE:** IntelliJ IDEA
- **Version Control:** Git & GitHub

## Project Structure
```text
FlugVerwaltung/
├── src/
│   ├── Flug.java             # Flight entity, static ID counter, capacity & revenue logic   
│   └── ...                   # Main / test classes for scenario verification
└── README.md
