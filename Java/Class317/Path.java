package Class317;

import java.util.*;
import java.io.*;

public class Path {

public static void main (String[] args){

	
		System.out.println("Hello World!");
		String path1 = "///home/..a//.../.junk////";
		System.out.print(simplifyPath(path1));
		
		String path2 = "/////////";
		System.out.print("\n" + simplifyPath(path2));
	}

	public static String simplifyPath(String path) {
            path = path.replaceAll("[.]+", "");
            path = path.replaceAll("/+$", "/");
            if(path.length() == 1)
                return path;
    	    path = path.replaceAll("^/+", "/");
    	    path = path.replaceAll("[/]+","/");
    	    return path;
        
	}
}