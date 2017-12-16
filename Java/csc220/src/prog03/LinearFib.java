package prog03;

public class LinearFib implements Fib {
	/** The Fibonacci number generator 0, 1, 1, 2, 3, 5, ...
	@param n index
	@return nth Fibonacci number
	 */
	public double fib (int n) {
		
		double a = 0;
		double b = 0;
		double c = 1;
		
		if (n <= 0)
			return (n);
		
		for (int i = 0; i < n-1 ; i++){
			a = c;
			c = a+b;
			b = a;
		}
		return (c);
	}

	/** The order O() of the implementation.
	@param n index
	@return the function of n inside the O()
	 */
	public double o (int n) {
		return (n);
	}
}

