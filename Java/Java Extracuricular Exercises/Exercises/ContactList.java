package Exercises;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ContactList {

    public static ArrayList<String> contactList = new ArrayList<String>();
    public static int size;
    
    public static void addContact(String contact){
        if (contactList.contains(contact) == true)
            return;
        contactList.add(contact);
    }
    
    public static int findContact(String partial){
        int count = 0;
        if (contactList.contains(partial))
        		count++;
        
        return count;
    }
    
    public static void main(String[] args) {
        
    		String test = "a";
        addContact("John");
        addContact("Jacob");
        addContact("Johnny");
        addContact("Mary");
        System.out.println(findContact("John"));
        System.out.println();
        if (test.substring(1).isEmpty())
        		System.out.println("Empty");
    }
}