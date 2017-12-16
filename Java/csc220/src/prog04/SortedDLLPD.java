package prog04;


/** This is an implementation of the prog02.PhoneDirectory interface that uses
 *   a doubly linked list to store the data.
 *   @author vjm
 */
public class SortedDLLPD extends DLLBasedPD {
  /** Add an entry to the directory.
      @param name The name of the new person.
      @param number The number of the new person.
  */
  protected void add (String name, String number) {
    // EXERCISE
    // Call find to find where to put the entry.
	  FindOutput fo = find(name);
	  

    // How does find tell you that the new entry should go at the end?
    // Test for this condition and call super.add which handles it.
    // Create a new entry to insert.
	  
	  /*if(fo.entry == null){
		  super.add(name, number);
		  return;
	  }*/
	  if (head == null && tail == null){
		  super.add(name, number);
	  return;
	  }
	  
	  DLLEntry entry = new DLLEntry(name, number);
    // How can you tell if the new entry should go at the front?
    // Test for this condition and write code to handle it.
	 
	  if (fo.entry == null){
		  entry.setPrevious(tail);
		  tail.setNext(entry);
		  tail = entry;
	  }
	  
	  if (fo.entry == head){
		  entry.setNext(head);
		  System.out.println("FO: " + fo.entry);
	  	  fo.entry.setPrevious(entry);
	  	  head = entry;
	  }


    // Set next to the entry that will be next after the new entry is
    // inserted.
	// Set previous to the entry that will be previous.
	  DLLEntry next = fo.entry;
	  DLLEntry previous = fo.entry.getPrevious();
	  
	  entry.setNext(next);
	  next.setPrevious(entry);
	  entry.setPrevious(previous);
	  previous.setNext(entry);
		  
    
    


    // Insert the new DLLEntry between next and previous.


  }

  /** Find an entry in the directory.
      @param name The name to be found.
      @return A FindOutput object describing the result.
  */
  protected FindOutput find (String name) {
	  // EXERCISE
	  // Modify find so it also stops when it gets to an entry after the
	  // one you want.
	  // EXERCISE
	  // For each entry in the directory.
		  
	  for (DLLEntry i = head; i != null; i = i.getNext()) {  
			  int cmp = name.compareTo(i.getName());
			  
			  if (cmp < 0){
				  return new FindOutput(false, i);
			  }
			  
			  if (i.getName().equals(name))
				  
	  			return new FindOutput(true, i);
			  	
			  }
	  

	  return new FindOutput(false, null);
  }

}
