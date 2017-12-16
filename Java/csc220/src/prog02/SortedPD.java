package prog02;
import java.io.*;

/**
 *
 * @author vjm
 */
public class SortedPD extends ArrayBasedPD {
	

	/** Add an entry to the directory.
    @param name The name of the new person
    @param number The number of the new person
	 */
	protected void add(String name, String number) {
		
		FindOutput fo = find(name);
		int insertionIndex = fo.index;
		
		for (int i = size-1; i >= fo.index; i--){
			theDirectory[i+1] = theDirectory[i];
		}
		
		if (size <= theDirectory.length) {
			reallocate();
		}
		theDirectory[insertionIndex] = new DirectoryEntry(name, number);
		size++;
		
	}
	
	/** Find an entry in the directory.
    @param name The name to be found
    @return A FindOutput object containing the result of the search.
	 */
	protected FindOutput find (String name) {
		
		int first = 0;
		int last = size;
		
		while (first < last){
			int mid = ((first + last) / 2);
			int cmp = name.compareTo(theDirectory[mid].getName());
		
			if (cmp < 0) {
				last = mid;	}
	
			if (cmp > 0) {
				first = mid + 1;}
			
			if (cmp == 0)
				return new FindOutput(true, mid);
			
		}
		
				return new FindOutput(false, first);
	}

	
	/** Remove an entry from the directory.
    @param name The name of the person to be removed
    @return The current number. If not in directory, null is
            returned
	 */
	public String removeEntry (String name) {
		FindOutput fo = find(name);
		if (!fo.found)
			return null;
		
		DirectoryEntry entry = theDirectory[fo.index];
		
		for (int i = fo.index; i < size-1; i++){
			theDirectory[i] = theDirectory[i+1];
		}
		
		size--;
		modified = true;
		return entry.getNumber();
	}
	
}
