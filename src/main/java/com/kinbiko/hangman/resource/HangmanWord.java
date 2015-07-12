package com.kinbiko.hangman.resource;

/**
 * POJO describing a word for hangman.
 *
 */
public class HangmanWord {
	
	private final String word;
	
	public HangmanWord(final String word){
		this.word = word;
	}
	
	public String getWord(){
		return word;
	}

}
