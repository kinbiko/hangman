package com.kinbiko.hangman.resource;

/**
 * POGO describing the result of a Guess
 */
class GuessResult {

	/** Lives remaining. */
	int lives;
	
	/**
	 * The word, only revealing the information about the word that the user has already learned.
	 * Same length as the word itself. E.g. for {@code "foobar"} when the user has guessed 'a' and 'f' we get:
	 * {@code "f***a*"}
	 */
	String secret;
	
}
