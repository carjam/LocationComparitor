package demo;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	public static void main(String args[]) {
		SpringApplication.run(Application.class);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		String urlGETList = "http://localhost:8080/location";

		ResponseEntity<Location[]> responseEntity = restTemplate.getForEntity(urlGETList, Location[].class);
		return args -> { 
			Location[] locations = responseEntity.getBody() ;
			ArrayList<Location> locList = new ArrayList<Location>(Arrays.asList(locations));
			CSVWriter.writeCsvFile("/var/tmp/test.csv", locList);
		};
	}
}