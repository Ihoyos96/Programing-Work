package Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MostFreq {

	public static void main (String[] arg) {
		
		HashMap<Integer, kNode> map = new HashMap<Integer, kNode>();
		
		for(int i = 0; i < 10; i++) {
			kNode n = new kNode(i);
			map.put(i, n);
		}
		
		for (int j = 6; j < 12; j++) {
			kNode m;
			
			if (map.containsKey(j)) {
				m = map.get(j);
				m.frequency++;
			}
			else {
				m = new kNode(j);
				map.put(j, m);
			}
		}
		kNode test = new kNode(35);
		test.frequency = 5;
		map.put(15, test);
		
		ArrayList<kNode> list = new ArrayList<kNode>();
		
		for (kNode s : map.values()){
			int low = 0;
			int high = list.size() - 1;
			
			while (low <= high) {
				int mid = (low + high)/2;
				kNode node = list.get(mid);
				
				if (s.frequency > node.frequency) {
					high = mid - 1;
					continue;
				}
				else if (s.frequency < node.frequency) {
					low = mid + 1;
					continue;
				}
				else
					low = mid;
					break;
			}
			list.add(low, s);
		}
		for (kNode n : list) {
			System.out.print(n.frequency + " ");
		}
	}
}

class kNode{
	int data;
	int frequency;
	
	public kNode(int data) {
		this.data = data;
		frequency = 1;
	}
}