package MoreExercises;

import java.util.ArrayList;

public class MyHashMap{
	
	public static void main(String[] args) {
		
		MHashMap<String, String> map = new MHashMap<String, String>(2);
		map.put("Ian", "Ian Hoyos");
		map.put("Ian", "Ian Lopez");
		map.put("John", "John Lennon");
		map.put("Mike", "Mike Lazousky");
		map.put("Joseph", "Joseph Ferrano");
		map.put("Mary", "Mary Helen");
		System.out.println(map.get("Ian"));
		System.out.println(map.get("Mike"));
		System.out.println(map.get("Joseph"));
		System.out.println(map.get("Mary"));
		System.out.println(map.get("Mark"));
		
		
	}
}



class MHashMap<K, V>{

	class HashNode{
		K key;
		V value;
		HashNode next;

		public HashNode(K key, V value){
			this.key = key;
			this.value = value;
			next = null;
		}
	}
	
	ArrayList<HashNode> map;
	int numberOfBuckets;

	public MHashMap(){
		numberOfBuckets = 100;
		map = new ArrayList<HashNode>();

		for(int i = 0; i < numberOfBuckets; i++){
			map.add(null);
		}
	}

	public MHashMap(int numberOfBuckets){
		this.numberOfBuckets = numberOfBuckets;
		map = new ArrayList<HashNode>();

		for(int i = 0; i < numberOfBuckets; i++){
			map.add(null);
		}
	}

	//==========Functions==============//

	private int getIndex(K key){
		int index = Math.abs(key.hashCode()) % numberOfBuckets;
		return index;
	}

	void put(K key, V value){
		synchronized(this) { //Implementing Thread Safety per Index
			
		int index = getIndex(key);
		HashNode currentNode = map.get(index);
			
		while(currentNode != null){
			if(currentNode.key == key){ // <-- if found,
				currentNode.value = value; // <-- update the value
				return;
			}
			else
				currentNode = currentNode.next;
		}

		HashNode newNode = new HashNode(key, value);
		newNode.next = map.get(index);
		map.set(index, newNode);
		
		}
	}

	V get(K key){
		int index = getIndex(key);
		HashNode currentNode = map.get(index);
		
		
		while(currentNode != null){
			if(currentNode.key == key){
				return currentNode.value;
			}
			else
				currentNode = currentNode.next;
		}
		
		return null;
	}

}


/**
class HashNode<K, V>{
	K key;
	V value;
	HashNode<K, V> next;
	
	public HashNode(K key, V value) {
		this.key = key;
		this.value = value;
		next = null;
	}
}

class IHashMap<K, V>{
	
	int numOfBuckets;
	ArrayList<HashNode<K, V>> map;
	
	//===========Constructors============//
	public IHashMap(){
		numOfBuckets = 100;
		map = new ArrayList<HashNode<K, V>>();
		
		for(int i = 0; i < numOfBuckets; i++) {
			map.add(null);
		}
	}
	
	public IHashMap(int numOfBuckets) {
		this.numOfBuckets = numOfBuckets;
		map = new ArrayList<HashNode<K, V>>();
		for(int i = 0; i < numOfBuckets; i++) {
			map.add(null);
		}
	}
	//===================================//
	//          ||         ||
	//          \/         \/
	//============Functions==============//
	
	private HashNode<K, V> search(K key) {
		
		int index = Math.abs(key.hashCode()) % numOfBuckets;
		HashNode<K, V> node = map.get(index);
		while (node != null && node.next != null) {
			if (node.key == key)
				return node;
			else
				node = node.next;
		}
		return node;
	}
	
	void put(K key, V value) {
		
		HashNode<K, V> node = search(key);
		HashNode<K, V> newNode = new HashNode<K, V>(key, value);
		if (node == null) {
			int index = Math.abs(key.hashCode()) % numOfBuckets;
			map.set(index, newNode);
		}
		else if(node.key != key)
			node.next = newNode;
		else {
			node.value = value;
		}
	}
	
	V get(K key) {
		HashNode<K, V> node = search(key);
		if(node.key != key) 
			return null;
		else
			return node.value;
	}
	
}
**/