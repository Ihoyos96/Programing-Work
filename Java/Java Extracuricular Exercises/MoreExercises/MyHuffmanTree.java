package MoreExercises;

import java.util.ArrayList;

public class MyHuffmanTree {

	public static void main(String[] args) {
		
		HuffmanTree htree = new HuffmanTree();
		char[] letters = {'a','b','c','d','e','f','g','h','i','j','k'};
		int[] frequencies = {1,1,1,1,1,1,2,2,3,4,6};
		htree.construct(letters, frequencies);
		
		htree.print(htree.root);
	}
}


class HuffmanTree{

	class Node{
		char letter;
		int frequency;
		Node right;
		Node left;

		public Node(char letter, int frequency){
			this.letter = letter;
			this.frequency = frequency;
			left = right = null;
		}

		public Node(int frequency){
			this.frequency = frequency;
			left = right = null;
		}
		
	}
	
	

	ArrayList<Node> list;
	Node root;
	//Node[] alphabet = new Node[26];

	public HuffmanTree() {
		list = new ArrayList<Node>();
		root = null;
	}
	
	void print(Node root) {
		if (root == null)
			return;
		print(root.left);
		print(root.right);
		System.out.print(root.frequency + " ");	
	}
	
	void construct(char[] letters, int[] frequencies){
		int limit = letters.length;

		Node first = new Node(letters[0], frequencies[0]);
		Node second = new Node(letters[1], frequencies[1]);
		int newFrequency = first.frequency + second.frequency;

		Node root = new Node(newFrequency);
		if (first.frequency <= second.frequency){
			root.left = first;
			root.right = second;
		} 
		else {
			root.left = second;
			root.right = first;
		}

		int count = 2;

		while (count < limit){

			if (!(list.isEmpty()) && (list.get(0).frequency < frequencies[count] && list.get(1).frequency < frequencies[count])){
				Node a = list.get(0);
				Node b = list.get(1);
				Node ffRoot = new Node(a.frequency + b.frequency);

				if (a.frequency <= b.frequency){
					ffRoot.left = a;
					ffRoot.right = b;
				}
				else {
					ffRoot.left = b;
					ffRoot.right = a;
				}
				list.remove(0);
				list.remove(0);
				list.add(ffRoot);
			}
			else if (count < limit - 1 && (root.frequency < frequencies[count + 1] && (!(list.isEmpty()) && root.frequency < list.get(0).frequency)) || count == limit - 1){
				Node lowest = new Node(letters[count], frequencies[count]);

				Node newRoot = new Node(lowest.frequency + root.frequency);

				if (lowest.frequency <= root.frequency){
					newRoot.left = lowest;
					newRoot.right = root;
				}
				else {
					newRoot.left = root;
					newRoot.right = lowest;
				}

				root = newRoot;
				count++;
			}
			else if (!(list.isEmpty()) && ((count < limit - 1) && list.get(0).frequency < frequencies[count + 1])){
				Node lowest = new Node(letters[count], frequencies[count]);
				Node a = list.get(0);

				Node ffRoot = new Node(a.frequency + lowest.frequency);

				if (lowest.frequency <= a.frequency){
					ffRoot.left = lowest;
					ffRoot.right = a;
				}
				else {
					ffRoot.left = a;
					ffRoot.right = lowest;
				}
				list.remove(0);
				list.add(ffRoot);
				count++;
			}
			else {
				Node a = new Node(letters[count], frequencies[count]);
				Node b = new Node(letters[count + 1], frequencies[count + 1]);

				Node ffRoot = new Node(a.frequency + b.frequency);

				if (a.frequency <= b.frequency){
					ffRoot.left = a;
					ffRoot.right = b;
				}
				else{
					ffRoot.left = b;
					ffRoot.right = a;
				}
				list.add(ffRoot);
				count += 2;
			}
		}
		
		while (!(list.isEmpty())){
			if (list.size() == 1) {
				Node node = list.get(0);
				Node newRoot = new Node (root.frequency + node.frequency);
				
				if ( root.frequency <= node.frequency) {
					newRoot.left = root;
					newRoot.right = node;
				}
				else {
					newRoot.left = node;
					newRoot.right = root;
				}
				root = newRoot;
				list.remove(0);
			}
			else if (root.frequency <= list.get(1).frequency) {
				Node node = list.get(0);
				Node newRoot = new Node (root.frequency + node.frequency);
				
				if (root.frequency <= node.frequency) {
					newRoot.left = root;
					newRoot.right = node;
				}
				else {
					newRoot.left = node;
					newRoot.right = root;
				}
				root = newRoot;
				list.remove(0);
			}
			else {
				Node a = list.get(0);
				Node b = list.get(1);
				Node ffRoot = new Node(a.frequency + b.frequency);
				
				if (a.frequency <= b.frequency) {
					ffRoot.left = a;
					ffRoot.right = b;
				}
				else {
					ffRoot.left = b;
					ffRoot.right = a;
				}
				list.add(ffRoot);
				list.remove(0);
				list.remove(0);
				
			}
		}
		this.root = root;
	}
}

