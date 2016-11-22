package com.app;

import java.io.IOException;
import com.search.ReadFile;

public class RunApp {

	  private RunApp() {
	  }
	   
      public static void main (String [] args) throws IOException {
    	     ReadFile readFile = new ReadFile();
    	     readFile.readWordList();
      }
	
}
