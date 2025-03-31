# blazorwasm-springbootj

This project demonstrates a Spring Boot application with gRPC capabilities.

## Project Structure

*   **`demo/pom.xml`:** Maven project configuration file.
*   **`demo/src/main/java/com/example/demo/DemoApplication.java`:** Main Spring Boot application entry point.
*   **`demo/src/main/java/com/example/demo/SimpleGrpcApplication.java`:** gRPC service implementation.
*   **`demo/src/test/java/com/example/demo/DemoApplicationTests.java`:** Spring Boot test class.
*   **`demo/src/main/proto/helloworld.proto`**: gRPC service definition file. (You need to create this file)

## Dependencies

The project uses the following key dependencies:

*   **Spring Boot:** For building the application.
*   **Spring gRPC:** For gRPC server functionality.
*   **gRPC:** Core gRPC libraries.
*   **Protocol Buffers:** For defining the gRPC service and messages.
*   **Lombok:** For reducing boilerplate code (optional).

## How to Compile

1.  **Navigate to the `demo` directory:**

    ```bash
    cd demo
    ```

2.  **Compile and build the project using Maven:**

    ```bash
    mvn clean install
    ```

    This command will:

    *   Clean the project (remove previous build artifacts).
    *   Compile the Java code.
    *   Generate gRPC code from the `.proto` file.
    *   Run tests.
    *   Package the application into a JAR file (`demo-0.0.1-SNAPSHOT.jar`).
    * Create the grpc jar file (`demo-0.0.1-SNAPSHOT-grpc.jar`).

## How to Run

1.  **Navigate to the `demo` directory:**

    ```bash
    cd demo
    ```

2.  **Run the Spring Boot application using Maven:**

    ```bash
    mvn spring-boot:run
    ```

    This command will start the embedded Tomcat server and run the Spring Boot application.

    **Alternatively, you can run the JAR directly:**

    1.  Navigate to the `target` directory:

        ```bash
        cd demo/target
        ```

    2.  Run the JAR:

        ```bash
        java -jar demo-0.0.1-SNAPSHOT.jar
        ```

3. **gRPC Server:** The gRPC server will be running at `localhost:9090` by default.

## How to Stop

* **If you started with `mvn spring-boot:run` or `java -jar demo-0.0.1-SNAPSHOT.jar` in the foreground:**
    * Press `Ctrl + C` (or `Cmd + C` on macOS) in the terminal where the application is running.
* **If you started with `java -jar demo-0.0.1-SNAPSHOT.jar` in the background:**
    1. Find the process ID (PID):
        * **Linux/macOS:** `jps -l` or `ps aux | grep demo-0.0.1-SNAPSHOT.jar`
        * **Windows:** Use Task Manager (Details tab) or `tasklist | findstr demo-0.0.1-SNAPSHOT.jar`
    2. Kill the process:
        * **Linux/macOS:** `kill <PID>` (or `kill -9 <PID>` if necessary)
        * **Windows:** `taskkill /PID <PID> /F`

## Testing the gRPC Service

You can test the gRPC service using a gRPC client like `grpcurl`.

**Example `grpcurl` Command:**

```bash
grpcurl -plaintext -d '{"name": "World"}' localhost:9090 com.example.grpc.lib.GreetService/SayHello
