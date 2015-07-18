package com.kinbiko.hangman.converter;

import org.springframework.stereotype.Service

import com.kinbiko.hangman.resource.Guess

@Service
class GuessConverter {
	
	public Guess convert(final String hash, final String[] guesses){
		final Guess guess = new Guess();
		guess.hash = hash
		guess.guesses = guesses
		
		return guess;
	}

}
