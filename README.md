# Student Skill & Career Path Analyzer

## Overview

Student Skill & Career Path Analyzer is a Java-based console application that analyzes a student's technical and soft skills and identifies suitable career paths.

The application compares the student's current skill levels with the required skills for different career roles and generates a career match score, skill-gap analysis, and personalized learning roadmap.

## Objectives

* Analyze student technical and soft skills
* Calculate an overall skill score
* Compare skills with career requirements
* Identify suitable career paths
* Detect skill gaps
* Generate a personalized learning roadmap
* Save career analysis reports

## Features

* Student profile creation
* CGPA input and validation
* Technical and soft skill assessment
* Overall skill score calculation
* Strongest and weakest skill identification
* Career matching algorithm
* Career ranking based on match percentage
* Skill-gap analysis
* Personalized learning roadmap
* File-based report generation
* Input validation
* Exception handling
* Career database

## Career Paths

The current version includes:

* Software Developer
* Backend Developer
* Data Analyst
* AI/ML Engineer
* Cyber Security Analyst
* Project Manager

## Technologies Used

* Java
* Object-Oriented Programming
* Java Collections Framework
* ArrayList
* HashMap
* File Handling
* Exception Handling
* Java 8+

## Java Concepts Demonstrated

### Classes and Objects

Classes are used to represent students, skills and careers.

### Encapsulation

Student and skill information is stored using private fields with public getter methods.

### Inheritance

`TechnicalCareer` and `NonTechnicalCareer` inherit from the abstract `Career` class.

### Polymorphism

Different career objects are handled through the common `Career` reference.

### Abstraction

`Career` is an abstract class and defines the common structure of different career types.

### Interfaces

The project structure can be extended with interfaces for analysis and recommendation services.

### Collections

`ArrayList` is used for storing skills and careers, while `HashMap` stores skill scores and career requirements.

### Exception Handling

Invalid numerical input is handled using `try-catch`.

### File Handling

Career analysis reports are saved as `.txt` files.

## Project Structure

```text
Student-Skill-Career-Analyzer/
│
├── src/
│   └── com/
│       └── careeranalyzer/
│           ├── Main.java
│           ├── model/
│           ├── analyzer/
│           ├── recommendation/
│           ├── service/
│           └── util/
│
├── data/
│   └── career_data.txt
│
├── output/
│   └── reports/
│
├── README.md
├── .gitignore
└── LICENSE
```

## How the Matching Works

For each career, the application compares the student's score with the required score.

The basic matching calculation is:

```text
Match Percentage =
(Student Skill Score / Required Skill Score) × 100
```

A value above 100% is capped at 100%.

The final career match is calculated using the average match across all required skills for that career.

## Example

If a career requires:

```text
Java = 80
SQL = 70
Problem Solving = 75
```

and the student has:

```text
Java = 90
SQL = 60
Problem Solving = 80
```

the program calculates individual skill matches and uses their average to determine the career match score.

## How to Run

### 1. Clone the repository

```bash
git clone <your-repository-url>
```

### 2. Open the project

Open the project in:

* IntelliJ IDEA
* Eclipse
* VS Code

### 3. Locate Main.java

```text
src/com/careeranalyzer/Main.java
```

### 4. Run Main.java

The application will display the main menu.

## Sample Workflow

```text
1. Start Career Analysis
2. View Career Database
3. Exit
```

Select:

```text
1
```

Enter the student's profile and skill scores.

The application then displays:

```text
Student Skills
Skill Analysis
Career Matching
Career Recommendation
Skill Gaps
Learning Roadmap
```

The user can also save the analysis as a text report.

## Future Enhancements

* JavaFX graphical user interface
* MySQL database integration
* Student login and registration
* Resume analysis
* Aptitude test module
* Machine learning-based recommendations
* Web dashboard
* Skill progress tracking
* PDF report generation
* Admin career database management
* Cloud deployment

## Learning Outcomes

This project provides practical experience with:

* Java OOP
* Classes and objects
* Constructors
* Encapsulation
* Inheritance
* Polymorphism
* Abstraction
* Collections
* File handling
* Exception handling
* Modular programming
* Basic recommendation algorithms

## Author

Student Skill & Career Path Analyzer

Developed as a Java academic project.
