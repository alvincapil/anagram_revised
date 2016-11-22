package com.test;

import java.util.Arrays;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class TestAnagram extends TestCase{

	public TestAnagram(String testName){
		super(testName);
	}
	
    @Before
    public String sort(String s) {
        char[] c = s.replaceAll("[\\s]", "").toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
    }	 

	@Before
    public boolean testWordsEqual(){
		String firstWord = "pinkish";
        String secondWord = "kinship";
        
        firstWord =  sort(firstWord);
		secondWord = sort(secondWord);

		return firstWord.equals(secondWord);
    }
	
	@Test
	public void testWordAnagram(){
		assertNotNull(sort("test"));
		assertTrue("This is anagram", testWordsEqual());
	}
	

}
