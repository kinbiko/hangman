package com.kinbiko.hangman.service;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import com.kinbiko.hangman.resource.Guess

/**
 * Class for doing all the heavy business logic.
 */
@Component
public class GameBrains {

	/** The number of words in the word list. */
	int numberOfWords;
	
	/** Number of lives per game. */
	private static final int LIVES_PER_GAME = 6;
	
	/** The mapping service. */
	@Autowired
	private MappingService mappingService;
	
	/**
	 * Generate a secret word from a given Guess.
	 * @param guess
	 * @return
	 */
	String generateSecret(final Guess guess){
		final String word = mappingService.getWord(guess.hash);
		StringBuilder secret = new StringBuilder("*" * word.size());
		String guesses = guess.guesses;
		def map = [:]
		word.eachWithIndex{ value, int index ->
			if(guesses.contains(value)){
				map.put(index, value)
			}
		}
		map.each{
			secret.setCharAt(it.key, (char)it.value);
		}
		
		return secret;
	}
	
	int calculateLives(final Guess guess){
		//How many of the guesses are in the word?
		int remainingLives = LIVES_PER_GAME;
		final String word = mappingService.getWord(guess.hash);
		guess.guesses.each {
			if(!word.contains(it)){
				remainingLives--
			}
		}

		return remainingLives
	}
	
	int getRandomNumber(){
		(int)(Math.random() * numberOfWords)
	}

}
