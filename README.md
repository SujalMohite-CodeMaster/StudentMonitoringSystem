# Student Monitoring System

## Overview
The Student Monitoring System is a Java-based application designed to help educational institutions track and manage student information efficiently. This system provides a user-friendly interface for administrators to perform CRUD (Create, Read, Update, Delete) operations on student records.

## Features

- **Student Management**:
  - Add new student records with details like name, roll number, department, etc.
  - View existing student information
  - Update student records
  - Delete student entries

- **User Interface**:
  - Graphical User Interface (GUI) built with Java Swing
  - Intuitive navigation and data presentation

- **Data Persistence**:
  - MySQL database integration for reliable data storage
  - JDBC for database connectivity

## Technologies Used

- **Programming Language**: Java
- **GUI Framework**: Java Swing
- **Database**: MySQL
- **Database Connectivity**: JDBC (Java Database Connectivity)

## Installation

### Prerequisites
- Java Development Kit (JDK) 8 or later
- MySQL Server
- MySQL Connector/J (JDBC driver)

### Setup Instructions

1. **Clone the repository**:
   ```bash
   git clone https://github.com/SujalMohite-CodeMaster/StudentMonitoringSystem.git
   ```

2. **Import the project** into your preferred Java IDE (Eclipse, IntelliJ IDEA, etc.)

3. **Database Setup**:
   - Create a MySQL database named `student_monitoring`
   - Run the SQL script provided in the repository to create the necessary tables

4. **Configure Database Connection**:
   - Update the database connection details in the `DBConnection.java` file:
     ```java
     private static final String URL = "jdbc:mysql://localhost:3306/student_monitoring";
     private static final String USERNAME = "your_username";
     private static final String PASSWORD = "your_password";
     ```

5. **Add MySQL Connector/J** to your project's build path

6. **Run the application** by executing the `Main.java` file

## Usage

1. Launch the application
2. Use the navigation buttons to:
   - Add new students
   - View existing student records
   - Update student information
   - Delete student entries
3. All changes will be immediately reflected in the database

## Project Structure

```
StudentMonitoringSystem/
├── src/
│   ├── com/
│   │   └── studentmonitoring/
│   │       ├── DBConnection.java       # Database connection handler
│   │       ├── Main.java               # Main application entry point
│   │       ├── Student.java            # Student entity class
│   │       ├── StudentAdd.java         # Add student functionality
│   │       ├── StudentDelete.java      # Delete student functionality
│   │       ├── StudentUpdate.java      # Update student functionality
│   │       └── StudentView.java        # View students functionality
├── lib/                                # External libraries (MySQL Connector)
└── README.md                           # Project documentation
```

## Screenshots

![Home Page](https://github.com/SujalMohite-CodeMaster/StudentMonitoringSystem/blob/master/src/images/Screenshot%202025-06-23%20095635.png)

## Future Enhancements

- Implement user authentication and authorization
- Add search and filtering capabilities
- Generate reports and statistics
- Expand to include attendance tracking and grade management

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request with your improvements.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For any questions or suggestions, please contact:
- Sujal Mohite
- GitHub: [@SujalMohite-CodeMaster](https://github.com/SujalMohite-CodeMaster)
