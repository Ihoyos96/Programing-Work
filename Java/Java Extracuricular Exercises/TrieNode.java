package Exercises;
import java.util.*;

class TrieNodeO {
	HashMap<Character, TrieNodeO> children;
	boolean isWord;
	int wordCount;
	
	public TrieNodeO() {
		this.children = new HashMap<Character, TrieNodeO>();
		this.isWord = false;
	}
	
	public void add(String s) {
		
		if (s.isEmpty()) {
			this.isWord = true;
			wordCount++;
			return;
		}
		children.putIfAbsent(s.charAt(0), new TrieNodeO());
		children.get(s.charAt(0)).add(s.substring(1));
		wordCount++;
		return;
		
	}
	
	public int find(String s) {
		TrieNodeO root = children.get(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			root = root.children.get(s.charAt(i));
			if (root == null)
				return 0;
		}
		return wordCount;
	}
}
