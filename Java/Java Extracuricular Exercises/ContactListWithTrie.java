package Exercises;
import java.util.*;

public class ContactListWithTrie {

    public static void main(String[] args) {
        TrieNode trie = new TrieNode();
        trie.add("eouecvksgllpvfxfvndu");
        System.out.println(trie.find("zivh"));
        trie.add("uugxgcrtujxzyjysqrhu");
        System.out.println(trie.find("of"));
        trie.add("ryhlozedmgzcmjdfjhte");
        System.out.println(trie.find("uqaqv"));
        trie.add("ibfzenldsdltkjbbsccq");
        System.out.println(trie.find("bmcop"));
        trie.add("vvxwlttswneoosvgfezt");
        System.out.println(trie.find("ve"));
        trie.add("gkhkvxwlttswneoofezt");
        System.out.println(trie.find("ge"));
        

    }
}

class TrieNode {
	HashMap<Character, TrieNode> children;
	int wordCount;
	
	public TrieNode() {
		this.children = new HashMap<Character, TrieNode>();
        this.wordCount = 0;
	}
	
	public void add(String s) {
		
		if (s.isEmpty()) {
			wordCount++;
			return;
		}
		children.putIfAbsent(s.charAt(0), new TrieNode());
		children.get(s.charAt(0)).add(s.substring(1));
		wordCount++;
		return;
		
	}
	
	public int find(String s) {
		TrieNode node = children.get(s.charAt(0));
		if (node == null)
			return 0;
		for (int i = 1; i < s.length(); i++) {
			node = node.children.get(s.charAt(i));
			if (node == null)
				return 0;
		}
		return node.wordCount;
	}
}