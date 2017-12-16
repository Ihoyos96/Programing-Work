package prog07;

import java.io.File;
import java.util.Scanner;

import prog02.UserInterface;
import prog11.OpenHashTable;
import prog02.ConsoleUI;
import prog02.GUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Jumble {
  /**
   * Sort the letters in a word.
   * @param word Input word to be sorted, like "computer".
   * @return Sorted version of word, like "cemoptru".
   */
  public static String sort (String word) {
    char[] sorted = new char[word.length()];
    for (int n = 0; n < word.length(); n++) {
      char c = word.charAt(n);
      int i = n;

      while (i > 0 && c < sorted[i-1]) {
        sorted[i] = sorted[i-1];
        i--;
      }

      sorted[i] = c;
    }

    return new String(sorted, 0, word.length());
  }

  public static void main (String[] args) {
    UserInterface ui = new GUI();
    // Map<String,String> map = new TreeMap<String,String>();
    // Map<String,String> map = new DummyList<String,String>();
    // Map<String,String> map = new SkipList<String,String>();
    Map<String,List<String>> map = new OpenHashTable<String,List<String>>();
    
    Scanner in = null;
    do {
      try {
        in = new Scanner(new File(ui.getInfo("Enter word file.")));
      } catch (Exception e) {
        System.out.println(e);
        System.out.println("Try again.");
      }
    } while (in == null);
	    
    int n = 0;
    while (in.hasNextLine()) {
      String word = in.nextLine();
      if (n++ % 1000 == 0)
	      System.out.println(word + " sorted is " + sort(word));
      
      // EXERCISE: Insert an entry for word into map.
      // What is the key?  What is the value?
      //map.put(sort(word), word);

      String aWord = sort(word);
      if (!map.containsKey(aWord)){
    	  List<String> aList = new ArrayList<String>();
    	  aList.add(word);
    	  map.put(aWord, aList);
      }else {
    	  List<String> thisList = map.get(aWord);
    	  thisList.add(word);
      }

    }

    while (true) {
      String jumble = ui.getInfo("Enter jumble.");
      if (jumble == null){
    	  break;
    	  
      }

      // EXERCISE:  Look up the jumble in the map.
      // What key do you use?
      jumble = sort(jumble);
      List<String> word = map.get(jumble);

      if (word == null)
        ui.sendMessage("No match for " + jumble);
      else
        ui.sendMessage(jumble + " unjumbled is " + word);
    }
    
    String key2 = null;
    
    
    while (true){
    	int theLength = -1; 
        String clue = sort(ui.getInfo("Enter clue word jumble."));
            while ( theLength < 0){
                String thisLength = ui.getInfo("length of the first clue word");
                try {
                    theLength = Integer.parseInt(thisLength);
                    //do this
                    if (theLength < 0)
                        ui.sendMessage("Enter a number please.");
                    //do this
                }catch(Exception e){
   			  ui.sendMessage("Not a number");
   		  }
    }
   	  
   	  for ( String key1 : map.keySet()){
   		  if (theLength == key1.length()){
   			   key2 = crossOff (key1, clue);
   			   
   			   if (key2 != null && map.containsKey(key2)){
   				List<String> word = map.get(key1);
   				List<String> word1 = map.get(key2);
   				ui.sendMessage(clue + " can be unjumbled as" + word + " " + word1);
   				
   			   }
   				   
   		  }
   	  }
   		  
   	  
   	  
    }
  }
  public static String crossOff (String key1, String clue){
	  String key2 = "";
	  int i = 0;
	  int j = 0;
	  for (j = 0; j < clue.length(); j++){
	  
		  if(i >= key1.length()){
			  key2 += clue.charAt(j);
		  }else{
		  
		  if (key1.charAt(i) == clue.charAt(j))
			  i++;
		  else if (clue.charAt(j) < key1.charAt(i)) 
			  key2 += clue.charAt(j);
		  else
			  return null;
		  }
	  }
	  
	  if (key2.length() != (clue.length() - key1.length()))
		  return null;
	  return key2;
  }
}
