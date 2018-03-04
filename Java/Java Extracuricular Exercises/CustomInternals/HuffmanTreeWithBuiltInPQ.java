package CustomInternals;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanTreeWithBuiltInPQ{
	  public static void main(String[] args){
	    char[] letters = {'a','b','c','d','f','i','s','r'};
	    int[] frequencies = {4,2,7,5,4,8,2,1};
	    
	    ThisHuffmanTree htree = new ThisHuffmanTree();
	    htree.construct(letters, frequencies);
	    
	    
	    
	    System.out.println("dad econded is -> " + htree.encode("dad"));
	    System.out.println("110100110 decoded is -> " + htree.decode("110100110"));
	    System.out.println("fardis encoded is -> " + htree.encode("fardis"));
	    System.out.println("110100110 decoded is -> " + htree.decode("10110011110110011110"));
	 }
}


class MyComparator implements Comparator<Node>{
  public int compare(Node a, Node b){
    return a.freq - b.freq;
  }
}

class ThisHuffmanTree{
  Node root; // root of the HuffmanTree

  public ThisHuffmanTree(){
    root = null;
  }

  String encode(String s){
    StringBuilder sb = new StringBuilder();
    String code = "";
    String partial = "";
    for(char letter : s.toCharArray()){
      partial = traverse(root, letter, sb, partial);
      if (partial.isEmpty())
        return partial;
      code = code + partial;
      partial = "";
      sb = new StringBuilder();
    }
    return code;
  }

  String decode(String code){
    Node node = root;
    String decoded = "";
    for(char bit : code.toCharArray()){
      
        
        if(bit == '0')
            if(node.left != null){
              node = node.left;
            }
            else
              return null;
        else if(bit == '1')
          if(node.right != null){
            node = node.right;
          }
          else
            return null;
      
        if(node.left == null && node.right == null){
          decoded = decoded + Character.toString(node.letter);
          node = root;
        }
      
    }
    return decoded;
  }
  
  private String traverse(Node root, char letter, StringBuilder sb, String partial){
    if (root != null){
      if (root.letter == letter){
        partial = sb.toString();
        return partial;
      }

      sb.append("0");
      partial = traverse(root.left, letter, sb, partial);
      if (!partial.isEmpty())
        return partial;
      sb.deleteCharAt(sb.length() - 1);

      sb.append("1");
      partial = traverse(root.right, letter, sb, partial);
      if (!partial.isEmpty())
        return partial;
      sb.deleteCharAt(sb.length() - 1);
    }
    return partial;
  }

  void construct(char[] letters, int[] frequencies){
    PriorityQueue<Node> pq = new PriorityQueue<Node>(letters.length, new MyComparator());

    for(int i = 0; i < letters.length; i++){
      char letter = letters[i];
      int frequency = frequencies[i];

      Node newNode = new Node(letter, frequency);
      pq.add(newNode);
    }

    while(pq.size() > 1){
      Node lowest = pq.peek();
      pq.poll();

      Node nextLowest = pq.peek();
      pq.poll();

      Node newSubRoot = new Node('+', lowest.freq + nextLowest.freq);
      newSubRoot.left = lowest;
      newSubRoot.right = nextLowest;

      pq.add(newSubRoot);
    }

    root = pq.peek();
  }
}