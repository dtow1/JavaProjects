
/**
 * This program is a solution to the Github Project: https://github.com/karan/Projects-Solutions.
 * 
 * Solution written: 11/2/2016
 * 
 * @author dtow1
 *
 * Instead of implementing this within main as a monolithic file. I implemented it as a class. I included
 * the ability to set other bounds and to set the value of fizz and buzz so that it is a little more interesting.
 *
 */
public class FizzBuzzTester {

	public static void main(String[] args) {
		
		System.out.println("Standard FizzBuzz range of 1 to 100, fizz at 3, buzz at 5");
		
		FizzBuzz fizzyTest = new FizzBuzz(1,100);
		
		fizzyTest.run();
		
		
		
		System.out.println("\n\nShort FizzBuzz range of 1 to 15, fizz at 3, buzz at 5");
		
		FizzBuzz shortTest = new FizzBuzz(1,15);
		
		shortTest.run();
		
		
		
		System.out.println("\n\nNew FizzBuzz range of 1 to 20, fizz at 2, buzz at 4");
		
		FizzBuzz diffVals = new FizzBuzz(1,20,2,4);
		
		diffVals.run();

	}

}
