package com.kinbiko.hangman.service;

import javax.annotation.PostConstruct

import org.springframework.stereotype.Service

import com.kinbiko.hangman.resource.HangmanWord

/**
 * Service for retrieving a word
 */
@Service
public class WordService {
	
	/** The number of words in the word list. */
	private int numberOfWords

	/** The word list. */
	private ArrayList<String> wordList
	
	/**
	 * Returns a random word from the wordlist.
	 * @return a hangman word.
	 */
	public HangmanWord getHangmanWord() {
		return new HangmanWord(wordList.get((int)Math.random()*numberOfWords))
	}
	
	/**
	 * After creating this service instance, scan the word list and add each line and store each line as a String.
	 */
	@PostConstruct
	public void parseWordList(){
		final String stringRepresentation = new String(new File("src/main/resources/passwords.txt").bytes)
		wordList = new ArrayList<String>(Arrays.asList(stringRepresentation.split("\n")))
		numberOfWords = wordList.size
	}
	
	/**
	 * @return The number of words in the word list.
	 */
	public int getNumberOfWords(){
		return numberOfWords
	}
}
