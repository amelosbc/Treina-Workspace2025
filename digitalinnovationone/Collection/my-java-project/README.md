# My Java Project

This is a simple Java project that demonstrates how to set up a Java application using Maven and Visual Studio Code.

## Project Structure

```
my-java-project
├── src
│   └── Main.java
├── .vscode
│   ├── launch.json
│   └── settings.json
├── pom.xml
└── README.md
```

## Prerequisites

- Java Development Kit (JDK) installed on your machine.
- Maven installed on your machine.
- Visual Studio Code with the Java Extension Pack.

## Setup Instructions

1. **Clone the Repository**
   Clone this repository to your local machine using the following command:
   ```
   git clone <repository-url>
   ```

2. **Navigate to the Project Directory**
   Change to the project directory:
   ```
   cd my-java-project
   ```

3. **Build the Project**
   Use Maven to build the project:
   ```
   mvn clean install
   ```

4. **Run the Application**
   You can run the application using the following command:
   ```
   mvn exec:java -Dexec.mainClass="Main"
   ```

5. **Debugging in Visual Studio Code**
   Open the project in Visual Studio Code. You can start debugging by pressing `F5` or by selecting the debug option from the menu.

## License

This project is licensed under the MIT License. See the LICENSE file for more details.