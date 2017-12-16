package prog12;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Newgle implements SearchEngine{

	HardDisk<PageFile> pageDisk = new HardDisk<PageFile>();
	HardDisk<List<Long>> wordDisk = new HardDisk <List<Long>>();
	
	PageTrie page2index = new PageTrie();
	WordTable word2index = new WordTable();
	
	
	
	//Browser browser, List<String> startingURLs <- as constructors?
	public void gather(Browser browser, List<String> startingURLs) {
		
		Queue<Long> theQueue = new ArrayDeque();
		
		for(String url : startingURLs){
			if(!page2index.containsKey(url)){
				theQueue.offer(indexPage(url));
			}
		}
		
		while (theQueue.size()>0){
			Long urlIndex = theQueue.poll();
			PageFile file = pageDisk.get(urlIndex);
			if(browser.loadPage(file.url)){
			    
				List<String> browserURLs = browser.getURLs();
				Set<Long> urlHashCodes = new HashSet<Long>();
				Set<Long> wordHashCodes = new HashSet<Long>();
				
				for(String url : browserURLs){
					if(!page2index.containsKey(url)){
						Long tempIndex = indexPage(url);
						theQueue.offer(tempIndex);
						urlHashCodes.add(tempIndex);
					}else{
						urlHashCodes.add(page2index.get(url));
					}
				}
				for(Long reference : urlHashCodes){
					pageDisk.get(reference).incRefCount();
				}
				
				for(String word : browser.getWords()){
					if(!word2index.containsKey(word)){
						wordHashCodes.add(indexWord(word));
					} else {
						wordHashCodes.add(word2index.get(word));
					}
				}
				for(Long word : wordHashCodes){
					wordDisk.get(word).add(urlIndex);
				}
				
			}
		
			
			
		}
		System.out.println("pageDisk");
		System.out.println(pageDisk);
		System.out.println("page2index");
		System.out.println(page2index);
		System.out.println("wordDisk");
		System.out.println(wordDisk);
		System.out.println("word2index");
		System.out.println(word2index);
		page2index.write(pageDisk);
		word2index.write(wordDisk);
		
	}
	
	public Long indexWord (String word){
		
		Long index = wordDisk.newFile();
		List<Long> pagesOn = new LinkedList<Long>();
		wordDisk.put(index, pagesOn);
		word2index.put(word, index);
		return index;
	}

	@Override
	public String[] search(List<String> keyWords, int numResults) {
		// TODO Auto-generated method stub
		return new String[0];
	}
	
	public Long indexPage(String url){
		
		Long index = pageDisk.newFile();
		PageFile thisPageFile = new PageFile(index, url);
		pageDisk.put(index, thisPageFile);
		page2index.put(url, index);
		System.out.println(thisPageFile);
		return index;
		
	}
	
}
