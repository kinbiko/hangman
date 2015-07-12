package com.kinbiko.hangman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Simple Spring Boot application.
 */
@SpringBootApplication
public class HangmanConfig {
	
	/**
	 * Runs the application using this class as config class.
	 * @param args ignored.
	 */
	public static void main(String args[]){
		SpringApplication.run(HangmanConfig.class, args);
	}

}
