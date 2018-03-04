package Exercises;

import java.util.HashMap;

public class LRUCache { // All operations O(1);
	
	HashMap<Integer, QNode> map;
	int capacity; 
	QNode head;
	QNode tail;
	
	// Constructor: 
	public LRUCache(int capacity) {
		map = new HashMap<Integer, QNode>();
		this.capacity = capacity;
		head = null;
		tail = null;
	}
	
	public void setQueue(int key) {
		// Create first node
		QNode firstNode = new QNode(key);
		//Add first node to map
		map.put(key, firstNode);
		// Make first node both head and tail.
		head = tail = firstNode;
	}
	
	public void removeLast(){
		// Get last node's key
		int lastKey = tail.key;
		// Move Tail forward one
		tail = tail.prev;
		tail.next = null;
		// Remove <K, V> pair from map.
		map.remove(lastKey);
	}
	
	public void visit(int key) { // Called method visit assuming a web-page cache approach
		// Check if map is empty: Set queue if empty.
		if(map.isEmpty())
			setQueue(key);
		
		if (map.containsKey(key)) { // key was found in map
			// Get that node
			QNode node = map.get(key);
			
			// Remove node from current position
			// Check if node is not Head
			if (node.prev != null) {
				node.prev.next = node.next;
			}
			else // Node is Head. It's already at the front, we're done.
				return; 
			
			// Check if node is Tail
			if (node.next != null) {
				node.next.prev = node.prev;
			}
			else { // Node is Tail: Move Tail back one.
				node.prev.next = null;
				tail = node.prev;
			}
			
			// Move node to the front of the queue and make new Head
			node.next = head;
			head.prev = node;
			head = node;
		}
		
		else { // If the map does not contain the key
			
			// Check for capacity: remove last node if at capacity
			if (map.size() >= capacity)
				removeLast();
			
			// Create new node with key
			QNode newNode = new QNode(key);
			
			// Put new <K, V> pair into the map
			map.put(key, newNode);
			
			// Add new node to the front of the queue
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
	}

}

class QNode{
	int key;
	QNode next;
	QNode prev;
	
	public QNode(int key) {
		this.key = key;
		next = null;
		prev = null;
	}
}
