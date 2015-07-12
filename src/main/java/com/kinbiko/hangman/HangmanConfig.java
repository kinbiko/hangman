package com.kinbiko.hangman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HangmanConfig {
	
	public static void main(String args[]){
		System.out.println("hello");
		SpringApplication.run(HangmanConfig.class, args);
		System.out.println("bye!");
	}

}
