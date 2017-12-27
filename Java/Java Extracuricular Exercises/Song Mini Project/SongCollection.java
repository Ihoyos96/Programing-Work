package songs;

import java.util.*;
import java.io.*;
public class SongCollection implements SongCollectionInt{

    private Song[] theSongs;

    	public SongCollection(){
		theSongs = new Song[0];
	}
    	

        public int size(){
           return theSongs.length;
        }

        public void addFromFile( File f ){
            Scanner scanner;
            try{
    		 scanner = new Scanner (f);
    	   }catch (FileNotFoundException ex){
    		System.out.println("File " + f + " not found.");
    		System.out.println(ex);
    		return;
    		}
    		   int additions =  Integer.parseInt(scanner.nextLine());
    		   Song[] tmp = new Song[theSongs.length+additions];
    		   for(int i = 0; i < theSongs.length; i++){
    		      tmp[i] = theSongs[i];
    		   }

    		   for ( int i=0; i < additions; i++){
    		   Song add = new Song (scanner.nextLine(), scanner.nextLine());
    		       tmp[i + theSongs.length] = add;
    		   }
    		   theSongs = tmp;
    		   scanner.close();
    	}
        
        public void writeToFile( File f ){
	        try{
			   System.out.println("Enter file name:" + f.getName());
			   @SuppressWarnings("resource")
			PrintStream stream =  new PrintStream(f);
			   stream.println(theSongs.length);
			   for ( int i=0; i< theSongs.length; i++){
			       stream.println (theSongs[i].getTitle());
			       stream.println (theSongs[i].getArtist());
			   }
			}
			catch (FileNotFoundException ex){
				System.out.println("File " + f + " not found.");
				System.out.println(ex);
				return;
			}
        }
        
        public void addOneSong( String t, String a ){
	        Song song = new Song(t, a);
	        Song[] tmp = Arrays.copyOf ( theSongs, (theSongs.length + 1));
	        int index = tmp.length;
	        tmp[index-1] = song;
	        theSongs = tmp;
        }
        
        public void delete( int pos ){
	        for(int i=pos; i<theSongs.length - 1; i++){
	        	theSongs[i] = theSongs[i+1];
	        }

	        Song[] tmp = new Song [theSongs.length -1];
	        theSongs = tmp;
       	}

        
        public void searchByTitle (String key){
        
	        for (int i = 0; i < theSongs.length; i++){
	        	if (theSongs[i].getTitle().equals(key)){
	        	System.out.println(i + ": " + theSongs[i].getTitle() + ", " +  theSongs[i].getArtist());
	        	}
        	}
        }
        
        public void searchByArtist (String key){
     
	        for (int i = 0; i < theSongs.length; i++){
	        	if (theSongs[i].getArtist() == key){
	        	System.out.println(i + ": " + theSongs[i].getTitle() + ", " +  theSongs[i].getArtist());
	        	}
	        }
        }
       
        public void show (int start, int end){
			if(start < 0) {
				start = 0;
			}
			if(end > theSongs.length){
				end = theSongs.length;
			}
	        for (int i=start; i<end; i++){
	        	System.out.println(i + ": " + theSongs[i].getTitle() + ", " +  theSongs[i].getArtist());
	        }
       }
}

