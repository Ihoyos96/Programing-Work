package songs;

import java.util.*;
import java.io.*;

public interface SongMain{

    public static void main (String [] args) throws FileNotFoundException{

    SongCollection collection = new SongCollection();

    @SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);

    System.out.println("========Select action========");
    System.out.println("0. Quit");
    System.out.println("1. Get collection size");
    System.out.println("2. Search for title");
    System.out.println("3. Search for artist");
    System.out.println("4. Add from file");
    System.out.println("5. Save to file");
    System.out.println("6. Add one song");
    System.out.println("7. Remove one song");
    System.out.println("8. Show");
    System.out.println("Enter input:");

    int input;
    input= Integer.parseInt(in.nextLine());
    
    boolean condition = true;
    while(condition){
    	switch (input){
    	case 0:
    		condition = false;
    		return;
        case 1: 
        	int size = collection.size();
        	System.out.println( "Size=" + size);
           break;
        case 2:  
        	System.out.println("Enter Song Name: ");
         	String name = in.nextLine();
         	collection.searchByTitle(name);
         	break;
        case 3: 
        	System.out.println("Enter Artist Name: ");
         	name = in.nextLine();
         	collection.searchByArtist(name);
         	break;
        case 4:
        	System.out.println("Enter File Name: ");
			String file = in.nextLine();
        	collection.addFromFile(new File(file));
        	break;
        case 5: 
        	System.out.println("Enter File Name: ");
        	file = in.nextLine();
        	collection.writeToFile(new File(file));
        	break;
        case 6: 
        	System.out.println("Enter Song Title: ");
        	String title = in.nextLine(); 
        	System.out.println("Enter Artist Name: ");
        	String artist = in.nextLine(); 
        	collection.addOneSong(title, artist);
        	break; 
        case 7: 
        	System.out.println("Enter Index: ");
        	int index = Integer.parseInt(in.nextLine()); 
        	collection.delete(index);
        	break;
        case 8: 
        	System.out.println("Start: ");
        	int start = Integer.parseInt(in.nextLine());
        	System.out.println("End: ");
        	int end = Integer.parseInt(in.nextLine());
        	collection.show(start, end);
        	break;
        	}
    	
        	System.out.println("Enter input");
		    System.out.println("0. Quit");
		    System.out.println("1. Get collection size");
		    System.out.println("2. Search for title");
		    System.out.println("3. Search for artist");
		    System.out.println("4. Add from file");
		    System.out.println("5. Save to file");
		    System.out.println("6. Add one song");
		    System.out.println("7. Remove one song");
		    System.out.println("8. Show");
		    System.out.println("Enter your input:");


input= Integer.parseInt(in.nextLine());

        }
    }
}

    
