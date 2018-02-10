package MoreExercises;

/* Class containing left and right child of current
node and key value*/
class Node
{
	int data;
	Node left, right;

	public Node(int data)
	{
		this.data = data;
		left = right = null;
	}
}

// A Java program to introduce Binary Tree
class BinaryTree
{
	// Root of Binary Tree
	Node root;

	// Constructors
	BinaryTree(int key)
	{
		root = new Node(key);
	}

	BinaryTree()
	{
		root = null;
	}

	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();

		/*create root*/
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		
		System.out.println(isPresent(tree.root, 5));
		
	}
	
	private static Node find(Node root, int val){
	    if (root != null) {
	    		if (root.data == val)
	    			return root;     
	    		else {
	    			Node found = find(root.left, val);
	    			if (found == null)
	    		    		found = find(root.right, val);
	    			return found;
	    		}
	    }
	    return null;
	}

	private static int isPresent(Node root, int val){
	
	    Node found = find(root, val);
	    if (found != null)
	        return 1;
	    return 0;
	    
	}
}
