package com.kinbiko.hangman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kinbiko.hangman.converter.GuessConverter;
import com.kinbiko.hangman.resource.GuessResult;
import com.kinbiko.hangman.resource.NewGame;
import com.kinbiko.hangman.service.GameService;


/**
 * REST controller for getting hangman words.
 */
@RestController
public class HangmanController {
	
	/** The {@link GameService}. */
	@Autowired
	private GameService gameService;
	
	@Autowired
	private GuessConverter converter;
	
	/**
	 * Entry point for '/hangman'. Will return a JSON representation of a {@link GuessResult}.
	 * @return the {@link GuessResult}.
	 */
	@RequestMapping(method=RequestMethod.GET,value="/hangman/newgame")
	public NewGame newGame(){
		return gameService.getNewGame();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/hangman/guess")
	public GuessResult hangmanWord(
			@RequestParam(required=true, value="hash") final String hash,
			@RequestParam(required=true, value="guesses") final String[] guesses){
				
		return gameService.getGuessResult(converter.convert(hash, guesses));
		
	}

}
