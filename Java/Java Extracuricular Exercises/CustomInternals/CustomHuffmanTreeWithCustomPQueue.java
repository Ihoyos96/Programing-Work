package CustomInternals;

public class CustomHuffmanTreeWithCustomPQueue {

	public static void main(String[] args) {
		HuffmanTree htree = new HuffmanTree();
		char[] letters = {'a','b','c','d','e','f','g','h','i','j','k'};
		int[] frequencies = {4,1,2,6,2,1,1,2,3,4,1};
		
		htree.construct(letters, frequencies);
		
		System.out.println(htree.encode("cab"));
		
	}
}

class HuffmanTree{
	Node root;
	
	public HuffmanTree() {
		root = null;
	}
	
	void construct(char[] letters, int[] frequencies) {
		PriorityQueue pq = new PriorityQueue(letters.length);
		
		for(int i = 0; i < letters.length; i++) {
			char letter = letters[i];
			int frequency = frequencies[i];
			Node newNode = new Node(letter, frequency);
			pq.add(newNode);
		}
		
		while(pq.size > 1) {
			Node lowest = pq.peak();
			pq.poll();
			
			Node nextLowest = pq.peak();
			pq.poll();
			
			Node newSubRoot = new Node('|', lowest.freq + nextLowest.freq);
			newSubRoot.left = lowest;
			newSubRoot.right = nextLowest;
			
			pq.add(newSubRoot);
		}
		this.root = pq.peak();
	}
	
	String encode(String s) {
		StringBuilder sb = new StringBuilder();
		String code = "";
		String partial = "";
		for(char letter : s.toCharArray()) {	
			partial = traverse(root, letter, sb, partial);
			code = code + partial;
			partial = "";
			sb = new StringBuilder();
		}
		return code;
	}
	
	String traverse(Node root, char c, StringBuilder sb, String code) {
		
		if (root != null) {
			if (root.letter == c) {
				code = sb.toString();
				return code;
			}
			
			sb.append("0");
			code = traverse(root.left, c, sb, code);
			if (!code.isEmpty())
				return code;
			sb.deleteCharAt(sb.length() - 1);
			
			sb.append("1");
			code = traverse(root.right, c, sb, code);
			if (!code.isEmpty())
				return code;
			sb.deleteCharAt(sb.length() - 1);
		}
		return code;
	}
}


class Node{
	char letter;
	int freq;

	Node left;
	Node right;

	public Node(char letter, int freq){
		this.letter = letter;
		this.freq = freq;
		left = right = null;
	}
}

class PriorityQueue{
	// capacity
	// parent function
	// left child function(Node root) -> if left child > size - 1, return root(original position);
	// right child funtion(Node root) -> --^
	// add function
	// poll function -> remove top element: array[0] = array[size - 1] (replace root value with last element's) -> decrement size -- -> HeapifyDown(root);
	// peak function
	// swap function -> store a in temp, make a = b, make b = temp;
	// heapifyDown function (recursive) ->  int left = getLeft(root) right = getRight(root) -> if (left < size && root > left) or (right < size && root > right) -> if root > left, swap(root, root.left) and heapifyDown(left)
	// heapifyUp function


	Node[] array;
	int capacity;
	int size = 0;

	public PriorityQueue(int capacity){
		this.capacity = capacity;
		array = new Node[capacity];
	}

	public void print()
    {
        for (int i = 0; i <= size / 2 - 1; i++ )
        {
            System.out.print(" PARENT : " + array[i].letter + " : " + array[i].freq + " LEFT CHILD : " + array[2*i + 1].letter + " : " + array[2*i+1].freq 
                + " RIGHT CHILD :" + array[2*i+2].letter + " : " + array[2*i+2].freq);
            System.out.println();
        } 
    }
	
	int getParent(int pos){
		int parent = (pos - 1)/2;
		if (parent < 0)
			return pos;
		return parent;
	}

	int getLeftChild(int pos){
		int left = (2*pos) + 1;
		if (left > size - 1)
			return pos;
		return left;
	}

	int getRightChild(int pos){
		int right = (2*pos) + 2;
		if (right > size - 1)
			return pos;
		return right;
	}

	void add(Node element){
		if (size < array.length){
			array[size] = element;
			size++;
			heapifyUp(size - 1);
		}
		else {
			throw new ArrayIndexOutOfBoundsException("Queue is full");
		}
	}

	void poll(){
		array[0] = array[size - 1];
		size--;
		heapifyDown(0);
	}

	Node peak(){
		return array[0];
	}

	void swap(int pos1, int pos2){
		Node temp = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = temp;
	}

	// int left = getLeft(root) right = getRight(root) 
	// -> if (left < size && root > left) or (right < size && root > right) 
	// -> if root > left, swap(root, root.left) and heapifyDown(left)
	void heapifyDown(int root){
		int left = getLeftChild(root);
		int right = getRightChild(root);

		
		if ((left != root && array[root].freq > array[left].freq) || (right != root && array[root].freq > array[right].freq)){
			if (array[root].freq > array[left].freq){
				swap(root, left);
				heapifyDown(left);
			}
			else {
				swap(root, right);
				heapifyDown(right);
			}
		}
	}

	void heapifyUp(int pos){
		int parent = getParent(pos);

		while(pos != parent){
			if (array[pos].freq < array[parent].freq){
				swap(pos, parent);
				heapifyUp(parent);
			}
			else{ return; }
		}
	}
}