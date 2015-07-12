package com.kinbiko.hangman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kinbiko.hangman.resource.HangmanWord;
import com.kinbiko.hangman.service.WordService;


/**
 * REST controller for getting hangman words.
 */
@RestController
public class WordController {
	
	/** The {@link WordService}. */
	@Autowired
	private WordService wordService;
	
	/**
	 * Entry point for '/hangman'. Will return a JSON representation of a {@link HangmanWord}.
	 * @return the {@link HangmanWord}.
	 */
	@RequestMapping(method=RequestMethod.GET,value="/hangman")
	public HangmanWord hangmanWord(){
		return wordService.getHangmanWord();
	}

}
