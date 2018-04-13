package com.rupertoss.toripchecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TorIpCheckerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TorIpCheckerApplication.class, args);
	}
}
