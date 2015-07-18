package com.kinbiko.hangman.service;

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import com.kinbiko.hangman.HangmanConfig
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=HangmanConfig.class)
public class GameBrainsIT {
	
	@Autowired private GameBrains brains;
	
	//getting random numbers
	@Test void "Random numbers are different each time"(){
		assert brains.getRandomNumber() != brains.getRandomNumber()
	}
	
	//Subtracting lives
	@Test void "cannot have negative lives"(){
		
	}
	
	@Test void "subtracts enough lives"(){
		
	}
	
	@Test void "cannot guess same letter multiple times"(){
		
	}
	
	@Test void "cannot have empty guesses"(){
		
	}
	
	@Test void "cannot have null guess"(){
		
	}
	
	@Test void "cannot have null guesses"(){
		
	}
	
	@Test void "hash must be valid"(){
		
	}
	
	//Generating secrets
	

}
