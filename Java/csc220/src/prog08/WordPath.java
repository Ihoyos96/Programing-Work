package prog08;

import prog02.GUI;
import java.util.Scanner;
import java.io.File;
import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Queue;
import java.util.ArrayDeque;

public class WordPath {
  private static class Node {
    String word;
    Node previous;
    
    Node (String word) {
      this.word = word;
    }
  }
  
  static GUI ui = new GUI();
  
  public static void main (String[] args) {
    WordPath game = new WordPath();
    String fn = null;
    do {
      fn = ui.getInfo("Enter dictionary file:");
      if (fn == null)
        return;
    } while (!game.loadDictionary(fn));
    
    String start = ui.getInfo("Enter starting word:");
    if (start == null)
      return;
    while (game.find(start) == null) {
      ui.sendMessage(start + " is not a word.");
      start = ui.getInfo("Enter starting word:");
      if (start == null)
        return;
    }
    String target = ui.getInfo("Enter target word:");
    if (target == null)
      return;
    while (game.find(target) == null) {
      ui.sendMessage(target + " is not a word.");
      target = ui.getInfo("Enter target word:");
      if (target == null)
        return;
    }
    
    String[] commands = { "Human plays.", "Computer plays." };
    int c = ui.getCommand(commands);
    
    if (c == 0)
      game.play(start, target);
    else
      game.solve(start, target);
  }
  
  void play (String start, String target) {
    while (true) {
      ui.sendMessage("Current word: " + start + "\n" +
                     "Target word: " + target);
      String word = ui.getInfo("What is your next word?");
      if (word == null)
        return;
      if (find(word) == null)
        ui.sendMessage(word + " is not in the dictionary.");
      else if (!oneDegree(start, word))
        ui.sendMessage("Sorry, but " + word +
                       " differs by more than one letter from " + start);
      else if (word.equals(target)) {
        ui.sendMessage("You win!");
        return;
      }
      else
        start = word;
    }
  }    
  
  static boolean oneDegree (String snow, String slow) {
    if (snow.length() != slow.length())
      return false;
    int count = 0;
    for (int i = 0; i < snow.length(); i++)
      if (snow.charAt(i) != slow.charAt(i))
        count++;
    return count == 1;
  }
  
  List<Node> nodes = new ArrayList<Node>();
  
  boolean loadDictionary (String file) {
    try {
      Scanner in = new Scanner(new File(file));
      while (in.hasNextLine()) {
        String word = in.nextLine();
        Node node = new Node(word);
        nodes.add(node);
      }
    } catch (Exception e) {
      ui.sendMessage("Uh oh: " + e);
      return false;
    }
    return true;
  }
  
  Node find (String word) {
    for (int i = 0; i < nodes.size(); i++)
      if (word.equals(nodes.get(i).word))
        return nodes.get(i);
    return null;
  }
  
  void clearAllPrevious () {
    for (int i = 0; i < nodes.size(); i++)
      nodes.get(i).previous = null;
  }
public class NodeComparator implements Comparator<Node>{
	private String target;
	public NodeComparator(String target){
		this.target = target;
	}
	
	public int value (Node node){
		String nodeWord = node.word;
		return linksToStart(node) + differenceOfLetters(nodeWord, target);
		
	}
	
	@Override
	public int compare(Node o1, Node o2) {
		return value(o1) - value(o2);
	}
	
	
	//Amount of letters different
	public int differenceOfLetters(String nodeWord, String target){
		int count = 0;
		for (int i = 0; i < nodeWord.length(); i++){
			if (nodeWord.charAt(i) != target.charAt(i)){
				count++;
			}
		}
		return count;
	}
	
	public int linksToStart(Node node){
		int count = 0;		
		while(node.previous != null){
			node = node.previous;
			count++;
		}		
	return count;
	}
}
  void solve (String start, String target) {
    clearAllPrevious();
    NodeComparator cmp = new NodeComparator(target);
    Queue<Node> queue = new PriorityQueue<Node>(1000, cmp);
    //Queue<Node> queue = new Heap<Node>(new NodeComparator(target));
    
    Node startNode = find(start);
    queue.offer(startNode);
    
    int counter = 0;
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      System.out.println("DEQUEUE: " + node.word);
      counter++;

      System.out.print("ENQUEUE:");
      for (int i = 0; i < nodes.size(); i++) {
        Node next = nodes.get(i);
        
        if (next != startNode && oneDegree(node.word, next.word)) {
        	
        	if (next.previous == null){
	           next.previous = node;
	           queue.offer(next);
	           System.out.print(" " + next.word);
	
	           if (next.word.equals(target)) {
	             ui.sendMessage("Got to " + target + " from " + node.word);
	             String s = node.word + "\n" + target;
	             
	             while (node != startNode) {
	               node = node.previous;
	               s = node.word + "\n" + s;
	             }
	            
	             ui.sendMessage(s);
	             ui.sendMessage("Got to the answer in " + counter + " steps.");
	             return;
	           }
            }
        	else if (cmp.linksToStart(node) + 1 < cmp.linksToStart(next)){
        		queue.remove(next);
        		next.previous = node;
        		queue.offer(next);
        	}
        }
      }
    } 	
       System.out.println();
  }
}

