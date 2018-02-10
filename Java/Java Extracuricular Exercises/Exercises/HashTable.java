package Exercises;

import java.util.*;

class HashNode <K, V> {

	// Data types K and V correspond to key and value
	K key;
	V value;

	// Adding reference to next node

	HashNode<K, V> next;

	// Constructor

	public HashNode(K key, V value){
		this.key = key;
		this.value = value;
	}
}

class HashTable<K, V>{

	private ArrayList<HashNode<K, V>> arrayLL;

	private int capacity;

	private int size;

	//Contructor: How to initalize
	public HashTable(){
		arrayLL = new ArrayList<>();
		capacity = 2;
		size = 0;

		for(int i = 0; i < capacity; i++){
			arrayLL.add(null);
		}
	}

	public int getIndex(K key){
		int hashCode = key.hashCode();
		int index = hashCode % capacity;
		return index;
	}

	//public V remove(){
		// Implement
	//}

	public V get(K key){
		// Implement
		int index = getIndex(key);
		HashNode<K, V> currentNode = arrayLL.get(index);

		while (currentNode != null){

			if (currentNode.key.equals(key)){
				return currentNode.value;
			}
			currentNode = currentNode.next;
		}
		return null;

	}

	public void add(K key, V value){
		// Implement
		int index = getIndex(key);
		HashNode<K, V> currentNode = arrayLL.get(index);
			
		while (currentNode != null){
			if (currentNode.key.equals(key)){
				currentNode.value = value;
				return;
			}
			currentNode = currentNode.next;
		}
		size++;
		currentNode = arrayLL.get(index);
		HashNode<K, V> newNode = new HashNode<K, V>(key, value);
		newNode.next = currentNode;
		arrayLL.set(index, newNode);
	}

	public static void main(String[] args){
		HashTable<String, Integer> hashTable = new HashTable<>();
        hashTable.add("this",1 );
        hashTable.add("coder",2 );
        hashTable.add("that",3 );
        hashTable.add("thus",2 );
        hashTable.add("this",4 );
        hashTable.add("hi",5 );
        System.out.print(hashTable.get("this"));
	}
}
