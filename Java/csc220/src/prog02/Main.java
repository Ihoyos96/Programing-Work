package prog02;

/**
 *
 * @author vjm
 */
public class Main {

	/** Processes user's commands on a phone directory.
      @param fn The file containing the phone directory.
      @param ui The UserInterface object to use
             to talk to the user.
      @param pd The PhoneDirectory object to use
             to process the phone directory.
	 */
	public static void processCommands(String fn, UserInterface ui, PhoneDirectory pd) {
		pd.loadData(fn);

		String[] commands = {
				"Add/Change Entry",
				"Look Up Entry",
				"Remove Entry",
				"Save Directory",
		"Exit"};

		String name, number, oldNumber;

		while (true) {
			int c = ui.getCommand(commands);
			switch (c) {
			case -1:
				ui.sendMessage("You clicked the red x, restarting.");
				break;
				
			case 0:
				// Ask for the name.
				name = ui.getInfo("Enter name");
								if (name == null || name.equals(""))
								break;
				// Ask for the number.				 	
				number = ui.getInfo("Enter number");
								if (number == null)
								break;
								
				//implement find and display old number if number is changed.
								
				pd.addOrChangeEntry(name, number);
				pd.save();
				
				ui.sendMessage(name + " has been added to the directory with the number " + number);
					
				break;
				
				// !!! Check for cancel.  Blank is o.k.
				// Call addOrChangeEntry
				// Report the result
				
			case 1:
				name = ui.getInfo("Enter name");
				
				if (name == null || name.equals("")){
					break;
				}

				number = pd.lookupEntry(name);
					
					if (pd.lookupEntry(name) == null){
						ui.sendMessage("That name is not in the directory");
						break; 
					}
					
					if (pd.lookupEntry(name) != null){
						ui.sendMessage("Name: "+ name + "\n" + "Number: " + pd.lookupEntry(name));
					}
					
				break;
				
			case 2:
				name = ui.getInfo("Enter name");
					if (name == null || name.equals(""))
						break;
					
					if (pd.removeEntry(name) == null){
						ui.sendMessage("Entry not found");
						break;
						}
						
					if (name != null)
						pd.removeEntry(name);
						ui.sendMessage("Contact has been removed.");
				
				
				break;
				
			case 3:
				pd.save();
				break;
				
			case 4:
				pd.save();
				return;
			}
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		String fn = "csc220.txt";
		PhoneDirectory pd = new SortedPD();
		UserInterface ui = new GUI();
		processCommands(fn, ui, pd);
	}
}
