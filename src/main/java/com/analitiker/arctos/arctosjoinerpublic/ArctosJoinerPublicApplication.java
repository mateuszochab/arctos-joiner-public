package com.analitiker.arctos.arctosjoinerpublic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ArctosJoinerPublicApplication {

	//TODO GLOBAL
	//TODO add controller advice
	//TODO kafka integration for logs and notifications
	//TODO redis service
	//TODO properties divided by envs
	//TODO add hibernate envers for revisions

	public static void main(String[] args) {
		SpringApplication.run(ArctosJoinerPublicApplication.class, args);
	}

}
