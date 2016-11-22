package com.search;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadFile {
	
	static String sort(String s) {
        char[] c = s.replaceAll("[\\s]", "").toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
    }
	
	private static final Logger LOGGER = Logger.getLogger(ReadFile.class.getName());
	
	public void readWordList(){
        
		String fileName = "/Users/Alvin/workspace/wordList/wordlist.txt";
		Map<String, List<String>> words = new HashMap<>();
               
		try (Stream<String> stream = Files.lines(Paths.get(fileName), StandardCharsets.ISO_8859_1)) {

			 Iterator<String> in = stream.iterator();
			 int c=0;
			 while(in.hasNext()){
				 String word = in.next();
				 String sorted = sort(word);
				 List<String> list = words.get(sorted);
	                
				 if (list == null){
	                words.put(sorted, list = new ArrayList<>());
	             }
				 list.add(word);
			 }
			 
			 for(Map.Entry<String, List<String>> entry : words.entrySet()) {
				 if(entry.getValue().size() > 1){
					 c++;
					 System.out.println(entry.getValue());
				 }
			 }
			     LOGGER.info("Total Numbers of Anagram :" + c);
			 
		} catch (IOException e) {
			LOGGER.log(Level.INFO, e.toString());
		}
   }
}
