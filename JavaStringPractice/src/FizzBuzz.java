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
public class FizzBuzz {
	private int start;
	private int end;
	private int fizz;
	private int buzz;
	
	/**
	 * 
	 */
	FizzBuzz(){
		this(1,100);
	}
	
	
	/**
	 * @param start
	 * @param end
	 */
	FizzBuzz(int start, int end){
		this(start,end,3,5);
	}
	
	
	/**
	 * @param start
	 * @param end
	 * @param fizz
	 * @param buzz
	 */
	FizzBuzz(int start, int end, int fizz, int buzz){
		this.start=start;
		this.end=end;
		this.fizz=fizz;
		this.buzz=buzz;
	}
	
	/******************************************************************************************************
	
		SETTERS AND GETTERS
	
	******************************************************************************************************/
	
	/**
	 * Getter for the values to print buzz
	 * @return
	 */
	public int getBuzz(){
		return buzz;
	}
	
	/**
	 * Getter for the end of the "fizzbuzz" range
	 * @return
	 */
	public int getEnd(){
		return end;
	}
	
	/**
	 * Getter for the values to print fizz
	 * @return
	 */
	public int getFizz(){
		return fizz;
	}
	
	/**
	 * Getter for the start of the "fizzbuzz" range
	 * @return
	 */
	public int getStart(){
		return start;
	}
	
	
	/**
	 * Setter for the values to print buzz
	 * @param buzz
	 */
	public void setBuzz(int buzz){
		this.buzz=buzz;
	}
	
	
	/**
	 * Setter for the end of the "fizzbuzz" range
	 * @param end
	 */
	public void setEnd(int end){
		this.end=end;
	}
	
	/**
	 * Setter for the values to print fizz
	 * @param fizz
	 */
	public void setFizz(int fizz){
		this.fizz=fizz;
	}
	
	/**
	 * Setter for the start of the "fizzbuzz" range
	 * @param start
	 */
	public void setStart(int start){
		this.start=start;
	}
	
	/**
	 * Method to execute the fizzbuzz functionality and print out the Fizz, Buzz, FizzBuzz, or the number
	 * 
	 */
	public void run(){
		for(int i=start;i<=end;i++){
			if(isFizz(i)){
				if(isBuzz(i)){
					System.out.println("FizzBuzz");
				}else{
					System.out.println("Fizz");
				}
			}else if(isBuzz(i)){
				System.out.println("Buzz");
			}else{
				System.out.println(i);
			}
		}
	}

	/**
	 * Method to determine if it is a "fizz" number
	 * @param testNum - This is the number to test against the current value for buzz
	 * @return True if testNum is divisible by fizz, false otherwise
	 */
	private boolean isFizz(int testNum){
		boolean result=false;
		if(testNum%fizz==0){
			result=true;
		}
		return result;
	}
	
	/**
	 * Method to determine if it is a "buzz" number
	 * @param testNum - This is the number to test against the current value for buzz
	 * @return True if testNum is divisible by buzz, false otherwise
	 */
	private boolean isBuzz(int testNum){
		boolean result=false;
		if(testNum%buzz==0){
			result=true;
		}
		return result;
	}
	

}
