package sk.kasv.degro.Hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import sk.kasv.degro.Hibernate.Program;

@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "FitnessApp",
        version = "1.0",
        description = "API documentation for FitnessApp Spring Boot application using Hibernate and SQL database." 
    )
)
public class Program {
    public static void main(String[] args) {
        SpringApplication.run(Program.class, args);
        openSwaggerUI();
    }

    @SuppressWarnings("deprecation")
    private static void openSwaggerUI() {
        String url = "http://localhost:8080/swagger-ui.html";
        
        try {
            String os = System.getProperty("os.name").toLowerCase();
            Runtime rt = Runtime.getRuntime();
            
            if (os.contains("win")) {
                rt.exec("cmd /c start " + url); // Windows
            } else if (os.contains("mac")) {
                rt.exec("open " + url); // macOS
            } else if (os.contains("nix") || os.contains("nux")) {
                rt.exec("xdg-open " + url); // Linux
            } else {
                System.out.println("Unknown OS. Open manually: " + url);
            }
        } catch (Exception e) {
            System.err.println("Failed to open browser: " + e.getMessage());
        }
    }
    
}
