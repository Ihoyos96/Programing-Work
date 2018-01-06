package Exercises;

import java.util.*;

class Node{
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
	}
}

public class CycleDetection {

	boolean hasCycle(Node head) {

	    HashSet<Node> set = new HashSet<Node>();

	    while (head != null){
	        if (set.contains(head))
	            return true;
	        else{
	            set.add(head);
	        }
	        head = head.next;
	    }     
	    return false;
	        
	}
	
}
