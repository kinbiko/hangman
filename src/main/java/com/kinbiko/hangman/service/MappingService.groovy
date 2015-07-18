package com.kinbiko.hangman.service;

import java.security.MessageDigest

import javax.annotation.PostConstruct

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MappingService {

	private static final String PATH_TO_WORDS = "src/main/resources/passwords.txt";
	
	@Autowired
	private GameBrains brains;	

	/** Map linking commonalities to words. */
	private final Map commonalities2Words = [:];

	/** Map linking hashes to words. */
	private final Map hashes2Words = [:];

	/** Map linking commonalities to words. */
	private final Map commonalities2Hashes = [:];

	/**
	 * After creating this service instance, scan the word list and add each line along with it's frequency to a map.
	 */
	@PostConstruct
	public void populateMaps(){
		generateCommonalities2Words()
		brains.numberOfWords = commonalities2Words.size();
		generateHashMaps()
	}

	/**
	 * Populates a map of commonalities to words.
	 */
	private void generateCommonalities2Words(){
		final String stringRepresentation = new String(new File(PATH_TO_WORDS).bytes)
		Arrays.asList(stringRepresentation.split("\n")).eachWithIndex {elem, index ->
			commonalities2Words.put(index, elem)
		}
	}

	/**
	 * Populates a map of hashes to words and commonalities to hashes.
	 */
	private void generateHashMaps(){
		commonalities2Words.each{
			final String word = it.value
			final String hash = hash(word)
			hashes2Words.put(hash, word)
			commonalities2Hashes.put(it.key, hash)
		}
	}

	/**
	 * Generates a hash from a string.
	 */
	private String hash(final String toHash){
		final MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		messageDigest.update(toHash.getBytes());
		final String hash = new String(messageDigest.digest());

		return hash;
	}

	public String getSecret(final int commonality){
		return "*" * commonalities2Words.get(commonality).size();
	}

	public String getHash(final int commonality){
		return commonalities2Hashes.get(commonality);
	}
	
	public String getWord(String hash){
		return hashes2Words.get(hash);
	}
}
