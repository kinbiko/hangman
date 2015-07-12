package com.kinbiko.hangman.resource;

/**
 * POJO describing a word for hangman.
 */
public class HangmanWord {
	
	/** The word. */
	private final String word;
	
	/**
	 * Constructor.
	 * @param word the word.
	 */
	public HangmanWord(final String word){
		this.word = word;
	}
	
	/**
	 * Accessor for the word.
	 * @return the word.
	 */
	public String getWord(){
		return word;
	}

}
