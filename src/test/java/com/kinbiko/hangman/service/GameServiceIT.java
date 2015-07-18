package com.kinbiko.hangman.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kinbiko.hangman.HangmanConfig;
import com.kinbiko.hangman.resource.Guess;
import com.kinbiko.hangman.resource.GuessResult;
import com.kinbiko.hangman.resource.NewGame;

/**
 * Integration test for GameService.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=HangmanConfig.class)
public class GameServiceIT {
	
	/** The class to test. */
	@Autowired
	private GameService service;
	
	/** Mapping service, used to get a valid hash. */
	@Autowired
	private MappingService mappingService;
	
	/**
	 * Tests that two words retrieved after one another are not the same. 
	 * FIXME: this is a non-deterministic test, as there's a 1/10 000 chance it will fail, assuming uniform distribution.
	 */
	@Test
	public void testGetNewGame(){
		final NewGame word1 = service.getNewGame();
		final NewGame word2 = service.getNewGame();
		Assert.assertNotEquals(word1.getHash(),word2.getHash());
	}

	/**
	 * Test that guessing a result will return a proper {@link GuessResult}.
	 */
	@Test
	public void testGetGuessResult(){
		final Guess guess = new Guess();
		String guesses = "aeq"; // password will be 'charlie'
		String hash = mappingService.getHash(42); //"randomly" chosen integer
		guess.setGuesses(guesses);
		guess.setHash(hash);
		final GuessResult result = service.getGuessResult(guess);
		Assert.assertEquals("**a***e",result.getSecret());
		Assert.assertEquals(5,result.getLives());
	}

}
