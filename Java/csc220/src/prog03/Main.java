package prog03;
import prog02.UserInterface;

import java.util.regex.Pattern;

import prog02.GUI;

/**
 *
 * @author vjm
 */
public class Main {
  /** Use this variable to store the result of each call to fib. */
  public static double fibN;

  /** Determine the time in microseconds it takes to calculate the
      n'th Fibonacci number.
      @param fib an object that implements the Fib interface
      @param n the index of the Fibonacci number to calculate
      @return the time for the call to fib(n) in microseconds
  */
  public static double time (Fib fib, int n) {
    // Get the starting time in nanoseconds.
    long start = System.nanoTime();
    // Store the result in fibN.
    fibN = fib.fib(n);
    // Get the ending time in nanoseconds.  Use long, as for start.
    long end = System.nanoTime();
    // Return the difference between the end time and the
    // start time divided by 1000.0 to convert to microseconds.
    return ((end - start)/1000);
  }

  /** Determine the average time in microseconds it takes to calculate
      the n'th Fibonacci number.
      @param fib an object that implements the Fib interface
      @param n the index of the Fibonacci number to calculate
      @param ncalls the number of calls to average over
      @return the average time per call
  */
  public static double averageTime (Fib fib, int n, long ncalls) {
    double totalTime = 0;

    // Add up the total call time for calling time (above) ncalls times.
    for (long i = 0; i < ncalls; i++){
    	totalTime += time(fib, n);
    }
    	
     return (totalTime/ncalls); 
     
    // Use long instead int in your declaration of the counter variable.
  }

  /** Determine the time in microseconds it takes to to calculate
      the n'th Fibonacci number accurate to three significant figures.
      @param fib an object that implements the Fib interface
      @param n the index of the Fibonacci number to calculate
      @return the time it it takes to compute the n'th Fibonacci number
  */
  public static double accurateTime (Fib fib, int n) {
    // Get the time using the time method above.
	  double t = time(fib, n);
	  
     //Since it is not very accurate, it might be zero.  If so set it to 0.1
	 if (t == 0){
		 t = 0.1;
	  }


    // Calculate the number of calls to average over that will give
    // three figures of accuracy.  
	 
	 //You will need to "cast" it to long
    // by putting   (long)   in front of the formula.
	 long ncalls = (long) ((1000*1000)/(t*t));


    // If ncalls is 0, increase it to 1.
	 if (ncalls == 0){
		 ncalls = 1;
	 }



    // Get the accurate time using averageTime.
	 return (averageTime(fib, n, ncalls));
	 

  }

  static void labExperiments () {
    // Create (Exponential time) Fib object and test it.
    Fib efib = new ExponentialFib();
    System.out.println(efib);
    for (int i = 0; i < 11; i++)
      System.out.println(i + " " + efib.fib(i));
    //implement for ncalls , for all calculations. n1, n2, etc..
    //then find accurate time.
    
    // Determine running time for n1 = 20 and print it out.
    int n1 = 20;
    double time1 = averageTime(efib, n1, 1000);
    System.out.println("n1 " + n1 + " time1 " + time1);
    
    // Calculate constant:  time = constant times O(n). 
    double c = time1 / efib.o(n1);
    System.out.println("c " + c);
   
    // Estimate running time for n2=30.
    int n2 = 30;
    double time2est = c * efib.o(n2);
    System.out.println("n2 " + n2 + " estimated time " + time2est);
    
    // Calculate actual running time for n2=30.
    double time2 = averageTime(efib, n2, 100);
    System.out.println("n2 " + n2 + " actual time " + time2);
    
    int n3 = 100;
    double time3est = c * efib.o(n3);
    System.out.println("n3 " + n3 + " estimated time " + time3est);
    double years = time3est/1000000;
    System.out.println("It would take " + (years/31622400) + " years.");
    
   String name = ("Ian");
   String name2 = ("John");
   
   int cmp = name.compareTo(name2);
   System.out.println(cmp);
    
     
  }

  private static UserInterface ui = new GUI();

  static void hwExperiments (Fib fib) {
	  

	  String[] repeatPrompt = {
			  "Yes",
			  "No"
	  };
	  
    double k = -1;  // -1 indicates that no experiments have been run yet.
    double c = 0;
    while (k <= -1){
    	
    	String input = ui.getInfo("Enter n: ");
    	if (input == null)
    		return;
    	
    	if (Pattern.matches("[a-zA-Z]+", input) == true){
    		ui.sendMessage("Program will only run with positive intergers.");
    		hwExperiments(fib);
    	}
		int n = Integer.parseInt(input);
    	
		if (n < 0){
			ui.sendMessage("Program will only run with positive intergers.");
			break;
		}
		
		// Now, calculate the (accurate) running time for that n.
    	double accuTime = accurateTime(fib, n);
    	// Calculate the constant c. 
    	c = accuTime / fib.o(n);
    	// Display fib(n) and the actual running time.
    	ui.sendMessage("n: " + n + " time: " + accuTime);
    	k++;
    }

    while (k > -1) {
    	
    	String input = ui.getInfo("Enter n: ");
    	
    	if (Pattern.matches("[a-zA-Z]+", input) == true){
    		ui.sendMessage("Program will only run with positive intergers.");
    		hwExperiments(fib);
    	}
    	
		int n = Integer.parseInt(input);
    	
		if (n < 0){
			ui.sendMessage("Program will only run with positive intergers.");
			break;
		}
		 
		double EstTime = c * fib.o(n);
		ui.sendMessage("the estimated time is " + EstTime + " microseconds.");
	   
		if ((EstTime/3599999999.99712) > 1){
			ui.sendMessage("The opertaton is going to take more than an hour.\n"
						 + "I will now ask you if you wish to proceed.");
			 while (true) {
					int z = ui.getCommand(repeatPrompt);
					switch (z) {
					case -1:
						hwExperiments();
						
					case 0:
						
					case 1:
						return;
					}
			 }
			
		}
	    double aTime = accurateTime(fib, n);
	    double fibV = (fib.fib(n));
	    ui.sendMessage("The " + n + "th Fibonacci number is: " + fibV + 
	    			   "\nThe operation took " + aTime + " microseconds.");
	   k=1;
		}
		   
	   }
      // Ask the user for an integer n.
      // Return if the user cancels.
      // Deal with bad inputs:  not positive, not an integer.
      
      // If this not the first experiment, estimate the running time for
      // that n using the value of the constant from the last time.
      
      // Display the estimate.
      
      // ADD LATER: If it is greater than an hour, ask the user for
      // confirmation before running the experiment.
      // If not, the "continue;" statement will skip the experiment.
      
    
      
      
      
      
      // Ask the user before doing another experiment.  Otherwise return.

    
  

  static void hwExperiments () {
    // In a loop, ask the user which implementation of Fib or exit,
    // and call hwExperiments (above) with a new Fib of that type.
	  String[] commands = {
				"EponentialFib",
				"LinearFib",
				"LogFib",
				"ConstantFib",
		"Exit"};
	  
	  //Changed the return value of ui.getInfo from String to int
	  //to be able to import interger values for operations
	  
	  while (true) {
			int c = ui.getCommand(commands);
			switch (c) {
			case -1:
				ui.sendMessage("You clicked the red x, restarting.");
				break;
				
			case 0:
				//ExponentialFib
				
				Fib expoFib = new ExponentialFib();				
				hwExperiments(expoFib);		       
				break;
				
				
			case 1:
				//LinearFib
				
				Fib linFib = new LinearFib();				
				hwExperiments(linFib);		       
				break;
				
				
			case 2:
				//LogFib
				
				Fib logFib = new LogFib();				
				hwExperiments(logFib);		       
				break;
				
			case 3:
				//ConstantFib
				
				Fib consFib = new ConstantFib();				
				hwExperiments(consFib);		       
				break;
				
				
			case 4:
				return;
		
			}
		}
	}


  /**
   * @param args the command line arguments
   */
  public static void main (String[] args) {
    labExperiments();
    hwExperiments();
  }
}
