package com.kinbiko.hangman.base

import org.junit.Assert
import org.junit.Test


/**
 * Class for simplifying testing of POGOs.
 */
public class POGOTestBase {
	
	/** The class to test. */
	private Class<?> toTest;
	
	private String pathString;
	
	/**
	 * Constructor.
	 * @param clazz the Class to test.
	 */
	POGOTestBase(final Class<?> clazz){
		this.toTest = clazz;
		init();
	}
	
	void init(){
		this.pathString = toTest.toString().replace("class ","")
	}
	
	/**
	 * Checks that getting and setting of fields works as expected.
	 */
	@Test
	void testCanGetAndSet(){
		final def pogo = toTest.newInstance();
		final def properties = getAllProperties();
		for (def entry : properties){
			testPogo(entry.key, entry.value, pogo)
		}
	}
	
	private void testPogo(final String propertyName, final Class<?> clazz, final def pogo){
		println "Testing $propertyName with type $clazz on $pogo"
		assert pogo."$propertyName" == null; //Does not throw MPE
		final def toSet = clazz.newInstance();
		pogo."$propertyName" = toSet //Can set
		println pogo."$propertyName"
		println toSet
		assert pogo."$propertyName" == toSet //Can get, and is equal to set value.
	}
	
	private def getAllProperties(){
		final def properties = [:];
		for (final def field : toTest.getDeclaredFields()){
			final String fs = field.toString();
			if (isProperty(fs)){
				//Get name
				final StringBuilder sb = new StringBuilder(fs);
				sb.delete(0, fs.indexOf(pathString))
				final String name = sb.toString().replace(pathString + ".", "")
				
				//get type
				Class<?> clazz = fs.getClass()
				properties.put(name,clazz);
			}
		}
		return properties;
	}
	

	private boolean isProperty(String s){
		return s.contains(pathString) && ! s.contains('$') && ! s.contains("metaClass");
	}

}
