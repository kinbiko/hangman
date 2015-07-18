package com.kinbiko.hangman.service;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import com.kinbiko.hangman.resource.Guess
import com.kinbiko.hangman.resource.GuessResult
import com.kinbiko.hangman.resource.NewGame

/**
 * Service for retrieving a word
 */
@Service
public class GameService {
	
	/** The lightweight database. */
	@Autowired
	private MappingService mappingService;
	
	/** The brains of the game. */
	@Autowired
	private GameBrains brains;

	public NewGame getNewGame() {
		final NewGame newGame = new NewGame();
		final int randomNumber = brains.getRandomNumber()
		newGame.secret = mappingService.getSecret(randomNumber);
		newGame.hash = mappingService.getHash(randomNumber);
		return newGame;
	}

	public GuessResult getGuessResult(final Guess guess) {
		final GuessResult result = new GuessResult();
		result.lives = brains.calculateLives(guess)
		result.secret = brains.generateSecret(guess)
		
		return result;
	}
}