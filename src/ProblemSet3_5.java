/**
 * INSTRUCTIONS.
 * 
 * The following exercises are, perhaps, more mathematically inclined than previous
 * problem sets. While they might be challenging, they are certainy doable.
 * 
 * You can (and should!) solve each of them using only the operators, conditional control
 * structures, and iterative control strucurs we've covered. You are not permitted to use
 * recursive code in your solutions.
 * 
 * Please be mindful of the expected outputs, as your code will be tested against that
 * directly. If you're unsure, please ask for clarification.
 * 
 * This problem set is worth 25 points and is due no later than 11:59pm on October 28, 2018.
 */
public class ProblemSet3_5 {
	
	public static void main(String[] args) {
		ProblemSet3_5 ps = new ProblemSet3_5();
		
		// test your solutions here
		
		/*ps.primes(1, 1000);*/
		ps.primes(1, 1000);
		ps.leapYears(3);
		ps.palindromicNumbers(-121);
		ps.fibonacci(12);
		ps.multiples(10, 25, 100);
	}
	
	/**
	 * How many prime numbers are there between @start and @end, where @start and @end
	 * are positive integers in the range [1, @Integer.MAX_VALUE]?
	 * 
	 * Print your solution in the following formats: "There is X prime number."
	 *                                               "There are X prime numbers."
	 * 
	 * @param start
	 * @param end
	 */
	
	public void primes(int start, int end) {
		
		if (start < 1 || end < 1) {
			System.out.println("Enter positive integers only.");
		}
		
		if (start > end) {
			int transfer = 0;
			transfer = start;
			start = end;
			end = transfer;
		}
		
		int primes = 0;
		
		for (int x = start; x <= end; x++) {
			if ((x % 2 != 0) && x != 1) {
				if((x == 3) || (x == 5) || (x == 7) || (x == 11) || (x == 13) || (x == 17) || (x == 19) || (x == 23) || (x == 29) || (x == 31)) {
					primes++;
				}
				else if((x % 3 != 0) && (x % 5 != 0) && (x % 7 != 0) && (x % 11 != 0) && (x % 13 != 0) && (x % 17 != 0) && (x % 19 != 0) && (x % 23 != 0) && (x % 29 != 0) && (x % 31 != 0)) {
					primes++;
				}
			}
			else if (x == 2) {
				primes++;
			}
		}
		
		if (primes == 1) {
			System.out.println("There is " + primes + " prime number.");
		}
		else if (primes > 1) {
			System.out.println("There are " + primes + " prime numbers.");
		}
	}
	
	/**
	 * What are the next @count leap years?
	 * 
	 * Print your solution in the following formats: "The next leap year is X."
	 *                                               "The next 2 leap years are X and Y."
	 *                                               "THe next N leap years are A, ..., X, Y, and Z."
	 * 
	 * @param count
	 */
	
	public void leapYears(int count) {
		int nextLeap = 2020;
		
		if (count == 1) {
			System.out.println("The next leap year is " + nextLeap +".");
		}
		else if (count > 1) {
			System.out.print("The next " + count + " leap years are ");
			for (int x = count; x > 0; x--) {
				if (x == 1) {
					System.out.println("and " + nextLeap + ".");
				}
				else {
					System.out.print(nextLeap + ", ");
					nextLeap += 4;
				}
				
			}
		
		}
	}
	
	/**
	 * Is @number a palindromic number?
	 * 
	 * Print your solution in the following formats: "X is a palindromic number."
	 *                                               "X is not a palindromic number."
	 *                                               
	 * @param number
	 */
	
	public void palindromicNumbers(int number) {
		int last = 0;
		int reverse = 0;
		boolean negative = false;
		
		if (number < 0) {
			negative = true;
		}

		if (negative == true) {
			number = number * -1;
		}
		
		String numstring = Integer.toString(number);
		int loopnum = numstring.length() - 1;
		int num = number;
		
		while (loopnum >= 0) {
			last = num % 10;
			reverse = (reverse * 10) + last;
			num /= 10;
			loopnum--;
		}
		
		if (negative == true) {
			reverse = reverse * -1;
			number = number * -1;
		}
		
		if (reverse == number) {
			System.out.println(number + " is a palindromic number.");
		}
		else {
			System.out.println(number + " is not a palindromic number.");
		}
	}
	
	/**
	 * What is the @nth Fibonacci number, where @n is a positive integer?
	 * 
	 * Print your solution in the following formats: "The 21st Fibonacci number is X."
	 *                                               "The 22nd Fibonacci number is X."
	 *                                               "The 23rd Fibonacci number is X."
	 *                                               "The 24th Fibonacci number is X."
	 *                                               
	 * @param n
	 */
	
	public void fibonacci(int n) {
		
		int k = 0;
		int l = 1;
		int last = n % 10;
		
		for (int m = 2; m <= n; m++) {
			int sum = k + l;
            k = l;
            l = sum;
            if (m == n) {
            	System.out.print("The " + n);
            	if (last == 1 && n != 11) {
            		System.out.print("st");
            	}
            	else if (last == 2 && n != 12) {
            		System.out.print("nd");
            	}
            	else if (last == 3 && n != 13) {
            		System.out.print("rd");
            	}
            	else {
            		System.out.print("th");
            	}
            	System.out.println(" Fibonacci number is " + sum + ".");
            }
		}
	}
	
	/**
	 * What is the sum of all multiples of @x and @y less than @limit, where @x, @y, and
	 * @limit are positive integers?
	 * 
	 * Print your solution in the following format: "The sum is X."
	 * 
	 * @param limit
	 */
	
	public void multiples(int x, int y, int limit) {
		int xMults = 0;
		int yMults = 0;
		
		for (int xx = x; xx < limit; xx++) {
			if (xx % x == 0) {
				xMults += xx;
			}
		}
		
		for (int yy = y; yy < limit; yy++) {
			if (yy % y == 0) {
				yMults += yy;
			}
		}
		
		int sum = xMults + yMults;
		
		System.out.println("The sum of all multiples of " + x + " and " + y + " less than " + limit + " is " + sum + ".");
		
	
	}
}