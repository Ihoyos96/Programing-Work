package prog06;
import prog02.GUI;
import prog02.UserInterface;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


/**
*
*      WELCOME
*      
*      Implementation of Game Module
*
**/

public class WordPath{

  static UserInterface ui = new GUI();
  
  
  private static class Node{
	  String word;
	  Node previous;
  
	  public Node(String word){
		  this.word = word;
	  }
  }
  
 
  private static List<Node> nodes;
  
  
  /*Main Comes Now*/
  
  public static void main (String[] args){
		
  WordPath game = new WordPath();
  nodes = new ArrayList<Node>();
  
  /*Modify main to check that the start
  and target words are in the dictionary (in nodes)*/
  
  String dictionary = ui.getInfo("please enter the name of the dictionary file.");
  game.loadDictionary(dictionary);
  
  String[] commands = { "Human plays", "Computer plays" };
  int playModes = 0;
  playModes = ui.getCommand(commands);
  
      switch (playModes) {
      case -1:
    	  ui.sendMessage("You clicked the red X. Exiting.");
    	  return;
      case 0:
    	
        String startWord = ui.getInfo("Enter starting word: ");
        System.out.println("Start Word: " + find(startWord));
        if (startWord.equals("") || startWord == null || (find(startWord) == null)){
    		return;
        }
        String targetWord = ui.getInfo("Enter target word: ");
        if (targetWord.equals("") ||targetWord == null || (find(targetWord) == null)){
        	return;
        }
        game.play(startWord, targetWord);
        break;
      
      case 1:
    	  startWord = ui.getInfo("Enter starting word: ");
          if (startWord.equals("") || startWord == null){
      		return;
          }
          targetWord = ui.getInfo("Enter target word: ");
          if (targetWord.equals("") ||targetWord == null){
          	return;
          }  
        game.play(startWord, targetWord);
        break;
        
      default:
    	  return;
    }
  }
      
    public void play (String a, String b){
    	while(true){
    		String targetWord = b;
    		String currentWord = a;
    		ui.sendMessage("The starting word is " + a + ".\nThe target word is " + b  + ".");
    		String nextWord = ui.getInfo("Enter your next word.");
    		
    		
    		if(nextWord.compareTo(targetWord) == 0){
    			ui.sendMessage("You Win!");
    			return;
    		}
    		
    		while (nextWord != targetWord){
    			if(nextWord.compareTo(targetWord) == 0){
        			ui.sendMessage("You Win!");
        			return;
    			}
    			boolean check = oneDegree(currentWord, nextWord);
	    		if (check == false){
	    			ui.sendMessage("Your word does not differ by one letter to the starting word.");
	    			nextWord = ui.getInfo("Enter your next word.");
	    		}
	    		if (check == true){
	    			currentWord = nextWord;
	    			ui.sendMessage("The current word is " + currentWord + ".\nThe target word is " + targetWord);
	    			nextWord = ui.getInfo("Enter your Next word.");
	    		}
    		}
    		
    	}
    }
    
    public void solve (String a, String b){
    	ArrayQueue<Node> solution;
    	
    	solution = new ArrayQueue<Node>();
    	
    	solution.offer(find(a));
    	
    	while(solution.isEmpty() == false){
    		Node thisNode = solution.poll();
    		
    		if (previous != null && solution);
    }
    
    static boolean oneDegree (String a, String b){
    	boolean sameLength = false;
    	int similarLetters = 0;
    	
    	if (a.length() == b.length() )
    		sameLength = true;
    	
    	if (sameLength == true){
    		for (int i = 0; i < a.length(); i++){
    			if (a.charAt(i) == (b.charAt(i))){
    				similarLetters++;
    			}
    		}
    		if (similarLetters == (a.length()-1)){
    			return true;
    		}
    		else{
    			return false;	
    		}
    	}
    	else{
    		ui.sendMessage("Word has to be of same length as the target word.");
    		return false;
    		
    	}
    }
    
    @SuppressWarnings("resource")
	public void loadDictionary (String a){
    	Scanner wordLoader = null;
    			try{
    				 wordLoader = new Scanner(new File(a));
    				
    			}
    			catch(Exception e){
    			ui.sendMessage(e.toString());
    			return;
    			}
    			while(wordLoader.hasNext()){
	    			nodes.add(new Node(wordLoader.next()));
    	 }
    	
    }
    
    public static Node find (String word){
    	for (int i =0; i < nodes.size(); i++){
    		//if words equals to node.words: return node
    		String nodeWord = nodes.get(i).word;
    		if (word.equals(nodeWord)){
    			return nodes.get(i);
    		}
    	}
    	return null;
    }
}
    		
    		
  


