package com.kinbiko.hangman.service;

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import com.kinbiko.hangman.HangmanConfig

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=HangmanConfig.class)
class MappingServiceIT{

	/** The unit to test. */
	@Autowired
	private MappingService service
	
	@Autowired
	private GameBrains brains;
	
	/** The number of words in the dictionary. */
	private int numberOfWords;
	
	/**
	 * Test initialisation.
	 */
	@Before
	void setUp(){
		numberOfWords = brains.numberOfWords
	}
	
	/**
	 * Check that the maps are populated on startup.
	 */
	@Test
	void testPostConstruct(){
		assert service.commonalities2Hashes.size() == numberOfWords
		assert service.commonalities2Words.size() == numberOfWords
		assert service.hashes2Words.size() == numberOfWords
	}
	
	@Test
	void testGetSecret(){
		for (final int i in 0..numberOfWords-1){
			assert service.getSecret(i)
		}
	}
	
	@Test
	void testGetHash(){
		for (final int i in 0..numberOfWords-1){
			assert service.getHash(i)
		}
	}
	
	@Test
	void getWord(){
		for (final int i in 0..numberOfWords-1){
			assert service.getWord(service.getHash(i))
		}
	}
	
}
