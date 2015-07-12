package com.kinbiko.hangman.service;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.kinbiko.hangman.HangmanConfig;
import com.kinbiko.hangman.resource.HangmanWord;

/**
 * Testing the {@link WordService} unit.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=HangmanConfig.class)
public class WordServiceTest {
	
	/** The unit to test. */
	@Autowired
	private WordService service;
	
	/**
	 * Test that no exceptions are thrown when parsing the password list, and that the wordList is populated.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testParseWordList(){
		final ArrayList<String> wordList = (ArrayList<String>) ReflectionTestUtils.getField(service, "wordList");
		Assert.assertEquals(service.getNumberOfWords(), wordList.size());
		Assert.assertNotEquals(0, service.getNumberOfWords());
	}
	
	/**
	 * Tests that two words retrieved after one another are not the same. 
	 * FIXME: this is a non-deterministic test, as there's a 1/100 000 000 chance it will fail, assuming uniform distribution.
	 */
	@Test
	public void testGetHangmanWord(){
		final HangmanWord word1 = service.getHangmanWord();
		final HangmanWord word2 = service.getHangmanWord();
		
		Assert.assertNotEquals(word1.getWord(),word2.getWord());
	}

}
