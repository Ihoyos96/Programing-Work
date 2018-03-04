package MoreExercises;

import java.io.*;
import java.util.*;


class TestLRU{ 
  
  public static void main(String[] args){
    
    LRUcache cache = new LRUcache(4);
    cache.visit(2);
    cache.printCache();
    cache.visit(4);
    cache.printCache();
    cache.visit(2);
    cache.printCache();
    cache.visit(5);
    cache.printCache();
    cache.visit(7);
    cache.printCache();
    cache.visit(2);
    cache.printCache();
    cache.visit(4);
    cache.printCache();
  }
  
}

class LRUcache{
  
  class Node{
    
    int data;
    Node next;
    Node prev;
    
    public Node(int data){
      this.data = data;
      next = null;
      prev = null;
    }
    
  }
  
  Node head;
  Node tail;
  
  int capacity;
  HashMap<Integer, Node> map;
  
  public LRUcache(int capacity){
    this.capacity = capacity;
    map = new HashMap<Integer, Node>();
  }
  
  void printCache(){
    
    Node iterator = head;
    while (iterator != null){
      System.out.print(iterator.data + " ");
      iterator = iterator.next;
    }
    System.out.println();
  }
  
  void removeLast(){
    
    int key = tail.data;
    map.remove(key);
    
    tail = tail.prev;
    tail.next.prev = null;
    tail.next = null;
    
  }
  
  void visit(int n){
  
    if (!(map.containsKey(n))){
      
      Node newNode = new Node(n);
      
      if (map.size() == capacity)
    	  	removeLast();
      
      map.put(n, newNode);
      
      if(head == null) {
    	  	head = tail = newNode;
    	  	return;
      }
      
      head.prev = newNode;
      newNode.next = head;
      head = newNode;
      return;
    }
    else{
      
      Node node = map.get(n);
      
      if(node.prev == null)
        return;
      if(node.next == null){
        tail = tail.prev;
        tail.next = null;
        
        head.prev = node;
        node.next = head;
        head = node;
        return;
        
      }
      node.prev.next = node.next;
      node.next.prev = node.prev;
      
      head.prev = node;
      node.next = head;
      head = node;
      
      return;
    }
    
  }
  
  
}