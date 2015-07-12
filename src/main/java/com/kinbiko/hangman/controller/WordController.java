package com.kinbiko.hangman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kinbiko.hangman.resource.HangmanWord;
import com.kinbiko.hangman.service.WordService;


@RestController
public class WordController {
	
	@Autowired
	private WordService wordService;
	
	@RequestMapping(method=RequestMethod.GET,value="/hangman")
	public HangmanWord hangmanWord(){
		return wordService.getHangmanWord();
	}

}
