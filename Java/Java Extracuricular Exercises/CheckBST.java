package Exercises;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
}

public class CheckBST {
   
	boolean checkBST(TreeNode root) {
		return checkBalance(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	boolean checkBalance(TreeNode root, int min, int max){
		if(root == null)
			return true;
	    
		if(root.data <= min || root.data >= max)
			return false;
	    
		return checkBalance(root.left, min, root.data) 
			&& checkBalance(root.right, root.data, max);
	}
	
}
