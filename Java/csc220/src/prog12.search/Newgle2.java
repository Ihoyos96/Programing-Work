
package prog12;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Newgle2 implements SearchEngine {
	
	
	public HardDisk<PageFile> pageDisk = new HardDisk<PageFile>();
	public PageTrie page2index = new PageTrie();
	public HardDisk<List<Long>> wordDisk = new HardDisk<List<Long>>();
	public WordTable word2index = new WordTable();

	Long IndexThisPage(String url) {
		Long thisIndex = pageDisk.newFile();
		PageFile pageFile = new PageFile(thisIndex, url);

		
		System.out.println("indexing page " + pageFile);

		pageDisk.put(thisIndex, pageFile);
		page2index.put(url, thisIndex);
		return thisIndex;
	}

	Long wordIndex(String word) {
		Long thisIndex = wordDisk.newFile();
		List<Long> wordFile = new ArrayList<Long>();
		
		System.out.println("indexing word " + thisIndex + "(" + word + ")" + wordFile);
		wordDisk.put(thisIndex, wordFile);
		word2index.put(word, thisIndex);
		return thisIndex;
	}

	@Override
	public void gather(Browser browser, List<String> startingURLs) {
		page2index.read(pageDisk);
		word2index.read(wordDisk);

		
			System.out.println("pageDisk\n" + pageDisk);
		
			System.out.println("page2index\n" + page2index);
		
			System.out.println("wordDisk\n" + wordDisk);
	
			System.out.println("word2index\n" + word2index);
	}

	@Override
	public String[] search(List<String> keyWords, int numResults) {

		Iterator<Long>[] pageIndexIterators = (Iterator<Long>[]) new Iterator[keyWords.size()];

		long[] currentPageIndices = new long[keyWords.size()];

		PriorityQueue<Long> bestPageIndices = new PriorityQueue<Long>(numResults, new PageComparator());

		for (int i = 0; i < keyWords.size(); i++) {
			if (!word2index.containsKey(keyWords.get(i)))
				return new String[0];

			pageIndexIterators[i] = wordDisk.get(word2index.get(keyWords.get(i))).iterator();

		}

		/////////////////////////////////////////
		// my Iterator moves through the indexes//
		/////////////////////////////////////////

		while (moveForward(currentPageIndices, pageIndexIterators)) {
			if (allEqual(currentPageIndices)) {
				long firstIndex = currentPageIndices[0];

				if (bestPageIndices.size() < numResults || 
						pageDisk.get(firstIndex).getRefCount() > pageDisk.get(bestPageIndices.peek()).getRefCount()) {
					
					if (bestPageIndices.size() == numResults)
						bestPageIndices.poll();

					bestPageIndices.offer(firstIndex);
				}
			}
		}
		String[] results = new String[bestPageIndices.size()];
		for (int j = bestPageIndices.size() - 1; j >= 0; j--)
			results[j] = pageDisk.get(bestPageIndices.poll()).url;
		return results;
	}

	private boolean moveForward(long[] currentPageIndices, Iterator<Long>[] pageIndexIterators) {
		long biggest = currentPageIndices[0];

		/////////////////////////////////////////////////X
		// Compare biggest to the currentPageIndex at i /X
		/////////////////////////////////////////////////X

		for (int i = 1; i < currentPageIndices.length; i++) {
			if (currentPageIndices[i] > biggest)
				biggest = currentPageIndices[i];
		}
		if (allEqual(currentPageIndices))
			biggest++;

		for (int i = 0; i < currentPageIndices.length; i++)
			if (currentPageIndices[i] != biggest)
				if (pageIndexIterators[i].hasNext())
					currentPageIndices[i] = pageIndexIterators[i].next();
				else
					return false;
		return true;
	}

	private boolean allEqual(long[] array) {
		for (int i = 1; i < array.length; i++)
			if (array[i] != array[0])
				return false;
		return true;
	}

	public class PageComparator implements Comparator<Long> {
		@Override
		public int compare(Long L1, Long L2) {
			return pageDisk.get(L1).getRefCount() - pageDisk.get(L2).getRefCount();
		}
	}
}
