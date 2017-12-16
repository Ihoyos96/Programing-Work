package prog12;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Newgle implements SearchEngine{

	HardDisk<PageFile> pageDisk = new HardDisk<PageFile>();
	
	PageTrie page2index = new PageTrie();
	
	
	
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
				for(String url : browserURLs){
					if(!page2index.containsKey(url)){
						theQueue.offer(indexPage(url));
					}
				}
			}
			
			
		}
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
