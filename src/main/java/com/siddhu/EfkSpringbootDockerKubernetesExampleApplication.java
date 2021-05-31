package com.siddhu;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class EfkSpringbootDockerKubernetesExampleApplication {

	Logger logger = LoggerFactory.getLogger(EfkSpringbootDockerKubernetesExampleApplication.class);
	//@RequestMapping(value = "/siddhu")
	@GetMapping("/siddhu")
	public String helloWorld() {
		String response = "Simple data message showing success call :- " + new Date();
		logger.info("response found : {}", response);

		return response;
	}

	//@RequestMapping(value = "/exception")
	@GetMapping("/exception")
	public String exception() {
		String response = "";
		try {
			throw new Exception("Displaying Exception :- ");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception Created:",e);

			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String stackTrace = sw.toString();
			logger.error("Exception stackTrace- " + stackTrace);
			response = stackTrace;
		}

		return response;
	}

	public static void main(String[] args) {
		SpringApplication.run(EfkSpringbootDockerKubernetesExampleApplication.class, args);
	}

}
