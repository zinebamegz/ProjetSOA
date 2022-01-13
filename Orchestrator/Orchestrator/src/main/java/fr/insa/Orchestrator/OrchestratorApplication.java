package fr.insa.Orchestrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class OrchestratorApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrchestratorApplication.class, args);
	}
}
