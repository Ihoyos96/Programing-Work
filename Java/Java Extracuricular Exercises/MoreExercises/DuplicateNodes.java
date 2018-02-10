package MoreExercises;

import java.util.HashSet;
import java.util.StringJoiner;

public class DuplicateNodes{
	public static void main(String[] args) {
		/*
		LinkedList singlyLL = new LinkedList();
		
		
		singlyLL.add(2);
		singlyLL.add(3);
		singlyLL.add(25);
		singlyLL.add(3);
		singlyLL.add(7);
		singlyLL.add(10);
		System.out.println(singlyLL.printList());
		singlyLL.removeDups();
		System.out.println(singlyLL.printList());
		singlyLL.add(10);
		singlyLL.add(14);
		singlyLL.add(129);
		singlyLL.add(17);
		singlyLL.add(18);
		System.out.println(singlyLL.printList());
		singlyLL.removeDups();
		System.out.println(singlyLL.printList());
		System.out.println(singlyLL.getSize());
		singlyLL.deleteNode(4);
		System.out.println(singlyLL.printList());
		System.out.println(singlyLL.getSize());
		singlyLL.partition(20);
		System.out.println(singlyLL.printList());
		*/
		
		LinkedList num1 = new LinkedList();
		LinkedList num2 = new LinkedList();
		LinkedList sum = new LinkedList();
		
		num1.add(1);
		num1.add(3);
		num1.add(9);
		num1.add(2);
		
		num2.add(5);
		num2.add(2);
		num2.add(2);
		num2.add(2);
		
		sum = sumLists(num1, num2);
		System.out.println(sum.printList());
		
		
	}
	
	//To produce in forward order, remove .reverse() functions.
	public static LinkedList sumLists(LinkedList num1, LinkedList num2) {
		LinkedList sumList = new LinkedList();
		StringBuilder number = new StringBuilder();
		
		while(num1.head != null) {
			number.append(num1.head.data);
			num1.head = num1.head.next;
		}
		int firstInt = Integer.parseInt(number.reverse().toString());
		number = new StringBuilder();
		
		while(num2.head != null) {
			number.append(num2.head.data);
			num2.head = num2.head.next;
		}
		int secondInt = Integer.parseInt(number.reverse().toString());
		number = new StringBuilder();
		
		int sum = firstInt + secondInt;
		number.append(sum);
		char[] numReversed = number.reverse().toString().toCharArray();
		
		for(int i = 0; i < numReversed.length; i++) {
			sumList.add(Character.getNumericValue(numReversed[i]));
		}
		return sumList;
		
		
	}
}

class LinkedList{
	Node head;
	
	public void add(int data) {
		if(head != null) {
			head.add(head, data);
			return;
		}
		Node node = new Node(data);
		head = node;
	}
	
	public void removeDups() {
		head.removeDups(head);
	}
	
	public String printList() {
		return head.printList(head);
	}
	
	public int getSize() {
		return head.getSize(head);
	}
	
	public void deleteNode(int index) {
		head.deleteNode(head, index);
	}
	
	public void partition(int x) {
		head.partition(head, x);
	}
	
	class Node{
			
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
		
		public void add(Node head, int data) {
			Node newNode = new Node(data);
			
			while (head.next != null) {
				head = head.next;
			}
			head.next = newNode;
			return;
		}
		
		public void deleteNode(Node node)
	    {
	       Node temp = node.next;
	       node.data = temp.data;
	       node.next = temp.next;
	       temp = null;
	    }
		
		public void deleteNode(Node head, int index) {
			for (int i = 0; i < index; i++) {
				head = head.next;
			}
			deleteNode(head);
		}
		
		public void removeDups(Node head) {
			
			HashSet<Integer> set = new HashSet<>();
			
			while(head != null) {
				if(set.contains(head.data)) {
					deleteNode(head);
					head = head.next;
					continue;
				}
				set.add(head.data);
				head = head.next;
			}
		}
		
		public String printList(Node head) {
			StringJoiner list = new StringJoiner("->");
			while (head != null) {
				list.add(String.valueOf(head.data));
				head = head.next;
			}
			return list.toString();
		}
		
		public int getSize(Node head) {
			int size = 0;
			
			while(head != null) {
				size++;
				head = head.next;
			}
			return size;
		}
		
		public void swap(Node node1, Node node2) {
			Node tmp = new Node(node1.data);
			node1.data = node2.data;
			node2.data = tmp.data;
		}
		
		public void partition(Node head, int x) {
			Node node1 = head;
			Node node2 = head;
			
			while(node2 != null) {
				if(node1.data < x) {
					node1 = node1.next;
				}
				else {
					node2 = node1;
					while(node2.data > x && node2 != null) {
						node2 = node2.next;
						if(node2 == null)
							return;
					}
					
					
					swap(node1, node2);
				}
				
			}
		}
	}
}

