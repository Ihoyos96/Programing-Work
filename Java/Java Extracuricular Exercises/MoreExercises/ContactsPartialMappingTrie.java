package MoreExercises;
import java.util.*;

public class ContactsPartialMappingTrie {

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
        trie.add("gvxwlttswneoosvgfezt");
        trie.add("gaby herp");
        System.out.println(trie.find("ve"));
        trie.add("gkhkvxwlttswneoofezt");
        System.out.println(trie.find("g"));
        

    }
}

class TrieNode {
	HashMap<Character, TrieNode> children;
	int wordCount;
	boolean isComplete;
	
	public TrieNode() {
		this.children = new HashMap<Character, TrieNode>();
        this.wordCount = 0;
        this.isComplete = false;
	}
	
	public void add(String s) {
		
		if (s.isEmpty()) {
			wordCount++;
			isComplete = true;
			return;
		}
		children.putIfAbsent(s.charAt(0), new TrieNode());
		children.get(s.charAt(0)).add(s.substring(1));
		wordCount++;
		return;
		
	}
	
	public ArrayList<String> traverse(TrieNode t, StringBuilder sb, ArrayList<String> list) {
		if (t.isComplete)
			list.add(sb.toString());
			
		if (t.children.keySet().isEmpty())
			return list;
		
		for (Character key : t.children.keySet()) {
			sb.append(key);
			traverse(t.children.get(key), sb, list);
			sb.deleteCharAt(sb.length() - 1);
		}
		return list;
	}
	
	public ArrayList<String> find(String s) {
		TrieNode node = children.get(s.charAt(0));
		if (node == null)
			return null;
		for (int i = 1; i < s.length(); i++) {
			node = node.children.get(s.charAt(i));
			if (node == null)
				return null;
		}
		
		ArrayList<String> list = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		
		return traverse(node, sb, list);
	}
}